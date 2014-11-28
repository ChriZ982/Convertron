/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facharbeit.io;

import com.facharbeit.tools.*;
import java.util.*;

public class HtmlWriter
{

    private static String generateClasses(SchoolClass[] schoolClasses)
    {
        Calendar c = Calendar.getInstance();
        String s = "<br/><br/><br/>KEINE VERTRETUNGEN";
        for(SchoolClass sc : schoolClasses)
        {
            Settings.logging(false);
            boolean show = false;
            for(Entry e : sc.getEntrys())
                if(e.isNextEqual())
                {
                    if(c.get(Calendar.HOUR_OF_DAY) == Integer.valueOf(Settings.load("cutLesson" + (e.getHour() + 1)).split(":")[0]))
                        if(c.get(Calendar.MINUTE) <= Integer.valueOf(Settings.load("cutLesson" + (e.getHour() + 1)).split(":")[1]))
                            show = true;

                    if(c.get(Calendar.HOUR_OF_DAY) < Integer.valueOf(Settings.load("cutLesson" + (e.getHour() + 1)).split(":")[0]))
                        show = true;
                } else
                {
                    if(c.get(Calendar.HOUR_OF_DAY) == Integer.valueOf(Settings.load("cutLesson" + e.getHour()).split(":")[0]))
                        if(c.get(Calendar.MINUTE) <= Integer.valueOf(Settings.load("cutLesson" + e.getHour()).split(":")[1]))
                            show = true;

                    if(c.get(Calendar.HOUR_OF_DAY) < Integer.valueOf(Settings.load("cutLesson" + e.getHour()).split(":")[0]))
                        show = true;
                }
            Settings.logging(true);

            if(show)
            {
                if(s.equals("<br/><br/><br/>KEINE VERTRETUNGEN"))
                    s = "";

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
                    Settings.logging(false);
                    show = false;
                    if(e.isNextEqual())
                    {
                        if(c.get(Calendar.HOUR_OF_DAY) == Integer.valueOf(Settings.load("cutLesson" + (e.getHour() + 1)).split(":")[0]))
                            if(c.get(Calendar.MINUTE) <= Integer.valueOf(Settings.load("cutLesson" + (e.getHour() + 1)).split(":")[1]))
                                show = true;

                        if(c.get(Calendar.HOUR_OF_DAY) < Integer.valueOf(Settings.load("cutLesson" + (e.getHour() + 1)).split(":")[0]))
                            show = true;
                    } else
                    {
                        if(c.get(Calendar.HOUR_OF_DAY) == Integer.valueOf(Settings.load("cutLesson" + e.getHour()).split(":")[0]))
                            if(c.get(Calendar.MINUTE) <= Integer.valueOf(Settings.load("cutLesson" + e.getHour()).split(":")[1]))
                                show = true;

                        if(c.get(Calendar.HOUR_OF_DAY) < Integer.valueOf(Settings.load("cutLesson" + e.getHour()).split(":")[0]))
                            show = true;
                    }
                    Settings.logging(true);

                    if(show)
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
                }

                s += "        </table>\n\n";
            }
        }

        return s;
    }

    private static String generateDay(boolean today)
    {
        Calendar c = Calendar.getInstance();

        if(!today)
            c.add(Calendar.DAY_OF_MONTH, 1);

        String s = c.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.GERMANY) + " "
                   + String.format("%02d", c.get(Calendar.DAY_OF_MONTH)) + "."
                   + String.format("%02d", c.get(Calendar.MONTH) + 1) + ". ";

        if(c.get(Calendar.WEEK_OF_YEAR) % 2 == 0)
            s += "B-Woche";
        else
            s += "A-Woche";

        return s;
    }

    public static void generatePlanToday(SchoolClass[] schoolClasses)
    {
        String day = generateDay(true);
        String speed = Integer.toString((int)((1.0 / (Double.parseDouble(Settings.load("planSpeed")) / 100.0)) * 12.0));
        String farbe = Settings.load("color" + Settings.load("colorPlan"));
        String classes = generateClasses(schoolClasses);

        if(day.equals("") || speed.equals("") || farbe.equals("") || classes.equals(""))
        {
            Logger.log("Eine Einstellung wurde noch nicht gemacht - Plan kann nicht generiert werden!", 2);
            return;
        }

        FileReader reader = new FileReader("Data/", "TEMPLATE heute morgen.html");
        FileWriter writer = new FileWriter("Data/", "heute.html");

        String[] file = reader.readAll();
        for(int i = 0; i < file.length; i++)
        {
            file[i] = file[i].replaceAll("GESCHW", speed);
            file[i] = file[i].replaceAll("TAG", day);
            file[i] = file[i].replaceAll("BGFARBE", farbe);
            file[i] = file[i].replaceAll("VERTRETUNGEN", classes);
        }
        writer.writeAll(file);

        Logger.log("Plan von heute wurde generiert", 0);
    }

    public static void generatePlanTomorrow(SchoolClass[] schoolClasses)
    {
        String day = generateDay(false);
        String speed = Integer.toString((int)((1.0 / (Double.parseDouble(Settings.load("planSpeed")) / 100.0)) * 12.0));
        String farbe = Settings.load("color" + Settings.load("colorPlan"));
        String classes = generateClasses(schoolClasses);

        if(day.equals("") || speed.equals("") || farbe.equals("") || classes.equals(""))
        {
            Logger.log("Eine Einstellung wurde noch nicht gemacht - Plan kann nicht generiert werden!", 2);
            return;
        }

        FileReader reader = new FileReader("Data/", "TEMPLATE heute morgen.html");
        FileWriter writer = new FileWriter("Data/", "morgen.html");

        String[] file = reader.readAll();
        for(int i = 0; i < file.length; i++)
        {
            file[i] = file[i].replaceAll("GESCHW", speed);
            file[i] = file[i].replaceAll("TAG", day);
            file[i] = file[i].replaceAll("BGFARBE", farbe);
            file[i] = file[i].replaceAll("VERTRETUNGEN", classes);
        }
        writer.writeAll(file);

        Logger.log("Plan von morgen wurde generiert", 0);
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

        FileReader reader = new FileReader("Data/", "TEMPLATE laufschrift.html");
        FileWriter writer = new FileWriter("Data/", "laufschrift.html");

        String[] file = reader.readAll();
        for(int i = 0; i < file.length; i++)
        {
            file[i] = file[i].replaceAll("GESCHW", speed);
            file[i] = file[i].replaceAll("TEXT", text);
            file[i] = file[i].replaceAll("BGFARBE", farbe);
        }
        writer.writeAll(file);

        Logger.log("Laufschrift wurde generiert", 0);
    }
}
