package eu.convertron.interlib.config;

public class LoadingContext
{
    private final Purpose purpose;
    private final Location location;

    public LoadingContext(Purpose purpose, Location location)
    {
        this.purpose = purpose;
        this.location = location;
    }

    public Purpose getPurpose()
    {
        return purpose;
    }

    public Location getLocation()
    {
        return location;
    }

    /**
     * Gibt an ob alle Funktionalitäten des Moduls gebraucht werden oder nur die lokalen Einstellungen angepasst werden können müssen.
     */
    public enum Purpose
    {
        /**
         * Das Modul wurde geladen um zu arbeiten. Das heißt alle Funktionalitäten werden gebraucht:
         * - Exportieren/Importieren
         * - Globale Einstellungen anpassen
         * - Lokale Einstellungen anpassen
         */
        Excecution,
        /**
         * Das Modul wurde geladen um Einstellungen am Server zu verändern.
         * Es müssen nur die lokalen Einstellungen des Moduls angepasst werden können
         */
        Configuration
    }

    /**
     * Gibt an in welcher Umgebung das Modul geladen wurde.
     */
    public enum Location
    {
        /**
         * Client im Remote Modus (mit Server)
         */
        Client_Remote_Mode,
        /**
         * Client, der sich nicht im Remote Modus befindet (nur der Client)
         */
        Client_Standalone_Mode,
        /**
         * Server
         */
        Server
    }
}
