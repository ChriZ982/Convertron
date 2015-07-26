package converter.util;

public class Validators
{
    /**
     * Prüft ob der String zu einer Zahl konvertiert werden kann.
     *
     * @param s          Der String der überprüft wird
     * @param extraChars zusätzlich zugelassene Zeichen (neben Ziffern)
     *
     * @return Ob der String nur aus Ziffern und "extraChars" besteht
     */
    public static boolean validateAsNumber(String s, char... extraChars)
    {
        boolean found = false;
        if(s.isEmpty())
            return false;

        for(char c : s.toCharArray())
            if(Character.isDigit(c))
                found = true;
        if(!found)
            return false;

        for(char c : s.toCharArray())
            if(!Character.isDigit(c))
            {
                found = false;
                for(char extra : extraChars)
                    if(c == extra)
                    {
                        found = true;
                        break;
                    }
                if(!found)
                    return false;
            }
        return true;
    }

    public static boolean validateAsDate(String date)
    {
        if(!validateAsNumber(date, '.'))
            return false;

        if(!date.endsWith("."))
            return false;

        if(date.startsWith("."))
            return false;

        String[] parts = date.split(".");
        if(parts.length != 3)
            return false;

        return true;
    }
}
