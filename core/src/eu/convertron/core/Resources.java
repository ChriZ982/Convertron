package eu.convertron.core;

import eu.convertron.interlib.io.ResourceFile;
import java.net.URL;

public class Resources
{
    public static String RESOURCEPATH = "/eu/convertron/core/res/";

    public static URL get(String name)
    {
        return Resources.class.getResource(RESOURCEPATH + name);
    }

    public static void copyRes(String name, String dest)
    {
        new ResourceFile(RESOURCEPATH + name, Resources.class).copyIfNotExists(dest);
    }

    private Resources()
    {
    }
}
