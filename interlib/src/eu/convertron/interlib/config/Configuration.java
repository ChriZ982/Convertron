package eu.convertron.interlib.config;

import java.util.HashMap;
import java.util.Map;

public interface Configuration
{
    public void addConfigListener(ConfigurationListener l);

    public HashMap<String, byte[]> getAllConfigs();

    public byte[] getConfig(String name);

    public String[] getConfigFiles();

    public void setMultipleConfigs(Map<String, byte[]> config);

    public boolean hasConfig(String name);

    public boolean removeConfig(String name);

    public boolean removeConfigListener(ConfigurationListener l);

    public void setConfig(String name, byte[] value);

}
