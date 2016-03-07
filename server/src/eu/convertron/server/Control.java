package eu.convertron.server;

import eu.convertron.applib.storage.CsvStorage;
import eu.convertron.applib.storage.Storage;
import eu.convertron.interlib.data.Lesson;
import eu.convertron.interlib.logging.LogPriority;
import eu.convertron.interlib.logging.Logger;
import javax.xml.ws.Endpoint;

public class Control
{
    private ModuleManager moduleManager;
    private Storage storage;

    public Control()
    {
        this.moduleManager = new ModuleManager();
        this.storage = new CsvStorage("./data.csv");

        publishWebService("http://127.0.0.1:8023/_convertron");
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
        moduleManager.export(getData(), ServerSettings.motdText.load());
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
