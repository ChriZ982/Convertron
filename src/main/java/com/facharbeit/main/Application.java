package com.facharbeit.main;

import com.facharbeit.io.*;
import com.facharbeit.main.Frame;
import com.facharbeit.tools.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.lang.reflect.*;
import java.util.*;
import javax.imageio.*;
import javax.swing.*;

/**
 * Verwaltet alle Aktionen, die im Programm geschehen sollen.
 */
public class Application
{

    /**
     * Das Fenster des Programms.
     */
    private Frame frame;

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
    private static ArrayList<QueueElement> queue;

    /**
     * Erstellt die Anwendung.
     */
    public Application()
    {
        try
        {
            System.setProperty("file.encoding", "ISO-8859-1");
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            queue = new ArrayList<QueueElement>();
            frame = new Frame();

            boolean firstStart = new FileHandler("./local.settings").exists();
            if(!firstStart)
                new FileHandler("/com/facharbeit/ressources/stdData/global.settings").copyFromRes("./Data/");
            new FileHandler("/com/facharbeit/ressources/stdData/local.settings").copyFromRes("./");
//            if(firstStart)
//                new FileHandler("/com/facharbeit/ressources/stdData/global.settings").copyFromRes(Settings.load("pathData") + "/");

            Logger.init(frame.getStatusPane());
            Settings.init();
            if(firstStart)
                new FileHandler("/com/facharbeit/ressources/stdData/global.settings").copyFromRes(Settings.load("pathData") + "/");
            initData();
            initTray();

            String[] pos = Settings.loadArray("position");
            if(!pos[0].isEmpty() && !pos[1].isEmpty())
                frame.setLocation(Integer.parseInt(pos[0]), Integer.parseInt(pos[1]));

            QueueableMethods.loadSettings();
            frame.addWindowListener(new FrameActions(frame, this));
            frame.setVisible(true);
            running = true;
        }
        catch(Exception ex)
        {
            Logger.log("Anwendung konnte nicht initialisiert werden", 2);
            Logger.error(ex);
        }
    }

    /**
     * Beendet das Programm.
     */
    public void exit()
    {
        try
        {
            running = false;
            for(QueueElement element : queue)
                element.invoke();

            Settings.sort();
            Settings.saveArray("position",
                               new String[]
                               {
                                   String.valueOf((int)frame.getLocation().getX()),
                                   String.valueOf((int)frame.getLocation().getY())
                               });

            SystemTray.getSystemTray().remove(trayIcon);
            frame.dispose();
            System.exit(0);
        }
        catch(Exception ex)
        {
            Logger.log("Fehler beim Beenden", 2);
            Logger.error(ex);
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
            new FileHandler("/com/facharbeit/ressources/stdData/antonianumLogo.png").copyFromRes(Settings.load("pathData") + "/");
            new FileHandler("/com/facharbeit/ressources/stdData/TEMPLATE heute morgen.html").copyFromRes(Settings.load("pathData") + "/");
            new FileHandler("/com/facharbeit/ressources/stdData/TEMPLATE laufschrift.html").copyFromRes(Settings.load("pathData") + "/");
            new FileHandler("/com/facharbeit/ressources/stdData/VERTRETUNGSPLAN.html").copyFromRes(Settings.load("pathData") + "/");
            new FileHandler("/com/facharbeit/ressources/stdData/TEMPLATE style.css").copyFromRes(Settings.load("pathData") + "/");
        }
        catch(Exception ex)
        {
            Logger.log("Data-Ordner konnte nicht initialisiert werden", 2);
            Logger.error(ex);
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
            Application app = new Application();
            app.run();
        }
        catch(Exception ex)
        {
            Logger.log("Fehler in der Main-Methode", 2);
            Logger.error(ex);
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
                    Application.addToQueue("genAllBtnActionPerformed");
                }
            }
        }
        catch(Exception ex)
        {
            Logger.log("Fehler in der Programm-Schleife", 2);
            Logger.error(ex);
        }
    }

    /**
     * Fügt Methoden aus "QueueableMethods" zur Warteschlange hinzu.
     *
     * @param methodName Name der Methode
     */
    public static void addToQueue(String methodName)
    {
        try
        {
            Method[] methods = QueueableMethods.class.getDeclaredMethods();
            Method theMethod = null;
            for(Method method : methods)
                if(method.getName().equals(methodName))
                {
                    theMethod = method;
                    break;
                }
            queue.add(new QueueElement(theMethod));
        }
        catch(Exception ex)
        {
            Logger.log("Methode \"" + methodName + "\"konnte nicht zur Warteschlange hinzugefügt werden", 2);
            Logger.error(ex);
        }
    }

    /**
     * Führt das erste Element der Schlange aus.
     */
    private void runOneElementOfQueue()
    {
        try
        {
            frame.getProgBar().setValue(queue.size());
            if(queue.size() > 0)
            {
                queue.get(0).invoke();
                queue.remove(0);
            }
        }
        catch(Exception ex)
        {
            Logger.log("Element der Warteschlange konnte nicht ausgeführt werden", 2);
            Logger.error(ex);
        }
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
                frame.setExtendedState(JFrame.NORMAL);
                frame.setVisible(true);
                frame.toFront();
                frame.requestFocus();
            });

            tray.add(trayIcon);
        }
        catch(Exception ex)
        {
            Logger.log("Tray konnte nicht initialisiert werden", 2);
            Logger.error(ex);
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
            Application.addToQueue("genAllBtnActionPerformed");
        });
        genToday.addActionListener((java.awt.event.ActionEvent evt) ->
        {
            Application.addToQueue("genTodayBtnActionPerformed");
        });
        genTomorrow.addActionListener((java.awt.event.ActionEvent evt) ->
        {
            Application.addToQueue("genTomorrowBtnActionPerformed");
        });
        backup.addActionListener((java.awt.event.ActionEvent evt) ->
        {
            Application.addToQueue("createBackupBtnActionPerformed");
        });
        show.addActionListener((java.awt.event.ActionEvent evt) ->
        {
            frame.setExtendedState(JFrame.NORMAL);
            frame.setVisible(true);
            frame.toFront();
            frame.requestFocus();
        });
        hide.addActionListener((java.awt.event.ActionEvent evt) ->
        {
            frame.setVisible(false);
        });
        exitItem.addActionListener((java.awt.event.ActionEvent evt) ->
        {
            System.exit(0);
        });
    }
}