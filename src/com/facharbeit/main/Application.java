package com.facharbeit.main;

import com.facharbeit.io.*;
import com.facharbeit.main.Frame;
import com.facharbeit.tools.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
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
     * Gibt an ob die Anwendung laufen soll.
     */
    private boolean running;

    private static ArrayList<QueueElement> queue;

    /**
     * Erstellt die Anwendung.
     */
    public Application()
    {
        queue = new ArrayList<QueueElement>();

        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); // Bestimmt das Aussehen der Anwendung
        } catch(ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex)
        {
        }

        frame = new Frame();
        frame.setVisible(true);

        Logger.init(frame.getStatusPane(), frame.getProgBar());
        Settings.init();

        frame.loadSettings();

        initTray();

        running = true;
    }

    /**
     * Ruft die "main-Methode" der Anwendung auf.
     *
     * @param args Parameter, die beim Aufruf des Programms übergeben wurden
     */
    public static void main(String[] args)
    {
        Application app = new Application();
        app.run();
    }

    /**
     * While-Schleife, die das ganze Programm über läuft. Ähnlich der main.Methode.
     */
    public void run()
    {
        long time;
        long cTime;
        while(running)
        {
            time = System.currentTimeMillis();
            runOneElementOfQueue();
            cTime = System.currentTimeMillis();

            try
            {
                if(cTime < time + 100 && cTime > time)
                    Thread.sleep((time - cTime) + 100);
            } catch(InterruptedException ex)
            {
                System.out.println("MAIN-SCHLEIFE KONNTE NICHT PAUSIEREN!");
            }
        }
    }

    public static void addToQueue(String methodName, Object... args)
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
    }

    private void runOneElementOfQueue()
    {
        if(queue.size() > 0)
        {
            queue.get(0).invoke();
            queue.remove(0);
        }
    }

    private void initTray()
    {
        BufferedImage icon;
        try
        {
            icon = ImageIO.read(getClass().getResource("/com/facharbeit/ressources/trayLogo.png"));
        } catch(IOException ex)
        {
            Logger.log("Tray konnte nicht initialisiert werden", 2);
            return;
        }

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

        try
        {
            tray.add(trayIcon);
        } catch(AWTException ex)
        {
        }
    }

    private void setMenuItems(MenuItem genAll, MenuItem genToday, MenuItem genTomorrow, MenuItem genMotd, MenuItem backup,
                              MenuItem removeSources, MenuItem show, MenuItem hide, MenuItem exitItem)
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
    }
}
