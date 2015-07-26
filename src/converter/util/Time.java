package converter.util;

import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;

/**
 * Klasse für die Verwaltung von Zeitangaben.
 */
public class Time
{
    /**
     * Kalender mit dem die Zeiten ermittelt werden.
     */
    private static Calendar c = Calendar.getInstance();

    /**
     * Aktualisiert den Kalender.
     */
    private static void instance()
    {
        c = Calendar.getInstance();
    }

    public static String date()
    {
        Calendar c = Calendar.getInstance();
        return String.format("%1$TY-%1$Tm-%1$Td-%1$TH-%1$TM-%1$TS", c);
    }

    /**
     * Gibt die Zeit für die Error-Dokumentation.
     *
     * @return Zeit als String
     *
     *
     */
    public static String error()
    {
        instance();
        return c.get(Calendar.YEAR) + ""
               + c.get(Calendar.MONTH) + ""
               + c.get(Calendar.DATE) + "-"
               + c.get(Calendar.HOUR_OF_DAY) + ""
               + c.get(Calendar.MINUTE) + ""
               + c.get(Calendar.SECOND) + ""
               + c.get(Calendar.MILLISECOND);
    }

    /**
     * Gibt die Zeit für das Logging.
     *
     * @return Zeit
     *
     *
     */
    public static String log()
    {
        instance();
        return "[" + String.format("%02d", c.get(Calendar.HOUR_OF_DAY)) + ":"
               + String.format("%02d", c.get(Calendar.MINUTE)) + ":"
               + String.format("%02d", c.get(Calendar.SECOND)) + "] ";
    }

    /**
     * Gibt die Zeit für das Lesen.
     *
     * @param addDays Tagesabstand
     *
     * @return Zeit
     *
     * @throws java.io.IOException
     *
     *
     */
    public static String htmlReading(int addDays) throws IOException
    {
        instance();
        if(Settings.load("customUse").equals("true"))
            if(addDays == 0)
                return Settings.loadArray("customDates")[0];
            else
                return Settings.loadArray("customDates")[1];
        else if(addDays == 0)
            return c.get(Calendar.DATE) + "." + (c.get(Calendar.MONTH) + 1) + ".";
        else
            return addDays(addDays).get(Calendar.DATE) + "." + (addDays(addDays).get(Calendar.MONTH) + 1) + ".";
    }

    /**
     * Gibt die Zeit für das Schreiben.
     *
     * @param date Zu verwendendes Datum
     *
     * @return Zeit
     *
     * @throws java.io.IOException
     *
     *
     */
    public static String htmlWriting(String date) throws IOException
    {
        instance();
        c.set(Calendar.DATE, Integer.parseInt(date.split("\\.")[0]));
        c.set(Calendar.MONTH, Integer.parseInt(date.split("\\.")[1]) - 1);

        String gerade = Settings.load("customWeek");
        String ungerade;
        String week;

        if(gerade.equals("A"))
            ungerade = "B";
        else
            ungerade = "A";

        if(c.get(Calendar.WEEK_OF_YEAR) % 2 == 0)
            week = gerade;
        else
            week = ungerade;

        return "Vertretungen " + c.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.GERMANY) + " "
               + date + "<br/>" + week + "-Woche (" + c.get(Calendar.WEEK_OF_YEAR) + ". KW)";
    }

    /**
     * Gibt die aktuelle Stunde.
     *
     * @return Stunde
     *
     *
     */
    public static int hour()
    {
        instance();
        return c.get(Calendar.HOUR_OF_DAY);

    }

    /**
     * Gibt die aktuelle Minute.
     *
     * @return Minute
     *
     *
     */
    public static int minute()
    {
        instance();
        return c.get(Calendar.MINUTE);
    }

    /**
     * Verschibt den Kalender um n Tage.
     *
     * @param amount Anzahl der Tage
     *
     * @return Neuer Kalender
     *
     *
     */
    public static Calendar addDays(int amount)
    {
        instance();
        Calendar nc = (Calendar)c.clone();
        nc.add(Calendar.DATE, amount);
        return nc;
    }

    /**
     * Findet heraus ob die Uhrzeiten aufeinander folgen.
     *
     * @param afterHour    Stunde die nachher kommen soll
     * @param afterMinute  Minute die nachher kommen soll
     * @param beforeHour   Stunde die vorher kommen soll
     * @param beforeMinute Minute die vorher kommen soll
     *
     * @return Sind die Uhrzeiten nacheinander?
     *
     *
     */
    public static boolean isAfter(int afterHour, int afterMinute, int beforeHour, int beforeMinute)
    {
        boolean after = false;
        if(beforeHour == afterHour)
            if(beforeMinute <= afterMinute)
                after = true;
        if(beforeHour < afterHour)
            after = true;
        return after;
    }
}
