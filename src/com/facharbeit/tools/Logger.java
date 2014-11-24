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

    /**
     * "Konstruktor".
     *
     * @param out Textfeld für die Ausgabe
     */
    public static void init(JTextPane out)
    {
        textPane = out;
    }

    /**
     * Standard zur Ausgabe von Fehlern oder Informationen.
     *
     * @param text Ausgegebener Text
     * @param prio Priorität des Textes. 0-INFO, 1-PROBLEM, 2-FEHLER
     */
    public static void log(String text, int prio)
    {
        String priority;
        Color color;

        switch(prio)
        {
            case 0:
                priority = "INFO";
                color = new Color(0, 100, 0);
                break;

            case 1:
                priority = "PROBLEM";
                color = new Color(200, 165, 0);
                break;

            case 2:
                priority = "FEHLER";
                color = new Color(160, 0, 0);
                break;

            default:
                priority = "UNBEKANNT";
                color = Color.BLACK;
                break;
        }

        String content = "[" + timestamp() + "] " + priority + ": " + text + "\n"; //Ausgabe-String wird zusammengestellt.

        SimpleAttributeSet set = new SimpleAttributeSet(); //Attribut-Set zur verwaltung der Farbe wird erstellt.
        StyleConstants.setForeground(set, color); //Farbe wird gesetzt.
        Document doc = textPane.getStyledDocument();

        try
        {
            doc.insertString(doc.getLength(), content, set); //Text wird mit Farbe ausgegeben.
        } catch(BadLocationException ex)
        {
            System.out.println("KONNTE LOG NICHT ERWEITERN!");
        }

        textPane.setCaretPosition(doc.getLength());
    }

    /**
     * Erstellt einen benutzerdefinierten Zeitstempel.
     *
     * @return Datum u. Zeit als String
     */
    private static String timestamp()
    {
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.DAY_OF_MONTH) + "."
               + c.get(Calendar.MONTH) + "."
               + String.valueOf(c.get(Calendar.YEAR)).substring(2) + " "
               + c.get(Calendar.HOUR_OF_DAY) + ":"
               + c.get(Calendar.MINUTE) + ":"
               + c.get(Calendar.SECOND);
    }
}
