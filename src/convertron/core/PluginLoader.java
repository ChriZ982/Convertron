package convertron.core;

import interlib.util.Logger;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class PluginLoader
{
    public Class[] loadAllModuleClasses(File jarFile) throws IOException
    {
        ArrayList<Class> moduleClasses = new ArrayList<>();

        JarFile jar = new JarFile(jarFile);
        URL url = jarFile.toURI().toURL();
        Enumeration<JarEntry> entries = jar.entries();

        while(entries.hasMoreElements())
        {
            JarEntry e = entries.nextElement();

            if(!validateJarEntryAsClass(e))
                continue;

            Class cl = loadClass(url, e);
            if(isModule(cl))
                moduleClasses.add(cl);
        }

        return moduleClasses.toArray(new Class[0]);
    }

    protected static Class loadClass(URL jarFileUrl, JarEntry e)
    {
        String logPart = "Try to load " + parseClassName(e.getName()) + " from Jar " + jarFileUrl;

        try
        {
            Logger.logMessage(Logger.INFO, "Try to load " + logPart);

            Class clazz = new URLClassLoader(new URL[]
            {
                jarFileUrl
            }).loadClass(parseClassName(e.getName()));

            Logger.logMessage(Logger.INFO, logPart + " loaded");

            return clazz;
        }
        catch(Throwable t)
        {
            Logger.logMessage(Logger.INFO, "Failed to load " + logPart);
            Logger.logError(Logger.INFO, t);
            return null;
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
