package com.facharbeit.tools;

import com.facharbeit.io.Settings;
import java.util.Calendar;
import java.util.Locale;

/**
 * Klasse für Zeiten.
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
        try
        {
            c = Calendar.getInstance();
        }
        catch(Exception ex)
        {
            Logger.log("Kalender konnte nicht erstellt werden", 2);
            Logger.error(ex);
        }
    }

    /**
     * Gibt die Zeit für die Error-Dokumentation.
     *
     * @return Zeit als String
     */
    public static String error()
    {
        try
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
        catch(Exception ex)
        {
            Logger.log("Zeit konnte nicht ermittelt werden", 2);
            Logger.error(ex);
            return null;
        }
    }

    /**
     * Gibt die Zeit für das Logging.
     *
     * @return Zeit
     */
    public static String log()
    {
        try
        {
            instance();
            return "[" + String.format("%02d", c.get(Calendar.HOUR_OF_DAY)) + ":"
                   + String.format("%02d", c.get(Calendar.MINUTE)) + ":"
                   + String.format("%02d", c.get(Calendar.SECOND)) + "] ";
        }
        catch(Exception ex)
        {
            Logger.log("Zeit konnte nicht ermittelt werden", 2);
            Logger.error(ex);
            return null;
        }
    }

    /**
     * Gibt die Zeit für das Lesen.
     *
     * @param addDays Tagesabstand
     *
     * @return Zeit
     */
    public static String htmlReading(int addDays)
    {
        try
        {
            instance();
            if(Settings.load("customDate").equals("true"))
                if(addDays == 0)
                    return Settings.load("customToday");
                else
                    return Settings.load("customTomorrow");
            else if(addDays == 0)
                return c.get(Calendar.DATE) + "." + (c.get(Calendar.MONTH) + 1) + ".";
            else
                return addDays(addDays).get(Calendar.DATE) + "." + (addDays(1).get(Calendar.MONTH) + 1) + ".";
        }
        catch(Exception ex)
        {
            Logger.log("Zeit konnte nicht ermittelt werden", 2);
            Logger.error(ex);
            return null;
        }
    }

    /**
     * Gibt die Zeit für das Schreiben.
     *
     * @param date Zu verwendendes Datum
     *
     * @return Zeit
     */
    public static String htmlWriting(String date)
    {
        try
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
                   + date + "<br/>Woche-" + week + " (" + c.get(Calendar.WEEK_OF_YEAR) + ")";
        }
        catch(Exception ex)
        {
            Logger.log("Zeit konnte nicht ermittelt werden", 2);
            Logger.error(ex);
            return null;
        }
    }

    /**
     * Gibt die aktuelle Stunde.
     *
     * @return Stunde
     */
    public static int hour()
    {
        try
        {
            instance();
            return c.get(Calendar.HOUR_OF_DAY);
        }
        catch(Exception ex)
        {
            Logger.log("Zeit konnte nicht ermittelt werden", 2);
            Logger.error(ex);
            return -1;
        }
    }

    /**
     * Gibt die aktuelle Minute.
     *
     * @return Minute
     */
    public static int minute()
    {
        try
        {
            instance();
            return c.get(Calendar.MINUTE);
        }
        catch(Exception ex)
        {
            Logger.log("Zeit konnte nicht ermittelt werden", 2);
            Logger.error(ex);
            return -1;
        }
    }

    /**
     * Verschibt den Kalender um n Tage.
     *
     * @param amount Anzahl der Tage
     *
     * @return Neuer Kalender
     */
    public static Calendar addDays(int amount)
    {
        try
        {
            instance();
            Calendar nc = (Calendar)c.clone();
            nc.add(Calendar.DATE, amount);
            return nc;
        }
        catch(Exception ex)
        {
            Logger.log("Es konnten keine Tage hinzugefügt werden", 2);
            Logger.error(ex);
            return null;
        }
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
     */
    public static boolean isAfter(int afterHour, int afterMinute, int beforeHour, int beforeMinute)
    {
        try
        {
            boolean after = false;
            if(beforeHour == afterHour)
                if(beforeMinute <= afterMinute)
                    after = true;
            if(beforeHour < afterHour)
                after = true;
            return after;
        }
        catch(Exception ex)
        {
            Logger.log("Zeiten konnten nicht verglichen werden", 2);
            Logger.error(ex);
            return false;
        }
    }
}
