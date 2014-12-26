package com.facharbeit.tools;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;

public class PathConverter
{
    public static final String BEGIN = "<";
    public static final String END = ">";

    private static class ConvertableExpressions
    {
        private static String yyyy(String date)
        {
            if(date == null)
                return cyyyy(date);
            else
            {
                String[] d = date.split(".");
                if(d.length >= 3)
                    if(d[2].length() <= 2)
                        return "20" + d[2];
                    else
                        return d[2];
                else if(Integer.parseInt(d[1]) > Calendar.getInstance().get(Calendar.MONTH))
                    return String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
                else if(Calendar.getInstance().get(Calendar.MONTH) - Integer.parseInt(d[1]) < 6)
                    return String.valueOf(Calendar.getInstance().get(Calendar.YEAR) + 1);
                else
                    return String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
            }

        }

        private static String yy(String date)
        {
            return yyyy(date).substring(2);
        }

        private static String mm(String date)
        {
            if(date == null)
                return cmm(date);
            else
                return date.split(".")[1];
        }

        private static String dd(String date)
        {
            if(date == null)
                return cdd(date);
            else
                return date.split(".")[0];
        }

        private static String hour(String date)
        {
            return String.valueOf(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
        }

        private static String minute(String date)
        {
            return String.valueOf(Calendar.getInstance().get(Calendar.MINUTE));
        }

        private static String second(String date)
        {
            return String.valueOf(Calendar.getInstance().get(Calendar.SECOND));
        }

        private static String cyyyy(String date)
        {
            return String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
        }

        private static String cyy(String date)
        {
            return cyyyy(date).substring(2);
        }

        private static String cmm(String date)
        {
            String s = String.valueOf(Calendar.getInstance().get(Calendar.MONTH));
            while(s.length() < 2)
                s = "0" + s;
            return s;
        }

        private static String cdd(String date)
        {
            String s = String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
            while(s.length() < 2)
                s = "0" + s;
            return s;
        }

        private static String notFound(String date)
        {
            return "";
        }
    }

    private static class StringPart
    {
        String content;
        boolean mustCovert;

        StringPart(String content, boolean mustCovert)
        {
            this.content = content;
            this.mustCovert = mustCovert;
        }

        StringPart(String content)
        {
            this.content = content;
            this.mustCovert = false;
        }

        public String getContent()
        {
            return content;
        }

        public boolean mustCovert()
        {
            return mustCovert;
        }
    }

    /**
     * Ersetzt in dem angegebenen String(Pfad) bestimmte Ausdrücke innerhalb von BEGIN und END.
     *
     * @param s    Der zu konvertierende String.
     * @param date Das Datum im Format der Quelldateien (DD.MM) das zum konvertieren genutzt werden soll.
     *
     * @return Den konvertieren String s.
     */
    public static String convert(String s, String date)
    {
        try
        {
            Method[] convertOperations = ConvertableExpressions.class.getMethods();
            ArrayList<StringPart> parts = new ArrayList<>();

            while(s.contains(BEGIN) && s.contains(END))
            {
                parts.add(new StringPart(s.substring(0, s.indexOf(BEGIN))));
                parts.add(new StringPart(s.substring(s.indexOf(BEGIN) + BEGIN.length(),
                                                     s.indexOf(END)), true));
                s = s.substring(s.indexOf(END) + END.length());
            }
            parts.add(new StringPart(s));
            s = "";

            for(StringPart p : parts)
                if(p.mustCovert())
                {
                    boolean found = false;
                    for(Method m : convertOperations)
                        if(m.getName().equals(p.getContent()))
                        {
                            s += m.invoke(null, date);
                            found = true;
                            break;
                        }
                    if(!found)
                        s += ConvertableExpressions.notFound(date);
                }
                else
                    s += p.getContent();

        } catch(Exception ex)
        {
            Logger.log("Fehler beim konvertieren der Textfelder", 2);
            Logger.error(ex);
        }
        return s;
    }

    public static String convert(String s)
    {
        return convert(s, null);
    }
}
