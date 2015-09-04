package convertron.tabs.modules;

import convertron.core.Control;
import interlib.data.Lesson;
import interlib.interfaces.Input;
import interlib.interfaces.Module;
import interlib.interfaces.Output;
import interlib.util.Logger;
import interlib.util.Settings;
import java.util.ArrayList;

public class ModuleManager implements Input, Output
{
    private ArrayList<Output> allOutputs;
    private ArrayList<Output> activeOutputs;
    private ArrayList<Input> allInputs;
    private Input activeInput;

    private ModuleView view;
    private ModuleLoader loader;

    public ModuleManager()
    {
        loader = new ModuleLoader();

        Module[] modules = loader.loadAllImportedModules();

        for(Module module : modules)
        {
            if(module instanceof Output)
                allOutputs.add((Output)module);
            if(module instanceof Input)
                allInputs.add((Input)module);
        }

        loadActive();

        view = new ModuleView(allOutputs.toArray(),
                              activeOutputs.toArray(),
                              allInputs.toArray(),
                              activeInput);
        Control.addViewToWindow(view);

        for(Module module : modules)
        {
            if(module.getView() != null)
                Control.addViewToWindow(module.getView());
        }

        initializeListeners();
    }

    private void initializeListeners()
    {
        view.addSaveListener(() ->
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

    @Override
    public Lesson[] in()
    {
        return activeInput.in();
    }

    @Override
    public void out(Lesson[] types)
    {
        try
        {
            for(Output out : activeOutputs)
            {
                Lesson[] copy = new Lesson[types.length];
                for(int i = 0; i < types.length; i++)
                    copy[i] = types[i].clone();

                out.out(copy);
            }
        }
        catch(CloneNotSupportedException ex)
        {
            Logger.logError(Logger.ERROR, "Unerwarteter Fehler beim duplizieren der Stunden-Objekte", ex);
        }
    }

    @Override
    public void motdOut(String motd)
    {
        for(Output out : activeOutputs)
            out.motdOut(motd);
    }

    protected void saveActive()
    {
        String[] forSaving = new String[activeOutputs.size()];
        for(int i = 0; i < forSaving.length; i++)
        {
            forSaving[i] = forSaving(activeOutputs.get(i));
        }
        Settings.saveArray(true, "activeOutputs", forSaving);

        Settings.save(true, "activeInput", forSaving(activeInput));
    }

    protected void loadActive()
    {
        activeOutputs.clear();
        String[] fromSaving = Settings.loadArray(true, "activeOutputs");
        for(String className : fromSaving)
        {
            Module m = fromSaving(className);
            if(m != null && m instanceof Output)
                activeOutputs.add((Output)m);
        }

        activeInput = null;
        Module m = fromSaving(Settings.load(true, "activeInput"));

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

    protected Module getModuleByNameFromList(ArrayList<? extends Object> list, String className)
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
