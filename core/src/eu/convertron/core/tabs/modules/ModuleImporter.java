package eu.convertron.core.tabs.modules;

import eu.convertron.applib.modules.ClassLocation;
import eu.convertron.applib.modules.ModuleLoader;
import eu.convertron.core.CoreArraySettings;
import eu.convertron.interlib.interfaces.Module;
import eu.convertron.interlib.logging.LogPriority;
import eu.convertron.interlib.logging.Logger;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Der ModuleImporter ist für das importieren und laden (Instanz erzeugen) der Module zuständig.
 *
 * @see convertron.tabs.modules.ModuleManager
 */
public class ModuleImporter
{
    private ArrayList<ClassLocation> locationOfImportedModules;

    private ModuleImporterTab view;
    private ModuleLoader<Module> loader;

    public ModuleImporter(ModuleLoader<Module> loader)
    {
        this.loader = loader;
        locationOfImportedModules = new ArrayList<>();
        loadImported();

        view = new ModuleImporterTab(locationOfImportedModules.toArray(
                new ClassLocation[locationOfImportedModules.size()]));

        initializeListeners();
    }

    private void initializeListeners()
    {
        view.addChangesMadeListener(() -> saveAction());
        view.addOpenJarListener(() -> openJarAction());
    }

    private void saveAction()
    {
        locationOfImportedModules.clear();
        locationOfImportedModules.addAll(view.getAllModules());

        saveImported();
    }

    private void openJarAction()
    {
        try
        {
            view.setFileOpened(false);

            File jarFile = new File(view.getJarFile());
            ClassLocation[] foundModules = loader.getAvailableModules(jarFile);

            ArrayList<ClassLocation> foundAndNotImportedModules = new ArrayList<>();

            for(ClassLocation loc : foundModules)
            {
                if(!locationOfImportedModules.contains(loc))
                    foundAndNotImportedModules.add(loc);
            }

            if(foundAndNotImportedModules.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "In der Jar konnten keine neuen Module gefunden werden!", "Keine Module gefunden", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            view.setModulesInJar(foundAndNotImportedModules);

            view.setFileOpened(true);
        }
        catch(IOException ex)
        {
            Logger.logError(LogPriority.INFO, "Fehler beim öffnen oder lesen der Datei", ex);
        }
    }

    public List<Module> loadModules()
    {
        return loader.loadAll(locationOfImportedModules);
    }

    protected void saveImported()
    {
        String[] arrayForSetting = new String[locationOfImportedModules.size()];
        for(int i = 0; i < arrayForSetting.length; i++)
        {
            arrayForSetting[i] = locationOfImportedModules.get(i).forSaving();
        }
        CoreArraySettings.locationOfImportedModules.saveArray(arrayForSetting);
    }

    protected void loadImported()
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

    public ModuleImporterTab getView()
    {
        return view;
    }
}
