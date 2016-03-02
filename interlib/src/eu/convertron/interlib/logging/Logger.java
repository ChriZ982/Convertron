package eu.convertron.interlib.logging;

import eu.convertron.interlib.logging.messages.LogErrorMessage;
import eu.convertron.interlib.logging.messages.LogMessage;
import eu.convertron.interlib.logging.messages.LogPriority;
import java.util.ArrayList;

/** Registriert alle Aktionen und gibt diese sowohl im Programm als auch in einer Datei aus. */
public class Logger
{
    private static ArrayList<LogOutput> output;

    static
    {
        output = new ArrayList<>();
    }

    /**
     * Zur Ausgabe von Informationen.
     * Schreibt wichtige Nachrichten in das Statusfenster der Anwendung.
     * Hängt die Nachricht an die Datei an.
     * @param message  Text der Nachricht
     * @param priority Priorität der Nachricht
     */
    public static void logMessage(LogPriority priority, String message)
    {
        log(new LogMessage(priority, message));
    }

    /**
     * Zur Ausgabe von Fehlern.
     * Schreibt wichtige Fehler in das Statusfenster der Anwendung.
     * Hängt die Fehler an die Datei an.
     * @param exception Fehler für die Nachricht
     * @param message   Die Ausgabe im Programm
     * @param priority  Priorität der Nachricht
     */
    public static void logError(LogPriority priority, String message, Throwable exception)
    {
        log(new LogErrorMessage(priority, message, exception));
    }

    public static boolean addLogOutput(LogOutput out)
    {
        if(output.contains(out))
            return false;
        output.add(out);
        return true;
    }

    public static boolean removeLogOutput(LogOutput out)
    {
        return output.remove(out);
    }

    /**
     * Zur Ausgabe von Nachrichten und Fehlern.
     * @param logMessage Nachricht oder Fehler
     */
    private static void log(LogMessage logMessage)
    {
        try
        {
            for(LogOutput out : output)
            {
                Thread.sleep(10);
                logSingle(out, logMessage);
            }
        }
        catch(InterruptedException ex)
        {
            throw new RuntimeException("Thread could not sleep", ex);
        }
    }

    private static void logSingle(LogOutput out, LogMessage message)
    {
        try
        {
            out.addLogMessage(message);
        }
        catch(Exception ex)
        {
            output.remove(out);
            logMessage(LogPriority.ERROR, "A LogOutput of type "
                                          + (out == null ? "null" : out.getClass().getName())
                                          + " threw an exception while logging.");
        }
    }

    private Logger()
    {
    }
}
