package convertron.tabs.modules;

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
    public ClassLocation[] getAvailableModuleClasses(File jarFile) throws IOException
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
                ClassLocation location = new ClassLocation(url, e.getName());

                Class cl = loadClass(location);
                if(isModule(cl))
                    moduleClasses.add(location);
            }
            catch(Exception ex)
            {
                Logger.logError(Logger.INFO, ex);
            }
        }

        return moduleClasses.toArray(new ClassLocation[0]);
    }

    public static Class loadClass(ClassLocation location)
    {
        String logPart = parseClassName(location.getJarEntryName())
                         + " from Jar " + location.getJarFileUrl();

        try
        {
            Logger.logMessage(Logger.INFO, "Try to load " + logPart);

            Class clazz = new URLClassLoader(new URL[]
            {
                location.getJarFileUrl()
            }).loadClass(parseClassName(location.getJarEntryName()));

            Logger.logMessage(Logger.INFO, logPart + " loaded");

            return clazz;
        }
        catch(Throwable t)
        {
            throw new RuntimeException("Failed to load " + logPart, t);
        }
    }

    protected static String parseClassName(String jarEntryName)
    {
        return jarEntryName.substring(0, jarEntryName.length() - ".class".length()).replaceAll("/", ".");
    }

    protected static boolean validateJarEntryAsClass(JarEntry e)
    {
        return e.getName().endsWith(".class");
    }

    protected static boolean isModule(Class c)
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
}
