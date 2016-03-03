package eu.convertron.core.tabs.modules;

import eu.convertron.applib.modules.ModuleLoader;
import eu.convertron.core.Control;
import eu.convertron.core.CoreArraySettings;
import eu.convertron.core.CoreSettings;
import eu.convertron.interlib.data.Lesson;
import eu.convertron.interlib.filter.DefaultTableOptions;
import eu.convertron.interlib.filter.TableOptions;
import eu.convertron.interlib.interfaces.Input;
import eu.convertron.interlib.interfaces.Module;
import eu.convertron.interlib.interfaces.Output;
import eu.convertron.interlib.logging.LogPriority;
import eu.convertron.interlib.logging.Logger;
import eu.convertron.interlib.util.SubTabView;
import java.util.ArrayList;
import java.util.List;

/**
 * Der ModuleControl ist für das im- und exportieren mithilfe der Module zuständig.
 * Außerdem ist er für das aktivieren und deaktivieren von Modulen zuständig,
 * nicht jedoch für das importieren von Modulen.
 *
 * @see eu.convertron.core.tabs.modules.ModuleImporter
 */
public class ModuleControl
{
    private ArrayList<Output> allOutputs;
    private ArrayList<Output> activeOutputs;
    private ArrayList<Input> allInputs;
    private Input activeInput;

    private ModuleTab view;
    private ModuleImporter importer;
    private ModuleLoader<Module> loader;

    public ModuleControl()
    {
        allOutputs = new ArrayList<Output>();
        activeOutputs = new ArrayList<Output>();

        allInputs = new ArrayList<Input>();
        activeInput = null;

        loader = new ModuleLoader<>(Module.class);
        importer = new ModuleImporter(loader);

        List<Module> modules = importer.loadModules();

        for(Module module : modules)
        {
            if(module instanceof Output)
                allOutputs.add((Output)module);
            if(module instanceof Input)
                allInputs.add((Input)module);
        }

        loadActive();

        view = new ModuleTab(allOutputs.toArray(),
                             activeOutputs.toArray(),
                             allInputs.toArray(),
                             activeInput);

        Control.addViewToWindow(new SubTabView("Module", view, importer.getView()));

        for(Module module : modules)
        {
            if(module.getView() != null)
                Control.addViewToWindow(module.getView());
        }

        initializeListeners();
    }

    private void initializeListeners()
    {
        view.addSaveListener(()
                ->
                {
                    saveAction();
        });
    }

    private void saveAction()
    {
        activeOutputs.clear();

        Module[] outputsMarkedAsActive = view.getActiveOutputModules();
        for(Module out : outputsMarkedAsActive)
        {
            if(out instanceof Output)
                activeOutputs.add((Output)out);
        }

        activeInput = null;
        Module inputMarkedAsActive = view.getActiveInputModule();
        if(inputMarkedAsActive instanceof Input)
            activeInput = (Input)inputMarkedAsActive;

        saveActive();
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
        result = TableOptions.unify(result);
        result = TableOptions.sort(result, DefaultTableOptions.FIRSTHOUR);
        result = TableOptions.compress(result);

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

    protected void saveActive()
    {
        String[] forSaving = new String[activeOutputs.size()];
        for(int i = 0; i < forSaving.length; i++)
        {
            forSaving[i] = forSaving(activeOutputs.get(i));
        }
        CoreArraySettings.activeOutputs.saveArray(forSaving);

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
}
