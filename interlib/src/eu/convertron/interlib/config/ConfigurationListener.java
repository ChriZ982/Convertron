package eu.convertron.interlib.config;

import java.util.HashMap;

public interface ConfigurationListener
{
    public void configurationChanged(HashMap<String, ConfigFileChangeInfo> changed);
}
