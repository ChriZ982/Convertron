package com.facharbeit.tools;

import com.facharbeit.io.*;
import java.util.*;

/**
 * Schulklasse die alle Einträge der Klasse beinhaltet.
 */
public class SchoolClass
{
    /**
     * Name der Klasse.
     */
    private String name;

    public String getName()
    {
        return name;
    }

    /**
     * Datum mit dem die Schulklasse eingelesen wurde.
     */
    private String curDate;

    /**
     * Einträge der Klasse.
     */
    private List<Entry> entries;

    /**
     * Spalten, die es gibt.
     */
    private String[] contentColumms =
    {
        "Vertreter", "Raum", "Art", "Fach", "Lehrer", "Verl. von", "Hinweise"
    };

    /**
     * Initialisiert eine Schulklasse.
     *
     * @param name Name der Klasse
     */
    public SchoolClass(String name)
    {
        this.entries = new ArrayList<Entry>();
        this.name = name;
    }

    /**
     * Prüft die Einträge in der Klasse.
     *
     * @return Sind keine Einträge vorhanden?
     */
    public boolean isEmpty()
    {
        try
        {
            if(entries == null)
                return true;
            return entries.isEmpty();
        }
        catch(Exception ex)
        {
            Logger.log("Schulklasse konnte nicht überprüft werdenF", 2);
            Logger.error(ex);
            return false;
        }
    }

    /**
     * Sortiert die Einträge.
     *
     * @param newOrder Neue Reihenfolge
     */
    public void sort(int... newOrder)
    {
        try
        {
            contentColumms = sort(contentColumms, newOrder);
            for(Entry e : entries)
                e.setImportantContent(sort(e.getImportantContent(), newOrder));
        }
        catch(Exception ex)
        {
            Logger.log("Einträge konnten nicht sortiert werden", 2);
            Logger.error(ex);
        }
    }

    /**
     * Sortiert die Einträge.
     *
     * @param old      Alte Reihenfolge
     * @param newOrder Neue Reihenfolge
     *
     * @return Sortierte Tabelle
     */
    private String[] sort(String[] old, int[] newOrder)
    {
        try
        {
            String[] newContent = new String[newOrder.length];

            int i = 0;
            for(int j : newOrder)
                if(j < old.length)
                {
                    newContent[i] = old[j];
                    i++;
                }

            return newContent;
        }
        catch(Exception ex)
        {
            Logger.log("Einträge konnten nicht sortiert werden", 2);
            Logger.error(ex);
            return null;
        }
    }

    /**
     * Löscht unwichtige Stunden.
     */
    public void cut()
    {
        try
        {
            Settings.logging(false);

            ArrayList<Entry> newEntries = new ArrayList<Entry>();
            for(Entry e : entries)
            {
                int lesson = e.getLesson();
                if(e.isDoubleLesson())
                    lesson++;

                String lessonName = "lesson";
                if(lesson < 10)
                    lessonName += "0";
                lessonName += lesson;

                if(Time.isAfter(Integer.valueOf(Settings.load(lessonName).split(":")[0]),
                                Integer.valueOf(Settings.load(lessonName).split(":")[1]),
                                Time.hour(),
                                Time.minute()))
                    newEntries.add(e);
            }
            entries = newEntries;
            Settings.logging(true);
        }
        catch(Exception ex)
        {
            Logger.log("Stunden konnten nicht gelöscht werden", 2);
            Logger.error(ex);
        }
    }

    /**
     * Konvertiert eine Klasse in einen String.
     *
     * @return Konvertierte Klasse
     */
    @Override
    public String toString()
    {
        try
        {
            String s = "";
            if(entries.size() > 0)
            {
                s += "'        <br/>'+\n"
                     + "''+\n"
                     + "'        <table class=\"stufeTab\" rules=\"all\">'+\n"
                     + "'            <colgroup>'+\n"
                     + "'                <col width=\"" + 7 + "%\">'+\n"
                     + "'                <col width=\"" + 6 + "%\">'+\n";

                for(String cc : contentColumms)
                {
                    int colWidth = 10;
                    switch(cc)
                    {
                        case "Vertreter":
                            colWidth = 10;
                            break;
                        case "Raum":
                            colWidth = 10;
                            break;
                        case "Art":
                            colWidth = 12;
                            break;
                        case "Fach":
                            colWidth = 7;
                            break;
                        case "Lehrer":
                            colWidth = 10;
                            break;
                        case "Verl. von":
                            colWidth = 10;
                            break;
                        case "Hinweise":
                            colWidth = 28;
                            break;
                        default:
                            break;
                    }
                    s += "'                <col width=\"" + colWidth + "%\">'+\n";
                }
                s += "'            </colgroup>'+\n"
                     + "'            <tr >'+\n"
                     + "'                <td rowspan=\"" + (entries.size() + 1) + "\" valign=\"top\"><div class=\"stufe\">" + name + "</div></td>'+\n";

                s += "'                <td>Std</td>'+\n";
                for(String cc : contentColumms)
                    s += "'                <td>" + cc + "</td>'+\n";

                s += "'            </tr>'+\n";

                for(Entry e : entries)
                    s += e.toString(e.getImportantContent()[getIndexOfStringInArray(contentColumms, "Art")].replaceAll("\\.", ""));

                s += "'        </table>'+";
            }
            return s;
        }
        catch(Exception ex)
        {
            Logger.log("Klasse konnte nicht konvertiert werden", 2);
            Logger.error(ex);
            return null;
        }
    }

    /**
     * Sucht einen String in einem String-Array
     *
     * @param array    Array
     * @param toSearch Zu suchender String
     *
     * @return Index des Strings
     */
    private int getIndexOfStringInArray(String[] array, String toSearch)
    {
        try
        {
            int index = -1;
            for(int i = 0; i < array.length; i++)
                if(array[i].equals(toSearch))
                {
                    index = i;
                    break;
                }
            return index;
        }
        catch(Exception ex)
        {
            Logger.log("Array konnte nicht durchsucht werden", 2);
            Logger.error(ex);
            return -1;
        }
    }

    /**
     * Prüft ob Einträge eines Datums enthalten sind.
     *
     * @param date Datum, das geprüft wird
     *
     * @return Einträge des Datums vorhanden?
     */
    public boolean containsEntrysOfDate(String date)
    {
        try
        {
            for(Entry e : entries)
                if(e.getDate().equals(date))
                    return true;
            return false;
        }
        catch(Exception ex)
        {
            Logger.log("Verfügbarkeit von Einträgen konnte nicht geprüft werden", 2);
            Logger.error(ex);
            return false;
        }
    }

    /**
     * Löscht alle Einträge, die nicht dem Datum entsprechen.
     *
     * @param date Datum
     */
    public void onlyDate(String date)
    {
        try
        {
            curDate = date;
            ArrayList<Entry> newEntrys = new ArrayList<Entry>();
            for(Entry e : entries)
                if(e.getDate().equals(date))
                    newEntrys.add(e);
            entries = newEntrys;
        }
        catch(Exception ex)
        {
            Logger.log("Einträge konnten nicht aussortiert werden", 2);
            Logger.error(ex);
        }
    }

    /**
     * Gibt Datum.
     *
     * @return Datum
     */
    public String getCurDate()
    {
        return curDate;
    }

    /**
     * Gibt Einträge.
     *
     * @return Einträge
     */
    public List<Entry> getEntries()
    {
        return entries;
    }

    /**
     * Setzt Einträge.
     *
     * @param entrys Neue Einträge
     */
    public void setEntries(List<Entry> entrys)
    {
        this.entries = entrys;
    }
}
