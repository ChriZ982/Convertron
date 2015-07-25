package converter.util;

import converter.io.FileIO;
import java.io.IOException;
import java.util.*;
import javax.swing.*;

/**
 * Klasse für das verwalten der Einstellungen.
 */
public class Settings
{
    /**
     * FileIO, der zum Umgang mit der Settings Datei verwendet wird.
     */
    private static FileIO fileHandler;

    /**
     * Lokaler Speicherort
     */
    private static FileIO fileHandlerLocal;

    /**
     * Globaler Speicherort
     */
    private static FileIO fileHandlerGlobal;

    /**
     * Soll das Logging aktiviert werden?.
     */
    private static boolean logging;

    /**
     * Einstellungen, die lokal gespeichert werden. Der Rest wird global gespeichert.
     */
    private static ArrayList<String> local;

    /**
     * Initialisiert die Einstellungen.
     *
     *
     * @throws java.io.IOException
     */
    public static void init() throws IOException
    {

        local = new ArrayList<String>();
        local.add("pathBackup");
        local.add("pathData");
        local.add("pathDests");
        local.add("pathSource");
        local.add("position");
        logging = true;
        fileHandlerLocal = new FileIO("./local.settings");
        fileHandler = fileHandlerLocal;
        fileHandlerGlobal = new FileIO(load("pathData") + "\\global.settings");

        System.out.println(fileHandler.readAllString());

        // Logger.log("\"settings.ini\" wurde geladen", 0);
    }

    /**
     * Speichert eine Einstellung. Falls die Einstellung "" entspricht wird sie gelöscht.
     *
     * @param name    Name der Einstellung
     * @param setting Wert der Einstellung
     *
     * @throws java.io.IOException
     *
     *
     */
    public static void save(String name, String setting) throws IOException
    {
        if(local.contains(name))
            fileHandler = fileHandlerLocal;
        else
            fileHandler = fileHandlerGlobal;
        if(setting.equals(""))
        {
            delete(name);
            return;
        }
        int line = line(name);
        String settings = name + ": \"" + setting + "\"";
        if(line == -1)
            fileHandler.writeLine(fileHandler.lineCount(), settings);
        else
            fileHandler.writeLine(line, settings);
        //if(logging)
        // Logger.log("Einstellung \"" + name + "\" gespeichert", 0);
    }

    /**
     * Lädt eine Einstellung.
     *
     * @param name Name der einstellung
     *
     * @return Wert der Einstellung
     *
     * @throws java.io.IOException
     *
     *
     */
    public static String load(String name) throws IOException
    {
        if(local.contains(name))
            fileHandler = fileHandlerLocal;
        else
            fileHandler = fileHandlerGlobal;
        int line = line(name);
        if(line == -1)
        {
            //if(logging)
            //Logger.log("Einstellung \"" + name + "\" nicht vorhanden", 1);
            return "";
        }
        else
        {
            String setting = fileHandler.readLine(line);
            return setting.substring((name + ": \"").length(), setting.length() - 1);
        }
    }

    /**
     * Speichert eine Einstellung. Es kann eine Komponente übergeben werden, aus der der Wert der Einstellung genommen wird.
     *
     * @param name Name der Einstellung
     * @param comp Komponente die bearbeitet wird
     *
     * @throws java.io.IOException
     *
     *
     */
    public static void save(String name, JComponent comp) throws IOException
    {
        if(local.contains(name))
            fileHandler = fileHandlerLocal;
        else
            fileHandler = fileHandlerGlobal;
        if(comp instanceof JTextField)
            save(name, ((JTextField)comp).getText());
        else if(comp instanceof JCheckBox)
            Settings.save(name, String.valueOf(((JCheckBox)comp).isSelected()));
        else if(comp instanceof JComboBox)
            Settings.save(name, ((JComboBox)comp).getSelectedItem().toString());
    }

    /**
     * Lädt eine Einstellung. Es kann eine Komponente übergeben werden, in die der Wert der Einstellung gespeichert wird.
     *
     * @param name Name der einstellung
     * @param comp Komponente die bearbeitet wird
     *
     * @throws java.io.IOException
     *
     *
     */
    public static void load(String name, JComponent comp) throws IOException
    {
        if(local.contains(name))
            fileHandler = fileHandlerLocal;
        else
            fileHandler = fileHandlerGlobal;
        if(comp instanceof JTextField)
            ((JTextField)comp).setText(load(name));
        else if(comp instanceof JCheckBox)
            ((JCheckBox)comp).setSelected(Boolean.valueOf(Settings.load(name)));
        else if(comp instanceof JComboBox)
            ((JComboBox)comp).setSelectedItem(Settings.load(name));
    }

    /**
     * Speichert mehrere Einstellungen.
     *
     * @param name     Name der Einstellung
     * @param settings Werte der Einstellung
     *
     * @throws java.io.IOException
     *
     *
     */
    public static void saveArray(String name, String[] settings) throws IOException
    {
        if(local.contains(name))
            fileHandler = fileHandlerLocal;
        else
            fileHandler = fileHandlerGlobal;
        if(settings == null || settings.length == 0)
        {
            delete(name);
            return;
        }
        int line = line(name);
        String set = name + ": {";
        for(String s : settings)
            set += "\"" + s + "\",";
        set = set.substring(0, set.length() - 1) + "}";
        if(line == -1)
            fileHandler.writeLine(fileHandler.lineCount(), set);
        else
            fileHandler.writeLine(line, set);
        //if(logging)
        //Logger.log("Einstellung \"" + name + "\" gespeichert", 0);
    }

    /**
     * Lädt mehrere Einstellungen.
     *
     * @param name Name der Einstellung
     *
     * @return Werte der Einstellung
     *
     * @throws java.io.IOException
     *
     *
     */
    public static String[] loadArray(String name) throws IOException
    {
        if(local.contains(name))
            fileHandler = fileHandlerLocal;
        else
            fileHandler = fileHandlerGlobal;
        int line = line(name);
        if(line == -1)
        {
            //if(logging)
            //Logger.log("Einstellung \"" + name + "\" nicht vorhanden", 1);
            return null;
        }
        else
        {
            String setting = fileHandler.readLine(line);
            setting = setting.substring((name + ": {").length(), setting.length() - 2);
            String[] settings = setting.split("\",");
            for(int i = 0; i < settings.length; i++)
                if(!settings[i].equals("\""))
                    settings[i] = settings[i].substring(1);
                else
                    settings[i] = "";
            return settings;
        }
    }

    /**
     * Speichert eine Einstellung auf einem bestimmten Index eines Arrays.
     *
     * @param name    Name der Einstellung
     * @param setting Wert der Einstellung
     * @param i       Index der Einstellung
     *
     * @throws java.io.IOException
     *
     *
     */
    public static void saveArrayIndex(String name, String setting, int i) throws IOException
    {
        if(local.contains(name))
            fileHandler = fileHandlerLocal;
        else
            fileHandler = fileHandlerGlobal;
        if(line(name) == -1)
            return;
        String[] array = loadArray(name);
        String[] settings = array;
        if(array.length <= i)
        {
            settings = new String[i + 1];
            System.arraycopy(array, 0, settings, 0, settings.length);
        }
        settings[i] = setting;
        saveArray(name, settings);

    }

    /**
     * Lädt eine Einstellung aus einem bestimmten Index eines Arrays.
     *
     * @param name Name der einstellung
     * @param i    Index der einstellung
     *
     * @return Wert der Einstellung
     *
     * @throws java.io.IOException
     *
     *
     */
    public static String loadArrayIndex(String name, int i) throws IOException
    {
        if(local.contains(name))
            fileHandler = fileHandlerLocal;
        else
            fileHandler = fileHandlerGlobal;
        return loadArray(name)[i];
    }

    /**
     * Speichert mehrere Einstellungen. Es können mehrere Komponenten übergeben werden, aus der die Werte der Einstellung genommen werden.
     *
     * @param nameAndComp Name und Komponenten für die Einstellung
     *
     * @throws java.io.IOException
     *
     *
     */
    public static void saveArray(Object... nameAndComp) throws IOException
    {
        if(local.contains((String)nameAndComp[0]))
            fileHandler = fileHandlerLocal;
        else
            fileHandler = fileHandlerGlobal;
        String[] settings = new String[nameAndComp.length - 1];
        if(nameAndComp[1] instanceof JTextField)
            for(int i = 1; i < nameAndComp.length; i++)
                settings[i - 1] = ((JTextField)nameAndComp[i]).getText();
        else if(nameAndComp[1] instanceof JTextArea)
            settings = ((JTextArea)nameAndComp[1]).getText().split("\n");
        saveArray((String)nameAndComp[0], settings);
    }

    /**
     * Lädt eine Einstellung. Es können mehrere Komponenten übergeben werden, in die die Werte der Einstellung gespeichert werden.
     *
     * @param nameAndComp Name der Einstellung
     *
     * @throws java.io.IOException
     *
     *
     */
    public static void loadArray(Object... nameAndComp) throws IOException
    {
        if(local.contains((String)nameAndComp[0]))
            fileHandler = fileHandlerLocal;
        else
            fileHandler = fileHandlerGlobal;
        if(nameAndComp[1] instanceof JTextField)
            for(int i = 1; i < nameAndComp.length; i++)
                ((JTextField)nameAndComp[i]).setText(loadArray((String)nameAndComp[0])[i - 1]);
    }

    /**
     * Löscht eine Einstellung.
     *
     * @param name Zu löschende Einstellung
     *
     * @return Konnte die Einstellung gelöscht werden?
     *
     * Fehler
     *
     * @throws java.io.IOException
     */
    public static boolean delete(String name) throws IOException
    {
        if(local.contains(name))
            fileHandler = fileHandlerLocal;
        else
            fileHandler = fileHandlerGlobal;
        int line = line(name);
        if(line == -1)
            return false;

        ArrayList<String> content = new ArrayList<String>();
        content.addAll(Arrays.asList(fileHandler.readAllArray()));
        content.remove(line);
        fileHandler.writeLines(content.toArray(new String[]
        {
        }));
        //if(logging)
        //Logger.log("Einstellung \"" + name + "\" gelöscht", 0);
        return true;
    }

    /**
     * Gibt die Namen der Einstellungen zurück die gleich beginnen.
     *
     * @param name Anfang der Namen
     *
     * @return Einstellungen mit gleich beginnendem Namen
     *
     * @throws java.io.IOException
     *
     *
     */
    public static String[] findNames(String name) throws IOException
    {
        if(local.contains(name))
            fileHandler = fileHandlerLocal;
        else
            fileHandler = fileHandlerGlobal;
        ArrayList<String> names = new ArrayList<String>();
        String[] file = fileHandler.readAllArray();

        for(String s : file)
            if(s.startsWith(name))
                names.add(s.split(":")[0].trim());

        return names.toArray(new String[]
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
     * @throws java.io.IOException
     *
     *
     */
    public static int line(String name) throws IOException
    {
        if(local.contains(name))
            fileHandler = fileHandlerLocal;
        else
            fileHandler = fileHandlerGlobal;
        String[] content = fileHandler.readAllArray();
        int line = -1;
        for(int i = 0; i < content.length; i++)
            if(content[i] != null && content[i].startsWith(name))
            {
                line = i;
                break;
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
     *
     * @throws java.io.IOException
     */
    public static void sort() throws IOException
    {
        List<String> settings = Arrays.asList(fileHandler.readAllArray());
        Collections.sort(settings, String.CASE_INSENSITIVE_ORDER);
        fileHandler.writeLines((String[])settings.toArray());
    }
}
