package eu.convertron.server;

import eu.convertron.applib.modules.ConfigurationProvider;
import eu.convertron.applib.modules.IOConfigurationProvider;
import eu.convertron.applib.storage.CsvStorage;
import eu.convertron.applib.storage.Storage;
import eu.convertron.interlib.data.Configuration;
import eu.convertron.interlib.data.Lesson;
import eu.convertron.interlib.filter.TableOptions;
import eu.convertron.interlib.logging.LogPriority;
import eu.convertron.interlib.logging.Logger;
import java.nio.charset.StandardCharsets;
import javax.swing.Timer;
import javax.xml.ws.Endpoint;

public class Control
{
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

        this.timer = new Timer(60000, (e) -> export());
        this.timer.start();

        publishWebService("http://127.0.0.1:8023/_convertron");
    }

    public Configuration getOrCreateConfiguration(String moduleName)
    {
        return provider.getOrCreateConfiguration(moduleName);
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
        moduleManager.export(getData(), new String(coreConfig.getOrCreateConfig("motd.txt"), StandardCharsets.UTF_8));
    }

    private void publishWebService(String address)
    {
        Endpoint.publish(address, new ConvertronWS(this));
        Logger.logMessage(LogPriority.HINT, "WebService gestart, Adresse: " + address);
    }

    public void exit()
    {
        try
        {
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
