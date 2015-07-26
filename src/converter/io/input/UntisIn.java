package converter.io.input;

import converter.data.Class;
import converter.data.Lesson;
import converter.io.FileIO;
import converter.io.FolderIO;
import converter.unused.PathConverter;
import converter.util.Settings;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Liest die HTML-Dateien für einzelne Klassen aus.
 */
public class UntisIn
{
    /**
     * Erste Stufe
     */
    public static final int firstGrade = 5;

    /**
     * Letzte Stufe
     */
    public static final int lastGrade = 9;

    /**
     * Zusätzliche Stufen, die es gibt.
     */
    public static final String[] extraGrades =
    {
        "EF", "Q1", "Q2", "___"
    };

    /**
     * Name der SQL-Spalten die ausgelesen werden. Editieren, falls andere Namen. Reihenfolge:
     * Stufe, Datum, Wochentag, Vertreter, Raum, Art, Fach, Lehrer, Verl. von, Hinweise
     */
    public static final String[] sqlColumms =
    {
        "Stufe", "Datum", "Vertreter", "Raum", "Vertretungsart", "Fach", "Lehrer", "Verl. von", "Hinweise"
    };

    /**
     * Liest die heutigen Vertretungen ein.
     *
     * @return Ein Array mit Schulklassen in denen die jeweiligen Vertretungen gespeichert sind
     *
     * @throws java.lang.reflect.InvocationTargetException
     * @throws java.lang.IllegalAccessException
     * @throws java.io.IOException
     *
     *
     */
//    public static converter.data.Class[] today() throws Exception
//    {
//        converter.data.Class[] schoolClasses;
//        if(Settings.load("sqlUse").equals("true") && SqlMode.READ.isActive())
//           schoolClasses = getAllSql();
//        else
//            schoolClasses = getAllHtml(PathConverter.convert(Settings.load("pathData") + "/Source/"));
//
//        boolean found = false;
//        String date = Time.htmlReading(0);
//        for(converter.data.Class schoolClass : schoolClasses)
//        {
//            if(schoolClass.containsEntrysOfDate(date))
//                found = true;
//
//            schoolClass.onlyDate(Time.htmlReading(0));
//        }
//        if(found)
//            return schoolClasses;
//        return null;
//    }
    /**
     * Liest die morgigen Vertretungen ein.
     *
     * @return Ein Array mit Schulklassen in denen die jeweiligen Vertretungen gespeichert sind
     *
     * @throws java.lang.IllegalAccessException
     * @throws java.lang.reflect.InvocationTargetException
     * @throws java.io.IOException
     *
     *
     */
//    public static converter.data.Class[] tomorrow() throws Exception
//    {
//        converter.data.Class[] schoolClasses;
//        if(Settings.load("sqlUse").equals("true") && SqlMode.READ.isActive())
//          schoolClasses = getAllSql();
//        else
//            schoolClasses = getAllHtml(PathConverter.convert(Settings.load("pathData") + "/Source/"));
//
//        boolean found = false;
//        int i = 0;
//        while(i < 10 && !found)
//        {
//            i++;
//            for(converter.data.Class schoolClass : schoolClasses)
//                if(schoolClass.containsEntrysOfDate(Time.htmlReading(i)))
//                    found = true;
//        }
//        if(found)
//        {
//            for(converter.data.Class schoolClass : schoolClasses)
//                schoolClass.onlyDate(Time.htmlReading(i));
//            return schoolClasses;
//        }
//        return null;
//    }
    /**
     * Liest die Vertretungen für die SQL-Verwendung ein.
     *
     * @return Ein Array mit Schulklassen in denen die jeweiligen Vertretungen gespeichert sind
     *
     * @throws java.lang.reflect.InvocationTargetException
     * @throws java.lang.IllegalAccessException
     * @throws java.io.IOException
     *
     *
     */
    public static converter.data.Class[] forSql() throws InvocationTargetException, IllegalAccessException, IOException
    {
        return sort(getAllHtml(PathConverter.convert(Settings.load("pathData") + "/Source/")));
    }

    /**
     * Liest alle Quelldateien aus.
     *
     * @param path Pfad zu den Dateien
     *
     * @return Ein Array in denen alle in den Quelldateien vorhandenen Vertretungen gespeichert sind (alle Tage)
     *
     * @throws java.io.IOException
     *
     *
     */
    public static converter.data.Class[] getAllHtml(String path) throws IOException
    {
        if(new FolderIO(path).isEmpty())
            return new converter.data.Class[]
            {
            };

        File[] files = getFiles(path);
        converter.data.Class[] classes = new converter.data.Class[files.length];

        initalizeClasses(classes, files);

        for(Class currClass : classes)
        {
            String[][] table = convertToTable(new FileIO(path).readAllString());
            String[] colummNames = table[0];

            for(int i = 1; i < table.length; i++)
            {
                String[] currRow = table[i];

                HashMap<String, String> data = new HashMap<>();

                for(int j = 0; j < currRow.length; j++)
                {
                    data.put(colummNames[j], currRow[j]);
                }

                //TODO: Class erkennt selbst ob lesson valid ist
                Lesson lesson = new Lesson(data);
                if(lesson.isValid())
                    currClass.addLesson(new Lesson(data));
                else
                    currClass.appendLesson(new Lesson(data));
            }
        }
        return classes;
    }

    /**
     * Gibt den genauen HTML-Tag zurück
     *
     * @param source Der String in dem nach HTML-Tags gesucht werden soll
     * @param toFind Den HTML-Tag der gefunden werden soll.
     *
     * @return Den genauen HTML-Tag;
     *         Bsp: findHtmlTag("blabla&lt;font color="black"&gt;blabla", "font") gibt "&lt;font color="black"&gt;" züruck
     */
    private static String findHtmlTag(String source, String toFind)
    {
        if(!source.contains("<" + toFind) || !source.contains(">"))
            return ">";
        source = source.substring(source.indexOf("<" + toFind));
        source = source.substring(0, source.indexOf(">") + 1);
        return source;
    }

    /**
     * Schneidet die Tabelle mit den Vertretungen aus.
     *
     * @param source Der String in dem die Tabelle gefunden werden soll (normalerweise eine Quelldatei als String)
     *
     * @return Die Tabelle mit den Vertretungen (Anfang: "&lt;table&gt;"; Ende: "&lt;/table&gt;")
     */
    private static String getTable(String source)
    {
        source = source.substring(source.indexOf("<TABLE border=\"3\" rules=\"all\" bgcolor=\"#E7E7E7\" cellpadding=\"1\" cellspacing=\"1\">"));
        source = source.substring(0, source.indexOf(findHtmlTag(source, "/TABLE")) + findHtmlTag(source, "/TABLE").length());
        return source;
    }

    private static void initalizeClasses(converter.data.Class[] classes, File[] files)
    {
        for(int i = 0; i < classes.length; i++)
        {
            String filename = files[i].getName();
            String[] prefix = Settings.loadArray("fileName");
            classes[i] = new converter.data.Class(filename.substring(prefix[0].length(), filename.indexOf(prefix[1])));
        }
    }

    private static String[][] convertToTable(String rawFile)
    {
        ArrayList<String[]> rows = new ArrayList<>();

        rawFile = getTable(rawFile);

        while(rawFile.contains("<TR>"))
        {
            rawFile = rawFile.substring(rawFile.indexOf(findHtmlTag(rawFile, "TR")) + 4);
            rows.add(readRow(rawFile.substring(0, rawFile.indexOf(findHtmlTag(rawFile, "/TR")))));
        }

        return rows.toArray(new String[0][]);
    }

    private static String[] readRow(String rawRow)
    {
        ArrayList<String> columms = new ArrayList<>();
        while(rawRow.indexOf(findHtmlTag(rawRow, "TD")) < rawRow.indexOf(findHtmlTag(rawRow, "TR")))
        {
            rawRow = rawRow.substring(rawRow.indexOf(findHtmlTag(rawRow, "TD")) + findHtmlTag(rawRow, "TD").length());
            columms.add(readEntry(rawRow.substring(0, rawRow.indexOf(findHtmlTag(rawRow, "/TD")))));
        }
        return columms.toArray(new String[0]);
    }

    /**
     * Gibt die nächste Zelle der Tabelle soruce zurück
     *
     * @param source Die bis dahin noch übriggebliebene Tabelle
     *
     * @return Die nächste Zelle der Tabelle
     */
    private static String readEntry(String source)
    {
        if(source.contains("<font"))
            source = source.substring(source.indexOf(findHtmlTag(source, "font")) + findHtmlTag(source, "font").length());

        if(source.contains("</font"))
            source = source.substring(1, source.indexOf(findHtmlTag(source, "/font")) - 1);

        while(source.startsWith(" ") || source.startsWith("\n"))
            source = source.substring(1);

        while(source.endsWith(" ") || source.endsWith("\n"))
            source = source.substring(0, source.length() - 1);

        return source;
    }

    /**
     * Sortiert das Schulklassen-Array.
     *
     * @param schoolClasses Zu sortierendes Array
     *
     * @return Sortiertes Array
     *
     *
     */
    public static converter.data.Class[] sort(converter.data.Class[] schoolClasses)
    {
        if(schoolClasses == null)
            return null;
        for(converter.data.Class schoolClass : schoolClasses)
        {
            ArrayList<Lesson> out = new ArrayList<>();
            while(schoolClass.getEntries().size() > 0)
            {
                double lowestLesson = Double.MAX_VALUE;
                Lesson lowestEntry = schoolClass.getEntries().get(0);
                for(Lesson entry : schoolClass.getEntries())
                {
                    double thisLesson = entry.getLesson() + 0.0;
                    if(entry.isDoubleLesson())
                        thisLesson += 0.5;

                    if(thisLesson < lowestLesson)
                    {
                        lowestLesson = thisLesson;
                        lowestEntry = entry;
                    }
                }
                schoolClass.getEntries().remove(lowestEntry);
                out.add(lowestEntry);

            }
            schoolClass.setEntries(out);
        }
        return schoolClasses;
    }

    /**
     * Gibt die Quelldateien zurück.
     *
     * @param path Pfad in dem die Dateien liegen
     *
     * @return Liste der Dateien
     */
    private static File[] getFiles(String path) throws IOException
    {
        while(path.endsWith("\\"))
            path = path.substring(0, path.length() - 1);
        if(!path.endsWith("/"))
            path += "/";

        String[] prefix = Settings.loadArray("fileName");
        ArrayList<File> files = new ArrayList<>();
        File file;
        for(int grade = firstGrade; grade <= lastGrade; grade++)
            for(int c = 97; c <= 122; c++)
            {
                String g = String.valueOf(grade) + "" + (char)c;
                while(g.length() < 3)
                    g = "0" + g;

                file = new File(path, prefix[0] + g + prefix[1]);

                if(file.exists())
                    files.add(file);
            }
        for(String g : extraGrades)
        {
            file = new File(path, prefix[0] + g + prefix[1]);
            if(file.exists())
                files.add(file);
        }
        return files.toArray(new File[0]);
    }

    /**
     * Liest die Vertretungen aus einer Datenbank.
     *
     * @return alle Schulklassen
     */
//    private static converter.data.Class[] getAllSql() throws Exception
//    {
//        String[] settings = Settings.loadArray("sql");
//        ArrayList< converter.data.Class> asList = new ArrayList<>();
//        SqlTableReader read = new SqlTableReader(PathConverter.convert(settings[0]),
//                                                 Integer.parseInt(settings[1]),
//                                                 PathConverter.convert(settings[2]),
//                                                 settings[4],
//                                                 settings[5],
//                                                 PathConverter.convert(settings[3]),
//                                                 sqlColumms);
//
//        ArrayList<String[]> readIn = read.readAll();
//        for(String[] asArray : readIn)
//        {
//            Map<String, String> forEntry = new HashMap<>();
//            for(int i = 0; i < asArray.lineCount; i++)
//                forEntry.put(sqlColumms[i], asArray[i]);
//
//            boolean added = false;
//            for(converter.data.Class sc : asList)
//                if(sc.getName().equals(forEntry.get("Stufe")))
//                {
//                    sc.getEntries().add(new Lesson(forEntry));
//                    added = true;
//                }
//            if(!added)
//            {
//                converter.data.Class sc = new converter.data.Class(forEntry.get("Stufe"));
//                sc.getEntries().add(new Lesson(forEntry));
//                asList.add(sc);
//            }
//        }
//        return (converter.data.Class[])asList.toArray();
//    }
}
