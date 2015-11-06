package eu.convertron.core.tabs.modules;

import eu.convertron.core.Control;
import eu.convertron.core.modules.ClassLocation;
import eu.convertron.core.settings.CoreArraySettings;
import eu.convertron.interlib.interfaces.Module;
import eu.convertron.interlib.logging.Logger;
import eu.convertron.interlib.logging.messages.LogPriority;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import javax.swing.JOptionPane;

/**
 * Der ModuleManagerControl ist für das importieren und laden (Instanz erzeugen) der Module zuständig.
 *
 * @see convertron.tabs.modules.ModuleManager
 */
public class ModuleManagerControl
{
    private ArrayList<ClassLocation> locationOfImportedModules;

    private ModuleManagerView view;

    public ModuleManagerControl()
    {
        locationOfImportedModules = new ArrayList<>();
        loadImported();

        view = new ModuleManagerView(locationOfImportedModules.toArray(
                new ClassLocation[locationOfImportedModules.size()]));

        Control.addViewToWindow(view);

        initializeListeners();
    }

    private void initializeListeners()
    {
        view.addSaveListener(() ->
        {
            saveAction();
        });

        view.addOpenJarListener(() ->
        {
            openJarAction();
        });
    }

    private void saveAction()
    {
        locationOfImportedModules.clear();
        locationOfImportedModules.addAll(view.getAllModules());

        saveImported();

        JOptionPane.showMessageDialog(null, "Die Änderungen werden erst nach einem Neustart der Anwendung wirksam!");
    }

    private void openJarAction()
    {
        try
        {
            view.setFileOpened(false);

            File jarFile = new File(view.getJarFile());
            ClassLocation[] foundModules = getAvailableModules(jarFile);

            view.setModulesInJar(Arrays.asList(foundModules));

            view.setFileOpened(true);
        }
        catch(IOException ex)
        {
            Logger.logError(LogPriority.INFO, "Fehler beim öffnen oder lesen der Datei", ex);
        }
    }

    public Module[] loadAllImportedModules()
    {
        ArrayList<Module> modules = new ArrayList<>();

        for(ClassLocation loc : locationOfImportedModules)
            try
            {
                modules.add(loadModule(loc));
            }
            catch(RuntimeException ex)
            {
                Logger.logError(LogPriority.INFO, "Laden des Modules" + loc.toString() + " fehlgeschlagen", ex);
            }

        return modules.toArray(new Module[modules.size()]);
    }

    protected ClassLocation[] getAvailableModules(File jarFile) throws IOException
    {
        ArrayList<ClassLocation> moduleClasses = new ArrayList<>();

        JarFile jar = new JarFile(jarFile);
        URL url = jarFile.toURI().toURL();
        Enumeration<JarEntry> entries = jar.entries();

        while(entries.hasMoreElements())
        {
            JarEntry e = entries.nextElement();

            if(!validateJarEntryAsClass(e))
                continue;

            try
            {
                ClassLocation location = new ClassLocation(url, parseClassName(e.getName()));

                Class cl = loadClass(location);
                if(isModule(cl))
                    moduleClasses.add(location);
            }
            catch(Exception ex)
            {
                Logger.logError(LogPriority.INFO, "Fehler beim Laden einer Klasse die potentiell ein Modul ist", ex);
            }
        }

        return moduleClasses.toArray(new ClassLocation[moduleClasses.size()]);
    }

    protected Module loadModule(ClassLocation location)
    {
        try
        {
            return (Module)loadClass(location).newInstance();
        }
        catch(ClassCastException ex)
        {
            throw new RuntimeException(location.forSaving() + " isn't a Module", ex);
        }
        catch(InstantiationException ex)
        {
            throw new RuntimeException("Failed to create an Instance of " + location.forSaving(), ex);
        }
        catch(Throwable t)
        {
            throw new RuntimeException("Failed to load Module" + location.forSaving(), t);
        }
    }

    protected Class loadClass(ClassLocation location)
    {
        String logPart = location.getClassName()
                         + " from Jar " + location.getJarFileUrl();

        try
        {
            Logger.logMessage(LogPriority.INFO, "Try to load " + logPart);

            Class clazz = new URLClassLoader(new URL[]
            {
                location.getJarFileUrl()
            }).loadClass(location.getClassName());

            Logger.logMessage(LogPriority.INFO, logPart + " loaded");

            return clazz;
        }
        catch(Throwable t)
        {
            throw new RuntimeException("Failed to load " + logPart, t);
        }
    }

    protected String parseClassName(String jarEntryName)
    {
        return jarEntryName.substring(0, jarEntryName.length() - ".class".length()).replaceAll("/", ".");
    }

    protected boolean validateJarEntryAsClass(JarEntry e)
    {
        return e.getName().endsWith(".class");
    }

    protected boolean isModule(Class c)
    {
        if(c == null)
            return false;

        Class[] interfaces = c.getInterfaces();

        for(Class interf : interfaces)
        {
            if(interf.equals(eu.convertron.interlib.interfaces.Module.class) || isModule(interf))
                return true;
        }
        return false;
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
}
