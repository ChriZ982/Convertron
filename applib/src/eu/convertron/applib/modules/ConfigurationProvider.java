package eu.convertron.applib.modules;

import eu.convertron.interlib.config.Configuration;

public interface ConfigurationProvider
{
    public Configuration getOrCreateConfiguration(Class<?> module);

    public Configuration getOrCreateConfiguration(String moduleName);
}
