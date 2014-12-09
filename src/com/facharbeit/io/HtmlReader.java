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
    static String[] extraGrades =
    {
        "EF", "Q1", "Q2", "___"
    };

    /**
     * Name der Spalten die ausgelesen werden. Editieren, falls andere Namen. Reihenfolge:
     * Stufe, Datum, Wochentag, Vertreter, Raum, Art, Fach, Lehrer, Verl. von, Hinweise
     */
    static String[] sqlColumms =
    {
        "Stufe", "Datum", "Wochentag", "Vertreter", "Raum", "Art", "Fach", "Lehrer", "Verl. von", "Hinweise"
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
                schoolClasses = getAllHtml(Settings.load("pathSource"));

            boolean found = false;
            for(SchoolClass schoolClass : schoolClasses)
            {
                if(schoolClass.containsEntrysOfDate(Time.htmlReading(0)))
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
                schoolClasses = getAllHtml(Settings.load("pathSource"));

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
        return sort(getAllHtml(Settings.load("pathSource")));
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
            String cellStartsWith = "<TD align=center>";
            String cellStartsWith2 = "<font size=\"3\" face=\"Arial\">";
            String cellStartsWith2a = "<font size=\"3\" face=\"Arial\" color=\"#000000\">";
            String cellEndsWith = "</TD>";
            String cellEndsWith2 = "</font> ";

            ArrayList<File> files = getFiles(path);

            SchoolClass[] schoolClasses = new SchoolClass[files.size()];

            for(int i = 0; i < schoolClasses.length; i++)
            {
                Logger.setProgress(10 + (int)(40.0 * ((double)i / (double)schoolClasses.length)));
                schoolClasses[i] = new SchoolClass(files.get(i).getName().substring(13, files.get(i).getName().lastIndexOf('.')));

                if(schoolClasses[i].isEmpty())
                    schoolClasses[i].setEntrys(new ArrayList<Entry>());

                FileReader reader = new FileReader(files.get(i));
                String asString = reader.toString();
                asString = asString.substring(asString.indexOf("<TABLE border=\"3\" rules=\"all\" bgcolor=\"#E7E7E7\" cellpadding=\"1\" cellspacing=\"1\">"));
                asString = asString.substring(0, asString.indexOf("<TABLE cellspacing=\"1\" cellpadding=\"1\">") - 13);
                asString = asString.substring(asString.indexOf("<TR>") + 4);
                boolean endOfFile = false;

                while(!endOfFile)
                {
                    asString = asString.substring(asString.indexOf("<TR>") + 4);

                    String[] entries = new String[10];

                    for(int t = 0; t < entries.length; t++)
                    {
                        asString = asString.substring(asString.indexOf(cellStartsWith) + cellStartsWith.length());
                        if(asString.startsWith(cellStartsWith2a))
                        {
                            asString = asString.substring(asString.indexOf(cellStartsWith2a) + cellStartsWith2a.length());
                            entries[t] = asString.substring(1, asString.indexOf(cellEndsWith2) - 1); //1 bzw -1 um die Absätze nicht mitzukopieren
                            asString = asString.substring(asString.indexOf(cellEndsWith2) + cellEndsWith2.length());

                        } else if(asString.startsWith(cellStartsWith2))
                        {
                            asString = asString.substring(asString.indexOf(cellStartsWith2) + cellStartsWith2.length());
                            entries[t] = asString.substring(1, asString.indexOf(cellEndsWith2) - 1); //1 bzw -1 um die Absätze nicht mitzukopieren
                            asString = asString.substring(asString.indexOf(cellEndsWith2) + cellEndsWith2.length());
                        } else
                            entries[t] = "";
                    }

                    schoolClasses[i].getEntrys().add(new Entry(entries));

                    asString = asString.substring(asString.indexOf(cellEndsWith) + cellEndsWith.length());

                    if(!asString.contains("<TR>"))
                        endOfFile = true;

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
                while(schoolClass.getEntrys().size() > 0)
                {
                    double lowestLesson = 1000;
                    Entry lowestEntry = schoolClass.getEntrys().get(0);
                    for(Entry entry : schoolClass.getEntrys())
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
                    schoolClass.getEntrys().remove(lowestEntry);
                    out.add(lowestEntry);

                }
                schoolClass.setEntrys(out);
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
            ArrayList<File> files = new ArrayList<>();
            File file;
            for(int grade = 5; grade <= 9; grade++)
                for(int c = 97; c <= 122; c++)
                {
                    file = new File(path + "/" + "Druck_Klasse_0" + grade + "" + (char)c + ".htm");

                    if(file.exists())
                        files.add(file);
                }

            for(String s : extraGrades)
            {
                file = new File(path + "/" + "Druck_Klasse_" + s + ".htm");
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
            SqlTableReader read = new SqlTableReader(Settings.load("sqlHost"),
                                                     Integer.parseInt(Settings.load("sqlPort")),
                                                     Settings.load("sqlName"),
                                                     Settings.load("sqlUser"),
                                                     Settings.load("sqlPassw"),
                                                     Settings.load("sqlTableName"),
                                                     sqlColumms);

            ArrayList<String[]> readIn = read.readAll();

            for(String[] s : readIn)
            {
                String grade = s[0];
                String[] forEntry = new String[s.length - 1];
                boolean added = false;

                for(int i = 0; i < forEntry.length; i++)
                    forEntry[i] = s[i + 1];

                for(SchoolClass sc : asList)
                    if(sc.getName().equals(grade))
                    {
                        sc.getEntrys().add(new Entry(forEntry));
                        added = true;
                    }
                if(!added)
                {
                    SchoolClass sc = new SchoolClass(grade);
                    sc.getEntrys().add(new Entry(forEntry));
                    asList.add(sc);
                }
            }

            return (SchoolClass[])asList.toArray();
        } catch(Exception ex)
        {
            Logger.log("Fehler beim auslesen der Datenbank", 2);
            Logger.error(ex);
            return null;
        }
    }
}
