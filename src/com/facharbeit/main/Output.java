/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facharbeit.main;

import com.facharbeit.io.*;
import com.facharbeit.tools.*;
import java.util.*;

public class Output
{

    private static String generateClasses(SchoolClass[] schoolClasses)
    {
        String s = "";
        for(SchoolClass sc : schoolClasses)
        {
            s += "        <br/>\n"
                 + "\n"
                 + "        <table class=\"stufeTab\" rules=\"all\">\n"
                 + "            <colgroup>\n"
                 + "                <col width=\"7%\">\n"
                 + "                <col width=\"6%\">\n"
                 + "                <col width=\"10%\">\n"
                 + "                <col width=\"10%\">\n"
                 + "                <col width=\"12%\">\n"
                 + "                <col width=\"7%\">\n"
                 + "                <col width=\"10%\">\n"
                 + "                <col width=\"10%\">\n"
                 + "                <col width=\"28%\">\n"
                 + "            </colgroup>\n"
                 + "            <tr >\n"
                 + "                <td rowspan=\"" + (sc.getEntrys().size() + 1) + "\" valign=\"top\"><div class=\"stufe\"><b>" + sc.getName() + "</b></div></td>\n"
                 + "                <td>Std</td>\n"
                 + "                <td>Vertreter</td>\n"
                 + "                <td>Raum</td>\n"
                 + "                <td>Art</td>\n"
                 + "                <td>Fach</td>\n"
                 + "                <td>Lehrer</td>\n"
                 + "                <td>Verl. von</td>\n"
                 + "                <td>Hinweise</td>\n"
                 + "            </tr>\n";

            for(Entry e : sc.getEntrys())
            {
                s += "            <tr >\n";

                if(e.isNextEqual())
                    s += "                <td>" + e.getHour() + "-" + (e.getHour() + 1) + "</td>\n";
                else
                    s += "                <td>" + e.getHour() + "</td>\n";

                s += "                <td>" + e.getContent()[0] + "</td>\n"
                     + "                <td>" + e.getContent()[1] + "</td>\n"
                     + "                <td>" + e.getContent()[2] + "</td>\n"
                     + "                <td>" + e.getContent()[3] + "</td>\n"
                     + "                <td>" + e.getContent()[4] + "</td>\n"
                     + "                <td>" + e.getContent()[5] + "</td>\n"
                     + "                <td>" + e.getContent()[6] + "</td>\n"
                     + "            </tr>\n";
            }

            s += "        </table>\n\n";
        }

        return s;
    }

    private static String generateDay(boolean today)
    {
        Calendar c = Calendar.getInstance();

        if(!today)
            c.add(Calendar.DAY_OF_MONTH, 1);

        String s = c.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.GERMANY) + " "
                   + c.get(Calendar.DAY_OF_MONTH) + "."
                   + (c.get(Calendar.MONTH) + 1) + ". ";

        if(c.get(Calendar.WEEK_OF_YEAR) % 2 == 0)
            s += "B-Woche";
        else
            s += "A-Woche";

        return s;
    }

    /**
     * TEMPORÄR.
     *
     * @deprecated
     */
    private static SchoolClass[] generateTEMP()
    {
        SchoolClass[] sca = new SchoolClass[10];

        for(int i = 0; i < sca.length; i++)
        {
            sca[i] = new SchoolClass("Q1");

            ArrayList<Entry> list = new ArrayList<Entry>();
            for(int j = 0; j < 2; j++)
                list.add(new Entry(3, false, "ker", "info1", "EVA", "Informatik", "ker", "-", ""));

            for(int j = 0; j < 2; j++)
                list.add(new Entry(5, true, "ker", "info1", "EVA", "Informatik", "ker", "-", ""));

            sca[i].setEntrys(list);
        }

        return sca;
    }

    public static void generatePlanToday(SchoolClass[] schoolClasses)
    {
        schoolClasses = generateTEMP();

        String day = generateDay(true);
        String speed = Integer.toString((int)((1.0 / (Double.parseDouble(Settings.load("planSpeed")) / 100.0)) * 12.0));
        String farbe = Settings.load("color" + Settings.load("colorPlan"));
        String classes = generateClasses(schoolClasses);

        if(day.equals("") || speed.equals("") || farbe.equals("") || classes.equals(""))
        {
            Logger.log("Eine Einstellung wurde noch nicht gemacht - Plan kann nicht generiert werden!", 2);
            return;
        }

        Reader reader = new Reader("TEMPLATE heute morgen.html");

        String[] file = reader.readAll();

        for(int i = 0; i < file.length; i++)
        {
            file[i] = file[i].replaceAll("GESCHW", speed);
            file[i] = file[i].replaceAll("TAG", day);
            file[i] = file[i].replaceAll("BGFARBE", farbe);
            file[i] = file[i].replaceAll("VERTRETUNGEN", classes);
        }

        Writer writer1 = new Writer("heute.html");
        writer1.writeAll(file);

        Writer writer2 = new Writer("morgen.html");

        Writer writer3 = new Writer("laufschrift.html");

        Writer writer4 = new Writer("beide.html");

        String[] dest = Settings.giveMultiple("destPath");
        for(String s : dest)
        {
            writer1.copy(s + "\\");
            writer2.copy(s + "\\");
            writer3.copy(s + "\\");
            writer4.copy(s + "\\");
        }
    }

    public static void generatePlanTomorrow(SchoolClass[] schoolClasses)
    {
        schoolClasses = generateTEMP();

        String day = generateDay(false);
        String speed = Integer.toString((int)((1.0 / (Double.parseDouble(Settings.load("planSpeed")) / 100.0)) * 12.0));
        String farbe = Settings.load("color" + Settings.load("colorPlan"));
        String classes = generateClasses(schoolClasses);

        if(day.equals("") || speed.equals("") || farbe.equals("") || classes.equals(""))
        {
            Logger.log("Eine Einstellung wurde noch nicht gemacht - Plan kann nicht generiert werden!", 2);
            return;
        }

        Reader reader = new Reader("TEMPLATE heute morgen.html");

        String[] file = reader.readAll();

        for(int i = 0; i < file.length; i++)
        {
            file[i] = file[i].replaceAll("GESCHW", speed);
            file[i] = file[i].replaceAll("TAG", day);
            file[i] = file[i].replaceAll("BGFARBE", farbe);
            file[i] = file[i].replaceAll("VERTRETUNGEN", classes);
        }

        Writer writer1 = new Writer("heute.html");

        Writer writer2 = new Writer("morgen.html");
        writer2.writeAll(file);

        Writer writer3 = new Writer("laufschrift.html");

        Writer writer4 = new Writer("beide.html");

        String[] dest = Settings.giveMultiple("destPath");
        for(String s : dest)
        {
            writer1.copy(s + "\\");
            writer2.copy(s + "\\");
            writer3.copy(s + "\\");
            writer4.copy(s + "\\");
        }
    }

    public static void generateModt()
    {
        String speed = Integer.toString((int)(Double.parseDouble(Settings.load("motdSpeed")) / 100.0 * 15.0));
        String text = Settings.load("motdText");
        String farbe = Settings.load("color" + Settings.load("colorMotd"));

        if(speed.equals("") || text.equals("") || farbe.equals(""))
        {
            Logger.log("Eine Einstellung wurde noch nicht gemacht - Plan kann nicht generiert werden!", 2);
            return;
        }

        Reader reader = new Reader("TEMPLATE laufschrift.html");

        String[] file = reader.readAll();

        for(int i = 0; i < file.length; i++)
        {
            file[i] = file[i].replaceAll("GESCHW", speed);
            file[i] = file[i].replaceAll("TEXT", text);
            file[i] = file[i].replaceAll("BGFARBE", farbe);
        }

        Writer writer1 = new Writer("heute.html");

        Writer writer2 = new Writer("morgen.html");

        Writer writer3 = new Writer("laufschrift.html");
        writer3.writeAll(file);

        Writer writer4 = new Writer("beide.html");

        String[] dest = Settings.giveMultiple("destPath");
        for(String s : dest)
        {
            writer1.copy(s + "\\");
            writer2.copy(s + "\\");
            writer3.copy(s + "\\");
            writer4.copy(s + "\\");
        }
    }
}
