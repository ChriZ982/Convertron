package converter.core;

import converter.core.Window;
import converter.io.FileIO;
import converter.modules.design.DesignView;
import converter.modules.overview.OverviewView;
import converter.modules.paths.PathsView;
import converter.modules.settings.SettingsView;
import converter.modules.sql.SqlView;
import converter.util.Logger;
import converter.util.Settings;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import javax.swing.*;

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
     * Die Warteschlange der Anwendung.
     */
    //private static ArrayList<QueueElement> queue;
    /**
     * Erstellt die Anwendung.
     */
    public Control()
    {
        setFileEncoding();
        setJavaLookAndFeel();
        createAndFillWindow();

        Logger.log(Logger.INFO, "Die Datei " + " konnte nicht erstellt werden");

        Logger.log(Logger.HINT, "Die Datei " + " konnte nicht erstellt werden", Logger.SECURITY_EXCEPTION);
        Logger.log(Logger.ERROR, "Die Datei " + " konnte nicht erstellt werden", Logger.IO_EXCEPTION);

        FileIO file = new FileIO("/converter/res/stdData/antonianumLogo.png");
        file.copyFromRes("./Testsxtts");
        //queue = new ArrayList<QueueElement>();
//            boolean firstStart = new FileIO("./local.settings").exists();
//            if(!firstStart)
//                new FileIO("/com/facharbeit/ressources/stdData/global.settings").copyFromRes("./Data/");
//            new FileIO("/com/facharbeit/ressources/stdData/local.settings").copyFromRes("./");
////            if(firstStart)
////                new FileIO("/com/facharbeit/ressources/stdData/global.settings").copyFromRes(Settings.load("pathData") + "/");
//
//            //Logger.init(frame.getStatusPane());
//            Settings.init();
//            if(firstStart)
//                new FileIO("/com/facharbeit/ressources/stdData/global.settings").copyFromRes(Settings.load("pathData") + "/");
//            initData();
//            initTray();
//
//            String[] pos = Settings.loadArray("position");
//            if(!pos[0].isEmpty() && !pos[1].isEmpty())
//                window.setLocation(Integer.parseInt(pos[0]), Integer.parseInt(pos[1]));
//
//            //QueueableMethods.loadSettings();
//            //frame.addWindowListener(new FrameActions(frame, this));
//            window.setVisible(true);
//            running = true;
    }

    private void setFileEncoding()
    {
        try
        {
            System.setProperty("file.encoding", "ISO-8859-1");
        }
        catch(SecurityException e)
        {
            JOptionPane.showMessageDialog(null, "Das File Encoding konnte nicht auf ISO-8859-1 umgestellt werden.\n"
                                                + "Es kann zu Anzeigeproblemen kommen.\n"
                                                + "Bitte prüfen Sie die Sicherheitseinstellungen und installierte Charsets.",
                                          "Warnung", JOptionPane.OK_OPTION);
        }
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
        window.addTab(new DesignView());
        window.addTab(new SqlView());
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
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

            Settings.sort();
            Settings.saveArray("position",
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
            //Logger.log("Fehler beim Beenden", 2);
            //Logger.error(ex);
            System.exit(-1);
        }
    }

    /**
     * Initialisiert den Data-Ordner.
     */
    private void initData()
    {
        try
        {
            new FileIO("/com/facharbeit/ressources/stdData/antonianumLogo.png").copyFromRes(Settings.load("pathData") + "/");
            new FileIO("/com/facharbeit/ressources/stdData/TEMPLATE heute morgen.html").copyFromRes(Settings.load("pathData") + "/");
            new FileIO("/com/facharbeit/ressources/stdData/TEMPLATE laufschrift.html").copyFromRes(Settings.load("pathData") + "/");
            new FileIO("/com/facharbeit/ressources/stdData/VERTRETUNGSPLAN.html").copyFromRes(Settings.load("pathData") + "/");
            new FileIO("/com/facharbeit/ressources/stdData/TEMPLATE style.css").copyFromRes(Settings.load("pathData") + "/");
        }
        catch(Exception ex)
        {
            //Logger.log("Data-Ordner konnte nicht initialisiert werden", 2);
            //Logger.error(ex);
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
            //Logger.log("Fehler in der Main-Methode", 2);
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
            //Logger.log("Fehler in der Programm-Schleife", 2);
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
//            Logger.log("Methode \"" + methodName + "\"konnte nicht zur Warteschlange hinzugefügt werden", 2);
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
//            Logger.log("Element der Warteschlange konnte nicht ausgeführt werden", 2);
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
            //Logger.log("Tray konnte nicht initialisiert werden", 2);
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
