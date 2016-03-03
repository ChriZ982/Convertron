package eu.convertron.server;

import eu.convertron.interlib.logging.LogPriority;
import eu.convertron.interlib.logging.Logger;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Mirko Ruether
 */
public class ConsoleScanner
{
    private Scanner scanner;
    private Thread scanningThread;

    private HashMap<String, Runnable> commands;

    public ConsoleScanner()
    {
        scanner = new Scanner(System.in);
        load();
    }

    public void startScanning()
    {
        scanningThread = new Thread(() -> scan());
        scanningThread.start();
    }

    public void stopScanning()
    {
        scanningThread.interrupt();
    }

    private void load()
    {
        //TODO load from file
        commands = new HashMap<>();

        Runnable exit = () -> Control.exit();
        commands.put("exit", exit);
        commands.put("quit", exit);
        commands.put("close", exit);
        commands.put("stop", exit);
        commands.put("abort", exit);
    }

    private void scan()
    {
        try
        {
            while(true)
            {
                String line = scanner.next();
                String[] parts = line.split(" ", 2);
                String cmd = parts[0].toLowerCase();

                if(!commands.containsKey(cmd))
                {
                    Logger.logMessage(LogPriority.WARNING, "Unknown command " + cmd);
                    continue;
                }

                commands.get(cmd).run();
            }
        }
        catch(Exception ex)
        {
            Logger.logError(LogPriority.ERROR, "Unexpected Exception", ex);
        }
    }
}
