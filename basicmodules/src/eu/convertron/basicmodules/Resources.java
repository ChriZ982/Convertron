package eu.convertron.basicmodules;

import eu.convertron.interlib.io.ResourceFile;
import java.net.URL;

public class Resources
{
    public static String RESOURCEPATH = "/eu/convertron/basicmodules/res/";

    public static URL get(String name)
    {
        return Resources.class.getResource(RESOURCEPATH + name);
    }

    public static ResourceFile file(String name)
    {
        return new ResourceFile(RESOURCEPATH + name, Resources.class);
    }

    public static void copyRes(String name, String dest)
    {
        file(name).copyIfNotExists(dest);
    }

    private Resources()
    {
    }
}
