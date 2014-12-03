package com.facharbeit.io;

import com.facharbeit.tools.*;
import java.util.*;

public class HtmlWriter
{
    public static void generatePlanToday(SchoolClass[] schoolClasses, int start, int end)
    {
        int part = end - start;
        String day = generateDay(true);
        Logger.setProgress(start + 1 * (part / 6));
        String speed = Integer.toString((int)((1.0 / (Double.parseDouble(Settings.load("planSpeed")) / 100.0)) * 12.0));
        Logger.setProgress(start + 2 * (part / 6));
        String classes = generateClasses(schoolClasses);
        Logger.setProgress(start + 3 * (part / 6));

        if(!validate(day, speed, classes))
            return;

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

        if(!validate(day, speed, classes))
            return;

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

        if(!validate(speed, text))
            return;

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
                     + "\n{"
                     + "\n  font: " + Settings.load(s + "FontStyle") + " " + Settings.load(s + "FontSize") + "px " + Settings.load(s + "FontFamily") + ";"
                     + "\n  color: " + Settings.load("color" + Settings.load(s + "FontColor")) + ";"
                     + "\n  background-color: " + Settings.load("color" + Settings.load(s + "BackColor")) + ";"
                     + "\n}";

            if(!validate(Settings.load(s + "FontSize"), Settings.load(s + "FontFamily"),
                         Settings.load("color" + Settings.load(s + "FontColor")),
                         Settings.load("color" + Settings.load(s + "BackColor"))))
                return;
        }

        if(!validate(datum1, datum2, stufe1, stufe2, tabelle1, tabelle2, schrift1, schrift2, plan, schrift, tabelle, frame))
            return;

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

        Logger.log("Style wurde generiert", 0);
    }

    private static String generateClasses(SchoolClass[] schoolClasses)
    {
        String s = "";
        for(SchoolClass sc : schoolClasses)
        {
            if(Settings.load("lessonUse").equals("true"))
                sc.cutLessons();

            String[] or = Settings.load("lessonOrder").split(",");
            sc.sortEntrys(Integer.parseInt(or[0]),
                          Integer.parseInt(or[1]),
                          Integer.parseInt(or[2]),
                          Integer.parseInt(or[3]),
                          Integer.parseInt(or[4]),
                          Integer.parseInt(or[5]),
                          Integer.parseInt(or[6]));

            s += sc.toString();
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

    private static boolean validate(String... test)
    {
        boolean valid = true;
        for(String s : test)
            if(s.equals(""))
            {
                valid = false;
                break;
            }

        if(!valid)
            Logger.log("Eine Einstellung wurde noch nicht gemacht - Konnte nicht generieren!", 2);

        return valid;
    }
}
