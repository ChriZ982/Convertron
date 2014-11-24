package com.facharbeit.main;

import com.facharbeit.io.*;
import com.facharbeit.tools.*;
import java.lang.reflect.*;
import java.util.*;
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
    private static boolean doingStuff;

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

        Logger.init(frame.getStatusPane());
        Settings.init();

        frame.loadSettings();

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
        while(running)
        {
            runOneElementOfQueue();

            try
            {
                Thread.sleep(100);
            } catch(InterruptedException ex)
            {
                System.out.println("MAIN-SCHLEIFE KONNTE NICHT PAUSIEREN!");
            }
        }
    }

    public static void addToQueue(String methodName, Object... args)
    {
        Method[] methods = SettingHandler.class.getMethods();
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

    /**
     * Generiert einen zufälligen "Satz".
     *
     * @deprecated
     * @return "Zufalls-Satz"
     */
    private String randomString()
    {
        Random rand = new Random();
        int length = rand.nextInt(60) + 20;
        String s = "";

        for(int i = 0; i < length; i++)
        {
            if(rand.nextInt(5) == 0)
                s += " ";

            s += Character.toLowerCase((char)(rand.nextInt(26) + 65));
        }

        return s;
    }
}
