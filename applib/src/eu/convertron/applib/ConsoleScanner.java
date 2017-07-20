package eu.convertron.applib;

import eu.convertron.interlib.logging.LogPriority;
import eu.convertron.interlib.logging.Logger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleScanner
{
    private Scanner scanner;
    private Thread scanningThread;

    private HashMap<String, ConsoleOperation> commands;

    public ConsoleScanner(Map<String, ConsoleOperation> commands)
    {
        scanner = new Scanner(System.in);
        this.commands = new HashMap<>(commands);
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

    private void scan()
    {
        try
        {
            while(true)
            {
                String line = scanner.next();
                String[] parts = line.split(" ", 2);
                String cmd = parts[0].toLowerCase();
                //TODO escape space with backslash
                String[] args = parts.length < 2 ? new String[0] : parts[1].split(" ");

                if(!commands.containsKey(cmd))
                {
                    Logger.logMessage(LogPriority.WARNING, "Unknown command " + cmd);
                    continue;
                }

                commands.get(cmd).execute(args);
            }
        }
        catch(Exception ex)
        {
            Logger.logError(LogPriority.ERROR, "Unexpected Exception", ex);
        }
    }
}
