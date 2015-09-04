package convertron.core;

import convertron.tabs.modules.ModuleManager;
import convertron.tabs.overview.OverviewControl;
import convertron.tabs.settings.SettingsControl;
import interlib.interfaces.View;
import interlib.io.FileIO;
import interlib.util.LogPriority;
import interlib.util.Logger;
import interlib.util.Settings;
import java.awt.EventQueue;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

/**
 * Verwaltet alle Aktionen, die im Programm geschehen sollen.
 */
public class Control
{
    /**
     * Das Fenster des Programms.
     */
    private static Window window;

    private static OverviewControl overview;
    private static SettingsControl settings;
    private static ModuleManager moduleManager;

    private static Storage storage;

    /**
     * Das Symbol der Anwendung im Tray.
     */
    private static TrayIcon trayIcon;

    /**
     * Ruft die "main-Methode" der Anwendung auf.
     *
     * @param args Parameter, die beim Aufruf des Programms übergeben wurden
     */
    public static void main(String[] args)
    {
        try
        {
            setFileEncoding("ISO-8859-1");

            setJavaLookAndFeel();

            copyFilesFromPackage();

            createAndFillWindow();

            loadWindowPosition();

            initTray();
            Logger.logMessage(LogPriority.INFO, "test");

            //ToDo init Settings & Logger
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,
                                          "Fehler beim initialisieren der Anwendung!",
                                          "Schwerwiegender Fehler",
                                          JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void setJavaLookAndFeel()
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex)
        {
            JOptionPane.showMessageDialog(null, "Das Design der Anwendung konnte nicht geändert werden.\n"
                                                + "Es kann zu Anzeigeproblemen kommen.\n"
                                                + "Bitte prüfen Sie die Sicherheitseinstellungen und installierte Java Looks and Feels.",
                                          "Warnung", JOptionPane.OK_OPTION);
        }
    }

    private static void initializeStorage()
    {
        storage = new CsvStorage();
    }

    private static void createAndFillWindow()
    {
        window = new Window();

        overview = new OverviewControl();
        settings = new SettingsControl();
        moduleManager = new ModuleManager();

        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
        Logger.logMessage(LogPriority.INFO, "Fenster wurde erstellt und gefüllt");
    }

    private static void setFileEncoding(String charsetName)
    {
        try
        {
            if(Charset.isSupported(charsetName))
            {
                System.setProperty("file.encoding", charsetName);
                Logger.logMessage(LogPriority.INFO, "File Encoding wurde konfiguriert");
            }
            else
            {
                throw new UnsupportedCharsetException(charsetName);
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Das File Encoding konnte nicht auf ISO-8859-1 umgestellt werden.\n"
                                                + "Es kann zu Anzeigeproblemen kommen.\n"
                                                + "Bitte prüfen Sie die Sicherheitseinstellungen und installierte Charsets.",
                                          "Warnung", JOptionPane.OK_OPTION);
        }
    }

    /**
     * Initialisiert den Data-Ordner.
     */
    private static void copyFilesFromPackage()
    {
        String packagePath = "/convertron/res/stdData/";
        copyFileFromPackage(packagePath, "local.settings", "./");

        String destPath = Settings.load(true, "pathData");
        copyFileFromPackage(packagePath, "global.settings", destPath);
        copyFileFromPackage(packagePath, "antonianumLogo.png", destPath);
        copyFileFromPackage(packagePath, "TEMPLATE style.css", destPath);
        copyFileFromPackage(packagePath, "VERTRETUNGSPLAN.html", destPath);
        copyFileFromPackage(packagePath, "TEMPLATE laufschrift.html", destPath);
        copyFileFromPackage(packagePath, "TEMPLATE heute morgen.html", destPath);
        Logger.logMessage(LogPriority.INFO, "Alle Dateien wurden erstellt oder überprüft");
    }

    private static void copyFileFromPackage(String packagePath, String fileName, String destPath)
    {
        FileIO file = new FileIO(packagePath + fileName);
        file.copyFromPackage(destPath);
    }

    private static void loadWindowPosition()
    {
        String[] positions = Settings.loadArray(true, "position");
        if(!positions[0].isEmpty() && !positions[1].isEmpty())
            window.setLocation(Integer.parseInt(positions[0]), Integer.parseInt(positions[1]));
        Logger.logMessage(LogPriority.INFO, "Fenster Position wurde geladen");
    }

    /**
     * Initialisiert den Tray.
     */
    private static void initTray()
    {
        trayIcon = null;
        try
        {
            if(SystemTray.isSupported())
            {
                SystemTray tray = SystemTray.getSystemTray();

                BufferedImage icon = ImageIO.read(Control.class.getResource("/com/facharbeit/ressources/trayLogo.png"));
                trayIcon = new TrayIcon(icon);

                PopupMenu popup = new PopupMenu();

                initTrayMenuItem("Alles generieren", popup, Tasks.GENALL, "Generieren...");
                initTrayMenuItem("Backup erstellen", popup, Tasks.BACKUP, "Backup erstellen...");

                initTrayMenuItem("Maximieren", popup,
                                 (java.awt.event.ActionEvent evt) ->
                                 {
                                     window.setExtendedState(JFrame.NORMAL);
                                     window.setVisible(true);
                                     window.toFront();
                                     window.requestFocus();
                                 });

                initTrayMenuItem("Minimieren", popup,
                                 (java.awt.event.ActionEvent evt) ->
                                 {
                                     window.setVisible(false);
                                 });

                initTrayMenuItem("Beenden", popup,
                                 (java.awt.event.ActionEvent evt) ->
                                 {
                                     Control.exit();
                                 });

                trayIcon.setPopupMenu(popup);
                trayIcon.setToolTip("Vertretungsplan-Generator");

                trayIcon.addActionListener((ActionEvent e) ->
                {
                    window.setExtendedState(JFrame.NORMAL);
                    window.setVisible(true);
                    window.toFront();
                    window.requestFocus();
                });

                tray.add(trayIcon);
            }
            else
            {
                Logger.logMessage(LogPriority.INFO, "Das Betriebssystem unterstützt kein Tray, "
                                                    + "es wurde kein Tray initialisiert");
            }
        }
        catch(Exception ex)
        {
            Logger.logError(LogPriority.WARNING, "Tray konnte nicht initialisiert werden", ex);
        }
    }

    private static void initTrayMenuItem(String text, PopupMenu menu, Runnable task, String taskMessage)
    {
        initTrayMenuItem(text, menu, (ActionEvent e) ->
                 {
                     //ToDo Message!?
                     EventQueue.invokeLater(task);
        });
    }

    private static void initTrayMenuItem(String text, PopupMenu menu, ActionListener listener)
    {
        MenuItem item = new MenuItem(text);
        item.addActionListener(listener);

        menu.add(item);
    }

    /**
     * Beendet das Programm.
     */
    public static void exit()
    {
        try
        {
            //ToDo Exit Tabs -> Pending Changes?!

            Settings.saveArray(true, "position",
                               new String[]
                               {
                                   String.valueOf((int)window.getLocation().getX()),
                                   String.valueOf((int)window.getLocation().getY())
                               });

            if(trayIcon != null)
                SystemTray.getSystemTray().remove(trayIcon);

            window.dispose();
            System.exit(0);
        }
        catch(Exception ex)
        {
            Logger.logError(LogPriority.ERROR, "Fehler beim Beenden", ex);
            System.exit(-1);
        }
    }

    public static void addViewToWindow(View view)
    {
        if(window != null)
            window.addTab(view);
    }

    public static void genAll()
    {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public static void importLessons()
    {
        storage.save(moduleManager.in());
    }

    public static void importMotd()
    {
        storage.saveMotd(overview.getMotdText());
    }

    public static void exportLessons()
    {
        moduleManager.out(storage.load());
    }

    public static void exportMotd()
    {
        moduleManager.motdOut(storage.loadMotd());
    }
}
