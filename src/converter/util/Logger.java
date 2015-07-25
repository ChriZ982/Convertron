package converter.util;

import converter.io.FileIO;
import converter.modules.overview.OverviewView;
import java.awt.Color;
import javax.swing.text.*;

/**
 * Klasse, die alle Aktionen registriert und im Programm ausgibt.
 */
public class Logger
{
    public static final int INFO = 0;
    public static final int HINT = 1;
    public static final int ERROR = 2;

    public static final String[] IO_EXCEPTION =
    {
        "Es gab einen Schreibfehler", "Prüfen Sie die Verfügbarkeit von Laufwerken, Ordnern und Berechtigungen"
    };
    public static final String[] SECURITY_EXCEPTION =
    {
        "Eine Sicherheitseinstellung wurde verletzt", "Prüfen Sie die Sicherteitseinstellungen"
    };

    private static FileIO log = new FileIO(".\\Logs\\" + Time.date() + ".log");
    private static boolean logInfos = true;

    /**
     * Standard zur Ausgabe von Fehlern oder Informationen.
     *
     * @param text        Ausgegebener Text
     * @param what
     * @param whyHelp
     * @param whatWhyHelp
     * @param error
     * @param reason
     * @param advice
     * @param prio        Priorität des Textes. 0-INFO, 1-PROBLEM, 2-FEHLER
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

    protected static String buildErrorMessage(String what, String[] whyHelp)
    {
        String message = Time.log() + what + "\n";
        if(whyHelp.length >= 1)
            message += "WARUM: " + whyHelp[0] + "\n";
        if(whyHelp.length == 2)
            message += "HILFE: " + whyHelp[1] + "\n";
        return message;
    }

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

    public static void setLogInfos(boolean logInfos)
    {
        Logger.logInfos = logInfos;
    }
}
