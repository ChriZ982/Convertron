package eu.convertron.applib;

import eu.convertron.interlib.config.ConfigFileChangeInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ChangeSet
{
    private List<ModuleChangeSet> moduleChangeSets = new ArrayList<>();

    public ChangeSet()
    {
    }

    @XmlElement
    public List<ModuleChangeSet> getModuleChangeSets()
    {
        return moduleChangeSets;
    }

    public void setModuleChangeSets(List<ModuleChangeSet> moduleChangeSets)
    {
        this.moduleChangeSets = moduleChangeSets;
    }

    public void registerConfigChange(Map<String, ConfigFileChangeInfo> changes)
    {
        for(Map.Entry<String, ConfigFileChangeInfo> change : changes.entrySet())
        {
            registerConfigChange(change.getKey(), change.getValue());
        }
    }

    public void registerConfigChange(String moduleName, ConfigFileChangeInfo info)
    {
        for(ModuleChangeSet cs : moduleChangeSets)
        {
            if(moduleName.equals(cs.getModuleName()))
            {
                cs.registerConfigChange(info);
                return;
            }
        }

        ModuleChangeSet cs = new ModuleChangeSet(moduleName);
        cs.registerConfigChange(info);
        moduleChangeSets.add(cs);
    }

    public void clear()
    {
        moduleChangeSets.clear();
    }

    public boolean isEmpty()
    {
        return moduleChangeSets.isEmpty();
    }
}
