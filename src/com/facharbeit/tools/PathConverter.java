package com.facharbeit.tools;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class PathConverter
{
    public static final String BEGIN = "<";
    public static final String END = ">";

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
            Method[] convertOperations = ConvertableExpressions.class.getDeclaredMethods();
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

        }
        catch(Exception ex)
        {
//            Logger.log("Fehler beim konvertieren der Textfelder", 2);
//            Logger.error(ex);
            ex.printStackTrace();
        }
        return s;
    }

    public static String convert(String s)
    {
        return convert(s, null);
    }
}
