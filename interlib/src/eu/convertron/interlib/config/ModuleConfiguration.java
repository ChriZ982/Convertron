package eu.convertron.interlib.config;

import eu.convertron.interlib.logging.LogPriority;
import eu.convertron.interlib.logging.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Consumer;

public class ModuleConfiguration implements Configuration
{
    private final ConfigurationSource local;
    private final ConfigurationSource global;

    private final String module;
    private final MoveConflictUserCallback callback;

    public ModuleConfiguration(ConfigurationSource local, ConfigurationSource global, String module)
    {
        this(local, global, module, null);
    }

    public ModuleConfiguration(ConfigurationSource local, ConfigurationSource global, String module, MoveConflictUserCallback callback)
    {
        if(local == null || global == null)
            throw new IllegalArgumentException("ConfigurationSources cannot be null");

        this.local = local;
        this.global = global;
        this.callback = callback;
        this.module = module;
    }

    public ConfigurationSource getLocal()
    {
        return local;
    }

    public ConfigurationSource getGlobal()
    {
        return global;
    }

    @Override
    public void addConfigListener(ConfigurationListener l)
    {
        local.addConfigListener(l);
        global.addConfigListener(l);
    }

    @Override
    public HashMap<String, byte[]> getAllConfigs()
    {
        HashMap<String, byte[]> map = global.getAllConfigs();
        map.putAll(local.getAllConfigs());
        return map;
    }

    @Override
    public byte[] getConfig(String name)
    {
        if(local.hasConfig(name))
            return local.getConfig(name);
        return global.getConfig(name);
    }

    @Override
    public String[] getConfigFiles()
    {
        ArrayList<String> files = new ArrayList<>(Arrays.asList(global.getConfigFiles()));
        for(String file : local.getConfigFiles())
        {
            if(!files.contains(file))
                files.add(file);
        }
        return files.toArray(new String[files.size()]);
    }

    @Override
    public void setMultipleConfigs(Map<String, byte[]> config)
    {
        Iterator<Map.Entry<String, byte[]>> it = config.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry<String, byte[]> entry = it.next();
            setConfig(entry.getKey(), entry.getValue());
        }
    }

    public byte[] getOrCreateConfig(String name, DesiredLocation location)
    {
        createOrMoveConfig(name, location);
        return getConfig(name);
    }

    public void createOrMoveConfig(String name, DesiredLocation location)
    {
        CurrentConfigFileLocation current = getLocation(name);
        switch(location)
        {
            case Local:
                if(!hasConfig(name))
                    local.setConfig(name, new byte[0]);
                break;

            case Global:
                if(!hasConfig(name))
                    global.setConfig(name, new byte[0]);
                break;

            case ForceLocal:
                switch(current)
                {
                    case None:
                        local.setConfig(name, new byte[0]);
                        break;
                    case Global:
                        moveToLocal(name);
                        break;
                }
                break;

            case ForceGlobalAndDiscardLocal:
                switch(current)
                {
                    case None:
                        global.setConfig(name, new byte[0]);
                        break;
                    case Local:
                        forceMoveToGlobal(name, OverwriteStrategy.DiscardLocal);
                        break;
                }
                break;

            case ForceGlobalAndOverrideExisting:
                switch(current)
                {
                    case None:
                        global.setConfig(name, new byte[0]);
                        break;
                    case Local:
                        forceMoveToGlobal(name, OverwriteStrategy.OverwriteGlobal);
                        break;
                }
                break;
        }
    }

    @Override
    public boolean hasConfig(String name)
    {
        return getLocation(name) != CurrentConfigFileLocation.None;
    }

    public CurrentConfigFileLocation getLocation(String name)
    {
        if(local.hasConfig(name))
            return CurrentConfigFileLocation.Local;
        if(global.hasConfig(name))
            return CurrentConfigFileLocation.Global;
        return CurrentConfigFileLocation.None;
    }

    @Override
    public boolean removeConfig(String name)
    {
        boolean result = false;
        if(local.hasConfig(name))
        {
            local.removeConfig(name);
            result = true;
        }
        if(global.hasConfig(name))
        {
            global.removeConfig(name);
            result = true;
        }
        return result;
    }

    @Override
    public boolean removeConfigListener(ConfigurationListener l)
    {
        return local.removeConfigListener(l) | global.removeConfigListener(l);
    }

    @Override
    public void setConfig(String name, byte[] value)
    {
        if(local.hasConfig(name))
        {
            local.setConfig(name, value);
        }
        else if(global.hasConfig(name))
        {
            global.setConfig(name, value);
        }
        else
        {
            local.setConfig(name, value);
        }
    }

    public void forceMoveToGlobal(String configName, OverwriteStrategy strategy)
    {
        if(getLocation(configName) != CurrentConfigFileLocation.Local)
        {
            throw new UnsupportedOperationException(configName + " isnt a local config file");
        }
        else if(!global.hasConfig(configName))
        {
            global.setConfig(configName, local.getConfig(configName));
        }
        else if(strategy == OverwriteStrategy.DiscardLocal
                || Arrays.equals(global.getConfig(configName), local.getConfig(configName)))
        {
            //Do nothing
        }
        else if(strategy == OverwriteStrategy.OverwriteGlobal)
        {
            global.setConfig(configName, local.getConfig(configName));
        }

        local.removeConfig(configName);
    }

    public void askMoveToGlobal(Consumer<MoveResult> resultAcceptor, String configName, OverwriteStrategy defaultStrategy)
    {
        if(callback == null)
        {
            forceMoveToGlobal(configName, defaultStrategy);

            MoveResult mr;
            switch(defaultStrategy)
            {
                case DiscardLocal:
                    mr = MoveResult.LocalDiscarded;
                    break;
                case OverwriteGlobal:
                    mr = MoveResult.GlobalOverrided;
                    break;
                default:
                    mr = MoveResult.Aborted;
                    break;
            }

            try
            {
                if(resultAcceptor != null)
                    resultAcceptor.accept(mr);
            }
            catch(Throwable t)
            {
                Logger.logError(LogPriority.ERROR, "Fehler beim Move-Conflict-Result-Acceptor von Modul " + module + " beim Verschieben von " + configName, t);
            }
        }
        else
        {
            ConflictInfo conflict = new ConflictInfo(module, configName, local.getConfig(configName), global.getConfig(configName));
            Consumer<byte[]> resultConsumer = createResultConsumer(resultAcceptor, conflict);
            callback.resolveConflict(resultConsumer, conflict);
        }
    }

    private Consumer<byte[]> createResultConsumer(Consumer<MoveResult> resultAcceptor, ConflictInfo conflict)
    {
        return (result) ->
        {
            MoveResult mr;
            if(result == null)
            {
                mr = MoveResult.Aborted;
            }
            else if(Arrays.equals(conflict.getLocalVersion(), result))
            {
                mr = MoveResult.GlobalOverrided;
            }
            else if(Arrays.equals(conflict.getGlobalVersion(), result))
            {
                mr = MoveResult.LocalDiscarded;
            }
            else
            {
                mr = MoveResult.Customized;
            }

            if(result != null)
            {
                global.setConfig(conflict.getConfigName(), result);
                local.removeConfig(conflict.getConfigName());
            }

            try
            {
                if(resultAcceptor != null)
                    resultAcceptor.accept(mr);
            }
            catch(Throwable t)
            {
                Logger.logError(LogPriority.ERROR, "Fehler beim Move-Conflict-Result-Acceptor von Modul " + module + " beim Verschieben von " + conflict.getConfigName(), t);
            }
        };
    }

    public void moveToLocal(String configName)
    {
        if(getLocation(configName) != CurrentConfigFileLocation.Global)
        {
            throw new UnsupportedOperationException(configName + " isnt a global config file");
        }

        local.setConfig(configName, global.getConfig(configName));
    }
}
