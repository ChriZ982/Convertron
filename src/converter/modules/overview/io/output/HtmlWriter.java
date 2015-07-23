package converter.modules.overview.io.output;

import converter.data.ClassTMP;
import converter.io.FileTMP;
import converter.io.Settings;
import converter.util.Logger;
import converter.util.Time;
import java.io.*;

/**
 * Generiert die HTML-Dateien.
 */
public class HtmlWriter
{
    /**
     * Name der Spalten in die geschrieben werden soll. Editieren, falls andere Namen. Reihenfolge:
     * Stufe, Datum, Wochentag, Vertreter, Raum, Art, Fach, Lehrer, Verl. von, Hinweise
     */
    static String[] sqlColumms =
    {
        "Stufe", "Datum", "Wochentag", "Vertreter", "Raum", "Art", "Fach", "Lehrer", "Verl. von", "Hinweise"
    };

    /**
     * Generiert den Plan.
     *
     * @param schoolClasses Schulklassen
     * @param type          Heute oder Morgen
     *
     * @throws java.io.UnsupportedEncodingException
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     *
     *
     */
    public static void plan(String type, ClassTMP[] schoolClasses) throws UnsupportedEncodingException, FileNotFoundException, IOException
    {
        if(type.equals("heute"))
            schoolClasses = cut(schoolClasses);
        String day = head(schoolClasses);
        String speed = Integer.toString((int)((1.0 / (Double.parseDouble(Settings.loadArray("speed")[0]) / 100.0)) * 12.0));
        String classes = classes(schoolClasses);
        if(invalid(day, speed))
            return;

        new FileTMP(Settings.load("pathData") + "/" + type + ".html").write(
                new String[]
                {
                    new FileTMP(Settings.load("pathData") + "/TEMPLATE heute morgen.html").asString()
                    .replaceAll("GESCHW", speed)
                    .replaceAll("TAG", day)
                    .replaceAll("VERTRETUNGEN", classes)
                });
        Logger.log("Plan von " + type + " wurde generiert", 0);
    }

    /**
     * Generiert die Laufschrift.
     *
     *
     * @throws java.io.UnsupportedEncodingException
     * @throws java.io.FileNotFoundException
     */
    public static void motd() throws UnsupportedEncodingException, FileNotFoundException, IOException
    {
        String speed = Integer.toString((int)(Double.parseDouble(Settings.loadArray("speed")[1]) / 100.0 * 15.0));
        String text = Settings.load("laufschriftText");
        if(invalid(speed, text))
            return;

        if(text.equals("Laufschrift"))
            text = "";

        new FileTMP(Settings.load("pathData") + "/laufschrift.html").write(
                new String[]
                {
                    new FileTMP(Settings.load("pathData") + "/TEMPLATE laufschrift.html").asString()
                    .replaceAll("GESCHW", speed)
                    .replaceAll("TEXT", text)
                });
        Logger.log("Laufschrift wurde generiert", 0);
    }

    /**
     * Generiert die Style-Datei der Seite.
     *
     *
     * @throws java.io.UnsupportedEncodingException
     * @throws java.io.FileNotFoundException
     */
    public static void style() throws UnsupportedEncodingException, FileNotFoundException, IOException
    {
        String plan = Settings.load("color" + Settings.load("planColor"));
        String frame = Settings.load("color" + Settings.load("borderColor"));

        String[] datum0 = Settings.loadArray("überschriftFont");
        String datum1 = datum0[0] + " " + datum0[1] + "px " + datum0[2];
        String datum2 = Settings.load("color" + datum0[3]);

        String[] stufe0 = Settings.loadArray("stufennameFont");
        String stufe1 = stufe0[0] + " " + stufe0[1] + "px " + stufe0[2];
        String stufe2 = Settings.load("color" + stufe0[3]);

        String[] tabelle0 = Settings.loadArray("tabelleFont");
        String tabelle1 = tabelle0[0] + " " + tabelle0[1] + "px " + tabelle0[2];
        String tabelle2 = Settings.load("color" + tabelle0[3]);
        String tabelle3 = Settings.load("color" + tabelle0[4]);

        String[] schrift0 = Settings.loadArray("laufschriftFont");
        String schrift1 = schrift0[0] + " " + schrift0[1] + "px " + schrift0[2];
        String schrift2 = Settings.load("color" + schrift0[3]);
        String schrift3 = Settings.load("color" + schrift0[4]);

        String other = "";
        String[] settings = Settings.findNames("art");
        for(String setting : settings)
        {
            String[] font = Settings.loadArray(setting);
            other += "\n.stufeTab ." + setting.substring(3, setting.indexOf("Font"))
                     + "\n{"
                     + "\n  font: " + font[0] + " " + font[1] + "px " + font[2] + ";"
                     + "\n  color: " + Settings.load("color" + font[3]) + ";"
                     + "\n  background-color: " + Settings.load("color" + font[4]) + ";"
                     + "\n}";
            if(invalid(font[1], font[2], Settings.load("color" + font[3]), Settings.load("color" + font[4])))
                return;
        }

        if(invalid(plan, frame, datum1, datum2, stufe1, stufe2, tabelle1, tabelle2, tabelle3, schrift1, schrift2, schrift3))
            return;

        new FileTMP(Settings.load("pathData") + "/style.css").write(
                new String[]
                {
                    new FileTMP(Settings.load("pathData") + "/TEMPLATE style.css").asString()
                    .replaceAll("PLAN", plan)
                    .replaceAll("FRAME", frame)
                    .replaceAll("DATUM1", datum1)
                    .replaceAll("DATUM2", datum2)
                    .replaceAll("STUFE1", stufe1)
                    .replaceAll("STUFE2", stufe2)
                    .replaceAll("TABELLE1", tabelle1)
                    .replaceAll("TABELLE2", tabelle2)
                    .replaceAll("TABELLE", tabelle3)
                    .replaceAll("SCHRIFT1", schrift1)
                    .replaceAll("SCHRIFT2", schrift2)
                    .replaceAll("SCHRIFT", schrift3)
                    .replaceAll("OTHER", other)
                });
        Logger.log("Style wurde generiert", 0);
    }

    /**
     * Schreibt in Datenbank.
     *
     *
     * @throws java.lang.reflect.InvocationTargetException
     * @throws java.lang.IllegalAccessException
     * @throws java.io.IOException
     */
//    public static void sql() throws Exception
//    {
//        String[] settings = Settings.loadArray("sql");
//        ClassTMP[] scs = HtmlReader.forSql();
//        SqlTableWriter write = new SqlTableWriter(PathConverter.convert(settings[0]),
//                                                  Integer.parseInt(settings[1]),
//                                                  PathConverter.convert(settings[2]),
//                                                  settings[4],
//                                                  settings[5],
//                                                  PathConverter.convert(settings[3]),
//                                                  sqlColumms);
//
//        if(SqlMode.OVERWRITE.isActive())
//            write.clear();
//
//        ArrayList<String[]> forSql = new ArrayList<>();
//        for(ClassTMP sc : scs)
//            for(Lesson e : sc.getEntries())
//            {
//                String[] line = new String[e.getImportantContent().length + 2];
//                line[0] = sc.getName();
//                line[1] = e.getDate();
//                for(int i = 3; i < line.length; i++)
//                    line[i] = e.getImportantContent()[i - 3];
//                forSql.add(line);
//            }
//        write.addAll(forSql);
//    }
    /**
     * Formatiert die Schulklassen.
     *
     * @param schoolClasses Zu formatierende Schulklassen
     *
     * @return Formatierte Schulklassen als String
     */
    private static String classes(ClassTMP[] schoolClasses) throws IOException
    {
        if(schoolClasses == null)
            return "'<p class=\"datum\">Keine Vertretungen</p><br /><br />'+";

        String s = "";
        for(ClassTMP schoolClass : schoolClasses)
        {
            String[] or = Settings.loadArray("lessonOrder");
            schoolClass.sort(Integer.parseInt(or[0]),
                             Integer.parseInt(or[1]),
                             Integer.parseInt(or[2]),
                             Integer.parseInt(or[3]),
                             Integer.parseInt(or[4]),
                             Integer.parseInt(or[5]),
                             Integer.parseInt(or[6]));
            s += schoolClass.toHtml();
        }
        if(s.equals(""))
            return "'<p class=\"datum\">Keine Vertretungen</p><br /><br />'+";
        return s;
    }

    /**
     * Schneidet die vergangenen Stunden falls nötig ab.
     *
     * @param scs Das zu bearbeitende Array
     *
     * @return Das bearbeitete Array
     */
    private static ClassTMP[] cut(ClassTMP[] scs) throws IOException
    {
        if(Settings.load("lessonUse").equals("true"))
            if(scs != null && scs.length > 0)
                for(ClassTMP sc : scs)
                    sc.cut();
        return scs;
    }

    /**
     * Generiert den Kopf der Seite.
     *
     * @param schoolClasses Schulklassen die verwendet werden
     *
     * @return Kopf der Seite
     */
    private static String head(ClassTMP[] schoolClasses) throws IOException
    {
        if(schoolClasses == null)
            return "Keine Vertretungen";
        return Time.htmlWriting(schoolClasses[0].getCurDate());
    }

    /**
     * Bestätigt die Texte, die verwendet werden sollen.
     *
     * @param test Zu bestätigende Strings
     *
     * @return Sind die Strings verwendbar?
     */
    private static boolean invalid(String... test)
    {
        for(String s : test)
            if(s.equals(""))
            {
                Logger.log("Eine Einstellung wurde noch nicht gemacht - Konnte nicht generieren!", 2);
                return true;
            }
        return false;
    }
}
