package eu.convertron.server;

import eu.convertron.applib.console.ConsoleScanner;
import eu.convertron.applib.console.Operation;
import eu.convertron.applib.etc.LogFile;
import eu.convertron.interlib.logging.LogMessage;
import eu.convertron.interlib.logging.LogPriority;
import eu.convertron.interlib.logging.Logger;
import java.util.HashMap;

public class ConsoleMain
{
    public static void main(String[] args)
    {
        Logger.addLogOutput(new LogFile());
        Logger.addLogOutput((LogMessage message)
                -> System.out.println("[" + message.getPriority().getNameString() + "] ["
                                      + message.getTimeStringDetailed() + "]: "
                                      + message.getMessageDetailed())
        );

        Control control = new Control();

        HashMap<String, Operation> commands = new HashMap<>();
        Operation exit = (arg) -> control.exit();
        Operation export = (arg) -> control.export();
        commands.put("exit", exit);
        commands.put("quit", exit);
        commands.put("close", exit);
        commands.put("stop", exit);
        commands.put("abort", exit);
        commands.put("export", export);
        commands.put("generate", export);
        commands.put("genall", export);
        new ConsoleScanner(commands).startScanning();
        Logger.logMessage(LogPriority.HINT, "Anwendung im no-gui Modus gestartet.");
    }
}
