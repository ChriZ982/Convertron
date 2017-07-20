package eu.convertron.core.tabs;

import eu.convertron.applib.modules.ClassLocation;
import eu.convertron.core.ModuleManager;
import eu.convertron.interlib.interfaces.View;
import eu.convertron.interlib.logging.LogPriority;
import eu.convertron.interlib.logging.Logger;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Der ModuleImportControl ist für das importieren und laden (Instanz erzeugen) der Module zuständig.
 *
 * @see convertron.tabs.modules.ModuleManager
 */
public class ModuleImportControl
{
    private final ModuleManager moduleManager;
    private final ModuleImportView view;

    public ModuleImportControl(ModuleManager moduleManager)
    {
        this.moduleManager = moduleManager;
        view = new ModuleImportView(moduleManager.getLocationOfImportedModules());

        initializeListeners();
    }

    private void initializeListeners()
    {
        view.addChangesMadeListener(() -> changesMadeAction());
        view.addOpenJarListener(() -> openJarAction());
    }

    private void changesMadeAction()
    {
        moduleManager.updateLocationOfImportedModules(view.getAllModules());
    }

    private void openJarAction()
    {
        try
        {
            view.setFileOpened(false);

            File jarFile = new File(view.getJarFile());
            ArrayList<ClassLocation> newModules = moduleManager.getNewModules(jarFile);

            if(newModules.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "In der Jar konnten keine neuen Module gefunden werden!", "Keine Module gefunden", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            view.setModulesInJar(newModules);
            view.setFileOpened(true);
        }
        catch(IOException ex)
        {
            Logger.logError(LogPriority.WARNING, "Fehler beim öffnen oder lesen der Datei", ex);
        }
    }

    public View getView()
    {
        return view;
    }
}
