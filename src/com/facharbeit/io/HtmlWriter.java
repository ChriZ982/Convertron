/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facharbeit.io;

import com.facharbeit.tools.*;

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
                    show = isAfter(Integer.valueOf(Settings.load("cutLesson" + (e.getHour() + 1)).split(":")[0]),
                                   Integer.valueOf(Settings.load("cutLesson" + (e.getHour() + 1)).split(":")[1]),
                                   Time.hour(),
                                   Time.minute());
                else
                    show = isAfter(Integer.valueOf(Settings.load("cutLesson" + e.getHour()).split(":")[0]),
                                   Integer.valueOf(Settings.load("cutLesson" + e.getHour()).split(":")[1]),
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
                        show = isAfter(Integer.valueOf(Settings.load("cutLesson" + (e.getHour() + 1)).split(":")[0]),
                                       Integer.valueOf(Settings.load("cutLesson" + (e.getHour() + 1)).split(":")[1]),
                                       Time.hour(),
                                       Time.minute());
                    else
                        show = isAfter(Integer.valueOf(Settings.load("cutLesson" + e.getHour()).split(":")[0]),
                                       Integer.valueOf(Settings.load("cutLesson" + e.getHour()).split(":")[1]),
                                       Time.hour(),
                                       Time.minute());
                    Settings.logging(true);

                    if(show)
                    {
                        if(e.getContent()[2].equals("Raum-Vtr."))
                            s += "'            <tr class=\"one\">'+\n";
                        else
                            s += "'            <tr class=\"two\">'+\n";

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
        String datumtype = Settings.load("typeDatum");
        String datumsize = Settings.load("sizeDatum");
        String datumfamily = Settings.load("familyDatum");
        String planfarbe = Settings.load(Settings.load("colorPlan"));
        String schriftfarbe = Settings.load(Settings.load("colorMotd"));
        String stufetype = Settings.load("typeStufe");
        String stufesize = Settings.load("sizeStufe");
        String stufefamily = Settings.load("familyStufe");
        String tabelletype = Settings.load("typeTabelle");
        String tabellesize = Settings.load("sizeTabelle");
        String tabellefamily = Settings.load("familyTabelle");
        String tabelleborder = Settings.load("borderTabelle");
        String tabellefarbe = Settings.load(Settings.load("colorTable"));
        String tabellevertrfarbe = Settings.load(Settings.load("colorTableVertr"));
        String tabelleanderefarbe = Settings.load(Settings.load("colorTableOther"));
        String schrifttype = Settings.load("typeMotd");
        String schriftsize = Settings.load("sizeMotd");
        String schriftfamily = Settings.load("familyMotd");
        String framefarbe = Settings.load(Settings.load("colorFrame"));

        if(datumtype.equals("") || datumsize.equals("") || datumfamily.equals("") || planfarbe.equals("")
           || schriftfarbe.equals("") || stufetype.equals("") || stufesize.equals("") || stufefamily.equals("")
           || tabelletype.equals("") || tabellesize.equals("") || tabellefamily.equals("") || tabelleborder.equals("")
           || tabellefarbe.equals("") || tabellevertrfarbe.equals("") || tabelleanderefarbe.equals("") || schrifttype.equals("")
           || schriftsize.equals("") || schriftfamily.equals("") || framefarbe.equals(""))
        {
            Logger.log("Eine Einstellung wurde noch nicht gemacht - Style kann nicht generiert werden!", 2);
            return;
        }

        FileReader reader = new FileReader("Data/", "TEMPLATE style.css");
        FileWriter writer = new FileWriter("Data/", "style.css");

        String[] file = reader.readAll();
        for(int i = 0; i < file.length; i++)
        {
            file[i] = file[i].replaceAll("DATUMTYPE", datumtype);
            file[i] = file[i].replaceAll("DATUMSIZE", datumsize);
            file[i] = file[i].replaceAll("DATUMFAMILY", datumfamily);
            file[i] = file[i].replaceAll("PLANFARBE", planfarbe);
            file[i] = file[i].replaceAll("SCHRIFTFARBE", schriftfarbe);
            file[i] = file[i].replaceAll("STUFETYPE", stufetype);
            file[i] = file[i].replaceAll("STUFESIZE", stufesize);
            file[i] = file[i].replaceAll("STUFEFAMILY", stufefamily);
            file[i] = file[i].replaceAll("TABELLETYPE", tabelletype);
            file[i] = file[i].replaceAll("TABELLESIZE", tabellesize);
            file[i] = file[i].replaceAll("TABELLEFAMILY", tabellefamily);
            file[i] = file[i].replaceAll("TABELLEBORDER", tabelleborder);
            file[i] = file[i].replaceAll("TABELLEFARBE", tabellefarbe);
            file[i] = file[i].replaceAll("TABELLEVERTRFARBE", tabellevertrfarbe);
            file[i] = file[i].replaceAll("TABELLEANDEREFARBE", tabelleanderefarbe);
            file[i] = file[i].replaceAll("SCHRIFTTYPE", schrifttype);
            file[i] = file[i].replaceAll("SCHRIFTSIZE", schriftsize);
            file[i] = file[i].replaceAll("SCHRIFTFAMILY", schriftfamily);
            file[i] = file[i].replaceAll("FRAMEFARBE", framefarbe);
        }
        writer.writeAll(file);

        Logger.log("Style wurde generiert", 0);
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
