package eu.convertron.server;

import eu.convertron.applib.LogFile;
import eu.convertron.interlib.logging.LogMessage;
import eu.convertron.interlib.logging.LogPriority;
import eu.convertron.interlib.logging.Logger;
import javax.xml.ws.Endpoint;

/**
 *
 * @author Mirko Ruether
 */
public class Control
{
    public static void main(String[] args)
    {
        Logger.addLogOutput(new LogFile());
        Logger.addLogOutput((LogMessage message)
                -> System.out.println("[" + message.getPriority().getNameString() + "] ["
                                      + message.getTimeStringDetailed() + "]: "
                                      + message.getMessageDetailed())
        );
        new ConsoleScanner().startScanning();
        Logger.logMessage(LogPriority.HINT, "Anwendung im no-gui Modus gestartet.");
        startServer();
    }

    public static void startServer()
    {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    private static void publishWebService(String address)
    {
        Endpoint.publish(address, new ConvertronWS());
        Logger.logMessage(LogPriority.HINT, "WebService gestart, Adresse: " + address);
    }

    public static void exit()
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
