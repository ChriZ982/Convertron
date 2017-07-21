package eu.convertron.server;

import eu.convertron.applib.modules.ClassLocation;
import eu.convertron.applib.modules.LoadedModule;
import eu.convertron.applib.modules.ModuleConfigurationProvider;
import eu.convertron.applib.modules.ModuleLoader;
import eu.convertron.interlib.Lesson;
import eu.convertron.interlib.config.LoadingContext;
import eu.convertron.interlib.logging.LogPriority;
import eu.convertron.interlib.logging.Logger;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class ModuleManager
{
    private final ArrayList<LoadedModule> modules;

    private final ModuleLoader loader;

    public ModuleManager(ModuleConfigurationProvider provider)
    {
        loader = new ModuleLoader(eu.convertron.interlib.interfaces.Output.class, provider);
        modules = loader.loadAll(loadLocations(), new LoadingContext(LoadingContext.Purpose.Excecution, LoadingContext.Location.Server));
    }

    public void export(Lesson[] lessons, String motd)
    {
        for(LoadedModule out : modules)
        {
            exportSingle(out, lessons, motd);
        }
        Logger.logMessage(LogPriority.HINT, "Export abgeschlossen");
    }

    private void exportSingle(LoadedModule out, Lesson[] lessons, String motd)
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
        if(saved == null)
            saved = new String[0];
        ArrayList<ClassLocation> result = new ArrayList<>(saved.length);

        for(String s : saved)
        {
            if(s == null || s.trim().isEmpty())
                continue;
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
