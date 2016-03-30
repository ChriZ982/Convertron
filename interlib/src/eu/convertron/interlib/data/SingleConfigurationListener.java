package eu.convertron.interlib.data;

import eu.convertron.interlib.logging.LogPriority;
import eu.convertron.interlib.logging.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class SingleConfigurationListener implements ConfigurationListener
{
    private ArrayList<ConfigFileListener> listeners;
    private String configFile;

    public SingleConfigurationListener(Configuration config, String configFile, ConfigFileListener l)
    {
        listeners = new ArrayList<>();
        listeners.add(l);

        config.addConfigListener(this);
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

    public static interface ConfigFileListener
    {
        public void configFileChanged(byte[] value);
    }
}
