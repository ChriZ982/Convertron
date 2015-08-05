package convertron.tabs.modules;

import convertron.core.Window;
import interlib.interfaces.Module;
import interlib.interfaces.View;
import interlib.util.Logger;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ModuleLoader
{
    private ArrayList<ClassLocation> locationOfImportedModules;
    private Window mainWindow;

    public ModuleLoader(Window mainWindow)
    {
        this.mainWindow = mainWindow;
        locationOfImportedModules = new ArrayList<>();
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
                Logger.logMessage(Logger.WARNING, "Laden des Modules" + loc.toString() + " fehlgeschlagen");
                Logger.logError(Logger.INFO, ex);
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
                Logger.logError(Logger.INFO, ex);
            }
        }

        return moduleClasses.toArray(new ClassLocation[moduleClasses.size()]);
    }

    protected Module loadModule(ClassLocation location)
    {
        try
        {
            Module module = (Module)loadClass(location).newInstance();
            View modulesView = module.getView();
            if(modulesView != null && mainWindow != null)
                mainWindow.addTab(modulesView);

            return module;
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
            Logger.logMessage(Logger.INFO, "Try to load " + logPart);

            Class clazz = new URLClassLoader(new URL[]
            {
                location.getJarFileUrl()
            }).loadClass(location.getClassName());

            Logger.logMessage(Logger.INFO, logPart + " loaded");

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
            if(interf.equals(interlib.interfaces.Module.class))
                return true;
        }
        return false;
    }

    public class ModuleImporterListeners
    {

    }
}
