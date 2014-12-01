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
        String s = "'<br/><br/><br/>KEINE VERTRETUNGEN'+\n";
        for(SchoolClass sc : schoolClasses)
        {
            Settings.logging(false);
            boolean show = false;
            for(Entry e : sc.getEntrys())
                if(e.isNextEqual())
                    show = isAfter(Integer.valueOf(Settings.load("lesson" + (e.getHour() + 1)).split(":")[0]),
                                   Integer.valueOf(Settings.load("lesson" + (e.getHour() + 1)).split(":")[1]),
                                   Time.hour(),
                                   Time.minute());
                else
                    show = isAfter(Integer.valueOf(Settings.load("lesson" + e.getHour()).split(":")[0]),
                                   Integer.valueOf(Settings.load("lesson" + e.getHour()).split(":")[1]),
                                   Time.hour(),
                                   Time.minute());
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
                     + "'                <td rowspan=\"" + (sc.getEntrys().size() + 1) + "\" valign=\"top\"><div class=\"stufe\">" + sc.getName() + "</div></td>'+\n"
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
                    if(e.isNextEqual())
                        show = isAfter(Integer.valueOf(Settings.load("lesson" + (e.getHour() + 1)).split(":")[0]),
                                       Integer.valueOf(Settings.load("lesson" + (e.getHour() + 1)).split(":")[1]),
                                       Time.hour(),
                                       Time.minute());
                    else
                        show = isAfter(Integer.valueOf(Settings.load("lesson" + e.getHour()).split(":")[0]),
                                       Integer.valueOf(Settings.load("lesson" + e.getHour()).split(":")[1]),
                                       Time.hour(),
                                       Time.minute());
                    Settings.logging(true);

                    if(show)
                    {
                        s += "'            <tr class=\"" + e.getContent()[2].replaceAll("\\.", "") + "\">'+\n";
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

    public static boolean isAfter(int afterHour, int afterMinute, int beforeHour, int beforeMinute)
    {
        boolean b = false;

        if(beforeHour == afterHour)
            if(beforeMinute <= afterMinute)
                b = true;

        if(beforeHour < afterHour)
            b = true;

        return b;
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

    public static void generateStyle()
    {
        String datum1 = Settings.load("überschriftFontStyle") + " " + Settings.load("überschriftFontSize") + "px " + Settings.load("überschriftFontFamily");
        String datum2 = Settings.load("color" + Settings.load("überschriftFontColor"));
        String stufe1 = Settings.load("stufennameFontStyle") + " " + Settings.load("stufennameFontSize") + "px " + Settings.load("stufennameFontFamily");
        String stufe2 = Settings.load("color" + Settings.load("stufennameFontColor"));
        String tabelle1 = Settings.load("tabelleFontStyle") + " " + Settings.load("tabelleFontSize") + "px " + Settings.load("tabelleFontFamily");
        String tabelle2 = Settings.load("color" + Settings.load("tabelleFontColor"));
        String schrift1 = Settings.load("laufschriftFontStyle") + " " + Settings.load("laufschriftFontSize") + "px " + Settings.load("laufschriftFontFamily");
        String schrift2 = Settings.load("color" + Settings.load("laufschriftFontColor"));
        String plan = Settings.load("color" + Settings.load("planColor"));
        String schrift = Settings.load("color" + Settings.load("motdColor"));
        String tabelle = Settings.load("color" + Settings.load("tableColor"));
        String frame = Settings.load("color" + Settings.load("borderColor"));

        String[] setting = Settings.loadNames("art");
        ArrayList<String> variants = new ArrayList<String>();
        for(String s : setting)
            if(s.contains("FontColor"))
                variants.add(s.substring(0, s.indexOf("FontColor")));

        String other = "";
        for(String s : variants)
        {
            other += "\n.stufeTab ." + s.substring(3)
                     + "{"
                     + "  font: " + Settings.load(s + "FontStyle") + " " + Settings.load(s + "FontSize") + "px " + Settings.load(s + "FontFamily") + ";"
                     + "  color: " + Settings.load("color" + Settings.load(s + "FontColor")) + ";"
                     + "  background-color: " + Settings.load("color" + Settings.load(s + "BackColor")) + ";"
                     + "}";

            if(Settings.load(s + "FontSize").equals("") || Settings.load(s + "FontFamily").equals("")
               || Settings.load("color" + Settings.load(s + "FontColor")).equals("")
               || Settings.load("color" + Settings.load(s + "BackColor")).equals(""))
            {
                Logger.log("Eine Einstellung wurde noch nicht gemacht - Style kann nicht generiert werden!", 2);
                return;
            }
        }

        if(datum1.equals("") || datum2.equals("") || stufe1.equals("") || stufe2.equals("")
           || tabelle1.equals("") || tabelle2.equals("") || schrift1.equals("") || schrift2.equals("")
           || plan.equals("") || schrift.equals("") || tabelle.equals("") || frame.equals("")
           || other.equals(""))
        {
            Logger.log("Eine Einstellung wurde noch nicht gemacht - Style kann nicht generiert werden!", 2);
            return;
        }

        FileReader reader = new FileReader("Data/", "TEMPLATE style.css");
        FileWriter writer = new FileWriter("Data/", "style.css");

        String[] file = reader.readAll();
        for(int i = 0; i < file.length; i++)
        {
            file[i] = file[i].replaceAll("DATUM1", datum1);
            file[i] = file[i].replaceAll("DATUM2", datum2);
            file[i] = file[i].replaceAll("STUFE1", stufe1);
            file[i] = file[i].replaceAll("STUFE2", stufe2);
            file[i] = file[i].replaceAll("TABELLE1", tabelle1);
            file[i] = file[i].replaceAll("TABELLE2", tabelle2);
            file[i] = file[i].replaceAll("SCHRIFT1", schrift1);
            file[i] = file[i].replaceAll("SCHRIFT2", schrift2);
            file[i] = file[i].replaceAll("PLAN", plan);
            file[i] = file[i].replaceAll("SCHRIFT", schrift);
            file[i] = file[i].replaceAll("TABELLE", tabelle);
            file[i] = file[i].replaceAll("FRAME", frame);
            file[i] = file[i].replaceAll("OTHER", other);
        }
        writer.writeAll(file);
    }

    public static void generatePlanToday(SchoolClass[] schoolClasses, int start, int end)
    {
        int part = end - start;
        String day = generateDay(true);
        Logger.setProgress(start + 1 * (part / 6));
        String speed = Integer.toString((int)((1.0 / (Double.parseDouble(Settings.load("planSpeed")) / 100.0)) * 12.0));
        Logger.setProgress(start + 2 * (part / 6));
        String classes = generateClasses(schoolClasses);
        Logger.setProgress(start + 3 * (part / 6));

        if(day.equals("") || speed.equals("") || classes.equals(""))
        {
            Logger.log("Eine Einstellung wurde noch nicht gemacht - Plan kann nicht generiert werden!", 2);
            return;
        }

        FileReader reader = new FileReader("Data/", "TEMPLATE heute morgen.html");
        FileWriter writer = new FileWriter("Data/", "heute.html");
        Logger.setProgress(start + 4 * (part / 6));

        String[] file = reader.readAll();
        Logger.setProgress(start + 5 * (part / 6));
        for(int i = 0; i < file.length; i++)
        {
            file[i] = file[i].replaceAll("GESCHW", speed);
            file[i] = file[i].replaceAll("TAG", day);
            file[i] = file[i].replaceAll("VERTRETUNGEN", classes);
        }
        writer.writeAll(file);
        Logger.setProgress(start + 6 * (part / 6));

        Logger.log("Plan von heute wurde generiert", 0);
    }

    public static void generatePlanTomorrow(SchoolClass[] schoolClasses, int start, int end)
    {
        int part = end - start;
        String day = generateDay(false);
        Logger.setProgress(start + 1 * (part / 6));
        String speed = Integer.toString((int)((1.0 / (Double.parseDouble(Settings.load("planSpeed")) / 100.0)) * 12.0));
        Logger.setProgress(start + 2 * (part / 6));
        String classes = generateClasses(schoolClasses);
        Logger.setProgress(start + 3 * (part / 6));

        if(day.equals("") || speed.equals("") || classes.equals(""))
        {
            Logger.log("Eine Einstellung wurde noch nicht gemacht - Plan kann nicht generiert werden!", 2);
            return;
        }

        FileReader reader = new FileReader("Data/", "TEMPLATE heute morgen.html");
        FileWriter writer = new FileWriter("Data/", "morgen.html");
        Logger.setProgress(start + 4 * (part / 6));

        String[] file = reader.readAll();
        Logger.setProgress(start + 5 * (part / 6));
        for(int i = 0; i < file.length; i++)
        {
            file[i] = file[i].replaceAll("GESCHW", speed);
            file[i] = file[i].replaceAll("TAG", day);
            file[i] = file[i].replaceAll("VERTRETUNGEN", classes);
        }
        writer.writeAll(file);
        Logger.setProgress(start + 6 * (part / 6));

        Logger.log("Plan von morgen wurde generiert", 0);
    }

    public static void generateModt(int start, int end)
    {
        int part = end - start;
        String speed = Integer.toString((int)(Double.parseDouble(Settings.load("motdSpeed")) / 100.0 * 15.0));
        Logger.setProgress(start + 1 * (part / 5));
        String text = Settings.load("motdText");
        Logger.setProgress(start + 2 * (part / 5));

        if(speed.equals("") || text.equals(""))
        {
            Logger.log("Eine Einstellung wurde noch nicht gemacht - Plan kann nicht generiert werden!", 2);
            return;
        }

        FileReader reader = new FileReader("Data/", "TEMPLATE laufschrift.html");
        FileWriter writer = new FileWriter("Data/", "laufschrift.html");
        Logger.setProgress(start + 3 * (part / 5));

        String[] file = reader.readAll();
        Logger.setProgress(start + 4 * (part / 5));
        for(int i = 0; i < file.length; i++)
        {
            file[i] = file[i].replaceAll("GESCHW", speed);
            file[i] = file[i].replaceAll("TEXT", text);
        }
        writer.writeAll(file);
        Logger.setProgress(start + 5 * (part / 5));

        Logger.log("Laufschrift wurde generiert", 0);
    }
}
