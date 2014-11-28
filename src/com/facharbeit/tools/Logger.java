package com.facharbeit.tools;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.text.*;

/**
 * Klasse, die alle Aktionen registriert und im Programm ausgibt.
 */
public class Logger
{
    /**
     * Textfeld zur Ausgabe des Logs.
     */
    public static JTextPane textPane;

    public static JProgressBar progressBar;

    /**
     * "Konstruktor".
     *
     * @param out  Textfeld für die Ausgabe
     * @param prog
     */
    public static void init(JTextPane out, JProgressBar prog)
    {
        textPane = out;
        progressBar = prog;
    }

    /**
     * Standard zur Ausgabe von Fehlern oder Informationen.
     *
     * @param text Ausgegebener Text
     * @param prio Priorität des Textes. 0-INFO, 1-PROBLEM, 2-FEHLER
     */
    public static void log(String text, int prio)
    {
        Color color;

        switch(prio)
        {
            case 0:
                color = new Color(0, 100, 0);
                break;

            case 1:
                color = new Color(200, 165, 0);
                break;

            case 2:
                color = new Color(160, 0, 0);
                break;

            default:
                color = Color.BLACK;
                break;
        }

        String content = "[" + timestamp() + "] " + text + "\n";

        SimpleAttributeSet set = new SimpleAttributeSet();
        StyleConstants.setForeground(set, color);
        Document doc = textPane.getStyledDocument();

        try
        {
            doc.insertString(doc.getLength(), content, set);
        } catch(BadLocationException ex)
        {
            System.out.println("KONNTE LOG NICHT ERWEITERN!");
        }

        textPane.setCaretPosition(doc.getLength());
    }

    public static void setProgress(int value)
    {
        progressBar.setValue(value);
    }

    /**
     * Erstellt einen benutzerdefinierten Zeitstempel.
     *
     * @return Datum u. Zeit als String
     */
    private static String timestamp()
    {
        Calendar c = Calendar.getInstance();
        return String.format("%02d", c.get(Calendar.HOUR_OF_DAY)) + ":"
               + String.format("%02d", c.get(Calendar.MINUTE)) + ":"
               + String.format("%02d", c.get(Calendar.SECOND));
    }
}
