package com.facharbeit.io;

import com.facharbeit.tools.Logger;
import java.util.*;

/**
 * Klasse für das verwalten der Einstellungen.
 */
public class Settings
{
    /**
     * FileHandler, der zum Umgang mit der Settings Datei verwendet wird.
     */
    private static FileHandler fileHandler;

    /**
     * Soll das Logging aktiviert werden?.
     */
    private static boolean logging;

    /**
     * Initialisiert die Einstellungen.
     *
     * @throws java.lang.Exception Fehler
     */
    public static void init() throws Exception
    {
        logging = true;
        fileHandler = new FileHandler("Data/settings.ini");
        Logger.log("\"settings.ini\" wurde geladen", 0);
    }

    /**
     * Speichert eine Einstellung. Falls die Einstellung "" entspricht wird sie gelöscht.
     *
     * @param name    Name der Einstellung
     * @param setting Wert der Einstellung
     *
     * @throws java.lang.Exception Fehler
     */
    public static void save(String name, String setting) throws Exception
    {
        if(setting.equals(""))
        {
            delete(name);
            return;
        }
        int line = line(name);
        String settings = name + ": \"" + setting + "\"";
        if(line == -1)
            fileHandler.write(fileHandler.length(), settings);
        else
            fileHandler.write(line, settings);
        if(logging)
            Logger.log("Einstellung \"" + name + "\" gespeichert", 0);
    }

    /**
     * Lädt eine Einstellung.
     *
     * @param name Name der einstellung
     *
     * @return Wert der Einstellung
     *
     * @throws java.lang.Exception Fehler
     */
    public static String load(String name) throws Exception
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
            String setting = fileHandler.read(line);
            setting = setting.substring((name + ": \"").length());
            setting = setting.substring(0, setting.length() - 1);
            return setting;
        }
    }

    /**
     * Löscht eine Einstellung.
     *
     * @param name Zu löschende Einstellung
     *
     * @return Konnte die Einstellung gelöscht werden?
     *
     * @throws java.lang.Exception Fehler Fehler
     */
    public static boolean delete(String name) throws Exception
    {
        int line = line(name);
        if(line == -1)
            return false;

        ArrayList<String> content = new ArrayList<String>();
        content.addAll(Arrays.asList(fileHandler.read()));
        content.remove(line);
        fileHandler.write(content.toArray(new String[]
        {
        }));
        if(logging)
            Logger.log("Einstellung \"" + name + "\" gelöscht", 0);
        return true;
    }

    /**
     * Gibt die Einstellungen zurück die gleich beginnen.
     *
     * @param name Anfang der Namen
     *
     * @return Einstellungen mit gleich beginnendem Namen
     *
     * @throws java.lang.Exception Fehler
     */
    public static String[] loadNames(String name) throws Exception
    {
        ArrayList<String> names = new ArrayList<String>();
        String[] file = fileHandler.read();

        for(String s : file)
            if(s.startsWith(name))
                names.add(s.split(": \"")[0].trim());

        return names.toArray(new String[]
        {
        });
    }

    /**
     * Lädt mehrere Einstellungen.
     *
     * @param name Text mit dem die Einstellungen beginnen
     *
     * @return Werte der Einstellungen
     *
     * @throws java.lang.Exception Fehler
     */
    public static String[] loadMulti(String name) throws Exception
    {
        logging = false;
        ArrayList<String> values = new ArrayList<String>();
        String[] file = fileHandler.read();

        for(String s : file)
            if(s.startsWith(name))
                values.add(Settings.load(s.split(": \"")[0].trim()));

        logging = true;
        return values.toArray(new String[]
        {
        });
    }

    /**
     * Gibt die Zeile einer Einstellung.
     *
     * @param name Zu suchende Einstellung
     *
     * @return Zeile der Einstellung (-1 wenn nicht vorhanden)
     *
     * @throws java.lang.Exception Fehler
     */
    public static int line(String name) throws Exception
    {
        String[] content = fileHandler.read();
        int line = -1;
        for(int i = 0; i < content.length; i++)
        {
            if(content[i] != null && content[i].startsWith(name))
            {
                line = i;
                break;
            }
        }
        return line;
    }

    /**
     * Bearbeitet das Logging der Einstellungen-Klasse.
     *
     * @param logging Neuer Logging Wert
     */
    public static void enable(boolean logging)
    {
        Settings.logging = logging;
    }

    /**
     * Sortiert die Datei.
     *
     * @throws java.lang.Exception Fehler
     */
    public static void sort() throws Exception
    {
        List<String> settings = Arrays.asList(fileHandler.read());
        Collections.sort(settings, String.CASE_INSENSITIVE_ORDER);
        fileHandler.write((String[])settings.toArray());
    }
}
