package eu.convertron.applib.modules;

import eu.convertron.interlib.config.ModuleConfiguration;
import eu.convertron.interlib.config.MoveConflictUserCallback;

public class ModuleConfigurationProvider
{
    private final ConfigurationSourceProvider localProvider;
    private final ConfigurationSourceProvider globalProvider;
    private final MoveConflictUserCallback callback;

    public ModuleConfigurationProvider(ConfigurationSourceProvider localProvider,
                                       ConfigurationSourceProvider globalProvider,
                                       MoveConflictUserCallback callback)
    {
        this.localProvider = localProvider;
        this.globalProvider = globalProvider;
        this.callback = callback;
    }

    public ModuleConfiguration provideConfig(Class<?> module)
    {
        return provideConfig(module.getName());
    }

    public ModuleConfiguration provideConfig(String moduleName)
    {
        return new ModuleConfiguration(localProvider.getOrCreateConfiguration(moduleName),
                                       globalProvider.getOrCreateConfiguration(moduleName),
                                       moduleName,
                                       callback);
    }
}
