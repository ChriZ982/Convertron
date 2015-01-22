package com.facharbeit.io;

import com.facharbeit.tools.*;
import java.util.*;

/**
 * Generiert die HTML-Dateien.
 */
public class HtmlWriter
{
    /**
     * Name der Spalten in die geschreiben werden soll. Editieren, falls andere Namen. Reihenfolge:
     * Stufe, Datum, Wochentag, Vertreter, Raum, Art, Fach, Lehrer, Verl. von, Hinweise
     */
    static String[] sqlColumms =
    {
        "Stufe", "Datum", "Wochentag", "Vertreter", "Raum", "Art", "Fach", "Lehrer", "Verl. von", "Hinweise"
    };

    /**
     * Generiert den heutigen Plan.
     *
     * @param schoolClasses Schulklassen für heute
     * @param start         Startprozente
     * @param end           Endprozente
     */
    public static void today(SchoolClass[] schoolClasses, int start, int end)
    {
        try
        {
            int part = end - start;
            String day = head(schoolClasses);
            Logger.setProgress(start + 1 * (part / 6));
            String speed = "";
            if(Settings.line("planSpeed") != -1)
                speed = Integer.toString((int)((1.0 / (Double.parseDouble(Settings.load("planSpeed")) / 100.0)) * 12.0));
            Logger.setProgress(start + 2 * (part / 6));
            String classes = classes(cut(schoolClasses));
            Logger.setProgress(start + 3 * (part / 6));

            if(!validate(day, speed))
                return;

            FileHandler reader = new FileHandler("Data/TEMPLATE heute morgen.html");
            FileHandler writer = new FileHandler("Data/heute.html");
            Logger.setProgress(start + 4 * (part / 6));

            String[] file = reader.read();
            Logger.setProgress(start + 5 * (part / 6));
            for(int i = 0; i < file.length; i++)
            {
                file[i] = file[i].replaceAll("GESCHW", speed);
                file[i] = file[i].replaceAll("TAG", day);
                file[i] = file[i].replaceAll("VERTRETUNGEN", classes);
            }
            writer.write(file);
            Logger.setProgress(start + 6 * (part / 6));

            Logger.log("Plan von heute wurde generiert", 0);
        }
        catch(Exception ex)
        {
            Logger.log("Plan von heute konnte nicht generiert werden", 2);
            Logger.error(ex);
        }
    }

    /**
     * Generiert den morgigen Plan.
     *
     * @param schoolClasses Schulklassen für morgen
     * @param start         Startprozente
     * @param end           Endprozente
     */
    public static void tomorrow(SchoolClass[] schoolClasses, int start, int end)
    {
        try
        {
            int part = end - start;
            String day = head(schoolClasses);
            Logger.setProgress(start + 1 * (part / 6));
            String speed = "";
            if(Settings.line("planSpeed") != -1)
                speed = Integer.toString((int)((1.0 / (Double.parseDouble(Settings.load("planSpeed")) / 100.0)) * 12.0));
            Logger.setProgress(start + 2 * (part / 6));
            String classes = classes(schoolClasses);
            Logger.setProgress(start + 3 * (part / 6));

            if(!validate(day, speed))
                return;

            FileHandler reader = new FileHandler("Data/TEMPLATE heute morgen.html");
            FileHandler writer = new FileHandler("Data/morgen.html");
            Logger.setProgress(start + 4 * (part / 6));

            String[] file = reader.read();
            Logger.setProgress(start + 5 * (part / 6));
            for(int i = 0; i < file.length; i++)
            {
                file[i] = file[i].replaceAll("GESCHW", speed);
                file[i] = file[i].replaceAll("TAG", day);
                file[i] = file[i].replaceAll("VERTRETUNGEN", classes);
            }
            writer.write(file);
            Logger.setProgress(start + 6 * (part / 6));

            Logger.log("Plan von morgen wurde generiert", 0);
        }
        catch(Exception ex)
        {
            Logger.log("Plan von morgen konnte nicht generiert werden", 2);
            Logger.error(ex);
        }
    }

    /**
     * Generiert die Laufschrift.
     *
     * @param start Startprozente
     * @param end   Endprozente
     */
    public static void motd(int start, int end)
    {
        try
        {
            int part = end - start;
            String speed = "";
            if(Settings.line("motdSpeed") != -1)
                speed = Integer.toString((int)(Double.parseDouble(Settings.load("motdSpeed")) / 100.0 * 15.0));
            Logger.setProgress(start + 1 * (part / 5));
            String text = Settings.load("motdText");
            Logger.setProgress(start + 2 * (part / 5));

            if(!validate(speed, text))
                return;

            if(text.equals("Laufschrift"))
                if(!validate(""))
                    return;

            FileHandler reader = new FileHandler("Data/TEMPLATE laufschrift.html");
            FileHandler writer = new FileHandler("Data/laufschrift.html");
            Logger.setProgress(start + 3 * (part / 5));

            String[] file = reader.read();
            Logger.setProgress(start + 4 * (part / 5));
            for(int i = 0; i < file.length; i++)
            {
                file[i] = file[i].replaceAll("GESCHW", speed);
                file[i] = file[i].replaceAll("TEXT", text);
            }
            writer.write(file);
            Logger.setProgress(start + 5 * (part / 5));

            Logger.log("Laufschrift wurde generiert", 0);
        }
        catch(Exception ex)
        {
            Logger.log("Laufschrift konnte nicht generiert werden", 2);
            Logger.error(ex);
        }
    }

    /**
     * Generiert die Style-Datei der Seite.
     */
    public static void style()
    {
        try
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

            String[] settings = Settings.loadNames("art");
            ArrayList<String> variants = new ArrayList<String>();
            for(String setting : settings)
                if(setting.contains("FontColor"))
                    variants.add(setting.substring(0, setting.indexOf("FontColor")));

            String other = "";
            for(String variant : variants)
            {
                other += "\n.stufeTab ." + variant.substring(3)
                         + "\n{"
                         + "\n  font: " + Settings.load(variant + "FontStyle") + " " + Settings.load(variant + "FontSize") + "px " + Settings.load(variant + "FontFamily") + ";"
                         + "\n  color: " + Settings.load("color" + Settings.load(variant + "FontColor")) + ";"
                         + "\n  background-color: " + Settings.load("color" + Settings.load(variant + "BackColor")) + ";"
                         + "\n}";

                if(!validate(Settings.load(variant + "FontSize"), Settings.load(variant + "FontFamily"),
                             Settings.load("color" + Settings.load(variant + "FontColor")),
                             Settings.load("color" + Settings.load(variant + "BackColor"))))
                    return;
            }

            if(!validate(datum1, datum2, stufe1, stufe2, tabelle1, tabelle2, schrift1, schrift2, plan, schrift, tabelle, frame))
                return;

            FileHandler reader = new FileHandler("Data/TEMPLATE style.css");
            FileHandler writer = new FileHandler("Data/style.css");

            String[] file = reader.read();
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
            writer.write(file);

            Logger.log("Style wurde generiert", 0);
        }
        catch(Exception ex)
        {
            Logger.log("Style konnte nicht generiert werden", 2);
            Logger.error(ex);
        }
    }

    /**
     * Schreibt in Datenbank.
     */
    public static void sql()
    {
        try
        {
            SchoolClass[] scs = HtmlReader.forSql();
            SqlTableWriter write = new SqlTableWriter(PathConverter.convert(Settings.load("sqlHost")),
                                                      Integer.parseInt(Settings.load("sqlPort")),
                                                      PathConverter.convert(Settings.load("sqlName")),
                                                      Settings.load("sqlUser"),
                                                      Settings.load("sqlPassw"),
                                                      PathConverter.convert(Settings.load("sqlTableName")),
                                                      sqlColumms);

            if(Settings.load("sqlMode").equals("löschen und schreiben"))
                write.clear();

            ArrayList<String[]> forSql = new ArrayList<>();
            for(SchoolClass sc : scs)
                for(Entry e : sc.getEntries())
                {
                    String[] line = new String[e.getImportantContent().length + 2];
                    line[0] = sc.getName();
                    line[1] = e.getDate();
                    for(int i = 3; i < line.length; i++)
                        line[i] = e.getImportantContent()[i - 3];
                    forSql.add(line);
                }

            write.addAll(forSql);

        }
        catch(Exception ex)
        {
            Logger.log("Datenbank konnte nicht aktualisiert werden", 2);
            Logger.error(ex);
        }
        Logger.setProgress(0);
    }

    /**
     * Formatiert die Schulklassen.
     *
     * @param schoolClasses Zu formatierende Schulklassen
     *
     * @return Formatierte Schulklassen als String
     */
    private static String classes(SchoolClass[] schoolClasses)
    {
        try
        {
            if(schoolClasses == null)
                return "'<b>Keine Vertretungen</b><br /><br />'+";

            String s = "";
            for(SchoolClass schoolClass : schoolClasses)
            {
                String[] or = Settings.load("lessonOrder").split(",");
                schoolClass.sort(Integer.parseInt(or[0]),
                                 Integer.parseInt(or[1]),
                                 Integer.parseInt(or[2]),
                                 Integer.parseInt(or[3]),
                                 Integer.parseInt(or[4]),
                                 Integer.parseInt(or[5]),
                                 Integer.parseInt(or[6]));
                s += schoolClass.toString();
            }
            if(s.equals(""))
                return "'<b>Keine Vertretungen</b><br /><br />'+";
            return s;
        }
        catch(Exception ex)
        {
            Logger.log("Schulklassen konnten nicht formatiert werden", 2);
            Logger.error(ex);
            return null;
        }
    }

    /**
     * Schneidet die vergangenen Stunden falls nötig ab.
     *
     * @param scs Das zu bearbeitende Array
     *
     * @return Das bearbeitete Array
     */
    private static SchoolClass[] cut(SchoolClass[] scs)
    {
        try
        {
            if(Settings.load("lessonUse").equals("true"))
                if(scs != null && scs.length > 0)
                    for(SchoolClass sc : scs)
                        sc.cut();

        }
        catch(Exception ex)
        {
            Logger.log("Stunden im gesamten Array konnten nicht gelöscht werden", 2);
            Logger.error(ex);
        }
        return scs;
    }

    /**
     * Generiert den Kopf der Seite.
     *
     * @param schoolClasses Schulklassen die verwendet werden
     *
     * @return Kopf der Seite
     */
    private static String head(SchoolClass[] schoolClasses)
    {
        try
        {
            if(schoolClasses == null)
                return "Keine Vertretungen";
            return Time.htmlWriting(schoolClasses[0].getCurDate());
        }
        catch(Exception ex)
        {
            Logger.log("Konnte den Kopf der Seite nicht generieren", 2);
            Logger.error(ex);
            return null;
        }
    }

    /**
     * Bestätigt die Texte, die verwendet werden sollen.
     *
     * @param test Zu bestätigende Strings
     *
     * @return Sind die Strings verwendbar?
     */
    private static boolean validate(String... test)
    {
        try
        {
            for(String s : test)
                if(s.equals(""))
                {
                    Logger.log("Eine Einstellung wurde noch nicht gemacht - Konnte nicht generieren!", 2);
                    return false;
                }
            return true;
        }
        catch(Exception ex)
        {
            Logger.log("Einstellungen konnten nicht bestätigt werden", 2);
            Logger.error(ex);
            return false;
        }
    }
}
