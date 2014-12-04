package com.facharbeit.io;

import com.facharbeit.io.FileReader;
import com.facharbeit.tools.*;
import java.io.*;
import java.util.*;

public class HtmlReader
{
    final static String[] extraGrades =
    {
        "EF", "Q1", "Q2", "___"
    };

    public static SchoolClass[] readInToday()
    {
        if(Settings.load("sqlUse").equals("false"))
        {
            SchoolClass[] scs = readInHtml(Settings.load("pathSource"));
            boolean found = false;
            for(SchoolClass sc : scs)
            {
                if(sc.containsEntrysOfDate(Time.forHtmlReading(true)))
                    found = true;

                sc.onlyDate(Time.forHtmlReading(true));
            }
            if(found)
                return scs;
        }
        return null;
    }

    public static SchoolClass[] readInTomorrow()
    {
        if(Settings.load("sqlUse").equals("false"))
        {
            SchoolClass[] scs = readInHtml(Settings.load("pathSource"));
            boolean found = false;
            int i = 0;
            while(i < 10 && !found)
            {
                i++;
                for(SchoolClass sc : scs)
                    if(sc.containsEntrysOfDate(Time.forHtmlReading(false)))
                        found = true;
            }
            if(found)
            {
                for(SchoolClass sc : scs)
                    sc.onlyDate(Time.forHtmlReading(false));
                return scs;
            }
        }
        return null;
    }

    private static SchoolClass[] readInHtml(String path)
    {

        final String cellStartsWith = "<TD align=center>";
        final String cellStartsWith2 = "<font size=\"3\" face=\"Arial\">";
        final String cellStartsWith2a = "<font size=\"3\" face=\"Arial\" color=\"#000000\">";
        final String cellEndsWith = "</TD>";
        final String cellEndsWith2 = "</font> ";

        ArrayList<File> files = getFiles(path);

        SchoolClass[] outcome = new SchoolClass[files.size()];

        for(int i = 0; i < outcome.length; i++)
        {
            Logger.setProgress(10 + (int)(40.0 * ((double)i / (double)outcome.length)));
            outcome[i] = new SchoolClass(files.get(i).getName().substring(13, files.get(i).getName().lastIndexOf('.')));

            if(outcome[i].isEmpty())
                outcome[i].setEntrys(new ArrayList<Entry>());

            FileReader read = new FileReader(files.get(i));
            String fileAsString = read.toString();
            fileAsString = fileAsString.substring(fileAsString.indexOf("<TABLE border=\"3\" rules=\"all\" bgcolor=\"#E7E7E7\" cellpadding=\"1\" cellspacing=\"1\">"));
            fileAsString = fileAsString.substring(0, fileAsString.indexOf("<TABLE cellspacing=\"1\" cellpadding=\"1\">") - 13);
            fileAsString = fileAsString.substring(fileAsString.indexOf("<TR>") + 4);
            boolean endOfFile = false;

            while(!endOfFile)
            {
                fileAsString = fileAsString.substring(fileAsString.indexOf("<TR>") + 4);

                String[] thisEntry = new String[10];

                for(int t = 0; t < thisEntry.length; t++)
                {
                    fileAsString = fileAsString.substring(fileAsString.indexOf(cellStartsWith) + cellStartsWith.length());
                    if(fileAsString.startsWith(cellStartsWith2a))
                    {
                        fileAsString = fileAsString.substring(fileAsString.indexOf(cellStartsWith2a) + cellStartsWith2a.length());
                        thisEntry[t] = fileAsString.substring(1, fileAsString.indexOf(cellEndsWith2) - 1); //1 bzw -1 um die Absätze nicht mitzukopieren
                        fileAsString = fileAsString.substring(fileAsString.indexOf(cellEndsWith2) + cellEndsWith2.length());

                    } else if(fileAsString.startsWith(cellStartsWith2))
                    {
                        fileAsString = fileAsString.substring(fileAsString.indexOf(cellStartsWith2) + cellStartsWith2.length());
                        thisEntry[t] = fileAsString.substring(1, fileAsString.indexOf(cellEndsWith2) - 1); //1 bzw -1 um die Absätze nicht mitzukopieren
                        fileAsString = fileAsString.substring(fileAsString.indexOf(cellEndsWith2) + cellEndsWith2.length());
                    } else
                        thisEntry[t] = "";
                }

                outcome[i].getEntrys().add(new Entry(thisEntry));

                fileAsString = fileAsString.substring(fileAsString.indexOf(cellEndsWith) + cellEndsWith.length());

                if(!fileAsString.contains("<TR>"))
                    endOfFile = true;

            }
        }
        Logger.setProgress(50);
        return outcome;
    }

    public static SchoolClass[] sortArray(SchoolClass[] p)
    {
        if(p == null)
            return null;

        for(SchoolClass s : p)
        {
            ArrayList<Entry> out = new ArrayList<>();
            while(s.getEntrys().size() > 0)
            {
                double lowestHour = 1000;
                Entry lowestEntry = s.getEntrys().get(0);
                for(Entry entry : s.getEntrys())
                {
                    double thisHour = entry.getHour() + 0.0;
                    if(entry.isNextEqual())
                        thisHour += 0.5;

                    if(thisHour < lowestHour)
                    {
                        lowestHour = thisHour;
                        lowestEntry = entry;
                    }
                }
                s.getEntrys().remove(lowestEntry);
                out.add(lowestEntry);

            }
            s.setEntrys(out);
        }
        return p;
    }

    private static ArrayList<File> getFiles(String path)
    {
        ArrayList<File> files = new ArrayList<>();
        File f;
        for(int grade = 5; grade <= 9; grade++)
            for(int c = 97; c <= 122; c++)
            {
                f = new File(path + "/" + "Druck_Klasse_0" + grade + "" + (char)c + ".htm");

                if(f.exists())
                    files.add(f);
            }

        for(String s : extraGrades)
        {
            f = new File(path + "/" + "Druck_Klasse_" + s + ".htm");
            if(f.exists())
                files.add(f);
        }

        return files;
    }
}
