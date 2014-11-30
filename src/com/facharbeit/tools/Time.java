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
}
