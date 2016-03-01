package eu.convertron.interlib.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Klasse für die Verwaltung von Zeitangaben.
 */
public class Time
{
    public static final String DATESTRINGFORMAT = "dd.MM.";

    /**
     * Formatiert das jetzige Datum.
     * @param formatString Formatierung
     * @return Formatiertes Datum
     */
    public static String formatNow(String formatString)
    {
        return format(new Date(), formatString);
    }

    /**
     * Formatiert ein Datum.
     * @param date         Datum
     * @param formatString Formatierung
     * @return Formatiertes Datum
     */
    public static String format(Date date, String formatString)
    {
        return new SimpleDateFormat(formatString).format(date);
    }

    public static String getTodayAsDateString()
    {
        return formatNow(DATESTRINGFORMAT);
    }

    public static String getFutureDateAsDateString(int daysInFuture)
    {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, daysInFuture);

        return format(c.getTime(), DATESTRINGFORMAT);
    }

    public static boolean isInFuture(String timeString)
    {
        try
        {
            Calendar now = Calendar.getInstance();
            now.set(2000, Calendar.JANUARY, 1);

            Calendar then = Calendar.getInstance();
            then.set(2000, Calendar.JANUARY, 1);

            String[] timeParts = timeString.split(":");

            if(timeParts.length < 2)
                throw new IllegalArgumentException("TimeString malformed: It does not contain a ':' (" + timeString + ")");

            then.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeParts[0]));
            then.set(Calendar.MINUTE, Integer.parseInt(timeParts[1]));

            return now.compareTo(then) < 0;
        }
        catch(NumberFormatException ex)
        {
            throw new IllegalArgumentException("TimeString malformed: Hour or Minute could not be converted to int (" + timeString + ")");
        }
    }
}
