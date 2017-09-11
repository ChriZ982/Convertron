package eu.convertron.interlib.config;

import eu.convertron.interlib.logging.LogPriority;
import eu.convertron.interlib.logging.Logger;
import java.nio.charset.Charset;
import java.util.ArrayList;
import static java.nio.charset.StandardCharsets.UTF_8;

public abstract class AbstractConfigFile
{
    protected ModuleConfiguration configuration;
    protected String configName;
    protected Charset charset;
    protected DesiredLocation location;

    protected final ArrayList<ConfigFileListener> listeners;

    protected AbstractConfigFile(ModuleConfiguration configuration, String configName, DesiredLocation location)
    {
        this(configuration, configName, location, UTF_8);
    }

    public AbstractConfigFile(ModuleConfiguration configuration, String configName, DesiredLocation location, Charset charset)
    {
        this.configuration = configuration;
        this.configName = configName;
        this.location = location;
        this.charset = charset;

        listeners = new ArrayList<>();
        configuration.addConfigListener((changed)
                ->
                {
                    if(changed.containsKey(configName))
                    {
                        fireConfigFileChanged(changed.get(configName));
                    }
        }
        );
    }

    protected void fireConfigFileChanged(ConfigFileChangeInfo info)
    {
        for(ConfigFileListener l : listeners)
        {
            try
            {
                l.configFileChanged(info);
            }
            catch(Exception ex)
            {
                Logger.logError(LogPriority.WARNING, "Fehler beim Ausführen eines 'config-file-changed' Ereignisses", ex);
            }
        }
    }

    public void addConfigFileListener(ConfigFileListener l)
    {
        listeners.add(l);
    }

    public boolean removeConfigFileListener(ConfigFileListener l)
    {
        return listeners.remove(l);
    }

    public ModuleConfiguration getConfiguration()
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
        return configuration.getOrCreateConfig(configName, location);
    }
}
