package eu.convertron.interlib.settings;

public interface SettingID
{
    /**
     * Gibt den Namen dieser Einstellung zurück.
     * @return Den Speicherort dieser Einstellung
     */
    public String getName();

    /**
     * Gibt den Standardwert dieser Einstellung zurück.
     * @return Den Standardwert oder <code>null</code> wenn kein Standardwert existiert
     */
    public String getDefaultValue();
}
