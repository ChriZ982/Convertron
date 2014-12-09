package com.facharbeit.main;

import com.facharbeit.io.*;
import com.facharbeit.main.Frame;
import com.facharbeit.tools.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.lang.reflect.*;
import java.nio.file.*;
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
            frame.setVisible(true);

            Logger.init(frame.getStatusPane(), frame.getProgBar());
            Settings.init();

            frame.loadSettings();
            frame.addWindowListener(new FrameActions(frame));

            initTray();
            initData();

            running = true;
        } catch(Exception ex)
        {
            Logger.log("Anwendung konnte nicht initialisiert werden", 2);
            Logger.error(ex);
        }
    }

    /**
     * Initialisiert den Data-Ordner.
     */
    private void initData()
    {
        try
        {
            copy("antonianumLogo.png");
            copy("TEMPLATE heute morgen.html");
            copy("TEMPLATE laufschrift.html");
            copy("VERTRETUNGSPLAN.html");
            copy("TEMPLATE style.css");
        } catch(Exception ex)
        {
            Logger.log("Data-Ordner konnte nicht initialisiert werden", 2);
            Logger.error(ex);
        }
    }

    /**
     * Kopiert Dateien.
     *
     * @param name Name der Datei
     */
    private void copy(String name)
    {
        try
        {
            if(!Files.exists(Paths.get(".\\Data\\" + name)))
            {
                Files.createDirectories(Paths.get(".\\Data\\"));
                InputStream in = getClass().getResourceAsStream("/com/facharbeit/ressources/stdData/" + name);
                FileOutputStream out = new FileOutputStream(new File(".\\Data\\" + name));

                for(int read; (read = in.read()) != -1;)
                    out.write(read);
                out.flush();

                Logger.log(name + " wurde initialisiert", 0);
            }
        } catch(Exception ex)
        {
            Logger.log("Datei konnte nicht kopiert werden", 2);
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
        } catch(Exception ex)
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

                if(lastTime < currentTime - 300000)
                {
                    lastTime = System.currentTimeMillis();
                    Application.addToQueue("genAllBtnActionPerformed");
                }
            }
        } catch(Exception ex)
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
            Method[] methods = QueueableMethods.class.getMethods();
            Method theMethod = null;

            for(Method method : methods)
                if(method.getName().equals(methodName))
                {
                    theMethod = method;
                    break;
                }

            queue.add(new QueueElement(theMethod, args));
        } catch(Exception ex)
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
            if(queue.size() > 0)
            {
                queue.get(0).invoke();
                queue.remove(0);
            }
        } catch(Exception ex)
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
            TrayIcon trayIcon = new TrayIcon(icon);
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

            tray.add(trayIcon);
        } catch(Exception ex)
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
            genAll.addActionListener(new java.awt.event.ActionListener()
            {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    Application.addToQueue("genAllBtnActionPerformed");
                }
            });
            genToday.addActionListener(new java.awt.event.ActionListener()
            {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    Application.addToQueue("genTodayBtnActionPerformed");
                }
            });
            genTomorrow.addActionListener(new java.awt.event.ActionListener()
            {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    Application.addToQueue("genTomorrowBtnActionPerformed");
                }
            });
            genMotd.addActionListener(new java.awt.event.ActionListener()
            {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    Application.addToQueue("genMotdBtnActionPerformed", new JTextField());
                }
            });
            backup.addActionListener(new java.awt.event.ActionListener()
            {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    Application.addToQueue("createBackupBtnActionPerformed");
                }
            });
            removeSources.addActionListener(new java.awt.event.ActionListener()
            {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    Application.addToQueue("deleteSourceBtnActionPerformed");
                }
            });
            show.addActionListener(new java.awt.event.ActionListener()
            {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    frame.setExtendedState(JFrame.NORMAL);
                    frame.setVisible(true);
                }
            });
            hide.addActionListener(new java.awt.event.ActionListener()
            {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    frame.setVisible(false);
                }
            });
            exitItem.addActionListener(new java.awt.event.ActionListener()
            {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    System.exit(0);
                }
            });
        } catch(Exception ex)
        {
            Logger.log("Aktionen der Menüitems konnten nicht gesetzt werden", 2);
            Logger.error(ex);
        }
    }
}
