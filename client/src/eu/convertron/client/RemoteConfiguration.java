package eu.convertron.client;

import eu.convertron.applib.ChangeSet;
import eu.convertron.interlib.config.ConfigurationSource;
import eu.convertron.interlib.logging.LogPriority;
import eu.convertron.interlib.logging.Logger;
import java.util.HashMap;

public class RemoteConfiguration extends ConfigurationSource
{
    private final ConvertronWS service;
    private final String moduleName;

    public RemoteConfiguration(ConvertronWS service, String moduleName)
    {
        super(service.getAvailableConfigs(moduleName));
        this.moduleName = moduleName;
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
            Logger.logMessage(LogPriority.INFO, "Received changes for config '" + s + "'");
        }

        if(!changedValues.isEmpty())
            configChanged(changedValues);
    }
}
