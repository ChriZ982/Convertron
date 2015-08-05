package convertron.tabs.modules;

import convertron.core.Window;
import interlib.data.Class;
import interlib.interfaces.Input;
import interlib.interfaces.Module;
import interlib.interfaces.Output;
import interlib.util.Settings;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ModuleManager implements Input, Output
{
    private ArrayList<Output> allOutputs;
    private ArrayList<Output> activeOutputs;
    private ArrayList<Input> allInputs;
    private Input activeInput;

    private ModuleView view;
    private ModuleViewListeners listeners;
    private ModuleLoader loader;

    public ModuleManager(Window mainWindow)
    {
        view = new ModuleView();
        listeners = new ModuleViewListeners();
        loader = new ModuleLoader(mainWindow);

        mainWindow.addTab(view);

        Module[] modules = loader.loadAllImportedModules();

        for(Module module : modules)
        {
            if(module instanceof Output)
                allOutputs.add((Output)module);
            if(module instanceof Input)
                allInputs.add((Input)module);
        }

        loadActive();
    }

    @Override
    public Class[] in()
    {
        return activeInput.in();
    }

    @Override
    public void out(Class[] types)
    {
        for(Output out : activeOutputs)
            out.out(types);
    }

    protected void saveActive()
    {
        String[] forSaving = new String[activeOutputs.size()];
        for(int i = 0; i < forSaving.length; i++)
        {
            forSaving[i] = forSaving(activeOutputs.get(i));
        }
        Settings.saveArray("activeOutputs", forSaving);

        Settings.save("activeInput", forSaving(activeInput));
    }

    protected void loadActive()
    {
        activeOutputs.clear();
        String[] fromSaving = Settings.loadArray("activeOutputs");
        for(String className : fromSaving)
        {
            Module m = fromSaving(className);
            if(m != null && m instanceof Output)
                activeOutputs.add((Output)m);
        }

        activeInput = null;
        Module m = fromSaving(Settings.load("activeInput"));

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

    protected class ModuleViewListeners
    {
        protected ModuleViewListeners()
        {
            initSaveListener();
        }

        protected void initSaveListener()
        {
            view.getSaveBtn().addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    activeOutputs.clear();

                    List<ModuleHolder> outputsMarkedAsActive = Collections.list(view.getActiveOutputModulesListModel().elements());
                    for(ModuleHolder holder : outputsMarkedAsActive)
                    {
                        if(holder.module instanceof Output)
                            activeOutputs.add((Output)holder.module);
                    }

                    activeInput = null;
                    ModuleHolder inputMarkedAsActive = (ModuleHolder)view.getActiveInputModuleComboModel().getSelectedItem();
                    if(inputMarkedAsActive instanceof Input)
                        activeInput = (Input)inputMarkedAsActive;

                    saveActive();
                }
            });
        }
    }

}
