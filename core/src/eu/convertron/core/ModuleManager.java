package eu.convertron.core;

import eu.convertron.applib.modules.ClassLocation;
import eu.convertron.applib.modules.ModuleLoader;
import eu.convertron.interlib.DefaultTableOptions;
import eu.convertron.interlib.Lesson;
import eu.convertron.interlib.TableOptions;
import eu.convertron.interlib.interfaces.Input;
import eu.convertron.interlib.interfaces.Module;
import eu.convertron.interlib.interfaces.Output;
import eu.convertron.interlib.logging.LogPriority;
import eu.convertron.interlib.logging.Logger;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import eu.convertron.applib.modules.ModuleConfigurationProvider;

/**
 *
 * @author Mirko Ruether
 */
public class ModuleManager
{
    private final ArrayList<ClassLocation> locationOfImportedModules;

    private final ArrayList<Output> allOutputs;
    private final ArrayList<Output> activeOutputs;
    private final ArrayList<Input> allInputs;
    private Input activeInput;

    private final ModuleLoader<Module> loader;

    public ModuleManager(ModuleConfigurationProvider provider)
    {
        locationOfImportedModules = new ArrayList<>();
        loadLocations();

        allOutputs = new ArrayList<>();
        activeOutputs = new ArrayList<>();

        allInputs = new ArrayList<>();
        activeInput = null;

        loader = new ModuleLoader<>(Module.class, provider);

        List<Module> modules = loader.loadAll(locationOfImportedModules);

        for(Module module : modules)
        {
            if(module instanceof Output)
                allOutputs.add((Output)module);
            if(module instanceof Input)
                allInputs.add((Input)module);
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
        for(Output out : activeOutputs)
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
        for(Output out : activeOutputs)
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

    private String getModuleName(Module m)
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
            Module m = fromSaving(className);
            if(m != null && m instanceof Output)
                activeOutputs.add((Output)m);
        }

        activeInput = null;
        Module m = fromSaving(CoreSettings.activeInput.load());

        if(m != null && m instanceof Input)
            activeInput = (Input)m;
    }

    protected String forSaving(Object module)
    {
        if(module instanceof Module)
            return module.getClass().getName();
        return null;
    }

    protected Module fromSaving(String className)
    {
        if(className == null || className.isEmpty())
            return null;

        Module module = getModuleByNameFromList(allInputs, className);
        if(module == null)
            module = getModuleByNameFromList(allOutputs, className);

        return module;
    }

    protected Module getModuleByNameFromList(ArrayList<?> list, String className)
    {
        Module module = null;

        for(Object o : list)
        {
            if(o instanceof Module)
            {
                Module current = (Module)o;
                if(current.getClass().getName().equals(className))
                {
                    module = current;
                    break;
                }
            }
        }

        return module;
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

    public ArrayList<Output> getAllOutputs()
    {
        return allOutputs;
    }

    public ArrayList<Output> getActiveOutputs()
    {
        return activeOutputs;
    }

    public void updateActiveOutputs(Collection<Output> active)
    {
        activeOutputs.clear();
        activeOutputs.addAll(active);

        saveActiveOutputs();
    }

    public ArrayList<Input> getAllInputs()
    {
        return allInputs;
    }

    public Input getActiveInput()
    {
        return activeInput;
    }

    public void updateActiveInput(Input active)
    {
        this.activeInput = active;

        saveActiveInput();
    }
}
