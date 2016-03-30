package eu.convertron.client;

import eu.convertron.applib.etc.ChangeSet;
import eu.convertron.applib.etc.CsvLessonSerializer;
import eu.convertron.applib.modules.ConfigurationProvider;
import eu.convertron.applib.storage.Storage;
import eu.convertron.interlib.data.Configuration;
import eu.convertron.interlib.data.Lesson;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Random;
import javax.swing.Timer;

public class ServerConnection implements Storage, ConfigurationProvider
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

        service.ping();

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

    @Override
    public Configuration getOrCreateConfiguration(Class<?> module)
    {
        return getOrCreateConfiguration(module.getName());
    }

    @Override
    public Configuration getOrCreateConfiguration(String moduleName)
    {
        if(configs.containsKey(moduleName))
            return configs.get(moduleName);

        service.subscribeToConfigChanges(moduleName, clientId);
        RemoteConfiguration conf = new RemoteConfiguration(service, moduleName);
        configs.put(moduleName, conf);
        return conf;
    }

    @Override
    public Lesson[] load()
    {
        String serialization = service.getData();
        return new CsvLessonSerializer().deserializeMultiple(serialization);
    }

    @Override
    public void save(Lesson[] lessons)
    {
        String serialization = new CsvLessonSerializer().serializeMultiple(lessons);
        service.setData(serialization);
    }

    public void close()
    {
        setCheckForChanges(false);
    }
}
