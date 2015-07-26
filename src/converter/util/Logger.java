package converter.util;

import converter.io.FileIO;
import converter.modules.overview.OverviewView;
import java.awt.Color;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/** Klasse, die alle Aktionen registriert und sowohl im Programm als auch in einer Datei ausgibt. */
public class Logger
{
    /** Wird zur Priorisierung verwendet (Information). */
    public static final int INFO = 0;
    /** Wird zur Priorisierung verwendet (Hinweis). */
    public static final int HINT = 1;
    /** Wird zur Priorisierung verwendet (Warnung). */
    public static final int WARNING = 2;
    /** Wird zur Priorisierung verwendet (Fehler). */
    public static final int ERROR = 3;

    /** Wird zum Speichern des Logs verwendet. */
    protected static FileIO log = new FileIO("./Logs/" + Time.date() + ".log");

    /** Wird nur im Programm zum Ausblenden von unwichtigen Optionen verwendet. */
    protected static boolean logInfos = true;

    /**
     * Standard zur Ausgabe von Fehlern oder Informationen.
     * @param what    Was ist passiert?
     * @param whyHelp Warum kam es zum Fehler? Wie kann man ihn beheben?
     * @param prio    Priorität des Textes. Nutzung der statischen Variablen z.B. Logger.ERROR
     */
    public static void log(int prio, String what, String... whyHelp)
    {
        String errorMessage = buildErrorMessage(what, whyHelp);
        log.create();
        log.appendLines(errorMessage);
        if(prio == INFO && !logInfos)
            return;
        writeInTextBox(errorMessage, selectColor(prio));
    }

    public static void error(int prio, RuntimeException exception)
    {
        String errorMessage = buildErrorMessage(what, whyHelp);
        log.create();
        log.appendLines(errorMessage);
        if(prio == INFO && !logInfos)
            return;
        writeInTextBox(errorMessage, selectColor(prio));
    }

    /**
     * Erzeugt die eigentliche Fehler Nachricht.
     * @param what    Was ist passiert?
     * @param whyHelp Warum kam es zum Fehler? Wie kann man ihn beheben?
     * @return Fehler Nachricht
     */
    protected static String buildErrorMessage(String what, String[] whyHelp)
    {
        String message = Time.log() + what + "\n";
        if(whyHelp.length >= 1)
            message += "WARUM: " + whyHelp[0] + "\n";
        if(whyHelp.length == 2)
            message += "HILFE: " + whyHelp[1] + "\n";
        return message;
    }

    /**
     * Wählt die Farbe im Programm anhand von der Priorität.
     * @param prio Priorität
     * @return Farbe
     */
    protected static Color selectColor(int prio)
    {
        if(prio == INFO)
            return new Color(120, 120, 120);
        else if(prio == HINT)
            return new Color(0, 100, 0);
        else if(prio == ERROR)
            return new Color(160, 0, 0);
        else
            return Color.BLACK;
    }

    /**
     * Schreibt den Text in die vorgesehene Box im Programm.
     * @param errorMessage Text
     * @param color        Farbe des Textes
     */
    protected static void writeInTextBox(String errorMessage, Color color)
    {
        try
        {
            SimpleAttributeSet set = new SimpleAttributeSet();
            StyleConstants.setForeground(set, color);
            Document doc = OverviewView.getLog().getStyledDocument();
            doc.insertString(doc.getLength(), errorMessage, set);
            OverviewView.getLog().setCaretPosition(doc.getLength());
        }
        catch(BadLocationException ex)
        {
            Logger.log(ERROR, "Es konnte nicht in die Textbox für Logs geschrieben werden", "Die Position zum Einfügen ist fehlerhaft", "Wenden Sie sich an einen Entwickler");
        }
    }

    /**
     * Bestimmt ob unwichtige Informationen angezeigt werden sollen.
     * @param logInfos Sollen Informationen angezeigt werden?
     */
    public static void setLogInfos(boolean logInfos)
    {
        Logger.logInfos = logInfos;
    }
}
