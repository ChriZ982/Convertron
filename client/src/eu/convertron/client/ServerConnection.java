package eu.convertron.client;

import eu.convertron.applib.ChangeSet;
import eu.convertron.applib.modules.ConfigurationSourceProvider;
import eu.convertron.interlib.config.ConfigurationSource;
import eu.convertron.interlib.logging.LogPriority;
import eu.convertron.interlib.logging.Logger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Random;
import javax.swing.Timer;

public class ServerConnection implements ConfigurationSourceProvider
{
    private ConvertronWS service;
    private byte[] clientId;
    private HashMap<String, RemoteConfiguration> configs;
    private Timer timer;

    public ServerConnection(String ip, int port, boolean autoCheck) throws MalformedURLException
    {
        this("http://" + ip + ":" + port + "/_convertron?WSDL", autoCheck);
    }

    public ServerConnection(String wsdl, boolean autoCheck) throws MalformedURLException
    {
        ConvertronWSService s = new ConvertronWSService(new URL(wsdl));
        service = s.getConvertronWSPort();
        clientId = new byte[8];
        new Random().nextBytes(clientId);
        configs = new HashMap<>();
        timer = new Timer(10000, (e) -> checkForChanges());

        try
        {
            service.ping();
        }
        catch(Exception ex)
        {
            throw new RuntimeException("Failed to ping server", ex);
        }

        setAutoCheckForChanges(autoCheck);
    }

    public void setAutoCheckForChanges(boolean autoCheck)
    {
        if(autoCheck)
        {
            if(!timer.isRunning())
                timer.start();
        }
        else
        {
            if(timer.isRunning())
                timer.stop();
        }

    }

    public void checkForChanges()
    {
        try
        {
            byte[] ser = service.getChanges(clientId);
            if(ser == null)
                return;

            ChangeSet c = ChangeSet.deserialize(ser);
            for(HashMap.Entry<String, ChangeSet.ConfigEntry> entry : c.getEntrysCopy().entrySet())
            {
                if(configs.containsKey(entry.getKey()))
                    configs.get(entry.getKey()).processChange(entry.getValue());
            }
        }
        catch(Exception ex)
        {
            Logger.logError(LogPriority.ERROR, "Fehler beim Überprüfen auf Änderungen, "
                                               + "Automatisches Prüfen alle 10 Sekunden ausgeschaltet", ex);
            setAutoCheckForChanges(false);
        }
    }

    @Override
    public ConfigurationSource getOrCreateConfiguration(String moduleName)
    {
        try
        {
            if(configs.containsKey(moduleName))
                return configs.get(moduleName);

            service.subscribeToConfigChanges(moduleName, clientId);
            RemoteConfiguration conf = new RemoteConfiguration(service, moduleName);
            configs.put(moduleName, conf);
            return conf;
        }
        catch(Exception ex)
        {
            Logger.logError(LogPriority.ERROR, "Konnte die Konfiguration nicht vom Server laden", ex);
            return null;
        }
    }

    public void close()
    {
        setAutoCheckForChanges(false);
    }
}
