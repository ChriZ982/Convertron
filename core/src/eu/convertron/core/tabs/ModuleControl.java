package eu.convertron.core.tabs;

import eu.convertron.core.ModuleManager;
import eu.convertron.interlib.interfaces.Module;
import eu.convertron.interlib.interfaces.View;
import java.util.ArrayList;

/**
 * Der ModuleControl ist für das im- und exportieren mithilfe der Module zuständig.
 * Außerdem ist er für das aktivieren und deaktivieren von Modulen zuständig,
 * nicht jedoch für das importieren von Modulen.
 *
 * @see eu.convertron.core.tabs.modules.ModuleImporter
 */
public class ModuleControl
{
    private ModuleManager moduleManager;
    private ModuleView view;

    public ModuleControl(ModuleManager moduleManager)
    {
        this.moduleManager = moduleManager;

        view = new ModuleView(moduleManager.getAllOutputs(),
                              moduleManager.getActiveOutputs(),
                              moduleManager.getAllInputs(),
                              moduleManager.getActiveInput());

        initializeListeners();
    }

    private void initializeListeners()
    {
        view.addSaveListener(() -> saveAction());
    }

    private void saveAction()
    {
        moduleManager.updateActiveOutputs(view.getActiveOutputModules());
        moduleManager.updateActiveInput(view.getActiveInputModule());
    }

    public View getView()
    {
        return view;
    }

    public ArrayList<View> getModuleViews()
    {
        ArrayList<View> result = new ArrayList<>();

        ArrayList<Module> modules = new ArrayList<>();
        modules.addAll(moduleManager.getAllInputs());
        modules.addAll(moduleManager.getAllOutputs());

        for(Module module : modules)
        {
            View moduleView = module == null ? null : module.getView();
            if(moduleView != null && !result.contains(moduleView))
                result.add(moduleView);
        }

        return result;
    }
}
