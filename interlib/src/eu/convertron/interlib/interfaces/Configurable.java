package eu.convertron.interlib.interfaces;

import eu.convertron.interlib.config.ModuleConfiguration;

public interface Configurable
{
    /**
     * Setzt die Konfiguration.
     * @param moduleConfig Die Modulkonfiguration bestehend aus allen lokalen und globalen Config-Files
     */
    public void setConfiguration(ModuleConfiguration moduleConfig);
}
