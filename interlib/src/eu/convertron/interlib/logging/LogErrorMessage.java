package eu.convertron.interlib.logging;

/** Stellt die Fehlernachrichten für den Logger da. */
public class LogErrorMessage extends LogMessage
{
    /** Enthält die Fehlerbeschreibung für Anwender. */
    private final String stackTrace;
    /** Enthält die Fehlerbeschreibung für Entwickler */
    private final String stackTraceDetailed;
    /** Soll die Fehlerbeschreibung für Anwender komplett angezeigt werden?. */
    private boolean logDevInfos;

    /**
     * Konstruktor.
     * @param priority  Wichtigkeit des Fehlers
     * @param message   nachricht des Fehlers
     * @param exception Fehler für die spätere Ausgabe
     */
    public LogErrorMessage(LogPriority priority, String message, Throwable exception)
    {
        super(priority, message);

        this.stackTrace = "\n-> " + getErrorMessage(exception);
        this.stackTraceDetailed = "\n       " + getErrorMessageDetailed(exception);
    }

    /**
     * Baut die Fehlerbeschreibung für Anwender.
     * @param exception Fehler
     * @return Fehlerbeschreibung
     */
    private String getErrorMessage(Throwable exception)
    {
        String errorMessage = exception.getClass().getSimpleName() + ": " + exception.getMessage() + "\n";
        if(exception.getCause() != null)
            errorMessage += "-> " + getErrorMessage(exception.getCause());

        return errorMessage.trim();
    }

    /**
     * Baut die Fehlerbeschreibung für Entwickler.
     * @param exception Fehler
     * @return Fehlerbeschreibung
     */
    private String getErrorMessageDetailed(Throwable exception)
    {
        StringBuilder errorMessage = new StringBuilder("EXCEPTION: " + exception.toString() + "\n");

        for(StackTraceElement stackTraceElement : exception.getStackTrace())
        {
            errorMessage.append("                  ");
            errorMessage.append(stackTraceElement.toString());
            errorMessage.append("\n");
        }

        if(exception.getCause() != null)
        {
            errorMessage.append("       CAUSED BY ");
            errorMessage.append(getErrorMessageDetailed(exception.getCause()));
        }
        return errorMessage.toString().trim();
    }

    /**
     * Gets the simple Message.
     * @return Message
     */
    @Override
    public String getMessage()
    {
        if(logDevInfos)
            return super.getMessage() + stackTrace;
        return super.getMessage();
    }

    /**
     * Gets the complex Message.
     * @return Message
     */
    @Override
    public String getMessageDetailed()
    {
        return super.getMessage() + stackTraceDetailed;
    }

    /**
     * Sets Logging of detailed Information.
     * @param logDevInfos Detailed Logging?
     */
    @Override
    public void setLogDevInfos(boolean logDevInfos)
    {
        this.logDevInfos = logDevInfos;
    }
}
