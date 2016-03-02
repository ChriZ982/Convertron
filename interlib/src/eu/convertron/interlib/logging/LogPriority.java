package eu.convertron.interlib.logging;

import java.awt.Color;

/** Wichtigkeit der Nachtichten für den Logger. */
public enum LogPriority
{
    /** Niedrigste Priorität: Kann ausgeblendet werden, also für Debug-Zwecke. */
    INFO,
    /** Hinweis: Sollte bei erfolgreichen Operationen verwendet werden. */
    HINT,
    /** Warnung: Sollte auf problematische Fehler hinweisen, die die Anwendung nicht daran hindern weiterzulaufen. */
    WARNING,
    /** Fehler: Sollte sehr kritische Fehler beschreiben, die zum Absturz der Anwendung führen könnten. */
    ERROR;

    /**
     * Gibt den Namen der Priorität für den Log-File.
     * @return Name
     */
    public String getNameString()
    {
        switch(this)
        {
            case INFO:
                return "INFO";
            case WARNING:
                return "WARN";
            case HINT:
                return "HINT";
            case ERROR:
                return "ERRO";
            default:
                return "UNKW";
        }
    }

    /**
     * Gibt die Farbe für die Ausgabe in der Anwendung.
     * @return Farbe
     */
    public Color getColor()
    {
        switch(this)
        {
            case INFO:
                return Color.GRAY;//new Color(120, 120, 120);
            case WARNING:
                return new Color(220, 160, 0);
            case HINT:
                return new Color(0, 160, 0);
            case ERROR:
                return Color.RED;//new Color(160, 0, 0);
            default:
                return Color.BLACK;
        }
    }
}
