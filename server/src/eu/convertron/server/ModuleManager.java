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

    public void exportLessons(Lesson[] types)
    {
        for(LoadedModule out : modules)
        {
            try
            {
                Logger.logMessage(LogPriority.INFO, "Versuche die Vertretungseinträge zu exportieren. Modul: " + getModuleName(out));
                Lesson[] copy = new Lesson[types.length];
                for(int i = 0; i < types.length; i++)
                    copy[i] = new Lesson(types[i]);

                out.out(copy);
            }
            catch(Throwable ex)
            {
                Logger.logError(LogPriority.WARNING, "Fehler beim exportieren der Vertretungseinträge mit dem Modul: "
                                                     + getModuleName(out), ex);
            }
        }
    }

    public void exportMotd(String motd)
    {
        for(LoadedModule out : modules)
        {
            try
            {
                Logger.logMessage(LogPriority.INFO, "Versuche die Laufschrift zu exportieren. Modul: " + getModuleName(out));
                out.motdOut(motd);
            }
            catch(Exception ex)
            {
                Logger.logError(LogPriority.WARNING, "Fehler beim exportieren der Laufschrift mit dem Modul: "
                                                     + getModuleName(out), ex);
            }
        }
    }

    private String getModuleName(LoadedModule m)
    {
        return m == null ? "null" : m.getName();
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
