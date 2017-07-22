package eu.convertron.server;

import eu.convertron.applib.CsvStorage;
import eu.convertron.applib.Storage;
import eu.convertron.applib.modules.IOConfigurationProvider;
import eu.convertron.applib.modules.ModuleConfigurationProvider;
import eu.convertron.interlib.Lesson;
import eu.convertron.interlib.TableOptions;
import eu.convertron.interlib.config.ConfigurationSource;
import eu.convertron.interlib.config.DesiredLocation;
import eu.convertron.interlib.config.GeneralConfigFile;
import eu.convertron.interlib.config.ModuleConfiguration;
import eu.convertron.interlib.logging.LogPriority;
import eu.convertron.interlib.logging.Logger;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.Timer;
import javax.xml.ws.Endpoint;

public class Control
{
    private final GeneralConfigFile motdConfigFile;

    private final ModuleManager moduleManager;
    private final Storage storage;

    private final ModuleConfigurationProvider provider;
    private final ModuleConfiguration coreConfig;

    private final Timer timer;

    public Control()
    {
        String data = ServerSettings.pathData.load();
        if(data == null || data.isEmpty())
            data = ".";

        this.provider = new ModuleConfigurationProvider(new IOConfigurationProvider(data + "/localconfig"),
                                                        new IOConfigurationProvider(data + "/globalconfig"),
                                                        null);

        this.coreConfig = provider.provideConfig(TableOptions.class);
        TableOptions.getInstance().setConfiguration(coreConfig);

        this.moduleManager = new ModuleManager(provider);
        this.storage = new CsvStorage(data + "/data.csv");

        this.timer = initializeTimer();

        this.motdConfigFile = new GeneralConfigFile(coreConfig, "motd.txt", DesiredLocation.ForceGlobalAndOverrideExisting);
        this.motdConfigFile.addConfigFileListener((newValue) -> export());

        publishWebService(getWsAddresses());
    }

    private String[] getWsAddresses()
    {
        try
        {
            ArrayList<String> result = new ArrayList<>();
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while(networkInterfaces.hasMoreElements())
            {
                NetworkInterface n = networkInterfaces.nextElement();
                Enumeration<InetAddress> addresses = n.getInetAddresses();
                while(addresses.hasMoreElements())
                {
                    InetAddress adr = addresses.nextElement();
                    if(adr instanceof Inet4Address)
                    {
                        result.add(getWsAddress((Inet4Address)adr));
                    }
                }
            }

            return result.toArray(new String[result.size()]);
        }
        catch(SocketException ex)
        {
            Logger.logError(LogPriority.WARNING, "Failed to generate WebService addresses based on network ips. Only localhost used instead", ex);
        }

        return new String[]
        {
            "http://127.0.0.1:8023/_convertron"
        };
    }

    private String getWsAddress(Inet4Address host)
    {
        String port = "8023";
        String location = "_convertron";
        return new StringBuilder()
                .append("http://")
                .append(host.getHostAddress())
                .append(":")
                .append(port)
                .append("/")
                .append(location)
                .toString();
    }

    public ConfigurationSource getOrCreateGlobalConfiguration(String moduleName)
    {
        return provider.provideConfig(moduleName).getGlobal();
    }

    public ModuleConfiguration getCoreConfig()
    {
        return coreConfig;
    }

    public GeneralConfigFile getMotdConfigFile()
    {
        return motdConfigFile;
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
        moduleManager.export(getData(), motdConfigFile.loadString());
    }

    private void publishWebService(String[] addresses)
    {
        Object ws = new ConvertronWS(this);

        for(String address : addresses)
        {
            Endpoint.publish(address, ws);
            Logger.logMessage(LogPriority.HINT, "WebService auf folgender Adresse veroeffentlicht: " + address);
        }
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
