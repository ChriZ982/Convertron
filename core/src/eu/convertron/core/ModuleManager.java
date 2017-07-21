package eu.convertron.core;

import eu.convertron.applib.modules.ClassLocation;
import eu.convertron.applib.modules.LoadedModule;
import eu.convertron.applib.modules.ModuleConfigurationProvider;
import eu.convertron.applib.modules.ModuleLoader;
import eu.convertron.interlib.DefaultTableOptions;
import eu.convertron.interlib.Lesson;
import eu.convertron.interlib.TableOptions;
import eu.convertron.interlib.config.LoadingContext;
import eu.convertron.interlib.logging.LogPriority;
import eu.convertron.interlib.logging.Logger;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Mirko Ruether
 */
public class ModuleManager
{
    private final ArrayList<ClassLocation> locationOfImportedModules;

    private final ArrayList<LoadedModule> allOutputs;
    private final ArrayList<LoadedModule> activeOutputs;
    private final ArrayList<LoadedModule> allInputs;
    private LoadedModule activeInput;

    private final ModuleLoader loader;

    public ModuleManager(ModuleConfigurationProvider provider)
    {
        locationOfImportedModules = new ArrayList<>();
        loadLocations();

        allOutputs = new ArrayList<>();
        activeOutputs = new ArrayList<>();

        allInputs = new ArrayList<>();
        activeInput = null;

        loader = new ModuleLoader(eu.convertron.interlib.interfaces.Module.class, provider);

        LoadingContext context = new LoadingContext(LoadingContext.Purpose.Excecution,
                                                    CoreSettings.useRemote.isTrue()
                                                    ? LoadingContext.Location.Client_Remote_Mode
                                                    : LoadingContext.Location.Client_Standalone_Mode);
        List<LoadedModule> modules = loader.loadAll(locationOfImportedModules, context);

        for(LoadedModule module : modules)
        {
            if(module.isOutput())
                allOutputs.add(module);
            if(module.isInput())
                allInputs.add(module);
        }

        loadActive();
    }

    public ArrayList<ClassLocation> getNewModules(File jarFile) throws IOException
    {
        ArrayList<ClassLocation> foundModules = loader.getAvailableModules(jarFile);

        ArrayList<ClassLocation> foundAndNotImportedModules = new ArrayList<>();
        for(ClassLocation loc : foundModules)
        {
            if(!locationOfImportedModules.contains(loc))
                foundAndNotImportedModules.add(loc);
        }
        return foundAndNotImportedModules;
    }

    public Lesson[] importLessons()
    {
        try
        {
            Logger.logMessage(LogPriority.INFO, "Versuche die Vertretungeinträge zu importieren. Modul: " + getModuleName(activeInput));
            return format(activeInput.in());
        }
        catch(Throwable ex)
        {
            Logger.logError(LogPriority.ERROR, "Fehler beim Einlesen der Vertretungseinträge mit dem Modul: "
                                               + getModuleName(activeInput), ex);
        }
        return null;
    }

    private Lesson[] format(Lesson[] source)
    {
        if(source == null)
            return null;

        Lesson[] result = source;
        TableOptions to = TableOptions.getInstance();
        result = to.unify(result);
        result = to.sort(result, DefaultTableOptions.FIRSTHOUR);
        result = to.compress(result);

        return result;
    }

    public void exportLessons(Lesson[] types)
    {
        for(LoadedModule out : activeOutputs)
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
        for(LoadedModule out : activeOutputs)
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

    protected void saveLocations()
    {
        String[] arrayForSetting = new String[locationOfImportedModules.size()];
        for(int i = 0; i < arrayForSetting.length; i++)
        {
            arrayForSetting[i] = locationOfImportedModules.get(i).forSaving();
        }
        CoreArraySettings.locationOfImportedModules.saveArray(arrayForSetting);
    }

    protected void loadLocations()
    {
        String[] fromSetting = CoreArraySettings.locationOfImportedModules.loadArray();
        for(String locationAsString : fromSetting)
        {
            try
            {
                locationOfImportedModules.add(new ClassLocation(locationAsString));
            }
            catch(Exception ex)
            {
                Logger.logError(LogPriority.INFO, "Konnte das Modul " + locationAsString + " nicht laden", ex);
            }
        }
    }

    protected void saveActiveOutputs()
    {
        String[] forSaving = new String[activeOutputs.size()];
        for(int i = 0; i < forSaving.length; i++)
        {
            forSaving[i] = forSaving(activeOutputs.get(i));
        }
        CoreArraySettings.activeOutputs.saveArray(forSaving);
    }

    protected void saveActiveInput()
    {
        CoreSettings.activeInput.save(forSaving(activeInput));
    }

    protected void loadActive()
    {
        activeOutputs.clear();
        String[] fromSaving = CoreArraySettings.activeOutputs.loadArray();
        for(String className : fromSaving)
        {
            LoadedModule m = fromSaving(className);
            if(m != null && m.isOutput())
                activeOutputs.add(m);
        }

        activeInput = null;
        LoadedModule m = fromSaving(CoreSettings.activeInput.load());

        if(m != null && m.isInput())
            activeInput = m;
    }

    protected String forSaving(LoadedModule module)
    {
        return module.getModuleClassName();
    }

    protected LoadedModule fromSaving(String className)
    {
        if(className == null || className.isEmpty())
            return null;

        LoadedModule module = getModuleByNameFromList(allInputs, className);
        if(module == null)
            module = getModuleByNameFromList(allOutputs, className);

        return module;
    }

    protected LoadedModule getModuleByNameFromList(ArrayList<LoadedModule> list, String className)
    {
        for(LoadedModule m : list)
        {
            if(m.getModuleClassName().equals(className))
            {
                return m;
            }
        }
        return null;
    }

    public ArrayList<ClassLocation> getLocationOfImportedModules()
    {
        return locationOfImportedModules;
    }

    public void updateLocationOfImportedModules(Collection<ClassLocation> locations)
    {
        locationOfImportedModules.clear();
        locationOfImportedModules.addAll(locations);

        saveLocations();
    }

    public ArrayList<LoadedModule> getAllOutputs()
    {
        return allOutputs;
    }

    public ArrayList<LoadedModule> getActiveOutputs()
    {
        return activeOutputs;
    }

    public void updateActiveOutputs(Collection<LoadedModule> active)
    {
        activeOutputs.clear();
        activeOutputs.addAll(active);

        saveActiveOutputs();
    }

    public ArrayList<LoadedModule> getAllInputs()
    {
        return allInputs;
    }

    public LoadedModule getActiveInput()
    {
        return activeInput;
    }

    public void updateActiveInput(LoadedModule active)
    {
        this.activeInput = active;

        saveActiveInput();
    }
}
