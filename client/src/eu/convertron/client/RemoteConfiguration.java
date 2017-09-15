package eu.convertron.client;

import eu.convertron.applib.ModuleChangeSet;
import eu.convertron.client.gen.ConvertronWS;
import eu.convertron.interlib.config.ConfigFileChangeInfo;
import eu.convertron.interlib.config.ConfigurationSource;
import eu.convertron.interlib.logging.LogPriority;
import eu.convertron.interlib.logging.Logger;

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

    public void processChange(ModuleChangeSet entry)
    {
        for(ConfigFileChangeInfo info : entry.getConfigChangeInfos())
        {
            Logger.logMessage(LogPriority.INFO, "Received changes from server for module + '"
                                                + moduleName + "', config file '" + info.getConfigName() + "'");
        }

        fireConfigChanged(entry.getConfigChangeInfos());
    }
}
