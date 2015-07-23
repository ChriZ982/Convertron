package converter.util;

import converter.io.FileTMP;
import converter.modules.overview.OverviewView;
import java.awt.Color;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.swing.text.*;

/**
 * Klasse, die alle Aktionen registriert und im Programm ausgibt.
 */
public class Logger
{
    /**
     * Der interne Log. Wird bei Fehlerausgaben verwendet
     */
    private static String internLog = "";

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

            logIntern(text);

            SimpleAttributeSet set = new SimpleAttributeSet();
            StyleConstants.setForeground(set, color);
            Document doc = OverviewView.getLog().getStyledDocument();
            doc.insertString(doc.getLength(), content, set);
            OverviewView.getLog().setCaretPosition(doc.getLength());

        }
        catch(Exception ex)
        {
            System.err.println("Konnte eine Aktion nicht dokumentieren");
            ex.printStackTrace();
        }
    }

    public static void logIntern(String text)
    {
        internLog += Time.log() + text + "\n\n";
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
            FileTMP writer = new FileTMP("Errors/err" + Time.error() + ".txt");
            writer.create();

            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);

            exception.printStackTrace(pw);
            pw.print("\n");
            if(exception.getCause() != null)
                exception.getCause().printStackTrace(pw);

            writer.write(0, sw.toString() + "\n"
                            + internLog);

        }
        catch(Exception ex)
        {
            System.err.println("Error konnte nicht dokumentiert werden");
            ex.printStackTrace();
        }
    }
}
