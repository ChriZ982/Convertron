package eu.convertron.interlib.interfaces;

import eu.convertron.interlib.data.InvalidConfigurationException;
import java.nio.file.Path;
import java.util.Map;

public interface RemoteConfigurable
{
    /**
     * Gibt die Namen der benötigten Konfigurationsdateien zurück.
     * @return Namen der gebrauchten Konfigurationsdateien
     */
    public String[] getNeededConfigFiles();

    /**
     * Setzt die Konfiguration.
     * @param configuration Konfiguration
     * @throws eu.convertron.interlib.data.InvalidConfigurationException
     */
    public void setConfiguration(Map<String, Path> configuration) throws InvalidConfigurationException;

    /**
     * Gibt die Standardkonfiguration zurück.
     * @return
     */
    public Map<String, byte[]> getDefaultConfiguration();
}
