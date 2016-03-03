package eu.convertron.applib.modules;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class ClassLocation
{
    private URL jarFileUrl;
    private String className;

    public ClassLocation(URL jarFileUrl, String className)
    {
        this.jarFileUrl = jarFileUrl;
        this.className = className;
    }

    public ClassLocation(File jarFile, String className) throws MalformedURLException
    {
        this(jarFile.toURI().toURL(), className);
    }

    public ClassLocation(String settingEntry) throws MalformedURLException
    {
        if(!settingEntry.contains("@"))
            throw new IllegalArgumentException("settingEntry must contain an @ for spliting className and URL");

        this.jarFileUrl = new URL(settingEntry.split("@", 2)[1]);
        this.className = settingEntry.split("@", 2)[0];
    }

    public String getClassName()
    {
        return className;
    }

    public void setClassName(String className)
    {
        this.className = className;
    }

    public URL getJarFileUrl()
    {
        return jarFileUrl;
    }

    public void setJarFileUrl(URL jarFileUrl)
    {
        this.jarFileUrl = jarFileUrl;
    }

    public String forSaving()
    {
        return className + "@" + jarFileUrl;
    }

    @Override
    public String toString()
    {
        return className;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof ClassLocation)
        {
            return ((ClassLocation)obj).getClassName().equals(className)
                   && ((ClassLocation)obj).getJarFileUrl().equals(jarFileUrl);
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.jarFileUrl);
        hash = 17 * hash + Objects.hashCode(this.className);
        return hash;
    }
}
