package eu.convertron.interlib.logging.messages;

import eu.convertron.interlib.util.Time;
import java.util.Date;

/** Nachricht für den Logger. */
public class LogMessage
{
    /** Zeitpunkt der Nachricht. */
    private final Date time;
    /** Text der Nachricht */
    private final String message;
    /** Wichtigkeit der Nachricht */
    private final LogPriority priority;

    /**
     * Konstruktor.
     * @param priority Wichtigkeit der Nachricht
     * @param message  Text der Nachricht
     */
    public LogMessage(LogPriority priority, String message)
    {
        this.time = new Date();
        this.message = message;
        this.priority = priority;
    }

    /**
     * Gibt den Zeitstempel für die Anwendung.
     * @return Zeitstempel
     */
    public String getTimeString()
    {
        return Time.format(time, "HH:mm:ss");
    }

    /**
     * Gibt den Zeitstempel für die Log-Datei.
     * @return Zeitstempel
     */
    public String getTimeStringDetailed()
    {
        return Time.format(time, "HH:mm:ss_SSS");
    }

    /**
     * Gets the Time.
     * @return Time
     */
    public Date getTime()
    {
        return (Date)time.clone();
    }

    /**
     * Gets the Priority.
     * @return Priority
     */
    public LogPriority getPriority()
    {
        return priority;
    }

    /**
     * Gets the simple Message.
     * @return Message
     */
    public String getMessage()
    {
        return message;
    }

    /**
     * Gets the complex Message.
     * @return
     */
    public String getMessageDetailed()
    {
        return message;
    }

    /**
     * Sets Logging of detailed Information.
     * @param logDevInfos Detailed Logging?
     */
    public void setLogDevInfos(boolean logDevInfos)
    {
    }
}
