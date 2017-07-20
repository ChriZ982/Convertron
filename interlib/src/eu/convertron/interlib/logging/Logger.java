package eu.convertron.interlib.logging;

import java.util.ArrayList;

/** Registriert alle Aktionen und gibt diese sowohl im Programm als auch in einer Datei aus. */
public class Logger
{
    private final static ArrayList<LogOutput> output;
    private final static LogBuffer buffer;

    static
    {
        output = new ArrayList<>();
        buffer = new LogBuffer();
        output.add(buffer);
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
        return addLogOutput(out, true);
    }

    public static boolean addLogOutput(LogOutput out, boolean insertBuffer)
    {
        if(output.contains(out))
            return false;

        if(insertBuffer && !buffer.copyTo(out))
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
            for(int i = 0; i < output.size(); i++)
            {
                Thread.sleep(10);
                logSingle(output.get(i), logMessage);
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

    private static class LogBuffer implements LogOutput
    {
        private final ArrayList<LogMessage> messages;

        private LogBuffer()
        {
            messages = new ArrayList<>();
        }

        @Override
        public void addLogMessage(LogMessage message)
        {
            messages.add(message);
        }

        public boolean copyTo(LogOutput out)
        {
            try
            {
                for(LogMessage message : messages)
                    out.addLogMessage(message);
                return true;
            }
            catch(Throwable t)
            {
                Logger.logError(LogPriority.WARNING, "Failed to copy Buffer to LogOutput.", t);
                return false;
            }
        }
    }
}
