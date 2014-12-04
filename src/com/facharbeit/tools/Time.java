package com.facharbeit.tools;

import com.facharbeit.io.*;
import java.util.*;

public class Time
{
    private static Calendar c = Calendar.getInstance();

    private static void instance()
    {
        c = Calendar.getInstance();
    }

    public static String forLogging()
    {
        instance();
        return "[" + String.format("%02d", c.get(Calendar.HOUR_OF_DAY)) + ":"
               + String.format("%02d", c.get(Calendar.MINUTE)) + ":"
               + String.format("%02d", c.get(Calendar.SECOND)) + "] ";
    }

    public static String forHtmlReading(boolean today)
    {
        instance();
        if(Settings.load("customDate").equals("true"))
            if(today)
                return Settings.load("customToday");
            else
                return Settings.load("customTomorrow");
        else
            if(today)
                return day() + "\\." + month() + "\\.";
            else
                if(c.getDisplayName(Calendar.DATE, Calendar.SHORT, Locale.GERMANY).equals("Fr"))
                    return addDays(3).get(Calendar.DATE) + "\\." + addDays(3).get(Calendar.MONTH) + "\\.";
                else
                    return addDays(1).get(Calendar.DATE) + "\\." + addDays(1).get(Calendar.MONTH) + "\\.";
    }

    public static int month()
    {
        instance();
        return c.get(Calendar.MONTH);
    }

    public static int day()
    {
        instance();
        return c.get(Calendar.DAY_OF_MONTH);
    }

    public static int hour()
    {
        instance();
        return c.get(Calendar.HOUR_OF_DAY);
    }

    public static int minute()
    {
        instance();
        return c.get(Calendar.MINUTE);
    }

    public static Calendar addDays(int amount)
    {
        instance();
        Calendar nc = (Calendar)c.clone();
        nc.add(Calendar.DATE, amount);
        return nc;
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

    public static String forHtmlWriting(String date)
    {
        instance();
        c.set(Calendar.DATE, Integer.parseInt(date.split("\\.")[0]));
        c.set(Calendar.MONTH, Integer.parseInt(date.split("\\.")[1]));

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

        return "Vertretungen " + date + " Woche-" + week + " (" + c.get(Calendar.WEEK_OF_YEAR) + ")";
    }
}
