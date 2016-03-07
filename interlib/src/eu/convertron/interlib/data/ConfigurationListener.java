package eu.convertron.interlib.data;

import java.util.HashMap;

public interface ConfigurationListener
{
    public void configurationChanged(HashMap<String, byte[]> changed, boolean complete);

    public void newConfigurationAdded(String name);
}
