package eu.convertron.interlib.config;

import eu.convertron.interlib.io.ResourceFile;

public class GeneralConfigFile extends AbstractConfigFile
{
    public GeneralConfigFile(ConfigurationSource configuration, String configName)
    {
        super(configuration, configName);
    }

    public GeneralConfigFile(ConfigurationSource configuration, String configName, ResourceFile defaults)
    {
        this(configuration, configName);
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
