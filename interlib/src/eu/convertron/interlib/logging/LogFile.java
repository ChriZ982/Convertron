package eu.convertron.interlib.logging;

import eu.convertron.interlib.io.TextFile;
import eu.convertron.interlib.logging.messages.LogMessage;
import eu.convertron.interlib.util.Time;

/** Gibt Fehler und Nachrichten in einer Datein aus. */
public class LogFile
{
    /** Datei für den Log. */
    protected static final TextFile logFile = new TextFile("./Logs/" + Time.formatNow("yyyy-MM-dd_HH-mm-ss") + ".log");

    /**
     * Hängt Nachrichten oder Fehler an die Datei an.
     * @param logMessage Nachricht oder Fehler
     */
    public static void addLogMessage(LogMessage logMessage)
    {
        logFile.createIfNotExists();
        logFile.appendLines("[" + logMessage.getPriority().getNameString() + "] [" + logMessage.getTimeStringDetailed() + "]");
        logFile.appendLines("       " + logMessage.getMessageDetailed() + "\n");
    }
}
