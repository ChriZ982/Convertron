package com.facharbeit.tools;

import com.facharbeit.io.*;
import java.util.*;

public class SchoolClass
{
    private ArrayList<Entry> entrys;
    private String[] contentColumms =
    {
        "Vertreter", "Raum", "Art", "Fach", "Lehrer", "Verl. von", "Hinweise"
    };
    private String name;

    public SchoolClass(String name)
    {
        entrys = new ArrayList<Entry>();
        this.name = name;
    }

    public SchoolClass(String name, ArrayList<Entry> entrys)
    {
        this.entrys = entrys;
        this.name = name;
    }

    public ArrayList<Entry> getEntrys()
    {
        return entrys;
    }

    public void setEntrys(ArrayList<Entry> entrys)
    {
        this.entrys = entrys;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public boolean isEmpty()
    {
        try
        {
            return entrys.isEmpty();
        } catch(NullPointerException ex)
        {
            return true;
        }
    }

    public void sortEntrys(int... newOrder)
    {
        contentColumms = sort(contentColumms, newOrder);
        for(Entry e : entrys)
            e.setContent(sort(e.getContent(), newOrder));
    }

    private String[] sort(String[] old, int[] newOrder)
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

    public void cutLessons()
    {
        Settings.logging(false);
        boolean show = false;
        for(Entry e : entrys)
        {
            if(e.isNextEqual())
                show = Time.isAfter(Integer.valueOf(Settings.load("lesson" + (e.getHour() + 1)).split(":")[0]),
                                    Integer.valueOf(Settings.load("lesson" + (e.getHour() + 1)).split(":")[1]),
                                    Time.hour(),
                                    Time.minute());
            else
                show = Time.isAfter(Integer.valueOf(Settings.load("lesson" + e.getHour()).split(":")[0]),
                                    Integer.valueOf(Settings.load("lesson" + e.getHour()).split(":")[1]),
                                    Time.hour(),
                                    Time.minute());
            if(!show)
                entrys.remove(e);
        }
        Settings.logging(true);
    }

    @Override
    public String toString()
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
    }

    private int getIndexOfStringInArray(String[] array, String toSearch)
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

    public boolean containsEntrysOfDate(String date)
    {
        for(Entry e : entrys)
            if(e.getDate().equals(date))
                return true;
        return false;
    }

    public void onlyDate(String date)
    {
        for(Entry e : entrys)
            if(!e.getDate().equals(date))
                entrys.remove(e);
    }
}
