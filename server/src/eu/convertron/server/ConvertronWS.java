package eu.convertron.server;

import eu.convertron.applib.ChangeSet;
import eu.convertron.interlib.config.ConfigurationListener;
import eu.convertron.interlib.config.ConfigurationSource;
import eu.convertron.interlib.logging.LogPriority;
import eu.convertron.interlib.logging.Logger;
import java.util.HashMap;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class ConvertronWS
{
    private final Control control;
    private final HashMap<byte[], ChangeSet> changes;

    public ConvertronWS(Control control)
    {
        this.control = control;
        this.changes = new HashMap<>();
    }

    @WebMethod
    public void subscribeToConfigChanges(String moduleName, byte[] clientId)
    {
        ChangeSet c;
        if(!changes.containsKey(clientId))
        {
            c = new ChangeSet();
            changes.put(clientId, c);
        }
        else
        {
            c = changes.get(clientId);
        }

        ConfigurationSource config = control.getOrCreateGlobalConfiguration(moduleName);
        config.addConfigListener(new ConfigurationListener()
        {
            @Override
            public void configurationChanged(HashMap<String, byte[]> changed, boolean complete)
            {
                for(String configPart : changed.keySet())
                    c.configChanged(moduleName, configPart);
            }

            @Override
            public void newConfigurationAdded(String name)
            {
                c.configAdded(moduleName, name);
            }
        });
        Logger.logMessage(LogPriority.HINT, "Ein Client abonnierte Aenderungen am Modul '" + moduleName + "'");
    }

    @WebMethod
    public byte[] getChanges(byte[] clientId)
    {
        if(!changes.containsKey(clientId))
            return null;

        ChangeSet c = changes.get(clientId);

        if(c == null || c.isEmpty())
            return null;

        byte[] result = c.serialize();
        c.clear();
        return result;
    }

    @WebMethod
    public void setConfigFile(String moduleName, String configName, byte[] value)
    {
        ConfigurationSource config = control.getOrCreateGlobalConfiguration(moduleName);
        config.setConfig(configName, value);
        Logger.logMessage(LogPriority.HINT, "Konfigurationsdatei geaendert: " + moduleName + " -> " + configName);
    }

    @WebMethod
    public byte[] getConfigFile(String moduleName, String configName)
    {
        ConfigurationSource config = control.getOrCreateGlobalConfiguration(moduleName);
        return config.getConfig(configName);
    }

    @WebMethod
    public boolean removeConfigFile(String moduleName, String configName)
    {
        ConfigurationSource config = control.getOrCreateGlobalConfiguration(moduleName);
        boolean result = config.removeConfig(configName);
        Logger.logMessage(LogPriority.HINT, "Konfigurationsdatei entfernt: " + moduleName + " -> " + configName);
        return result;
    }

    @WebMethod
    public String[] getAvailableConfigs(String moduleName)
    {
        ConfigurationSource config = control.getOrCreateGlobalConfiguration(moduleName);
        return config.getConfigFiles();
    }

    @WebMethod
    public String ping()
    {
        return "pong";
    }
}
