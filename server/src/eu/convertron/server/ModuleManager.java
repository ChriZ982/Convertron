package eu.convertron.server;

import eu.convertron.applib.modules.ClassLocation;
import eu.convertron.applib.modules.ModuleLoader;
import eu.convertron.interlib.data.Lesson;
import eu.convertron.interlib.interfaces.Output;
import eu.convertron.interlib.logging.LogPriority;
import eu.convertron.interlib.logging.Logger;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class ModuleManager
{
    private ArrayList<Output> modules;

    private ModuleLoader<Output> loader;

    public ModuleManager()
    {
        loader = new ModuleLoader<>(Output.class);
        modules = loader.loadAll(loadLocations());
    }

    public void export(Lesson[] lessons, String motd)
    {
        for(Output out : modules)
        {
            exportSingle(out, lessons, motd);
        }
        Logger.logMessage(LogPriority.HINT, "Export abgeschlossen");
    }

    private void exportSingle(Output out, Lesson[] lessons, String motd)
    {
        try
        {
            out.out(lessons);
            out.motdOut(motd);
        }
        catch(Throwable t)
        {
            Logger.logError(LogPriority.ERROR, "Fehler beim exportieren mit dem Modul " + out.getClass().getName(), t);
        }
    }

    private ArrayList<ClassLocation> loadLocations()
    {
        String[] saved = ServerArraySettings.locationOfImportedOutputs.load();
        ArrayList<ClassLocation> result = new ArrayList<>(saved.length);

        for(String s : saved)
        {
            try
            {
                result.add(new ClassLocation(s));
            }
            catch(MalformedURLException ex)
            {
                Logger.logError(LogPriority.WARNING, "Modul konnte nicht geladen werden: Ungültige ClassLocation " + s, ex);
            }
        }
        return result;
    }
}
