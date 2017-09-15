package eu.convertron.server;

import eu.convertron.applib.ChangeSet;
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
        ChangeSet cs;
        if(!changes.containsKey(clientId))
        {
            cs = new ChangeSet();
            changes.put(clientId, cs);
        }
        else
        {
            cs = changes.get(clientId);
        }

        ConfigurationSource config = control.getOrCreateGlobalConfiguration(moduleName);
        config.addConfigListener((map) -> cs.registerConfigChange(map));
        Logger.logMessage(LogPriority.HINT, "Ein Client abonnierte Aenderungen am Modul '" + moduleName + "'");
    }

    @WebMethod
    public ChangeSet getChanges(byte[] clientId)
    {
        if(!changes.containsKey(clientId))
            return null;

        ChangeSet cs = changes.get(clientId);

        if(cs == null || cs.isEmpty())
            return null;

        return cs;
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
