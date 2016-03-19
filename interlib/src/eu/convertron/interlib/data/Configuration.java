package eu.convertron.interlib.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class Configuration
{
    protected abstract void save(String name, byte[] value) throws Exception;

    protected abstract byte[] load(String name) throws Exception;

    protected abstract void remove(String name) throws Exception;

    private ArrayList<String> configFiles;
    private ArrayList<ConfigurationListener> listeners;

    protected Configuration(Collection<String> configFiles)
    {
        this.configFiles = new ArrayList<>(configFiles);
        this.listeners = new ArrayList<>();
    }

    public void addConfigListener(ConfigurationListener l)
    {
        listeners.add(l);
    }

    protected void configChanged(String name, byte[] value)
    {
        HashMap<String, byte[]> map = new HashMap<>();
        map.put(name, value);
        configChanged(map);
    }

    protected void configChanged(Map<String, byte[]> values)
    {
        Iterator<String> it = values.keySet().iterator();
        while(it.hasNext())
        {
            String name = it.next();
            if(!configFiles.contains(name))
            {
                fireConfigAdded(name);
                configFiles.add(name);
            }
        }
        fireConfigChanged(values);
    }

    private void fireConfigAdded(String name)
    {
        for(ConfigurationListener l : listeners)
        {
            l.newConfigurationAdded(name);
        }
    }

    private void fireConfigChanged(Map<String, byte[]> config)
    {
        boolean complete = true;
        for(String key : configFiles)
        {
            if(!config.containsKey(key))
                complete = false;
        }
        for(ConfigurationListener l : listeners)
        {
            l.configurationChanged(new HashMap<>(config), complete);
        }
    }

    public boolean removeConfigListener(ConfigurationListener l)
    {
        return listeners.remove(l);
    }

    public void setConfig(String name, byte[] value)
    {
        trySave(name, value);
        configChanged(name, value);
    }

    public void setMultipleConfigs(Map<String, byte[]> config)
    {
        Iterator<Map.Entry<String, byte[]>> it = config.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry<String, byte[]> entry = it.next();
            trySave(entry.getKey(), entry.getValue());
        }
        configChanged(config);
    }

    public byte[] getConfig(String name)
    {
        if(!configFiles.contains(name))
            throw new IllegalArgumentException("No such config");
        return tryLoad(name);
    }

    public HashMap<String, byte[]> getAllConfigs()
    {
        HashMap<String, byte[]> result = new HashMap<>();
        for(String key : configFiles)
        {
            result.put(key, tryLoad(key));
        }
        return result;
    }

    public boolean removeConfig(String name)
    {
        tryRemove(name);
        return configFiles.remove(name);
    }

    public String[] getConfigFiles()
    {
        return configFiles.toArray(new String[configFiles.size()]);
    }

    private void trySave(String name, byte[] value)
    {
        try
        {
            save(name, value);
        }
        catch(Exception ex)
        {
            throw new RuntimeException("Unable to save Configuration " + name, ex);
        }
    }

    private byte[] tryLoad(String name)
    {
        try
        {
            return load(name);
        }
        catch(Exception ex)
        {
            throw new RuntimeException("Unable to load Configuration " + name, ex);
        }
    }

    private void tryRemove(String name)
    {
        try
        {
            remove(name);
        }
        catch(Exception ex)
        {
            throw new RuntimeException("Unable to remove Configuration " + name, ex);
        }
    }
}
