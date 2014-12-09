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
    private ArrayList<Entry> entrys;

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
        this.entrys = new ArrayList<Entry>();
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
            if(entrys == null)
                return true;
            return entrys.isEmpty();
        } catch(Exception ex)
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
            for(Entry e : entrys)
                e.setContent(sort(e.getContent(), newOrder));
        } catch(Exception ex)
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
        } catch(Exception ex)
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
            boolean show;
            for(Entry e : entrys)
            {
                if(e.isDoubleLesson())
                    show = Time.isAfter(Integer.valueOf(Settings.load("lesson" + (e.getLesson() + 1)).split(":")[0]),
                                        Integer.valueOf(Settings.load("lesson" + (e.getLesson() + 1)).split(":")[1]),
                                        Time.hour(),
                                        Time.minute());
                else
                    show = Time.isAfter(Integer.valueOf(Settings.load("lesson" + e.getLesson()).split(":")[0]),
                                        Integer.valueOf(Settings.load("lesson" + e.getLesson()).split(":")[1]),
                                        Time.hour(),
                                        Time.minute());
                if(!show)
                    entrys.remove(e);
            }
            Settings.logging(true);
        } catch(Exception ex)
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
            if(entrys.size() > 0)
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
                     + "'                <td rowspan=\"" + (entrys.size() + 1) + "\" valign=\"top\"><div class=\"stufe\">" + name + "</div></td>'+\n";

                s += "'                <td>Std</td>'+\n";
                for(String cc : contentColumms)
                    s += "'                <td>" + cc + "</td>'+\n";

                s += "'            </tr>'+\n";

                for(Entry e : entrys)
                    s += e.toString(e.getContent()[getIndexOfStringInArray(contentColumms, "Art")].replaceAll("\\.", ""));

                s += "'        </table>'+";
            }
            return s;
        } catch(Exception ex)
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
        } catch(Exception ex)
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
            for(Entry e : entrys)
                if(e.getDate().equals(date))
                    return true;
            return false;
        } catch(Exception ex)
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
            for(Entry e : entrys)
                if(e.getDate().equals(date))
                    newEntrys.add(e);
            entrys = newEntrys;
        } catch(Exception ex)
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
    public ArrayList<Entry> getEntrys()
    {
        return entrys;
    }

    /**
     * Setzt Einträge.
     *
     * @param entrys Neue Einträge
     */
    public void setEntrys(ArrayList<Entry> entrys)
    {
        this.entrys = entrys;
    }
}
