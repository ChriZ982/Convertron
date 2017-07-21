package eu.convertron.interlib.config;

import eu.convertron.interlib.logging.LogPriority;
import eu.convertron.interlib.logging.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SingleConfigurationListener implements ConfigurationListener
{
    private ArrayList<ConfigFileListener> listeners;
    private String configFile;

    public SingleConfigurationListener(ConfigurationSource config, String configFile, ConfigFileListener... ls)
    {
        this(configFile, ls);
        config.addConfigListener(this);
    }

    public SingleConfigurationListener(String configFile, ConfigFileListener... ls)
    {
        listeners = new ArrayList<>();
        listeners.addAll(Arrays.asList(ls));

        this.configFile = configFile;
    }

    public void addConfigFileListener(ConfigFileListener l)
    {
        listeners.add(l);
    }

    public boolean removeConfigFileListener(ConfigFileListener l)
    {
        return listeners.remove(l);
    }

    @Override
    public void configurationChanged(HashMap<String, byte[]> changed, boolean complete)
    {
        if(changed.containsKey(configFile))
        {
            configFileChanged(changed.get(configFile));
        }
    }

    @Override
    public void newConfigurationAdded(String name)
    {
    }

    protected void configFileChanged(byte[] value)
    {
        for(ConfigFileListener l : listeners)
        {
            try
            {
                l.configFileChanged(value);
            }
            catch(Exception ex)
            {
                Logger.logError(LogPriority.WARNING, "Fehler beim Ausführen eines 'configfile-changed' Ereignisses", ex);
            }
        }
    }
}
