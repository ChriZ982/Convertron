package eu.convertron.server;

import eu.convertron.interlib.logging.LogPriority;
import eu.convertron.interlib.logging.Logger;
import java.awt.GridLayout;
import java.awt.TrayIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.xml.ws.Endpoint;

/**
 *
 * @author Mirko Ruether
 */
public class Control
{
    private static TrayIcon trayIcon;

    public static void main(String[] args)
    {
        Window window = initializeServer();
        JFrame frame = new JFrame("Convertron - Server");
        frame.setLayout(new GridLayout(1, 1));
        frame.add(window);

        frame.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                stopServer();
            }

            @Override
            public void windowIconified(WindowEvent e)
            {
                if(trayIcon != null)
                {
                    window.setVisible(false);
                }
            }
        });
    }

    public static void stopServer()
    {
        throw new UnsupportedOperationException();
    }

    public static Window initializeServer()
    {
        throw new UnsupportedOperationException();
    }

    private static void publishWebService(String address)
    {
        Endpoint.publish(address, new ConvertronWS());
        Logger.logMessage(LogPriority.HINT, "WebService gestart, Adresse: " + address);
    }
}
