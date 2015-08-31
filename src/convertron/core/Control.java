package convertron.core;

import convertron.tabs.modules.ModuleManager;
import convertron.tabs.overview.OverviewView;
import convertron.tabs.settings.SettingsView;
import interlib.io.FileIO;
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

    /**
     * Des OverviewTab des Fensters.
     */
    private static OverviewView overviewTab;

    /**
     * Der Modulverwalter.
     */
    private static ModuleManager moduleManager;

    /**
     * Das Symbol der Anwendung im Tray.
     */
    private static TrayIcon trayIcon;

    /**
     * Gibt an ob die Anwendung laufen soll.
     */
    private static boolean running;

    /**
     * Erstellt die Anwendung.
     */
    public Control()
    {
        setJavaLookAndFeel();
        createAndFillWindow();

        setFileEncoding();
        copyFilesFromPackage();

        loadWindowPosition();

        Logger.logMessage(Logger.WARNING, "HELP");

//            initTray();
//            //QueueableMethods.loadSettings();
//            //frame.addWindowListener(new FrameActions(frame, this));
    }

    private static void setJavaLookAndFeel()
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException classNotFoundException)
        {
            JOptionPane.showMessageDialog(null, "Das Design der Anwendung konnte nicht geändert werden.\n"
                                                + "Es kann zu Anzeigeproblemen kommen.\n"
                                                + "Bitte prüfen Sie die Sicherheitseinstellungen und installierte Java Looks and Feels.",
                                          "Warnung", JOptionPane.OK_OPTION);
        }
    }

    private static void createAndFillWindow()
    {
        window = new Window();
        overviewTab = new OverviewView();

        window.addTab(overviewTab);
        window.addTab(new SettingsView());
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
        Logger.logMessage(Logger.INFO, "Fenster wurde erstellt und gefüllt");
    }

    private static void setFileEncoding()
    {
        try
        {
            System.setProperty("file.encoding", "ISO-8859-1");
            Logger.logMessage(Logger.INFO, "File Encoding wurde konfiguriert");
        }
        catch(SecurityException e)
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
        String packagePath = "/converter/res/stdData/";
        copyFileFromPackage(packagePath, "local.settings", "./");

        String destPath = Settings.load(true, "pathData");
        copyFileFromPackage(packagePath, "global.settings", destPath);
        copyFileFromPackage(packagePath, "antonianumLogo.png", destPath);
        copyFileFromPackage(packagePath, "TEMPLATE style.css", destPath);
        copyFileFromPackage(packagePath, "VERTRETUNGSPLAN.html", destPath);
        copyFileFromPackage(packagePath, "TEMPLATE laufschrift.html", destPath);
        copyFileFromPackage(packagePath, "TEMPLATE heute morgen.html", destPath);
        Logger.logMessage(Logger.INFO, "Alle Dateien wurden erstellt oder überprüft");
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
        Logger.logMessage(Logger.INFO, "Fenster Position wurde geladen");
    }

    /**
     * Beendet das Programm.
     */
    public static void exit()
    {
        try
        {
            running = false;
//            for(QueueElement element : queue)
//                element.invoke();

            Settings.saveArray(true, "position",
                               new String[]
                               {
                                   String.valueOf((int)window.getLocation().getX()),
                                   String.valueOf((int)window.getLocation().getY())
                               });

            SystemTray.getSystemTray().remove(trayIcon);
            window.dispose();
            System.exit(0);
        }
        catch(Exception ex)
        {
            //Logger.logMessage("Fehler beim Beenden", 2);
            //Logger.error(ex);
            System.exit(-1);
        }
    }

    /**
     * Ruft die "main-Methode" der Anwendung auf.
     *
     * @param args Parameter, die beim Aufruf des Programms übergeben wurden
     */
    public static void main(String[] args)
    {
        try
        {
            Control app = new Control();
        }
        catch(Exception ex)
        {
            //Logger.logMessage("Fehler in der Main-Methode", 2);
            //Logger.error(ex);
        }
    }

    /**
     * Initialisiert den Tray.
     */
    private static void initTray()
    {
        try
        {
            BufferedImage icon = ImageIO.read(Control.class.getResource("/com/facharbeit/ressources/trayLogo.png"));
            PopupMenu popup = new PopupMenu();
            trayIcon = new TrayIcon(icon);
            SystemTray tray = SystemTray.getSystemTray();

            initTrayMenuItem("Alles generieren", Tasks.GENALL, "Generieren...", popup);
            initTrayMenuItem("Backup erstellen", Tasks.BACKUP, "Backup erstellen...", popup);

            initTrayMenuItem("Maximieren", (java.awt.event.ActionEvent evt) ->
                     {
                         window.setExtendedState(JFrame.NORMAL);
                         window.setVisible(true);
                         window.toFront();
                         window.requestFocus();
            }, popup);

            initTrayMenuItem("Minimieren", (java.awt.event.ActionEvent evt) ->
                     {
                         window.setVisible(false);
            }, popup);

            initTrayMenuItem("Beenden", (java.awt.event.ActionEvent evt) ->
                     {
                         Control.exit();
            }, popup);

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
        catch(Exception ex)
        {
            //Logger.logMessage("Tray konnte nicht initialisiert werden", 2);
            //Logger.error(ex);
        }
    }

    private static void initTrayMenuItem(String text, Runnable task, String taskMessage, PopupMenu menu)
    {
        initTrayMenuItem(text, (ActionEvent e) ->
                 {
                     //ToDo Message!?
                     EventQueue.invokeLater(task);
        }, menu);
    }

    private static void initTrayMenuItem(String text, ActionListener listener, PopupMenu menu)
    {
        MenuItem item = new MenuItem(text);
        item.addActionListener(listener);

        menu.add(item);
    }

    public static Window getWindow()
    {
        return window;
    }

    public static void genAll()
    {

    }

    public static void genLessons()
    {

    }

    public static void genMotd()
    {

    }
}
