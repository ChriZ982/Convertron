package eu.convertron.applib;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class ChangeSet implements Serializable
{
    private static final long serialVersionUID = -2637853264138413364L;

    private final HashMap<String, ConfigEntry> entrys;

    public ChangeSet()
    {
        entrys = new HashMap<>();
    }

    public synchronized void clear()
    {
        entrys.clear();
    }

    public synchronized boolean isEmpty()
    {
        return entrys.isEmpty();
    }

    public synchronized void configChanged(String configName, String configPart)
    {
        getOrCreateEntry(configName).configChanged(configPart);
    }

    public synchronized void configAdded(String configName, String configPart)
    {
        getOrCreateEntry(configName).configAdded(configPart);
    }

    private ConfigEntry getOrCreateEntry(String configName)
    {
        if(!entrys.containsKey(configName))
            entrys.put(configName, new ConfigEntry());
        return entrys.get(configName);
    }

    public synchronized HashMap<String, ConfigEntry> getEntrysCopy()
    {
        return new HashMap<>(entrys);
    }

    public synchronized byte[] serialize()
    {
        return SerializeUtils.serialize(this);
    }

    public static ChangeSet deserialize(byte[] bytes)
    {
        return SerializeUtils.deserialize(bytes);
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof ChangeSet)
        {
            ChangeSet cs = (ChangeSet)obj;
            return cs.getEntrysCopy().equals(this.getEntrysCopy());
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.entrys);
        return hash;
    }

    public static class ConfigEntry implements Serializable
    {
        private static final long serialVersionUID = -3141716426452293504L;

        private final ArrayList<String> addedConfigParts;
        private final ArrayList<String> changedConfigsParts;

        public ConfigEntry()
        {
            addedConfigParts = new ArrayList<>();
            changedConfigsParts = new ArrayList<>();
        }

        public void configChanged(String configPart)
        {
            if(!changedConfigsParts.contains(configPart))
                changedConfigsParts.add(configPart);
        }

        public void configAdded(String configPart)
        {
            if(!addedConfigParts.contains(configPart))
                addedConfigParts.add(configPart);
        }

        public ArrayList<String> getAddedConfigParts()
        {
            return addedConfigParts;
        }

        public ArrayList<String> getChangedConfigsParts()
        {
            return changedConfigsParts;
        }

        public byte[] serialize()
        {
            return SerializeUtils.serialize(this);
        }

        public static ConfigEntry deserialize(byte[] bytes)
        {
            return SerializeUtils.deserialize(bytes);
        }

        @Override
        public boolean equals(Object obj)
        {
            if(obj instanceof ConfigEntry)
            {
                ConfigEntry ce = (ConfigEntry)obj;
                return ce.getAddedConfigParts().equals(this.getAddedConfigParts())
                       && ce.getChangedConfigsParts().equals(this.getChangedConfigsParts());
            }
            return super.equals(obj);
        }

        @Override
        public int hashCode()
        {
            int hash = 5;
            hash = 47 * hash + Objects.hashCode(this.addedConfigParts);
            hash = 47 * hash + Objects.hashCode(this.changedConfigsParts);
            return hash;
        }
    }
}
