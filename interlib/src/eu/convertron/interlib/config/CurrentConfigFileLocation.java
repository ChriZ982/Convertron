package eu.convertron.interlib.config;

public enum CurrentConfigFileLocation
{
    /**
     * Die Config-File wird aktuell global bezogen.
     */
    Global,

    /**
     * Die Config-File wird aktuell lokal bezogen.
     */
    Local,

    /**
     * Die Config-File exisitert nicht.
     */
    None
}
