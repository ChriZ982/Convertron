package com.facharbeit.tools;

import com.facharbeit.io.FileWriter;
import java.awt.Color;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.swing.JProgressBar;
import javax.swing.JTextPane;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/**
 * Klasse, die alle Aktionen registriert und im Programm ausgibt.
 */
public class Logger
{
    /**
     * Textfeld zur Ausgabe des Logs.
     */
    private static JTextPane textPane;

    /**
     * Fortschritts-Anzeige.
     */
    private static JProgressBar progressBar;

    /**
     * Initialisiert den Logger.
     *
     * @param out  Textfeld für die Ausgabe
     * @param prog Fortschrittsbalken
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
        try
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
            String content = Time.log() + text + "\n";

            SimpleAttributeSet set = new SimpleAttributeSet();
            StyleConstants.setForeground(set, color);
            Document doc = textPane.getStyledDocument();
            doc.insertString(doc.getLength(), content, set);
            textPane.setCaretPosition(doc.getLength());
        } catch(Exception ex)
        {
            Logger.log("Konnte eine Aktion nicht dokumentieren", 2);
            Logger.error(ex);
        }
    }

    /**
     * Dokumentiert einen Fehler und speichert ihn.
     *
     * @param exception Der Fehler
     */
    public static void error(Exception exception)
    {
        try
        {
            FileWriter writer = new FileWriter("Errors/", "err" + Time.error() + ".txt");
            writer.create();

            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            exception.printStackTrace(pw);

            writer.write(0, exception.toString() + "\n\n"
                            + exception.getLocalizedMessage() + "\n\n"
                            + exception.getMessage() + "\n\n"
                            + sw.toString());
        } catch(Exception ex)
        {
            Logger.log("Error konnte nicht dokumentiert werden", 2);
            Logger.error(ex);
        }
    }

    /**
     * Setzt den Fortschritt.
     *
     * @param value Neuer Wert
     */
    public static void setProgress(int value)
    {
        try
        {
            progressBar.setValue(value);
        } catch(Exception ex)
        {
            Logger.log("Fortschritt konnte nicht geändert werden", 2);
            Logger.error(ex);
        }
    }
}
