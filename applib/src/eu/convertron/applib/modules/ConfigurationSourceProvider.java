package eu.convertron.applib.modules;

import eu.convertron.interlib.config.ConfigurationSource;

public interface ConfigurationSourceProvider
{
    public ConfigurationSource getOrCreateConfiguration(Class<?> module);

    public ConfigurationSource getOrCreateConfiguration(String moduleName);
}
