package eu.convertron.applib.settings;

import eu.convertron.interlib.config.IniConfigFile;
import eu.convertron.interlib.io.TextFile;
import eu.convertron.interlib.logging.LogPriority;
import eu.convertron.interlib.logging.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashMap;

/** Verwaltet die Einstellungen. */
public class Settings
{
    public final static String SETTING_FILE = "./local.settings";
    public final static String TEMP_SETTING_FILE = "./.tempsettings";

    private static boolean autoFlush;
    private final static MapStorage storage;

    static
    {
        HashMap<String, String> map = load();

        String useTempFile = "settings.useTempFile";
        String aF = "settings.autoFlush";

        if(!map.containsKey(useTempFile))
            map.put(useTempFile, "true");

        if(!map.containsKey(aF))
            map.put(aF, "true");

        if("true".equalsIgnoreCase(map.get(useTempFile)))
            storage = new FileMapStorage();
        else
            storage = new MemoryMapStorage();

        autoFlush = "true".equalsIgnoreCase(map.get(aF));
        storage.setMap(map);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> onShutdown()));
    }

    private static HashMap<String, String> load()
    {
        TextFile file = new TextFile(SETTING_FILE);
        try
        {
            if(file.exists())
                return IniConfigFile.deserialize(file.readAllToString());
        }
        catch(Exception ex)
        {
            Logger.logError(LogPriority.ERROR, "Fehler beim Laden der Einstellungen, Standardwerte werden benutzt", ex);
        }
        return new HashMap<>();
    }

    private static void onShutdown()
    {
        try
        {
            Settings.flush();
            Files.deleteIfExists(new File(TEMP_SETTING_FILE).toPath());
        }
        catch(Exception ex)
        {
        }
    }

    /**
     * Speichert eine Einstellung.
     * Hängt neue Einstellungen an und ersetzt alte.
     * @param settingID    Die Einstellung
     * @param settingValue Wert der Einstellung
     */
    public static void save(SettingID settingID, String settingValue)
    {
        save(settingID.getName(), settingValue);
    }

    /**
     * Lädt eine Einstellung. Setzt diese automatisch auf den Standardwert wenn sie nicht vorhanden ist.
     * Wenn auch keine Standardwert vorhanden ist, wird <code>null</code> zurückgegeben.
     * @param settingID Die Einstellung
     * @return Wert der Einstellung
     */
    public static String load(SettingID settingID)
    {
        if(hasSetting(settingID))
        {
            return load(settingID.getName());
        }
        else
        {
            String value = settingID.getDefaultValue();
            save(settingID, value);
            return value;
        }
    }

    /**
     * Speichert mehrere Einstellungen.
     * Hängt neue Einstellungen an und ersetzt alte.
     * @param settingID     Die Einstellung
     * @param settingValues Werte der Einstellung
     */
    public static void saveArray(SettingID settingID, String... settingValues)
    {
        saveArray(settingID.getName(), settingValues);
    }

    /**
     * Lädt mehrere Einstellungen. Setzt diese automatisch auf die Standardwerte wenn sie nicht vorhanden sind.
     * Wenn auch keine Standardwerte vorhanden sind, wird <code>null</code> zurückgegeben.
     * @param settingID Die Einstellung
     * @return Werte der Einstellung
     */
    public static String[] loadArray(SettingID settingID)
    {
        String value = load(settingID);
        if(value == null)
            return null;
        return value.split(";");
    }

    /**
     * Speichert eine Einstellungen eines Arrays.
     * @param settingID     Die Einstellung
     * @param index         Index der Einstellung
     * @param settingValues Wert der Einstellung
     */
    public static void saveArrayCell(SettingID settingID, int index, String settingValues)
    {
        saveArrayCell(settingID.getName(), index, settingValues);
    }

    /**
     * Lädt eine Einstellungen eines Arrays.
     * @param settingID Die Einstellung
     * @param index     Index der Einstellung
     * @return Wert der Einstellung
     */
    public static String loadArrayCell(SettingID settingID, int index)
    {
        String[] settingArray = loadArray(settingID);

        return index < settingArray.length ? settingArray[index] : null;
    }

    /**
     * Speichert mehrere Einstellungen.
     * Hängt neue Einstellungen an und ersetzt alte.
     * @param settingName   Name der Einstellung
     * @param settingValues Werte der Einstellung
     */
    public static void saveArray(String settingName, String... settingValues)
    {
        for(String v : settingValues)
        {
            if(v.contains(";"))
                throw new IllegalArgumentException("The values in the array that should be saved cannot contain a ';'");
        }

        save(settingName, String.join(";", settingValues));
        Logger.logMessage(LogPriority.INFO, "Einstellung " + settingName + " wurde auf die Werte " + Arrays.toString(settingValues) + " gesetzt");
    }

    /**
     * Lädt mehrere Einstellungen.
     * Gibt ein leeres Array falls nicht vorhanden.
     * @param settingName Name der Einstellung
     * @return Werte der Einstellung
     */
    public static String[] loadArray(String settingName)
    {
        String value = load(settingName);
        if(value == null)
            return null;

//        Logger.logMessage(LogPriority.INFO, "Einstellung " + settingName + " wurde mit den Werten " + Arrays.toString(settingValues) + " geladen");
        return value.split(";");
    }

    /**
     * Speichert eine Einstellungen eines Arrays.
     * @param settingName  Name der Einstellung
     * @param index        Index der Einstellung
     * @param settingValue Wert der Einstellung
     */
    public static void saveArrayCell(String settingName, int index, String settingValue)
    {
        String[] settingArray = loadArray(settingName);

        String extendedArray[] = new String[Math.max(index + 1, settingArray.length)];
        System.arraycopy(settingArray, 0, extendedArray, 0, settingArray.length);

        extendedArray[index] = settingValue;
        saveArray(settingName, extendedArray);
    }

    /**
     * Lädt eine Einstellungen eines Arrays.
     * @param settingName Name der Einstellung
     * @param index       Index der Einstellung
     * @return Wert der Einstellung
     */
    public static String loadArrayCell(String settingName, int index)
    {
        String[] settingArray = Settings.loadArray(settingName);
        if(settingArray == null)
            return null;

        return index < settingArray.length ? settingArray[index] : null;
    }

    /**
     * Speichert eine Einstellung.
     * Hängt neue Einstellungen an und ersetzt alte.
     * @param settingName  Name der Einstellung
     * @param settingValue Wert der Einstellung
     */
    public static void save(String settingName, String settingValue)
    {
        HashMap<String, String> map = storage.getMap();
        map.put(settingName, settingValue);
        storage.setMap(map);
        if(autoFlush)
            flush(map);
        Logger.logMessage(LogPriority.INFO, "Einstellung " + settingName + " wurde auf den Wert " + settingValue + " gesetzt");
    }

    /**
     * Lädt eine Einstellung.
     * Gibt einen leeren String falls nicht vorhanden.
     * @param settingName Name der Einstellung
     * @return Wert der Einstellung
     */
    public static String load(String settingName)
    {
        HashMap<String, String> map = storage.getMap();
        if(!map.containsKey(settingName))
        {
            Logger.logMessage(LogPriority.INFO, "Einstellung " + settingName + " nicht vorhanden");
            return null;
        }

//        Logger.logMessage(LogPriority.INFO, "Einstellung " + settingName + " wurde mit dem Wert " + settingValue + " geladen");
        return map.get(settingName);
    }

    /**
     * Prüft ob die Einstellung gesetzt wurde
     * @param settingID Die zu prüfende Einstellung
     * @return <code>true</code> wenn die Einstellung bereits gesetzt wurde, <code>false</code> wenn nicht
     */
    public static boolean hasSetting(SettingID settingID)
    {
        return storage.getMap().containsKey(settingID.getName());
    }

    /**
     * Schreibt die Einstellungen in die Einstellungsdatei.
     */
    public static void flush()
    {
        flush(storage.getMap());
    }

    private static void flush(HashMap<String, String> map)
    {
        TextFile file = new TextFile(SETTING_FILE);
        file.writeText(IniConfigFile.serialize(map));
    }

    /**
     * Gibt an ob beim Setzen der Einstellungen automatisch auch in die Einstellungsdatei geschrieben werden soll.
     * @return
     */
    public static boolean isAutoFlush()
    {
        return autoFlush;
    }

    /**
     * Setzt das Verhalten beim speichern von Einstellungen.
     * @param autoFlush Soll automatisch auch in die Einstellungsdatei geschrieben werden?
     */
    public static void setAutoFlush(boolean autoFlush)
    {
        Settings.autoFlush = autoFlush;
        save("settings.autoFlush", String.valueOf(autoFlush));
    }

    private static interface MapStorage
    {
        void setMap(HashMap<String, String> map);

        HashMap<String, String> getMap();
    }

    private static class MemoryMapStorage implements MapStorage
    {
        private HashMap<String, String> map;

        @Override
        public HashMap<String, String> getMap()
        {
            return map;
        }

        @Override
        public void setMap(HashMap<String, String> map)
        {
            this.map = map;
        }
    }

    private static class FileMapStorage implements MapStorage
    {
        @Override
        public void setMap(HashMap<String, String> map)
        {
            try
            {
                FileOutputStream s = new FileOutputStream(TEMP_SETTING_FILE);
                ObjectOutputStream out = new ObjectOutputStream(s);
                out.writeObject(map);
                out.close();
                s.close();
            }
            catch(Exception ex)
            {
                Logger.logMessage(LogPriority.ERROR, "Fehler beim Speichern der Einstellungen");
                throw new RuntimeException("Failed to load Setting", ex);
            }
        }

        @SuppressWarnings("unchecked")
        @Override
        public HashMap<String, String> getMap()
        {
            try
            {
                FileInputStream s = new FileInputStream(TEMP_SETTING_FILE);
                ObjectInputStream in = new ObjectInputStream(s);
                Object o = in.readObject();
                in.close();
                s.close();
                return (HashMap<String, String>)o;
            }
            catch(Exception ex)
            {
                Logger.logMessage(LogPriority.ERROR, "Fehler beim Laden der Einstellungen");
                throw new RuntimeException("Failed to load Setting", ex);
            }
        }
    }

    private Settings()
    {
    }
}
