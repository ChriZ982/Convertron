package eu.convertron.server.gui;

import java.net.URL;

public class Resources
{
    public static String RESOURCEPATH = "/eu/convertron/server/gui/res/";

    public static URL get(String name)
    {
        return Resources.class.getResource(RESOURCEPATH + name);
    }

    private Resources()
    {
    }
}
