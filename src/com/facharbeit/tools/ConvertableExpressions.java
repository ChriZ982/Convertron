package com.facharbeit.tools;

import java.util.Calendar;

public class ConvertableExpressions
{
    public static String yyyy(String date)
    {
        if(date == null)
            return cyyyy(date);
        else
        {
            String[] d = date.split("\\.");
            if(d.length >= 3)
                if(d[2].length() <= 2)
                    return "20" + d[2];
                else
                    return d[2];
            else if(Integer.parseInt(d[1]) > Calendar.getInstance().get(Calendar.MONTH) + 1)
                return String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
            else if((Calendar.getInstance().get(Calendar.MONTH) + 1) - Integer.parseInt(d[1]) >= 3)
                return String.valueOf(Calendar.getInstance().get(Calendar.YEAR) + 1);
            else
                return String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
        }

    }

    public static String yy(String date)
    {
        return yyyy(date).substring(2);
    }

    public static String mm(String date)
    {
        if(date == null)
            return cmm(date);
        else
        {
            String s = date.split("\\.")[1];
            while(s.length() < 2)
                s = "0" + s;
            return s;
        }
    }

    public static String dd(String date)
    {
        if(date == null)
            return cdd(date);
        else
        {
            String s = date.split("\\.")[0];
            while(s.length() < 2)
                s = "0" + s;
            return s;
        }
    }

    public static String hour(String date)
    {
        return String.valueOf(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
    }

    public static String minute(String date)
    {
        return String.valueOf(Calendar.getInstance().get(Calendar.MINUTE));
    }

    public static String second(String date)
    {
        return String.valueOf(Calendar.getInstance().get(Calendar.SECOND));
    }

    public static String cyyyy(String date)
    {
        return String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
    }

    public static String cyy(String date)
    {
        return cyyyy(date).substring(2);
    }

    public static String cmm(String date)
    {
        String s = String.valueOf(Calendar.getInstance().get(Calendar.MONTH) + 1);
        while(s.length() < 2)
            s = "0" + s;
        return s;
    }

    public static String cdd(String date)
    {
        String s = String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        while(s.length() < 2)
            s = "0" + s;
        return s;
    }

    public static String notFound(String date)
    {
        return "";
    }
}
