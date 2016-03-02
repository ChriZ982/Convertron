package eu.convertron.interlib.settings;

import eu.convertron.interlib.io.TextFile;
import eu.convertron.interlib.logging.LogPriority;
import eu.convertron.interlib.logging.Logger;
import java.util.Arrays;

/** Verwaltet die Einstellungen. */
public class Settings
{
    /**
     * Speichert eine Einstellung.
     * Hängt neue Einstellungen an und ersetzt alte.
     * @param settingID    Die Einstellung
     * @param settingValue Wert der Einstellung
     */
    public static void save(SettingID settingID, String settingValue)
    {
        save(settingID.getLocation().getFile(), settingID.getName(), settingValue);
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
            return load(settingID.getLocation().getFile(), settingID.getName());
        }
        else
        {
            String value = load(settingID.getFileWithDefaultValues().getFile(), settingID.getName());
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
        saveArray(settingID.getLocation().getFile(), settingID.getName(), settingValues);
    }

    /**
     * Lädt mehrere Einstellungen. Setzt diese automatisch auf die Standardwerte wenn sie nicht vorhanden sind.
     * Wenn auch keine Standardwerte vorhanden sind, wird <code>null</code> zurückgegeben.
     * @param settingID Die Einstellung
     * @return Werte der Einstellung
     */
    public static String[] loadArray(SettingID settingID)
    {
        if(hasSetting(settingID))
        {
            return loadArray(settingID.getLocation().getFile(), settingID.getName());
        }
        else
        {
            String[] value = loadArray(settingID.getFileWithDefaultValues().getFile(), settingID.getName());
            saveArray(settingID, value);
            return value;
        }
    }

    /**
     * Speichert eine Einstellungen eines Arrays.
     * @param settingID     Die Einstellung
     * @param index         Index der Einstellung
     * @param settingValues Wert der Einstellung
     */
    public static void saveArrayCell(SettingID settingID, int index, String settingValues)
    {
        saveArrayCell(settingID.getLocation().getFile(), settingID.getName(), index, settingValues);
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
     * Speichert eine Einstellung.
     * Hängt neue Einstellungen an und ersetzt alte.
     * @param file         Datei für die Einstellung
     * @param settingName  Name der Einstellung
     * @param settingValue Wert der Einstellung
     */
    public static void save(TextFile file, String settingName, String settingValue)
    {
        String settingLine = settingName + ":" + settingValue;
        if(!file.containsLineStartingWith(getPrefix(settingName)))
            file.appendLines(settingLine);
        else
            file.writeLineStartingWith(getPrefix(settingName), settingLine);

        Logger.logMessage(LogPriority.INFO, "Einstellung " + settingName + " wurde auf den Wert " + settingValue + " gesetzt");
    }

    /**
     * Lädt eine Einstellung.
     * Gibt einen leeren String falls nicht vorhanden.
     * @param file        Datei für die Einstellung
     * @param settingName Name der Einstellung
     * @return Wert der Einstellung
     */
    public static String load(TextFile file, String settingName)
    {
        if(!file.containsLineStartingWith(getPrefix(settingName)))
        {
            Logger.logMessage(LogPriority.INFO, "Einstellung " + settingName + " nicht vorhanden");
            return null;
        }
        String settingLine = file.readLineStartingWith(getPrefix(settingName));
        String settingValue = settingLine.substring((settingName + ":").length());

//        Logger.logMessage(LogPriority.INFO, "Einstellung " + settingName + " wurde mit dem Wert " + settingValue + " geladen");
        return settingValue;
    }

    /**
     * Speichert mehrere Einstellungen.
     * Hängt neue Einstellungen an und ersetzt alte.
     * @param file          Datei für die Einstellung
     * @param settingName   Name der Einstellung
     * @param settingValues Werte der Einstellung
     */
    public static void saveArray(TextFile file, String settingName, String... settingValues)
    {
        String settingLine = settingName + ":" + String.join(";", settingValues);
        if(!file.containsLineStartingWith(getPrefix(settingName)))
            file.appendLines(settingLine);
        else
            file.writeLineStartingWith(getPrefix(settingName), settingLine);

        Logger.logMessage(LogPriority.INFO, "Einstellung " + settingName + " wurde auf die Werte " + Arrays.toString(settingValues) + " gesetzt");
    }

    /**
     * Lädt mehrere Einstellungen.
     * Gibt ein leeres Array falls nicht vorhanden.
     * @param file        Datei für die Einstellung
     * @param settingName Name der Einstellung
     * @return Werte der Einstellung
     */
    public static String[] loadArray(TextFile file, String settingName)
    {
        if(!file.containsLineStartingWith(getPrefix(settingName)))
        {
            Logger.logMessage(LogPriority.INFO, "Einstellung " + settingName + " nicht vorhanden");
            return null;
        }
        String settingLine = file.readLineStartingWith(getPrefix(settingName));
        settingLine = settingLine.substring((settingName + ":").length());
        String[] settingValues = settingLine.split(";");

//        Logger.logMessage(LogPriority.INFO, "Einstellung " + settingName + " wurde mit den Werten " + Arrays.toString(settingValues) + " geladen");
        return settingValues;
    }

    /**
     * Speichert eine Einstellungen eines Arrays.
     * @param file         Datei für die Einstellung
     * @param settingName  Name der Einstellung
     * @param index        Index der Einstellung
     * @param settingValue Wert der Einstellung
     */
    public static void saveArrayCell(TextFile file, String settingName, int index, String settingValue)
    {
        String[] settingArray = Settings.loadArray(file, settingName);

        String extendedArray[] = new String[Math.max(index + 1, settingArray.length)];
        System.arraycopy(settingArray, 0, extendedArray, 0, settingArray.length);

        extendedArray[index] = settingValue;
        Settings.saveArray(file, settingName, extendedArray);
    }

    /**
     * Lädt eine Einstellungen eines Arrays.
     * @param file        Datei für die Einstellung
     * @param settingName Name der Einstellung
     * @param index       Index der Einstellung
     * @return Wert der Einstellung
     */
    public static String loadArrayCell(TextFile file, String settingName, int index)
    {
        String[] settingArray = Settings.loadArray(file, settingName);

        return index < settingArray.length ? settingArray[index] : null;
    }

    /**
     * Gibt die Namen der Einstellungen zurück die gleich beginnen.
     * @param file             Datei für die Einstellung
     * @param settingNameStart Anfang der Namen
     * @return Einstellungen mit gleich beginnendem Namen
     */
    protected static String[] settingNamesStartWith(TextFile file, String settingNameStart)
    {
        String[] fileLines = file.readLinesStartingWith(settingNameStart);
        String[] settingNames = new String[fileLines.length];

        for(int i = 0; i < fileLines.length; i++)
            settingNames[i] = fileLines[i].split(":")[0];

        return settingNames;
    }

    /**
     * Prüft ob die Einstellung gesetzt wurde
     * @param settingID Die zu prüfende Einstellung
     * @return <code>true</code> wenn die Einstellung bereits gesetzt wurde, <code>false</code> wenn nicht
     */
    public static boolean hasSetting(SettingID settingID)
    {
        TextFile file = settingID.getLocation().getFile();

        if(!file.exists())
            file.create();

        return file.containsLineStartingWith(getPrefix(settingID.getName()));
    }

    /**
     * Gibt den Prefix zu dem angegebenen Namen einer Einstellung.
     * @param settingName Name der Einstellung zu dem der Prefix generiert werden soll
     * @return Prefix zu dem angegeben Namen
     */
    private static String getPrefix(String settingName)
    {
        return settingName + ":";
    }
}
