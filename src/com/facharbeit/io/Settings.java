package com.facharbeit.io;

import com.facharbeit.tools.*;
import java.util.*;

public class Settings
{
    private static FileWriter writer;
    private static FileReader reader;
    private static boolean logging;

    public static void init()
    {
        writer = new FileWriter("Data/", "settings.ini");
        reader = new FileReader("Data/", "settings.ini");
        logging = true;

        if(!reader.exists())
            writer.create();
        else
            Logger.log("\"settings.ini\" wurde geladen.", 0);
    }

    public static void save(String name, String setting)
    {
        int line = getLineOf(name);

        String settings = name + ": \"" + setting + "\"";
        if(line == -1)
            writer.write(reader.getLines(), settings);
        else
            writer.write(line, settings);

        if(logging)
            Logger.log("Einstellung '" + name + "' gespeichert.", 0);
    }

    public static String load(String name)
    {
        int line = getLineOf(name);

        if(line == -1)
        {
            if(logging)
                Logger.log("Einstellung '" + name + "' nicht vorhanden.", 1);
            return "";
        } else
        {
            String setting = reader.read(line);
            setting = setting.replaceFirst(name + ": \"", "");
            setting = setting.substring(0, setting.length() - 1);

            if(logging)
                Logger.log("Einstellung '" + name + "' geladen.", 3);
            return setting;
        }
    }

    public static String[] giveMultipleNames(String name)
    {
        ArrayList<String> names = new ArrayList<String>();
        String[] file = reader.readAll();

        for(String s : file)
            if(s.startsWith(name))
                names.add(s.split(": \"")[0].trim());

        return names.toArray(new String[]
        {
        });
    }

    public static String[] giveMultipleValues(String name)
    {
        logging = false;
        ArrayList<String> values = new ArrayList<String>();
        String[] file = reader.readAll();

        for(String s : file)
            if(s.startsWith(name))
                values.add(Settings.load(s.split(": \"")[0].trim()));

        logging = true;
        return values.toArray(new String[]
        {
        });
    }

    public static boolean delete(String name)
    {
        int line = getLineOf(name);

        if(line != -1)
        {
            ArrayList<String> content = new ArrayList<String>();
            content.addAll(Arrays.asList(reader.readAll()));
            content.remove(line);

            writer.writeAll(content.toArray(new String[]
            {
            }));

            if(logging)
                Logger.log("Einstellung '" + name + "' gelöscht.", 0);
            return true;
        }

        return false;
    }

    public static int getLineOf(String name)
    {
        String[] content = reader.readAll();
        int line = -1;

        for(int i = 0; i < content.length; i++)
            if(content[i] != null && content[i].startsWith(name))
            {
                line = i;
                break;
            }

        return line;
    }

    public static void logging(boolean pLogging)
    {
        logging = pLogging;
    }
}
