package eu.convertron.interlib.config;

import eu.convertron.interlib.io.ResourceFile;

public class GeneralConfigFile extends AbstractConfigFile
{
    public GeneralConfigFile(ModuleConfiguration configuration, String configName)
    {
        this(configuration, configName, DesiredLocation.Local);
    }

    public GeneralConfigFile(ModuleConfiguration configuration, String configName, DesiredLocation location)
    {
        this(configuration, configName, location, null);
    }

    public GeneralConfigFile(ModuleConfiguration configuration, String configName, DesiredLocation location, ResourceFile defaults)
    {
        super(configuration, configName, location);
        if(defaults != null)
            loadDefaultsFromResource(defaults);
    }

    public void loadDefaultsFromResource(String resource, Class<?> parent)
    {
        loadDefaultsFromResource(new ResourceFile(resource, parent));
    }

    public void loadDefaultsFromResource(ResourceFile f)
    {
        if(!configuration.hasConfig(configName)
           || loadString().trim().isEmpty())
        {
            save(f.readAllBytes());
        }
    }

    public byte[] load()
    {
        return super.load0();
    }

    public String loadString()
    {
        return super.loadString0();
    }

    public void save(byte[] value)
    {
        super.save0(value);
    }

    public void save(String value)
    {
        super.save0(value);
    }
}
