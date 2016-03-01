package eu.convertron.interlib.settings;

public interface SettingID
{
    /**
     * Gibt den Speicherort dieser Einstellung zurück.
     * @return Den Speicherort dieser Einstellung
     */
    public SettingLocationID getLocation();

    /**
     * Gibt den Namen dieser Einstellung zurück.
     * @return Den Speicherort dieser Einstellung
     */
    public String getName();

    /**
     * Gibt den Ort der Datei mit dem Standardwert dieser Einstellung zurück.
     * @return Den Ort der Datei mit dem Standardwert oder <code>null</code> wenn kein Standardwert existiert
     */
    public SettingLocationID getFileWithDefaultValues();
}
