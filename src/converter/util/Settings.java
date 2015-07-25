package converter.util;

import converter.io.FileIO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Klasse für das verwalten der Einstellungen. */
public class Settings
{
    /** Für den Umgang mit der Settings Datei. */
    private static FileIO file;

    /** Einstellungen, die lokal gespeichert werden. Der Rest wird global gespeichert. */
    private static String[] localSettingNames = new String[]
    {
        "pathBackup", "pathData", "pathDests", "pathSource", "position"
    };

    /**
     * Speichert eine Einstellung.
     * @param settingName  Name der Einstellung
     * @param settingValue Wert der Einstellung
     */
    public static void save(String settingName, String settingValue)
    {
        selectCorrectFile(settingName);
        int lineNumber = lineNumberOfSetting(settingName);
        String settingLine = settingName + ":" + settingValue;
        if(lineNumber == -1)
            file.appendLines(settingLine);
        else
            file.writeLine(lineNumber, settingLine);

        Logger.log(Logger.INFO, "Einstellung " + settingName + " wurde auf den Wert " + settingValue + " gesetzt");
    }

    /**
     * Lädt eine Einstellung.
     * @param settingName Name der Einstellung
     * @return Wert der Einstellung
     */
    public static String load(String settingName)
    {
        selectCorrectFile(settingName);
        int line = lineNumberOfSetting(settingName);
        if(line == -1)
        {
            Logger.log(Logger.INFO, "Einstellung " + settingName + " nicht vorhanden");
            return "";
        }
        else
        {
            String settingLine = file.readLine(line);
            String settingValue = settingLine.substring((settingName + ":").length());
            Logger.log(Logger.INFO, "Einstellung " + settingName + " wurde mit dem Wert " + settingValue + " geladen");
            return settingValue;
        }
    }

    /**
     * Speichert mehrere Einstellungen.
     * @param settingName   Name der Einstellung
     * @param settingValues Werte der Einstellung
     */
    public static void saveArray(String settingName, String[] settingValues)
    {
        selectCorrectFile(settingName);
        int line = lineNumberOfSetting(settingName);
        String settingLine = settingName + ":" + String.join(";", settingValues);
        if(line == -1)
            file.appendLines(settingLine);
        else
            file.writeLine(line, settingLine);
        Logger.log(Logger.INFO, "Einstellung " + settingName + " wurde auf die Werte " + Arrays.toString(settingValues) + " gesetzt");
    }

    /**
     * Lädt mehrere Einstellungen.
     * @param settingName Name der Einstellung
     * @return Werte der Einstellung
     */
    public static String[] loadArray(String settingName)
    {
        selectCorrectFile(settingName);
        int line = lineNumberOfSetting(settingName);
        if(line == -1)
        {
            Logger.log(Logger.INFO, "Einstellung " + settingName + " nicht vorhanden");
            return new String[0];
        }
        else
        {
            String settingLine = file.readLine(line);
            settingLine = settingLine.substring((settingName + ":").length());
            String[] settingValues = settingLine.split(";");
            Logger.log(Logger.INFO, "Einstellung " + settingName + " wurde mit den Werten " + Arrays.toString(settingValues) + " geladen");
            return settingValues;
        }
    }

    /**
     * Löscht eine Einstellung.
     * @param settingName Name der einstellung
     * @return Konnte die Einstellung gelöscht werden?
     */
    public static boolean delete(String settingName)
    {
        selectCorrectFile(settingName);
        int line = lineNumberOfSetting(settingName);
        if(line == -1)
            return false;

        List<String> fileLines = Arrays.asList(file.readAllArray());
        fileLines.remove(line);
        file.writeLines(fileLines.toArray(new String[0]));
        Logger.log(Logger.INFO, "Einstellung " + settingName + " wurde gelöscht");
        return true;
    }

    /**
     * Gibt die Namen der Einstellungen zurück die gleich beginnen.
     *
     * @param settingNameStart Anfang der Namen
     * @return Einstellungen mit gleich beginnendem Namen
     */
    public static String[] settingNamesStartWith(String settingNameStart)
    {
        selectCorrectFile(settingNameStart);
        ArrayList<String> settingNames = new ArrayList<String>();
        String[] fileLines = file.readAllArray();
        for(String settingLine : fileLines)
            if(settingLine.startsWith(settingNameStart))
                settingNames.add(settingLine.split(":")[0]);
        return settingNames.toArray(new String[0]);
    }

    /**
     * Wählt die globale oder lokale Datei als Speicherort.
     * @param settingName Name der Einstellung
     */
    private static void selectCorrectFile(String settingName)
    {
        file = new FileIO("./local.settings");
        if(!Arrays.asList(localSettingNames).contains(settingName))
            file = new FileIO(load("pathData") + "/global.settings");
    }

    /**
     * Gibt die Zeilennummer einer Einstellung.
     * @param settingName Name der Einstellung
     * @return Zeilennummer der Einstellung (-1 wenn nicht vorhanden)
     */
    private static int lineNumberOfSetting(String settingName)
    {
        String[] fileLines = file.readAllArray();
        for(int i = 0; i < fileLines.length; i++)
            if(fileLines[i].startsWith(settingName + ":"))
                return i;
        return -1;
    }

// ========================== ??? Y.A.G.N.I. ??? ==========================
//    /**
//     * Speichert eine Einstellung auf einem bestimmten Index eines Arrays.
//     * @param name    Name der Einstellung
//     * @param setting Wert der Einstellung
//     * @param i       Index der Einstellung
//     */
//    public static void saveArrayIndex(String name, String setting, int i)
//    {
//        if(localSettingNames.contains(name))
//            file = localFile;
//        else
//            file = globalFile;
//        if(lineNumberOfSetting(name) == -1)
//            return;
//        String[] array = loadArray(name);
//        String[] settings = array;
//        if(array.length <= i)
//        {
//            settings = new String[i + 1];
//            System.arraycopy(array, 0, settings, 0, settings.length);
//        }
//        settings[i] = setting;
//        saveArray(name, settings);
//    }
//
//    /**
//     * Lädt eine Einstellung aus einem bestimmten Index eines Arrays.
//     * @param name Name der einstellung
//     * @param i    Index der einstellung
//     * @return Wert der Einstellung
//     */
//    public static String loadArrayIndex(String name, int i)
//    {
//        return loadArray(name)[i];
//    }
}
