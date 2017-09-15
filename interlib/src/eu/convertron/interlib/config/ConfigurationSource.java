package eu.convertron.interlib.config;

import eu.convertron.interlib.logging.LogPriority;
import eu.convertron.interlib.logging.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ConfigurationSource implements Configuration
{
    protected abstract void save(String name, byte[] value) throws Exception;

    protected abstract byte[] load(String name) throws Exception;

    protected abstract void remove(String name) throws Exception;

    private final ArrayList<String> configFiles;
    private final ArrayList<ConfigurationListener> listeners;

    protected ConfigurationSource(Collection<String> configFiles)
    {
        this.configFiles = new ArrayList<>(configFiles);
        this.listeners = new ArrayList<>();
    }

    @Override
    public void addConfigListener(ConfigurationListener l)
    {
        listeners.add(l);
    }

    protected void fireConfigChanged(ConfigFileChangeInfo info)
    {
        fireConfigChanged(Arrays.asList(info));
    }

    protected void fireConfigChanged(List<ConfigFileChangeInfo> changed)
    {
        HashMap<String, ConfigFileChangeInfo> changeMap = new HashMap<>(changed.size());
        for(ConfigFileChangeInfo info : changed)
        {
            changeMap.put(info.getConfigName(), info);
        }

        for(ConfigurationListener l : listeners)
        {
            try
            {
                l.configurationChanged(new HashMap<>(changeMap));
            }
            catch(Exception ex)
            {
                Logger.logError(LogPriority.WARNING, "Fehler beim Ausführen eines 'config-changed' Ereignisses", ex);
            }
        }
    }

    @Override
    public boolean removeConfigListener(ConfigurationListener l)
    {
        return listeners.remove(l);
    }

    @Override
    public void setConfig(String configName, byte[] value)
    {
        Map<String, byte[]> config = new HashMap<>();
        config.put(configName, value);
        setMultipleConfigs(config);
    }

    @Override
    public void setMultipleConfigs(Map<String, byte[]> config)
    {
        List<ConfigFileChangeInfo> changed = new ArrayList<>(config.size());
        for(Map.Entry<String, byte[]> entry : config.entrySet())
        {
            String configName = entry.getKey();
            byte[] newValue = entry.getValue();

            ConfigFileChangeInfo info = createInfo(configName, newValue);
            if(info.getChangeType() == ConfigFileChangeType.ADDED)
            {
                configFiles.add(configName);
            }
            trySave(configName, newValue);
            changed.add(info);
        }
        fireConfigChanged(changed);
    }

    @Override
    public byte[] getConfig(String configName)
    {
        return hasConfig(configName) ? tryLoad(configName) : null;
    }

    @Override
    public HashMap<String, byte[]> getAllConfigs()
    {
        HashMap<String, byte[]> result = new HashMap<>();
        for(String key : configFiles)
        {
            result.put(key, tryLoad(key));
        }
        return result;
    }

    @Override
    public boolean removeConfig(String configName)
    {
        if(!configFiles.contains(configName))
        {
            return false;
        }
        ConfigFileChangeInfo info = createInfo(configName, null);
        tryRemove(configName);
        fireConfigChanged(info);
        return configFiles.remove(configName);
    }

    @Override
    public boolean hasConfig(String configName)
    {
        return configFiles.contains(configName);
    }

    @Override
    public String[] getConfigFiles()
    {
        return configFiles.toArray(new String[configFiles.size()]);
    }

    private ConfigFileChangeInfo createInfo(String configName, byte[] newValue)
    {
        byte[] oldValue = getConfig(configName);
        ConfigFileChangeType type;

        if(oldValue != null && newValue != null)
        {
            type = ConfigFileChangeType.MODIFIED;
        }
        else if(oldValue == null && newValue != null)
        {
            type = ConfigFileChangeType.ADDED;
        }
        else if(oldValue != null && newValue == null)
        {
            type = ConfigFileChangeType.REMOVED;
        }
        else
        {
            throw new RuntimeException("Removing a non-existing config file is not allowed");
        }

        return new ConfigFileChangeInfo(configName, oldValue, newValue, type);
    }

    private void trySave(String name, byte[] value)
    {
        try
        {
            save(name, value);
        }
        catch(Exception ex)
        {
            Logger.logError(LogPriority.INFO, "Unable to save Configuration", ex);
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
            Logger.logError(LogPriority.INFO, "Unable to load Configuration", ex);
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
            Logger.logError(LogPriority.INFO, "Unable to remove Configuration", ex);
            throw new RuntimeException("Unable to remove Configuration " + name, ex);
        }
    }
}
