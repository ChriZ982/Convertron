package convertron.core;

import convertron.data.CsvStorage;
import convertron.data.Storage;
import convertron.settings.CoreSettings;
import convertron.tabs.modules.ModuleControl;
import convertron.tabs.overview.OverviewControl;
import convertron.tabs.settings.SettingsControl;
import interlib.data.Lesson;
import interlib.filter.TableOptions;
import interlib.interfaces.View;
import interlib.io.ResourceFile;
import interlib.logging.Logger;
import interlib.logging.messages.LogPriority;
import java.awt.EventQueue;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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
    private static ModuleControl moduleManager;

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
            setFileEncoding("UTF-8");

            setJavaLookAndFeel();

            copyFilesFromPackage();

            initializeStorage();

            createAndFillWindow();

            loadWindowPosition();

            initTray();

            Logger.logMessage(LogPriority.HINT, "Anwendung gestartet");
        }
        catch(Exception ex)
        {
            Logger.logError(LogPriority.ERROR, "Fehler beim initialisieren der Anwendung", ex);
            StringWriter writer = new StringWriter();
            ex.printStackTrace(new PrintWriter(writer));
            JOptionPane.showMessageDialog(null,
                                          "Fehler beim initialisieren der Anwendung!\n"
                                          + writer.toString(),
                                          "Schwerwiegender Fehler",
                                          JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
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
            Logger.logError(LogPriority.ERROR, "Das Design der Anwendung konnte nicht geändert werden", ex);
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
        moduleManager = new ModuleControl();

        window.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                exit();
            }

            @Override
            public void windowIconified(WindowEvent e)
            {
                if(trayIcon != null)
                {
                    window.setVisible(false);
                }
            }
        });

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
        String destPath = CoreSettings.pathData.load();
        copyFileFromPackage("antonianumLogo.png", destPath);
        copyFileFromPackage("TEMPLATE style.css", destPath);
        copyFileFromPackage("VERTRETUNGSPLAN.html", destPath);
        copyFileFromPackage("TEMPLATE laufschrift.html", destPath);
        copyFileFromPackage("TEMPLATE heute morgen.html", destPath);

        Logger.logMessage(LogPriority.INFO, "Alle Dateien wurden erstellt oder überprüft");
    }

    private static void copyFileFromPackage(String fileName, String destPath)
    {
        ResourceFile resourceFile = new ResourceFile("/convertron/res/stdData", fileName);
        resourceFile.copyIfNotExists(destPath);
    }

    public static void loadWindowPosition()
    {
        String x = CoreSettings.positionX.load();
        String y = CoreSettings.positionY.load();
        try
        {
            window.setLocation(Integer.parseInt(x), Integer.parseInt(y));
            Logger.logMessage(LogPriority.INFO, "Fenster Position wurde geladen");
        }
        catch(NumberFormatException ex)
        {
            Logger.logMessage(LogPriority.INFO, "Fenster Position konnte nicht geladen werden");
        }
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

                BufferedImage icon = ImageIO.read(Control.class.getResource("/convertron/res/trayLogo.png"));
                trayIcon = new TrayIcon(icon);

                PopupMenu popup = new PopupMenu();

                initTrayMenuItem("Alles generieren", popup,
                                 () ->
                                 {
                                     Control.genAll();
                                 });

                initTrayMenuItem("Backup erstellen", popup,
                                 () ->
                                 {
                                     Control.createBackup();
                                 });

                popup.addSeparator();

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

                popup.addSeparator();

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

    private static void initTrayMenuItem(String text, PopupMenu menu, Runnable task)
    {
        initTrayMenuItem(text, menu,
                         (ActionEvent e) ->
                         {
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

            CoreSettings.positionX.save(String.valueOf((int)window.getLocation().getX()));
            CoreSettings.positionY.save(String.valueOf((int)window.getLocation().getY()));

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
        if(CoreSettings.autoBackup.load().equals("true"))
            createBackup();

        if(CoreSettings.autoImport.load().equals("true"))
            importLessons();

        if(CoreSettings.autoExport.load().equals("true"))
            exportLessonsAndMotd();
    }

    public static void importLessons()
    {
        Lesson[] in = moduleManager.in();
        if(in != null)
            storage.save(TableOptions.compress(in));
    }

    public static void exportLessonsAndMotd()
    {
        moduleManager.out(storage.load());

        moduleManager.motdOut(CoreSettings.motdText.load());
    }

    public static void createBackup()
    {
        //ToDo implement (FolderIO missing)
        Logger.logMessage(LogPriority.HINT, "Backup wurde versucht zu erstellen, jedoch wird dieses Feature noch nicht unterstützt");
    }
}
