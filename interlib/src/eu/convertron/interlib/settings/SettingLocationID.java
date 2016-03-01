package eu.convertron.interlib.settings;

import eu.convertron.interlib.io.TextFile;

public interface SettingLocationID
{
    /**
     * Gibt die TextFile zurück, die zu diesem Einstellungsort gehört.
     * @return Die TextFile dieses Einstellungorts
     */
    public TextFile getFile();
}
