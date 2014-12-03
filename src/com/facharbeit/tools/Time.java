package com.facharbeit.tools;

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
        if(!today)
            c.add(Calendar.DAY_OF_MONTH, 1);

        String s = String.format("%02d", c.get(Calendar.YEAR) % 100)
                   + String.format("%02d", (c.get(Calendar.MONTH) + 1))
                   + String.format("%02d", c.get(Calendar.DAY_OF_MONTH));

        if(!today)
            c.add(Calendar.DAY_OF_MONTH, -1);

        return s;
    }

    public static String forHtmlWriting()
    {
        instance();
        return " (" + c.get(Calendar.WEEK_OF_YEAR) + ")";
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
}
