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

            Logger.init(frame.getStatusPane());

            initData();
            initTray();

            Settings.init();

            if(!Settings.load("positionX").isEmpty() && !Settings.load("positionY").isEmpty())
                frame.setLocation(Integer.parseInt(Settings.load("positionX")),
                                  Integer.parseInt(Settings.load("positionY")));

            frame.loadSettings();
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
            addToQueue("savePositionOfFrame", frame);

            for(QueueElement element : queue)
                element.invoke();

            Settings.sort();

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
            new FileHandler("/com/facharbeit/ressources/stdData/settings.ini").copyFromRes("Data/");
            new FileHandler("/com/facharbeit/ressources/stdData/antonianumLogo.png").copyFromRes("Data/");
            new FileHandler("/com/facharbeit/ressources/stdData/TEMPLATE heute morgen.html").copyFromRes("Data/");
            new FileHandler("/com/facharbeit/ressources/stdData/TEMPLATE laufschrift.html").copyFromRes("Data/");
            new FileHandler("/com/facharbeit/ressources/stdData/VERTRETUNGSPLAN.html").copyFromRes("Data/");
            new FileHandler("/com/facharbeit/ressources/stdData/TEMPLATE style.css").copyFromRes("Data/");
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
                    Application.addToQueue("copySourceBtnActionPerformed");
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
     * @param args       Parameter der Methode
     */
    public static void addToQueue(String methodName, Object... args)
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

            queue.add(new QueueElement(theMethod, args));
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
            MenuItem genMotd = new MenuItem("Laufschrift generieren");
            MenuItem backup = new MenuItem("Backup erstellen");
            MenuItem removeSources = new MenuItem("Quelldateien löschen");
            MenuItem show = new MenuItem("Maximieren");
            MenuItem hide = new MenuItem("Minimieren");
            MenuItem exitItem = new MenuItem("Beenden");

            setMenuItems(genAll, genToday, genTomorrow, genMotd, backup, removeSources, show, hide, exitItem);

            popup.add(genAll);
            popup.add(genToday);
            popup.add(genTomorrow);
            popup.add(genMotd);
            popup.addSeparator();
            popup.add(backup);
            popup.add(removeSources);
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
     * @param genAll        Item
     * @param genToday      Item
     * @param genTomorrow   Item
     * @param genMotd       Item
     * @param backup        Item
     * @param removeSources Item
     * @param show          Item
     * @param hide          Item
     * @param exitItem      Item
     */
    private void setMenuItems(MenuItem genAll, MenuItem genToday, MenuItem genTomorrow, MenuItem genMotd, MenuItem backup,
                              MenuItem removeSources, MenuItem show, MenuItem hide, MenuItem exitItem)
    {
        try
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
            genMotd.addActionListener((java.awt.event.ActionEvent evt) ->
            {
                Application.addToQueue("genMotdBtnActionPerformed", new JTextField());
            });
            backup.addActionListener((java.awt.event.ActionEvent evt) ->
            {
                Application.addToQueue("createBackupBtnActionPerformed");
            });
            removeSources.addActionListener((java.awt.event.ActionEvent evt) ->
            {
                Application.addToQueue("deleteSourceBtnActionPerformed");
            });
            show.addActionListener((java.awt.event.ActionEvent evt) ->
            {
                frame.setExtendedState(JFrame.NORMAL);
                frame.setVisible(true);
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
        catch(Exception ex)
        {
            Logger.log("Aktionen der Menüitems konnten nicht gesetzt werden", 2);
            Logger.error(ex);
        }
    }
}
