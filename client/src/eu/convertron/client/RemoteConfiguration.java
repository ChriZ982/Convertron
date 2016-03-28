package eu.convertron.client;

import eu.convertron.applib.etc.ChangeSet;
import eu.convertron.interlib.data.Configuration;
import java.util.HashMap;

public class RemoteConfiguration extends Configuration
{
    private ConvertronWS service;
    private String moduleName;

    public RemoteConfiguration(ConvertronWS service, String moduleName)
    {
        super(service.getAvailableConfigs(moduleName));
        this.service = service;
    }

    @Override
    protected byte[] load(String name) throws Exception
    {
        return service.getConfigFile(moduleName, name);
    }

    @Override
    protected void remove(String name) throws Exception
    {
        service.removeConfigFile(moduleName, name);
    }

    @Override
    protected void save(String name, byte[] value) throws Exception
    {
        service.setConfigFile(moduleName, name, value);
    }

    public void processChange(ChangeSet.ConfigEntry entry)
    {
        HashMap<String, byte[]> changedValues = new HashMap<>();
        for(String s : entry.getChangedConfigsParts())
        {
            changedValues.put(s, getConfig(s));
        }

        if(!changedValues.isEmpty())
            configChanged(changedValues);
    }
}
