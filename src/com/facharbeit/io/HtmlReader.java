package com.facharbeit.io;

import com.facharbeit.sql.SqlMode;
import com.facharbeit.sql.SqlTableReader;
import com.facharbeit.tools.*;
import java.io.*;
import java.util.*;

/**
 * Liest die HTML-Dateien für einzelne Klassen aus.
 */
public class HtmlReader
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
     * @throws java.lang.Exception Fehler
     */
    public static SchoolClass[] today() throws Exception
    {
        SchoolClass[] schoolClasses;
        if(Settings.load("sqlUse").equals("true") && SqlMode.READ.isActive())
            schoolClasses = getAllSql();
        else
            schoolClasses = getAllHtml(PathConverter.convert(Settings.load("pathData") + "/Source/"));

        boolean found = false;
        String date = Time.htmlReading(0);
        for(SchoolClass schoolClass : schoolClasses)
        {
            if(schoolClass.containsEntrysOfDate(date))
                found = true;

            schoolClass.onlyDate(Time.htmlReading(0));
        }
        if(found)
            return schoolClasses;
        return null;
    }

    /**
     * Liest die morgigen Vertretungen ein.
     *
     * @return Ein Array mit Schulklassen in denen die jeweiligen Vertretungen gespeichert sind
     *
     * @throws java.lang.Exception Fehler
     */
    public static SchoolClass[] tomorrow() throws Exception
    {
        SchoolClass[] schoolClasses;
        if(Settings.load("sqlUse").equals("true") && SqlMode.READ.isActive())
            schoolClasses = getAllSql();
        else
            schoolClasses = getAllHtml(PathConverter.convert(Settings.load("pathData") + "/Source/"));

        boolean found = false;
        int i = 0;
        while(i < 10 && !found)
        {
            i++;
            for(SchoolClass schoolClass : schoolClasses)
                if(schoolClass.containsEntrysOfDate(Time.htmlReading(i)))
                    found = true;
        }
        if(found)
        {
            for(SchoolClass schoolClass : schoolClasses)
                schoolClass.onlyDate(Time.htmlReading(i));
            return schoolClasses;
        }
        return null;
    }

    /**
     * Liest die Vertretungen für die SQL-Verwendung ein.
     *
     * @return Ein Array mit Schulklassen in denen die jeweiligen Vertretungen gespeichert sind
     *
     * @throws java.lang.Exception Fehler
     */
    public static SchoolClass[] forSql() throws Exception
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
     * @throws java.lang.Exception Fehler
     */
    public static SchoolClass[] getAllHtml(String path) throws Exception
    {
        if(new FolderHandler(path).isEmpty())
            return new SchoolClass[]
            {
            };

        ArrayList<File> files = getFiles(path);
        SchoolClass[] schoolClasses = new SchoolClass[files.size()];

        for(int i = 0; i < schoolClasses.length; i++)
        {
            String filename = files.get(i).getName();
            String[] prefix = Settings.loadArray("fileName");
            schoolClasses[i] = new SchoolClass(filename.substring(prefix[0].length(), filename.indexOf(prefix[1])));
            if(schoolClasses[i].isEmpty())
                schoolClasses[i].setEntries(new ArrayList<Entry>());

            String asString = getTable(new FileHandler(files.get(i)).asString());
            asString = asString.substring(asString.indexOf(findHtmlTag(asString, "TR")) + findHtmlTag(asString, "TR").length());

            ArrayList<String> head = new ArrayList<>();
            while(asString.indexOf(findHtmlTag(asString, "TD")) < asString.indexOf(findHtmlTag(asString, "TR")))
            {
                asString = asString.substring(asString.indexOf(findHtmlTag(asString, "TD")) + findHtmlTag(asString, "TD").length());
                head.add(readEntry(asString.substring(0, asString.indexOf(findHtmlTag(asString, "/TD")))));
            }

            while(true)
            {
                asString = asString.substring(asString.indexOf(findHtmlTag(asString, "TR")) + 4);
                HashMap<String, String> entries = new HashMap<>();

                for(String head1 : head)
                {
                    asString = asString.substring(asString.indexOf(findHtmlTag(asString, "TD")) + findHtmlTag(asString, "TD").length());
                    entries.put(head1, readEntry(asString.substring(0, asString.indexOf(findHtmlTag(asString, "/TD")))));
                }

                boolean valid = true;
                if(entries.containsKey("Std"))
                    if(!validateAsNumber(entries.get("Std"), '-', ' '))
                        valid = false;
                if(entries.containsKey("Datum"))
                    if(!validateAsNumber(entries.get("Datum"), '.'))
                        valid = false;
                if(valid)
                    schoolClasses[i].getEntries().add(new Entry(entries));
                else
                {
                    Entry e = schoolClasses[i].getEntries().get(schoolClasses[i].getEntries().size() - 1);
                    for(String key : entries.keySet())
                        if(e.getContent().containsKey(key))
                            e.getContent().put(key, e.getContent().get(key) + " " + entries.get(key));
                        else
                            e.getContent().put(key, entries.get(key));
                }
                asString = asString.substring(asString.indexOf(findHtmlTag(asString, "/TD")) + findHtmlTag(asString, "/TD").length());
                if(!asString.contains("<TR>"))
                    break;
            }
        }
        return schoolClasses;
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
    private static String findHtmlTag(String source, String toFind) throws Exception
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
    private static String getTable(String source) throws Exception
    {
        source = source.substring(source.indexOf("<TABLE border=\"3\" rules=\"all\" bgcolor=\"#E7E7E7\" cellpadding=\"1\" cellspacing=\"1\">"));
        source = source.substring(0, source.indexOf(findHtmlTag(source, "/TABLE")) + findHtmlTag(source, "/TABLE").length());
        return source;
    }

    /**
     * Prüft ob der String zu einer Zahl konvertiert werden kann.
     *
     * @param s          Der String der überprüft wird
     * @param extraChars zusätzlich zugelassene Zeichen (neben Ziffern)
     *
     * @return Ob der String nur aus Ziffern und "extraChars" besteht
     */
    private static boolean validateAsNumber(String s, char... extraChars) throws Exception
    {
        boolean found = false;
        if(s.isEmpty())
            return false;

        for(char c : s.toCharArray())
            if(Character.isDigit(c))
                found = true;
        if(!found)
            return false;

        for(char c : s.toCharArray())
            if(!Character.isDigit(c))
            {
                found = false;
                for(char extra : extraChars)
                    if(c == extra)
                    {
                        found = true;
                        break;
                    }
                if(!found)
                    return false;
            }
        return true;
    }

    /**
     * Gibt die nächste Zelle der Tabelle soruce zurück
     *
     * @param source Die bis dahin noch übriggebliebene Tabelle
     *
     * @return Die nächste Zelle der Tabelle
     */
    private static String readEntry(String source) throws Exception
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
     * @throws java.lang.Exception Fehler
     */
    public static SchoolClass[] sort(SchoolClass[] schoolClasses) throws Exception
    {
        if(schoolClasses == null)
            return null;
        for(SchoolClass schoolClass : schoolClasses)
        {
            ArrayList<Entry> out = new ArrayList<>();
            while(schoolClass.getEntries().size() > 0)
            {
                double lowestLesson = Double.MAX_VALUE;
                Entry lowestEntry = schoolClass.getEntries().get(0);
                for(Entry entry : schoolClass.getEntries())
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
    private static ArrayList<File> getFiles(String path) throws Exception
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
        return files;
    }

    /**
     * Liest die Vertretungen aus einer Datenbank.
     *
     * @return alle Schulklassen
     */
    private static SchoolClass[] getAllSql() throws Exception
    {
        String[] settings = Settings.loadArray("sql");
        ArrayList< SchoolClass> asList = new ArrayList<>();
        SqlTableReader read = new SqlTableReader(PathConverter.convert(settings[0]),
                                                 Integer.parseInt(settings[1]),
                                                 PathConverter.convert(settings[2]),
                                                 settings[4],
                                                 settings[5],
                                                 PathConverter.convert(settings[3]),
                                                 sqlColumms);

        ArrayList<String[]> readIn = read.readAll();
        for(String[] asArray : readIn)
        {
            Map<String, String> forEntry = new HashMap<>();
            for(int i = 0; i < asArray.length; i++)
                forEntry.put(sqlColumms[i], asArray[i]);

            boolean added = false;
            for(SchoolClass sc : asList)
                if(sc.getName().equals(forEntry.get("Stufe")))
                {
                    sc.getEntries().add(new Entry(forEntry));
                    added = true;
                }
            if(!added)
            {
                SchoolClass sc = new SchoolClass(forEntry.get("Stufe"));
                sc.getEntries().add(new Entry(forEntry));
                asList.add(sc);
            }
        }
        return (SchoolClass[])asList.toArray();
    }
}
