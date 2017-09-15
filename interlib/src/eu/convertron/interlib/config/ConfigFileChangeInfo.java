package eu.convertron.interlib.config;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ConfigFileChangeInfo
{
    private String configName;
    private byte[] oldValue;
    private byte[] newValue;
    private ConfigFileChangeType changeType;

    public ConfigFileChangeInfo()
    {
    }

    public ConfigFileChangeInfo(String configName, byte[] oldValue, byte[] newValue, ConfigFileChangeType changeType)
    {
        this.configName = configName;
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.changeType = changeType;
    }

    @XmlElement
    public String getConfigName()
    {
        return configName;
    }

    public void setConfigName(String configName)
    {
        this.configName = configName;
    }

    @XmlElement
    public byte[] getOldValue()
    {
        return oldValue;
    }

    public void setOldValue(byte[] oldValue)
    {
        this.oldValue = oldValue;
    }

    @XmlElement
    public byte[] getNewValue()
    {
        return newValue;
    }

    public void setNewValue(byte[] newValue)
    {
        this.newValue = newValue;
    }

    @XmlElement
    public ConfigFileChangeType getChangeType()
    {
        return changeType;
    }

    public void setChangeType(ConfigFileChangeType changeType)
    {
        this.changeType = changeType;
    }
}
