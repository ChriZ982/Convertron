package convertron.core;

import convertron.tabs.overview.OverviewView;
import convertron.tabs.paths.PathsView;
import convertron.tabs.settings.SettingsView;
import interlib.io.FileIO;
import interlib.util.Logger;
import interlib.util.Settings;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
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
    private Window window;

    /**
     * Das Symbol der Anwendung im Tray.
     */
    private TrayIcon trayIcon;

    /**
     * Gibt an ob die Anwendung laufen soll.
     */
    private boolean running;

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

    private void setJavaLookAndFeel()
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

    private void createAndFillWindow()
    {
        window = new Window();
        window.addTab(new OverviewView());
        window.addTab(new SettingsView());
        window.addTab(new PathsView());
//        window.addTab(new DesignView());
//        window.addTab(new SqlView());
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
        Logger.logMessage(Logger.INFO, "Fenster wurde erstellt und gefüllt");
    }

    private void setFileEncoding()
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
    private void copyFilesFromPackage()
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

    private void copyFileFromPackage(String packagePath, String fileName, String destPath)
    {
        FileIO file = new FileIO(packagePath + fileName);
        file.copyFromPackage(destPath);
    }

    private void loadWindowPosition()
    {
        String[] positions = Settings.loadArray(true, "position");
        if(!positions[0].isEmpty() && !positions[1].isEmpty())
            window.setLocation(Integer.parseInt(positions[0]), Integer.parseInt(positions[1]));
        Logger.logMessage(Logger.INFO, "Fenster Position wurde geladen");
    }

    /**
     * Beendet das Programm.
     */
    public void exit()
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
            app.run();
        }
        catch(Exception ex)
        {
            //Logger.logMessage("Fehler in der Main-Methode", 2);
            //Logger.error(ex);
        }
    }

    /**
     * While-Schleife, die das ganze Programm über läuft. Ähnlich der main.Methode.
     */
    public void run()
    {
        try
        {
            long beforeTime;
            long afterTime;
            long lastTime = System.currentTimeMillis();
            long currentTime;
            while(running)
            {
                beforeTime = System.currentTimeMillis();
                runOneElementOfQueue();
                afterTime = System.currentTimeMillis();
                currentTime = System.currentTimeMillis();

                if(afterTime < beforeTime + 100 && afterTime > beforeTime)
                    Thread.sleep((beforeTime - afterTime) + 100);

                if(lastTime < currentTime - 120000)
                {
                    lastTime = System.currentTimeMillis();
                    Control.addToQueue("genAllBtnActionPerformed");
                }
            }
        }
        catch(Exception ex)
        {
            //Logger.logMessage("Fehler in der Programm-Schleife", 2);
            //Logger.error(ex);
        }
    }

    /**
     * Fügt Methoden aus "QueueableMethods" zur Warteschlange hinzu.
     *
     * @param methodName Name der Methode
     */
    public static void addToQueue(String methodName)
    {
//        try
//        {
//            Method[] methods = QueueableMethods.class.getDeclaredMethods();
//            Method theMethod = null;
//            for(Method method : methods)
//                if(method.getName().equals(methodName))
//                {
//                    theMethod = method;
//                    break;
//                }
//            queue.add(new QueueElement(theMethod));
//        }
//        catch(Exception ex)
//        {
//            Logger.logMessage("Methode \"" + methodName + "\"konnte nicht zur Warteschlange hinzugefügt werden", 2);
//            Logger.error(ex);
//        }
    }

    /**
     * Führt das erste Element der Schlange aus.
     */
    private void runOneElementOfQueue()
    {
//        try
//        {
//            //frame.getProgBar().setValue(queue.size());
//            if(queue.size() > 0)
//            {
//                queue.get(0).invoke();
//                queue.remove(0);
//            }
//        }
//        catch(Exception ex)
//        {
//            Logger.logMessage("Element der Warteschlange konnte nicht ausgeführt werden", 2);
//            Logger.error(ex);
//        }
    }

    /**
     * Initialisiert den Tray.
     */
    private void initTray()
    {
        try
        {
            BufferedImage icon = ImageIO.read(getClass().getResource("/com/facharbeit/ressources/trayLogo.png"));
            PopupMenu popup = new PopupMenu();
            trayIcon = new TrayIcon(icon);
            SystemTray tray = SystemTray.getSystemTray();

            MenuItem genAll = new MenuItem("Alles generieren");
            MenuItem genToday = new MenuItem("Heute generieren");
            MenuItem genTomorrow = new MenuItem("Morgen generieren");
            MenuItem backup = new MenuItem("Backup erstellen");
            MenuItem show = new MenuItem("Maximieren");
            MenuItem hide = new MenuItem("Minimieren");
            MenuItem exitItem = new MenuItem("Beenden");

            setMenuItems(genAll, genToday, genTomorrow, backup, show, hide, exitItem);

            popup.add(genAll);
            popup.add(genToday);
            popup.add(genTomorrow);
            popup.addSeparator();
            popup.add(backup);
            popup.addSeparator();
            popup.add(show);
            popup.add(hide);
            popup.addSeparator();
            popup.add(exitItem);

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

    /**
     * Setzt die Aktionen der verschiedenen Items.
     *
     * @param genAll      Item
     * @param genToday    Item
     * @param genTomorrow Item
     * @param backup      Item
     * @param show        Item
     * @param hide        Item
     * @param exitItem    Item
     */
    private void setMenuItems(MenuItem genAll, MenuItem genToday, MenuItem genTomorrow, MenuItem backup,
                              MenuItem show, MenuItem hide, MenuItem exitItem)
    {
        genAll.addActionListener((java.awt.event.ActionEvent evt) ->
        {
            Control.addToQueue("genAllBtnActionPerformed");
        });
        genToday.addActionListener((java.awt.event.ActionEvent evt) ->
        {
            Control.addToQueue("genTodayBtnActionPerformed");
        });
        genTomorrow.addActionListener((java.awt.event.ActionEvent evt) ->
        {
            Control.addToQueue("genTomorrowBtnActionPerformed");
        });
        backup.addActionListener((java.awt.event.ActionEvent evt) ->
        {
            Control.addToQueue("createBackupBtnActionPerformed");
        });
        show.addActionListener((java.awt.event.ActionEvent evt) ->
        {
            window.setExtendedState(JFrame.NORMAL);
            window.setVisible(true);
            window.toFront();
            window.requestFocus();
        });
        hide.addActionListener((java.awt.event.ActionEvent evt) ->
        {
            window.setVisible(false);
        });
        exitItem.addActionListener((java.awt.event.ActionEvent evt) ->
        {
            System.exit(0);
        });
    }

    public Window getWindow()
    {
        return window;
    }

}
