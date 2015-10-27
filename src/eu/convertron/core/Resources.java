package eu.convertron.core;

import java.net.URL;

public class Resources
{
    public static String RESOURCEPATH = "/eu/convertron/core/res/";

    public static URL get(String name)
    {
        return Resources.class.getResource(RESOURCEPATH + name);
    }
}
