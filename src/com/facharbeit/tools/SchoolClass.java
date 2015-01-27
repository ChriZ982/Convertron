package com.facharbeit.tools;

import com.facharbeit.io.*;
import java.util.*;

/**
 * Klasse, die alle Vertretungen (Entrys) einer Schulklasse beinhaltet.
 */
public class SchoolClass
{
    /**
     * Name der Schulklasse.
     */
    private String name;

    /**
     * Datum auf das die Einträge begrenzt wurden (durch onlyDate(String)).
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
     * Gibt Name.
     *
     * @return Name der Schulklasse.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Prüft ob Einträge vorhanden sind.
     *
     * @return Sind keine Einträge vorhanden?
     *
     * @throws java.lang.Exception
     */
    public boolean isEmpty() throws Exception
    {
        if(entries == null)
            return true;
        return entries.isEmpty();
    }

    /**
     * Sortiert die Einträge.
     *
     * @param newOrder Neue Reihenfolge
     *
     * @throws java.lang.Exception
     */
    public void sort(int... newOrder) throws Exception
    {
        contentColumms = sort(contentColumms, newOrder);
        for(Entry e : entries)
            e.setImportantContentOrder(sort(e.getImportantContentOrder(), newOrder));
    }

    /**
     * Sortiert die Einträge.
     *
     * @param old      Alter Inhalt
     * @param newOrder Neue Reihenfolge
     *
     * @return Alter Inhalt neu sortiert
     */
    private String[] sort(String[] old, int[] newOrder) throws Exception
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

    /**
     * Löscht vergangene Stunden.
     *
     * @throws java.lang.Exception
     */
    public void cut() throws Exception
    {
        Settings.enable(false);

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
        Settings.enable(true);
    }

    /**
     * Konvertiert diese Schulklasse inkl ihrer Vertretungen (Entrys) in eine HTML-Tabelle.
     *
     * @return Konvertierte Klasse
     *
     * @throws java.lang.Exception
     */
    public String asString() throws Exception
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
                String setting;
                switch(cc)
                {
                    case "Vertreter":
                        setting = Settings.load("lessonSizeVtr");
                        if(!setting.equals(""))
                            colWidth = Integer.parseInt(setting);
                        break;
                    case "Raum":
                        setting = Settings.load("lessonSizeRaum");
                        if(!setting.equals(""))
                            colWidth = Integer.parseInt(setting);
                        break;
                    case "Art":
                        setting = Settings.load("lessonSizeArt");
                        if(!setting.equals(""))
                            colWidth = Integer.parseInt(setting);
                        break;
                    case "Fach":
                        setting = Settings.load("lessonSizeFach");
                        if(!setting.equals(""))
                            colWidth = Integer.parseInt(setting);
                        break;
                    case "Lehrer":
                        setting = Settings.load("lessonSizeLeh");
                        if(!setting.equals(""))
                            colWidth = Integer.parseInt(setting);
                        break;
                    case "Verl. von":
                        setting = Settings.load("lessonSizeVerl");
                        if(!setting.equals(""))
                            colWidth = Integer.parseInt(setting);
                        break;
                    case "Hinweise":
                        setting = Settings.load("lessonSizeHinw");
                        if(!setting.equals(""))
                            colWidth = Integer.parseInt(setting);
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
                s += e.asString(e.getContent().get("Vertretungsart").replaceAll("\\.", ""));

            s += "'        </table>'+";
        }
        return s;
    }

    /**
     * Sucht einen String in einem String-Array
     *
     * @param array    Array
     * @param toSearch Zu suchender String
     *
     * @return Index des Strings
     */
    private int getIndexOfStringInArray(String[] array, String toSearch) throws Exception
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

    /**
     * Prüft ob Einträge eines Datums enthalten sind.
     *
     * @param date Datum, das geprüft wird (dd.mm.)
     *
     * @return Einträge des Datums vorhanden?
     *
     * @throws java.lang.Exception
     */
    public boolean containsEntrysOfDate(String date) throws Exception
    {
        for(Entry e : entries)
            if(e.getDate().equals(date))
                return true;
        return false;
    }

    /**
     * Löscht alle Einträge, die nicht dem Datum entsprechen.
     *
     * @param date Datum (dd.mm.)
     *
     * @throws java.lang.Exception
     */
    public void onlyDate(String date) throws Exception
    {
        curDate = date;
        ArrayList<Entry> newEntrys = new ArrayList<Entry>();
        for(Entry e : entries)
            if(e.getDate().equals(date))
                newEntrys.add(e);
        entries = newEntrys;
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
