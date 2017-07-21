package eu.convertron.interlib.config;

public class ModuleConfiguration
{
    public final ConfigurationSource local;
    public final ConfigurationSource global;

    public ModuleConfiguration(ConfigurationSource local, ConfigurationSource global)
    {
        this.local = local;
        this.global = global;
    }
}
