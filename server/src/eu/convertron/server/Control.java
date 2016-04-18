package eu.convertron.server;

import eu.convertron.applib.modules.ConfigurationProvider;
import eu.convertron.applib.modules.IOConfigurationProvider;
import eu.convertron.applib.storage.CsvStorage;
import eu.convertron.applib.storage.Storage;
import eu.convertron.interlib.data.Configuration;
import eu.convertron.interlib.data.Lesson;
import eu.convertron.interlib.data.SingleConfigurationListener;
import eu.convertron.interlib.filter.TableOptions;
import eu.convertron.interlib.logging.LogPriority;
import eu.convertron.interlib.logging.Logger;
import java.nio.charset.StandardCharsets;
import javax.swing.Timer;
import javax.xml.ws.Endpoint;

public class Control
{
    public static final String MOTD_CONFIG = "motd.txt";

    private final ModuleManager moduleManager;
    private final Storage storage;

    private final ConfigurationProvider provider;
    private final Configuration coreConfig;

    private final Timer timer;

    public Control()
    {
        String data = ServerSettings.pathData.load();
        if(data == null || data.isEmpty())
            data = ".";

        this.provider = new IOConfigurationProvider(data + "/config");
        this.coreConfig = provider.getOrCreateConfiguration(TableOptions.class);
        TableOptions.getInstance().setConfiguration(coreConfig);

        this.moduleManager = new ModuleManager(provider);
        this.storage = new CsvStorage(data + "/data.csv");

        this.timer = initializeTimer();

        this.coreConfig.addConfigListener(new SingleConfigurationListener(MOTD_CONFIG, (v) -> export()));
        publishWebService("http://127.0.0.1:8023/_convertron");
    }

    public Configuration getOrCreateConfiguration(String moduleName)
    {
        return provider.getOrCreateConfiguration(moduleName);
    }

    public Configuration getCoreConfig()
    {
        return coreConfig;
    }

    public void setData(Lesson[] data)
    {
        storage.save(data);
        export();
    }

    public Lesson[] getData()
    {
        return storage.load();
    }

    public void export()
    {
        moduleManager.export(getData(), new String(coreConfig.getOrCreateConfig(MOTD_CONFIG), StandardCharsets.UTF_8));
    }

    private void publishWebService(String address)
    {
        Endpoint.publish(address, new ConvertronWS(this));
        Logger.logMessage(LogPriority.HINT, "WebService gestart, Adresse: " + address);
    }

    private Timer initializeTimer()
    {
        int interval;
        try
        {
            interval = Integer.parseInt(ServerSettings.autoInterval.load());
        }
        catch(Exception ex)
        {
            interval = 60000;
        }

        if(interval > 0)
        {
            Timer result = new Timer(interval, (e) -> export());
            result.start();
            return result;
        }
        return null;
    }

    public void exit()
    {
        try
        {
            if(timer != null)
                timer.stop();
            System.exit(0);
        }
        catch(Exception ex)
        {
        }
        finally
        {
            System.exit(-1);
        }
    }
}
