package eu.convertron.core.tabs;

import eu.convertron.applib.modules.LoadedModule;
import eu.convertron.core.ModuleManager;
import eu.convertron.interlib.interfaces.View;
import eu.convertron.interlib.logging.LogPriority;
import eu.convertron.interlib.logging.Logger;
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
    private final ModuleManager moduleManager;
    private final ModuleView view;

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

        ArrayList<LoadedModule> modules = new ArrayList<>();
        modules.addAll(moduleManager.getAllInputs());
        modules.addAll(moduleManager.getAllOutputs());

        for(LoadedModule module : modules)
        {
            View moduleView = null;
            try
            {
                moduleView = module.getView();
            }
            catch(Throwable t)
            {
                String moduleName = "!Fehler beim Lesen des Modulnamens!";
                try
                {
                    moduleName = module.getName();
                }
                catch(Throwable t2)
                {
                }
                Logger.logError(LogPriority.WARNING, "Laden der Benutzeroberfläche des Modules " + moduleName + " fehlgeschlagen. "
                                                     + "Unter Umständen wird das Modul nicht funktionieren.", t);
            }
            if(moduleView != null && !result.contains(moduleView))
                result.add(moduleView);
        }

        return result;
    }
}
