package com.facharbeit.io;

import com.facharbeit.tools.Logger;
import java.util.*;

/**
 * Klasse für das verwalten der Einstellungen.
 */
public class Settings
{
    /**
     * Writer für das Speichern der Einstellungen.
     */
    private static FileWriter writer;

    /**
     * Reader für das Laden der Einstellungen.
     */
    private static FileReader reader;

    /**
     * Soll das Logging aktiviert werden?.
     */
    private static boolean logging;

    /**
     * Initialisiert die Einstellungen.
     */
    public static void init()
    {
        try
        {
            writer = new FileWriter("Data/", "settings.ini");
            reader = new FileReader("Data/", "settings.ini");
            logging = true;

            if(!reader.exists())
                writer.create();
            else
                Logger.log("\"settings.ini\" wurde geladen", 0);
        }
        catch(Exception ex)
        {
            Logger.log("Einstellungen konnten nicht initialisiert werden", 2);
            Logger.error(ex);
        }
    }

    /**
     * Speichert eine Einstellung.
     *
     * @param name    Name der Einstellung
     * @param setting Wert der Einstellung
     */
    public static void save(String name, String setting)
    {
        try
        {
            if(setting.equals(""))
            {
                delete(name);
                return;
            }

            int line = line(name);
            String settings = name + ": \"" + setting + "\"";
            if(line == -1)
                writer.write(reader.length(), settings);
            else
                writer.write(line, settings);

            if(logging)
                Logger.log("Einstellung \"" + name + "\" gespeichert", 0);
        }
        catch(Exception ex)
        {
            Logger.log("Einstellung \"" + name + "\" konnte nicht gespeichert werden.", 2);
            Logger.error(ex);
        }
    }

    /**
     * Lädt eine Einstellung.
     *
     * @param name Name der einstellung
     *
     * @return Wert der Einstellung
     */
    public static String load(String name)
    {
        try
        {
            int line = line(name);
            if(line == -1)
            {
                if(logging)
                    Logger.log("Einstellung \"" + name + "\" nicht vorhanden", 1);
                return "";
            }
            else
            {
                String setting = reader.read(line);
                setting = setting.substring((name + ": \"").length());
                setting = setting.substring(0, setting.length() - 1);
                return setting;
            }
        }
        catch(Exception ex)
        {
            Logger.log("Einstellung \"" + name + "\" konnte nicht geladen werden", 2);
            Logger.error(ex);
            return null;
        }
    }

    /**
     * Gibt die Einstellungen zurück die gleich beginnen.
     *
     * @param name Anfang der Namen
     *
     * @return Einstellungen mit gleich beginnendem Namen
     */
    public static String[] loadNames(String name)
    {
        try
        {
            ArrayList<String> names = new ArrayList<String>();
            String[] file = reader.read();

            for(String s : file)
                if(s.startsWith(name))
                    names.add(s.split(": \"")[0].trim());

            return names.toArray(new String[]
            {
            });
        }
        catch(Exception ex)
        {
            Logger.log("Einstellungen konnten nicht geladen werden", 2);
            Logger.error(ex);
            return null;
        }
    }

    /**
     * Lädt mehrere Einstellungen.
     *
     * @param name Text mit dem die Einstellungen beginnen
     *
     * @return Werte der Einstellungen
     */
    public static String[] loadMulti(String name)
    {
        try
        {
            logging = false;
            ArrayList<String> values = new ArrayList<String>();
            String[] file = reader.read();

            for(String s : file)
                if(s.startsWith(name))
                    values.add(Settings.load(s.split(": \"")[0].trim()));

            logging = true;
            return values.toArray(new String[]
            {
            });
        }
        catch(Exception ex)
        {
            Logger.log("Einstellungen konnten nicht geladen werden", 2);
            Logger.error(ex);
            return null;
        }
    }

    /**
     * Löscht eine Einstellung.
     *
     * @param name Zu löschende Einstellung
     *
     * @return Konnte die Einstellung gelöscht werden?
     */
    public static boolean delete(String name)
    {
        try
        {
            int line = line(name);
            if(line != -1)
            {
                ArrayList<String> content = new ArrayList<String>();
                content.addAll(Arrays.asList(reader.read()));
                content.remove(line);

                writer.write(content.toArray(new String[]
                {
                }));

                if(logging)
                    Logger.log("Einstellung \"" + name + "\" gelöscht", 0);
                return true;
            }
            return false;
        }
        catch(Exception ex)
        {
            Logger.log("Einstellung \"" + name + "\" konnte nicht gelöscht werden", 2);
            Logger.error(ex);
            return false;
        }
    }

    /**
     * Gibt die Zeile einer Einstellung.
     *
     * @param name Zu suchende Einstellung
     *
     * @return Zeile der Einstellung (-1 wenn nicht vorhanden)
     */
    public static int line(String name)
    {
        try
        {
            String[] content = reader.read();
            int line = -1;

            for(int i = 0; i < content.length; i++)
                if(content[i] != null && content[i].startsWith(name))
                {
                    line = i;
                    break;
                }

            return line;
        }
        catch(Exception ex)
        {
            Logger.log("Zeile konnte nicht gefunden werden", 2);
            Logger.error(ex);
            return -1;
        }
    }

    /**
     * Bearbeitet das Logging der Einstellungen-Klasse.
     *
     * @param logging Neuer Logging Wert
     */
    public static void logging(boolean logging)
    {
        try
        {
            Settings.logging = logging;
        }
        catch(Exception ex)
        {
            Logger.log("Logging konnte nicht bearbeitet werden", 2);
            Logger.error(ex);
        }
    }

    /**
     * Sortiert die Datei.
     */
    public static void sort()
    {
        try
        {
            List<String> settings = Arrays.asList(reader.read());
            Collections.sort(settings, String.CASE_INSENSITIVE_ORDER);
            writer.write((String[])settings.toArray());
        }
        catch(Exception ex)
        {
            Logger.log("Settings.ini konnte nicht sortiert werden", 2);
            Logger.error(ex);
        }
    }
}
