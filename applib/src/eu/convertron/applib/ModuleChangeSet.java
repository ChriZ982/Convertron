package eu.convertron.applib;

import eu.convertron.interlib.config.ConfigFileChangeInfo;
import eu.convertron.interlib.config.ConfigFileChangeType;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import static eu.convertron.interlib.config.ConfigFileChangeType.ADDED;
import static eu.convertron.interlib.config.ConfigFileChangeType.MODIFIED;
import static eu.convertron.interlib.config.ConfigFileChangeType.REMOVED;

@XmlRootElement
public class ModuleChangeSet
{
    private List<ConfigFileChangeInfo> configChangeInfos = new ArrayList<>();
    private String moduleName;

    public ModuleChangeSet()
    {
    }

    public ModuleChangeSet(String moduleName)
    {
        this.moduleName = moduleName;
    }

    @XmlElement
    public List<ConfigFileChangeInfo> getConfigChangeInfos()
    {
        return configChangeInfos;
    }

    public void setConfigChangeInfos(List<ConfigFileChangeInfo> configChangeInfos)
    {
        this.configChangeInfos = configChangeInfos;
    }

    @XmlElement
    public String getModuleName()
    {
        return moduleName;
    }

    public void setModuleName(String moduleName)
    {
        this.moduleName = moduleName;
    }

    public void registerConfigChange(ConfigFileChangeInfo info)
    {
        ConfigFileChangeInfo existingInfo = null;
        for(ConfigFileChangeInfo ci : configChangeInfos)
        {
            if(ci.getConfigName().equals(info.getConfigName()))
            {
                existingInfo = ci;
                break;
            }
        }

        if(existingInfo == null)
        {
            configChangeInfos.add(info);
        }
        else
        {
            configChangeInfos.remove(existingInfo);
            ConfigFileChangeInfo merged = mergeChanges(existingInfo, info);
            if(merged != null)
            {
                configChangeInfos.add(merged);
            }
        }
    }

    private ConfigFileChangeInfo mergeChanges(ConfigFileChangeInfo oldInfo, ConfigFileChangeInfo newInfo)
    {
        if(!oldInfo.getConfigName().equals(newInfo.getConfigName()))
        {
            throw new IllegalArgumentException("Different configNames");
        }

        ConfigFileChangeInfo result = new ConfigFileChangeInfo();
        result.setConfigName(oldInfo.getConfigName());
        result.setOldValue(oldInfo.getOldValue());
        result.setNewValue(newInfo.getNewValue());

        ConfigFileChangeType type = mergeChangeTypes(oldInfo.getChangeType(), newInfo.getChangeType());
        if(type == null)
        {
            return null;
        }

        result.setChangeType(type);
        return result;
    }

    private ConfigFileChangeType mergeChangeTypes(ConfigFileChangeType oldType, ConfigFileChangeType newType)
    {
        /*
         * Merges by this pattern.
         *                            old
         *              ADDED       MODIFIED    REMOVED
         *               ---------------------------------
         *     ADDED    |Exception   Exception   MODIFIED
         * new MODIFIED |ADDED       MODIFIED    Exception
         *     REMOVED  |null        REMOVED     Exception
         */
        if((newType == ADDED && oldType != REMOVED)
           || (newType != ADDED && oldType == REMOVED))
        {
            throw new IllegalArgumentException("Illegal Combination of ChangeTypes: old="
                                               + oldType + ", new=" + newType);
        }
        else if(newType == ADDED && oldType == REMOVED)
        {
            return MODIFIED;
        }
        else if(newType == MODIFIED && oldType != REMOVED)
        {
            return oldType;
        }
        else if(newType == REMOVED && oldType == ADDED)
        {
            return null;
        }
        else if(newType == REMOVED && oldType == MODIFIED)
        {
            return REMOVED;
        }
        throw new RuntimeException("Should not reach this");
    }
}
