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
        this(new URL("http://" + ip + ":" + port + "/_convertron?WSDL"), autoCheck);
    }

    public ServerConnection(URL wsdl, boolean autoCheck)
    {
        ConvertronWSService s = new ConvertronWSService(wsdl);
        service = s.getConvertronWSPort();
        clientId = new byte[8];
        new Random().nextBytes(clientId);
        configs = new HashMap<>();
        timer = new Timer(5000, (e) -> checkChanges());

        try
        {
            service.ping();
        }
        catch(Exception ex)
        {
            Logger.logError(LogPriority.INFO, "Fehler beim pingen", ex);
            throw new RuntimeException("Failed to ping server", ex);
        }

        setCheckForChanges(true);
    }

    public void setCheckForChanges(boolean check)
    {
        if(check)
        {
            if(!timer.isRunning())
                timer.start();
        }
        else if(timer.isRunning())
            timer.stop();
    }

    private void checkChanges()
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
            Logger.logError(LogPriority.ERROR, "Fehler beim überprüfen auf Änderungen, prüfen eingestellt", ex);
            setCheckForChanges(false);
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
        setCheckForChanges(false);
    }
}
