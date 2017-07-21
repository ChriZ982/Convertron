package eu.convertron.applib.modules;

import eu.convertron.interlib.config.LoadingContext;
import eu.convertron.interlib.config.ModuleConfiguration;
import eu.convertron.interlib.config.ModuleInitializationResult;
import eu.convertron.interlib.interfaces.Module;
import eu.convertron.interlib.logging.LogPriority;
import eu.convertron.interlib.logging.Logger;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ModuleLoader
{
    private final Class<? extends Module> moduleClass;
    private final ModuleConfigurationProvider provider;

    public ModuleLoader(Class<? extends Module> moduleClass, ModuleConfigurationProvider provider)
    {
        this.moduleClass = moduleClass;
        this.provider = provider;
    }

    public ArrayList<LoadedModule> loadAll(Collection<ClassLocation> locations, LoadingContext context)
    {
        ArrayList<LoadedModule> loadedModules = new ArrayList<>();

        for(ClassLocation loc : locations)
        {
            try
            {
                loadedModules.add(loadModule(loc, context));
            }
            catch(RuntimeException ex)
            {
                Logger.logError(LogPriority.WARNING, "Laden des Modules der Klasse '" + loc.toString() + "' fehlgeschlagen", ex);
            }
        }
        return loadedModules;
    }

    public ArrayList<ClassLocation> getAvailableModules(File jarFile) throws IOException
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

                Class<?> cl = loadClass(location);
                if(isModule(cl))
                    moduleClasses.add(location);
            }
            catch(Exception ex)
            {
                Logger.logError(LogPriority.INFO, "Fehler beim Laden einer Klasse die potentiell ein Modul ist", ex);
            }
        }

        return moduleClasses;
    }

    public LoadedModule loadModule(ClassLocation location, LoadingContext context)
    {
        Module instance;
        try
        {
            instance = (Module)loadClass(location).newInstance();
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

        ModuleInitializationResult result;
        ModuleConfiguration config;
        try
        {
            config = provider.provideConfig(instance.getClass());
            result = instance.init(config, context);
            Logger.logMessage(LogPriority.HINT, "Modul " + instance.getClass().getName() + " geladen und konfiguriert");
        }
        catch(Throwable t)
        {
            throw new RuntimeException("Exception while initializing Module "
                                       + (instance != null ? instance.getClass() : "null")
                                       + " at location " + location.forSaving());
        }

        return new LoadedModule(location, result, instance, context, config);
    }

    protected Class<?> loadClass(ClassLocation location)
    {
        String logPart = location.getClassName()
                         + " from Jar " + location.getJarFileUrl();

        try
        {
            Logger.logMessage(LogPriority.INFO, "Try to load " + logPart);

            Class<?> clazz = new URLClassLoader(new URL[]
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
        return e.getName().endsWith(".class") && !e.getName().contains("$");
    }

    protected boolean isModule(Class<?> c)
    {
        if(c == null
           || c.isInterface()
           || c.isLocalClass()
           || c.isMemberClass()
           || c.isAnnotation()
           || c.isAnonymousClass())
            return false;

        return isModuleRecursive(c);
    }

    private boolean isModuleRecursive(Class<?> c)
    {
        if(c == null)
            return false;

        Class<?>[] interfaces = c.getInterfaces();
        for(Class<?> interf : interfaces)
        {
            if(interf.equals(moduleClass) || isModuleRecursive(interf))
                return true;
        }

        return c.equals(moduleClass) || isModuleRecursive(c.getSuperclass());
    }
}
