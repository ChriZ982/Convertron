package eu.convertron.interlib.logging;

import eu.convertron.interlib.logging.messages.LogErrorMessage;
import eu.convertron.interlib.logging.messages.LogMessage;
import eu.convertron.interlib.logging.messages.LogPriority;

/** Registriert alle Aktionen und gibt diese sowohl im Programm als auch in einer Datei aus. */
public class Logger
{
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

    /**
     * Zur Ausgabe von Nachrichten und Fehlern.
     * @param logMessage Nachricht oder Fehler
     */
    private static void log(LogMessage logMessage)
    {
        try
        {
            Thread.sleep(1);
            LogTable.addLogMessage(logMessage);
            LogFile.addLogMessage(logMessage);
        }
        catch(InterruptedException ex)
        {
            throw new RuntimeException("Thread could not sleep", ex);
        }
    }
}
