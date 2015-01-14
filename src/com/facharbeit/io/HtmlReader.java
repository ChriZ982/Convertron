package com.facharbeit.io;

import com.facharbeit.io.FileReader;
import com.facharbeit.tools.*;
import java.io.*;
import java.util.*;

/**
 * Liest die HTML-Dateien für einzelne Klassen aus.
 */
public class HtmlReader
{
    /**
     * Zusätzliche Stufen, die es gibt.
     */
    public static final String[] extraGrades =
    {
        "EF", "Q1", "Q2", "___"
    };

    /**
     * Name der Spalten die ausgelesen werden. Editieren, falls andere Namen. Reihenfolge:
     * Stufe, Datum, Wochentag, Vertreter, Raum, Art, Fach, Lehrer, Verl. von, Hinweise
     */
    public static final String[] sqlColumms =
    {
        "Stufe", "Datum", "Vertreter", "Raum", "Vertretungsart", "Fach", "Lehrer", "Verl. von", "Hinweise"
    };

    /**
     * Liest die Schulklassen für heute ein.
     *
     * @return Schulklassen für heute
     */
    public static SchoolClass[] today()
    {
        try
        {
            SchoolClass[] schoolClasses;
            if(Settings.load("sqlUse").equals("true") && Settings.load("sqlMode").equals("lesen"))
                schoolClasses = getAllSql();
            else
                schoolClasses = getAllHtml(PathConverter.convert(Settings.load("pathSource")));

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
        } catch(Exception ex)
        {
            Logger.log("Heutige Schulklassen konnten nicht ausgelesen werden", 2);
            Logger.error(ex);
            return null;
        }
    }

    /**
     * Liest die Schulklassen für morgen ein.
     *
     * @return Schulklassen für morgen
     */
    public static SchoolClass[] tomorrow()
    {
        try
        {
            SchoolClass[] schoolClasses;
            if(Settings.load("sqlUse").equals("true") && Settings.load("sqlMode").equals("lesen"))
                schoolClasses = getAllSql();
            else
                schoolClasses = getAllHtml(PathConverter.convert(Settings.load("pathSource")));

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
        } catch(Exception ex)
        {
            Logger.log("Morgige Schulklassen konnten nicht ausgelesen werden", 2);
            Logger.error(ex);
            return null;
        }
    }

    public static SchoolClass[] forSql()
    {
        return sort(getAllHtml(PathConverter.convert(Settings.load("pathSource"))));
    }

    /**
     * Liest alle Klassendateien aus.
     *
     * @param path Pfad zu den Dateien
     *
     * @return Alle Schulklassen
     */
    public static SchoolClass[] getAllHtml(String path)
    {
        try
        {
            ArrayList<File> files = getFiles(path);

            SchoolClass[] schoolClasses = new SchoolClass[files.size()];

            for(int i = 0; i < schoolClasses.length; i++)
            {
                Logger.setProgress(10 + (int) (40.0 * ((double) i / (double) schoolClasses.length)));
                String filename = files.get(i).getName();
                schoolClasses[i] = new SchoolClass(filename.substring(Settings.load("fileNamePrefix").length(),
                                                                      filename.indexOf(Settings.load("fileNameSuffix"))));

                if(schoolClasses[i].isEmpty())
                    schoolClasses[i].setEntries(new ArrayList<Entry>());

                String asString = getTable(new FileReader(files.get(i)).toString());

                asString = asString.substring(asString.indexOf(findHtmlTag(asString, "TR")) + findHtmlTag(asString, "TR").length());

                ArrayList<String> head = new ArrayList<>();

                while(asString.indexOf(findHtmlTag(asString, "TD"))
                      < asString.indexOf(findHtmlTag(asString, "TR")))
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

                    schoolClasses[i].getEntries().add(new Entry(entries));

                    asString = asString.substring(asString.indexOf(findHtmlTag(asString, "/TD")) + findHtmlTag(asString, "/TD").length());

                    if(!asString.contains("<TR>"))
                        break;
                }
            }
            Logger.setProgress(50);
            return schoolClasses;
        } catch(Exception ex)
        {
            Logger.log("HTML-Klassendateien konnten nicht ausgelesen werden", 2);
            Logger.error(ex);
            return null;
        }
    }

    private static String findHtmlTag(String source, String toFind)
    {
        try
        {
            source = source.substring(source.indexOf("<" + toFind));
            source = source.substring(0, source.indexOf(">") + 1);

            return source;
        } catch(Exception ex)
        {
            Logger.log("HTML-Tag <" + toFind + "> konnte nicht gefunden werden", 2);
            Logger.error(ex);
        }
        return ">";
    }

    private static String getTable(String source)
    {
        try
        {
            source = source.substring(source.indexOf("<TABLE border=\"3\" rules=\"all\" bgcolor=\"#E7E7E7\" cellpadding=\"1\" cellspacing=\"1\">"));
            source = source.substring(0, source.indexOf(findHtmlTag(source, "/TABLE")) + findHtmlTag(source, "/TABLE").length());
            return source;
        } catch(Exception ex)
        {
            Logger.log("Die Tabelle konnte nicht ausgeschnitten werden", 2);
            Logger.error(ex);
        }
        return null;
    }

    private static String readEntry(String source)
    {
        try
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
        } catch(Exception ex)
        {
            Logger.log("Eintrag konnte nicht gelesen werden", 2);
        }
        return null;
    }

    /**
     * Sortiert das Schulklassen-Array.
     *
     * @param schoolClasses Zu sortierendes Array
     *
     * @return Sortiertes Array
     */
    public static SchoolClass[] sort(SchoolClass[] schoolClasses)
    {
        try
        {
            if(schoolClasses == null)
                return null;

            for(SchoolClass schoolClass : schoolClasses)
            {
                ArrayList<Entry> out = new ArrayList<>();
                while(schoolClass.getEntries().size() > 0)
                {
                    double lowestLesson = 1000;
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
        } catch(Exception ex)
        {
            Logger.log("Schulklassen konnten nicht sortiert werden", 2);
            Logger.error(ex);
            return null;
        }
    }

    /**
     * Gibt die vorhandenen Dateien zurück.
     *
     * @param path Pfad in dem die Dateien liegen
     *
     * @return Liste der Dateien
     */
    private static ArrayList<File> getFiles(String path)
    {
        try
        {
            while(path.endsWith("\\"))
                path = path.substring(0, path.length() - 1);
            if(!path.endsWith("/"))
                path += "/";

            String prefix = Settings.load("fileNamePrefix");
            String suffix = Settings.load("fileNameSuffix");

            ArrayList<File> files = new ArrayList<>();
            File file;
            for(int grade = 5; grade <= 9; grade++)
                for(int c = 97; c <= 122; c++)
                {
                    String g = String.valueOf(grade) + "" + (char) c;
                    while(g.length() < 3)
                        g = "0" + g;

                    file = new File(path, prefix + g + suffix);

                    if(file.exists())
                        files.add(file);
                }

            for(String s : extraGrades)
            {
                file = new File(path, "Druck_Klasse_" + s + ".htm");
                if(file.exists())
                    files.add(file);
            }

            return files;
        } catch(Exception ex)
        {
            Logger.log("Dateien konnten nicht unter \"" + path + "\" gefunden werden", 2);
            Logger.error(ex);
            return null;
        }
    }

    /**
     * Liest die Klassendateien aus einer Datenbank.
     *
     * @return alle Schulklassen
     */
    private static SchoolClass[] getAllSql()
    {
        try
        {
            ArrayList<SchoolClass> asList = new ArrayList<>();
            SqlTableReader read = new SqlTableReader(PathConverter.convert(Settings.load("sqlHost")),
                                                     Integer.parseInt(Settings.load("sqlPort")),
                                                     PathConverter.convert(Settings.load("sqlName")),
                                                     Settings.load("sqlUser"),
                                                     Settings.load("sqlPassw"),
                                                     PathConverter.convert(Settings.load("sqlTableName")),
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

            return (SchoolClass[]) asList.toArray();
        } catch(Exception ex)
        {
            Logger.log("Fehler beim auslesen der Datenbank", 2);
            Logger.error(ex);
            return null;
        }
    }
}
