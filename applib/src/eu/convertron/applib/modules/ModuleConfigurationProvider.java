package eu.convertron.applib.modules;

import eu.convertron.interlib.config.ModuleConfiguration;

public class ModuleConfigurationProvider
{
    private final ConfigurationSourceProvider localProvider;
    private final ConfigurationSourceProvider globalProvider;

    public ModuleConfigurationProvider(ConfigurationSourceProvider localProvider, ConfigurationSourceProvider globalProvider)
    {
        this.localProvider = localProvider;
        this.globalProvider = globalProvider;
    }

    public ModuleConfiguration provideConfig(Class<?> module)
    {
        return new ModuleConfiguration(localProvider.getOrCreateConfiguration(module),
                                       globalProvider.getOrCreateConfiguration(module));
    }

    public ModuleConfiguration provideConfig(String moduleName)
    {
        return new ModuleConfiguration(localProvider.getOrCreateConfiguration(moduleName),
                                       globalProvider.getOrCreateConfiguration(moduleName));
    }
}
