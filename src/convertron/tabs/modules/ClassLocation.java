package convertron.tabs.modules;

import java.net.URL;

public class ClassLocation
{
    private URL jarFileUrl;
    private String jarEntryName;

    public ClassLocation(URL jarFileUrl, String jarEntryName)
    {
        this.jarFileUrl = jarFileUrl;
        this.jarEntryName = jarEntryName;
    }

    public String getJarEntryName()
    {
        return jarEntryName;
    }

    public void setJarEntryName(String jarEntryName)
    {
        this.jarEntryName = jarEntryName;
    }

    public URL getJarFileUrl()
    {
        return jarFileUrl;
    }

    public void setJarFileUrl(URL jarFileUrl)
    {
        this.jarFileUrl = jarFileUrl;
    }
}
