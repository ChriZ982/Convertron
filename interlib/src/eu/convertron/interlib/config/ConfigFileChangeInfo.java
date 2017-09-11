package eu.convertron.interlib.config;

public class ConfigFileChangeInfo
{
    private final String configName;
    private final byte[] oldValue;
    private final byte[] newValue;
    private final ConfigFileChangeType changeType;

    public ConfigFileChangeInfo(String configName, byte[] oldValue, byte[] newValue, ConfigFileChangeType changeType)
    {
        this.configName = configName;
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.changeType = changeType;
    }

    public String getConfigName()
    {
        return configName;
    }

    public byte[] getOldValue()
    {
        return oldValue;
    }

    public byte[] getNewValue()
    {
        return newValue;
    }

    public ConfigFileChangeType getChangeType()
    {
        return changeType;
    }
}
