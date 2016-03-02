package eu.convertron.applib;

import eu.convertron.interlib.io.TextFile;
import eu.convertron.interlib.logging.LogMessage;
import eu.convertron.interlib.logging.LogOutput;
import eu.convertron.interlib.util.Time;

/** Gibt Fehler und Nachrichten in einer Datein aus. */
public class LogFile implements LogOutput
{
    /** Datei f�r den Log. */
    protected TextFile logFile;

    public LogFile()
    {
        this("./Logs/" + Time.formatNow("yyyy-MM-dd_HH-mm-ss") + ".log");
    }

    public LogFile(String path)
    {
        this.logFile = new TextFile(path);
    }

    /**
     * H�ngt Nachrichten oder Fehler an die Datei an.
     * @param logMessage Nachricht oder Fehler
     */
    @Override
    public void addLogMessage(LogMessage logMessage)
    {
        logFile.createIfNotExists();
        logFile.appendLines("[" + logMessage.getPriority().getNameString() + "] [" + logMessage.getTimeStringDetailed() + "]");
        logFile.appendLines("       " + logMessage.getMessageDetailed() + "\n");
    }
}
