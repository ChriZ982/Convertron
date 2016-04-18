package eu.convertron.interlib.data;

import eu.convertron.interlib.io.ResourceFile;
import static java.nio.charset.StandardCharsets.UTF_8;

public class GeneralConfigFile
{
    private Configuration configuration;
    private String configName;

    public GeneralConfigFile(Configuration configuration, String configName)
    {
        this.configuration = configuration;
        this.configName = configName;
    }

    public GeneralConfigFile(Configuration configuration, String configName, ResourceFile defaults)
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
           || new String(configuration.getConfig(configName), UTF_8).trim().isEmpty())
        {
            configuration.setConfig(configName, f.readAllBytes());
        }
    }

    public byte[] load()
    {
        return configuration.getConfig(configName);
    }

    public String loadString()
    {
        return new String(load(), UTF_8);
    }

    public void save(byte[] value)
    {
        configuration.setConfig(configName, value);
    }

    public void save(String value)
    {
        save(value.getBytes(UTF_8));
    }

    public void addConifgFileListener(SingleConfigurationListener.ConfigFileListener l)
    {
        configuration.addConfigListener(new SingleConfigurationListener(configName, l));
    }
}
