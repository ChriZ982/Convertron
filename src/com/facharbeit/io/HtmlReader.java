package com.facharbeit.io;

import com.facharbeit.tools.Entry;
import com.facharbeit.tools.Logger;
import com.facharbeit.tools.SchoolClass;
import com.facharbeit.tools.Time;
import java.io.File;
import java.util.ArrayList;

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
     * Liest die Schulklassen für heute ein.
     *
     * @return Schulklassen für heute
     */
    public static SchoolClass[] today()
    {
        try
        {
            if(Settings.load("sqlUse").equals("false"))
            {
                SchoolClass[] schoolClasses = get(Settings.load("pathSource"));
                boolean found = false;
                for(SchoolClass schoolClass : schoolClasses)
                {
                    if(schoolClass.containsEntrysOfDate(Time.htmlReading(0)))
                        found = true;

                    schoolClass.onlyDate(Time.htmlReading(0));
                }
                if(found)
                    return schoolClasses;
            }
            return null;
        } catch(Exception ex)
        {
            Logger.log("Heutige HTML-Klassendateien konnten nicht gelesen werden", 2);
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
            if(Settings.load("sqlUse").equals("false"))
            {
                SchoolClass[] schoolClasses = get(Settings.load("pathSource"));
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
            }
            return null;
        } catch(Exception ex)
        {
            Logger.log("Morgige HTML-Klassendateien konnten nicht gelesen werden", 2);
            Logger.error(ex);
            return null;
        }
    }

    /**
     * Liest alle Klassendateien aus.
     *
     * @param path Pfad zu den Dateien
     *
     * @return Alle Schulklassen
     */
    private static SchoolClass[] get(String path)
    {
        try
        {
            String cellStartsWith = "<TD align=center>";
            String cellStartsWith2 = "<font size=\"3\" face=\"Arial\">";
            String cellStartsWith2a = "<font size=\"3\" face=\"Arial\" color=\"#000000\">";
            String cellEndsWith = "</TD>";
            String cellEndsWith2 = "</font> ";

            ArrayList<File> files = files(path);

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

                    String[] entry = new String[10];

                    for(int t = 0; t < entry.length; t++)
                    {
                        asString = asString.substring(asString.indexOf(cellStartsWith) + cellStartsWith.length());
                        if(asString.startsWith(cellStartsWith2a))
                        {
                            asString = asString.substring(asString.indexOf(cellStartsWith2a) + cellStartsWith2a.length());
                            entry[t] = asString.substring(1, asString.indexOf(cellEndsWith2) - 1); //1 bzw -1 um die Absätze nicht mitzukopieren
                            asString = asString.substring(asString.indexOf(cellEndsWith2) + cellEndsWith2.length());

                        } else if(asString.startsWith(cellStartsWith2))
                        {
                            asString = asString.substring(asString.indexOf(cellStartsWith2) + cellStartsWith2.length());
                            entry[t] = asString.substring(1, asString.indexOf(cellEndsWith2) - 1); //1 bzw -1 um die Absätze nicht mitzukopieren
                            asString = asString.substring(asString.indexOf(cellEndsWith2) + cellEndsWith2.length());
                        } else
                            entry[t] = "";
                    }

                    schoolClasses[i].getEntrys().add(new Entry(entry));

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
    private static ArrayList<File> files(String path)
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
}
