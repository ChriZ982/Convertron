package eu.convertron.interlib.config;

import java.nio.charset.Charset;
import static java.nio.charset.StandardCharsets.UTF_8;

public abstract class AbstractConfigFile
{
    protected ConfigurationSource configuration;
    protected String configName;
    protected Charset charset;

    private SingleConfigurationListener listener;

    protected AbstractConfigFile(ConfigurationSource configuration, String configName)
    {
        this(configuration, configName, UTF_8);
    }

    public AbstractConfigFile(ConfigurationSource configuration, String configName, Charset charset)
    {
        this.configuration = configuration;
        this.configName = configName;
        this.charset = charset;

        this.listener = new SingleConfigurationListener(configName);
        this.configuration.addConfigListener(listener);
    }

    public void addConfigFileListener(ConfigFileListener l)
    {
        listener.addConfigFileListener(l);
    }

    public boolean removeConfigFileListener(ConfigFileListener l)
    {
        return listener.removeConfigFileListener(l);
    }

    public ConfigurationSource getConfiguration()
    {
        return configuration;
    }

    public String getConfigName()
    {
        return configName;
    }

    protected void save0(String value)
    {
        save0(value.getBytes(charset));
    }

    protected void save0(byte[] value)
    {
        configuration.setConfig(configName, value);
    }

    protected String loadString0()
    {
        return new String(load0(), charset);
    }

    protected byte[] load0()
    {
        return configuration.getOrCreateConfig(configName);
    }
}
