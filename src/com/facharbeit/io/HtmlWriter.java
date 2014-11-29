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
        String s = "'<br/><br/><br/>KEINE VERTRETUNGEN'+\n";
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
                if(s.equals("'<br/><br/><br/>KEINE VERTRETUNGEN'+\n"))
                    s = "";

                s += "'        <br/>'+\n"
                     + "''+\n"
                     + "'        <table class=\"stufeTab\" rules=\"all\">'+\n"
                     + "'            <colgroup>'+\n"
                     + "'                <col width=\"7%\">'+\n"
                     + "'                <col width=\"6%\">'+\n"
                     + "'                <col width=\"10%\">'+\n"
                     + "'                <col width=\"10%\">'+\n"
                     + "'                <col width=\"12%\">'+\n"
                     + "'                <col width=\"7%\">'+\n"
                     + "'                <col width=\"10%\">'+\n"
                     + "'                <col width=\"10%\">'+\n"
                     + "'                <col width=\"28%\">'+\n"
                     + "'            </colgroup>'+\n"
                     + "'            <tr >'+\n"
                     + "'                <td rowspan=\"" + (sc.getEntrys().size() + 1) + "\" valign=\"top\"><div class=\"stufe\"><b>" + sc.getName() + "</b></div></td>'+\n"
                     + "'                <td>Std</td>'+\n"
                     + "'                <td>Vertreter</td>'+\n"
                     + "'                <td>Raum</td>'+\n"
                     + "'                <td>Art</td>'+\n"
                     + "'                <td>Fach</td>'+\n"
                     + "'                <td>Lehrer</td>'+\n"
                     + "'                <td>Verl. von</td>'+\n"
                     + "'                <td>Hinweise</td>'+\n"
                     + "'            </tr>'+\n";

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
                        s += "'            <tr >'+\n";

                        if(e.isNextEqual())
                            s += "'                <td>" + e.getHour() + "-" + (e.getHour() + 1) + "</td>'+\n";
                        else
                            s += "'                <td>" + e.getHour() + "</td>'+\n";

                        s += "'                <td>" + e.getContent()[0] + "</td>'+\n"
                             + "'                <td>" + e.getContent()[1] + "</td>'+\n"
                             + "'                <td>" + e.getContent()[2] + "</td>'+\n"
                             + "'                <td>" + e.getContent()[3] + "</td>'+\n"
                             + "'                <td>" + e.getContent()[4] + "</td>'+\n"
                             + "'                <td>" + e.getContent()[5] + "</td>'+\n"
                             + "'                <td>" + e.getContent()[6] + "</td>'+\n"
                             + "'            </tr>'+\n";
                    }
                }

                s += "'        </table>'+";
            }
        }

        return s;
    }

    private static String generateDay(boolean today)
    {
        String s;
        if(today)
            s = HtmlReader.readHeadToday();
        else
            s = HtmlReader.readHeadTomorrow();
        return s.substring(s.indexOf("Vertretungen  ") + "Vertretungen  ".length()) + Time.forHtmlWriting();
    }

    public static void generatePlanToday(SchoolClass[] schoolClasses, int start, int end)
    {
        int part = end - start;
        String day = generateDay(true);
        Logger.setProgress(start + 1 * (part / 7));
        String speed = Integer.toString((int)((1.0 / (Double.parseDouble(Settings.load("planSpeed")) / 100.0)) * 12.0));
        Logger.setProgress(start + 2 * (part / 7));
        String farbe = Settings.load("color" + Settings.load("colorPlan"));
        Logger.setProgress(start + 3 * (part / 7));
        String classes = generateClasses(schoolClasses);
        Logger.setProgress(start + 4 * (part / 7));

        if(day.equals("") || speed.equals("") || farbe.equals("") || classes.equals(""))
        {
            Logger.log("Eine Einstellung wurde noch nicht gemacht - Plan kann nicht generiert werden!", 2);
            return;
        }

        FileReader reader = new FileReader("Data/", "TEMPLATE heute morgen.html");
        FileWriter writer = new FileWriter("Data/", "heute.html");
        Logger.setProgress(start + 5 * (part / 7));

        String[] file = reader.readAll();
        Logger.setProgress(start + 6 * (part / 7));
        for(int i = 0; i < file.length; i++)
        {
            file[i] = file[i].replaceAll("GESCHW", speed);
            file[i] = file[i].replaceAll("TAG", day);
            file[i] = file[i].replaceAll("BGFARBE", farbe);
            file[i] = file[i].replaceAll("VERTRETUNGEN", classes);
        }
        writer.writeAll(file);
        Logger.setProgress(start + 7 * (part / 7));

        Logger.log("Plan von heute wurde generiert", 0);
    }

    public static void generatePlanTomorrow(SchoolClass[] schoolClasses, int start, int end)
    {
        int part = end - start;
        String day = generateDay(false);
        Logger.setProgress(start + 1 * (part / 7));
        String speed = Integer.toString((int)((1.0 / (Double.parseDouble(Settings.load("planSpeed")) / 100.0)) * 12.0));
        Logger.setProgress(start + 2 * (part / 7));
        String farbe = Settings.load("color" + Settings.load("colorPlan"));
        Logger.setProgress(start + 3 * (part / 7));
        String classes = generateClasses(schoolClasses);
        Logger.setProgress(start + 4 * (part / 7));

        if(day.equals("") || speed.equals("") || farbe.equals("") || classes.equals(""))
        {
            Logger.log("Eine Einstellung wurde noch nicht gemacht - Plan kann nicht generiert werden!", 2);
            return;
        }

        FileReader reader = new FileReader("Data/", "TEMPLATE heute morgen.html");
        FileWriter writer = new FileWriter("Data/", "morgen.html");
        Logger.setProgress(start + 5 * (part / 7));

        String[] file = reader.readAll();
        Logger.setProgress(start + 6 * (part / 7));
        for(int i = 0; i < file.length; i++)
        {
            file[i] = file[i].replaceAll("GESCHW", speed);
            file[i] = file[i].replaceAll("TAG", day);
            file[i] = file[i].replaceAll("BGFARBE", farbe);
            file[i] = file[i].replaceAll("VERTRETUNGEN", classes);
        }
        writer.writeAll(file);
        Logger.setProgress(start + 7 * (part / 7));

        Logger.log("Plan von morgen wurde generiert", 0);
    }

    public static void generateModt(int start, int end)
    {
        int part = end - start;
        String speed = Integer.toString((int)(Double.parseDouble(Settings.load("motdSpeed")) / 100.0 * 15.0));
        Logger.setProgress(start + 1 * (part / 6));
        String text = Settings.load("motdText");
        Logger.setProgress(start + 2 * (part / 6));
        String farbe = Settings.load("color" + Settings.load("colorMotd"));
        Logger.setProgress(start + 3 * (part / 6));

        if(speed.equals("") || text.equals("") || farbe.equals(""))
        {
            Logger.log("Eine Einstellung wurde noch nicht gemacht - Plan kann nicht generiert werden!", 2);
            return;
        }

        FileReader reader = new FileReader("Data/", "TEMPLATE laufschrift.html");
        FileWriter writer = new FileWriter("Data/", "laufschrift.html");
        Logger.setProgress(start + 4 * (part / 6));

        String[] file = reader.readAll();
        Logger.setProgress(start + 5 * (part / 6));
        for(int i = 0; i < file.length; i++)
        {
            file[i] = file[i].replaceAll("GESCHW", speed);
            file[i] = file[i].replaceAll("TEXT", text);
            file[i] = file[i].replaceAll("BGFARBE", farbe);
        }
        writer.writeAll(file);
        Logger.setProgress(start + 6 * (part / 6));

        Logger.log("Laufschrift wurde generiert", 0);
    }
}
