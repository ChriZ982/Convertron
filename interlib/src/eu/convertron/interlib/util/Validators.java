package eu.convertron.interlib.util;

/**
 * Überprüft ob verschiedene Strings den Vorgaben entsprechen.ÜÄÖßüäö
 */
public class Validators
{
    /**
     * Prüft ob der String nur aus Zahlen und festgelegten Zeichen besteht.
     * @param string     Der String der überprüft wird
     * @param extraChars Zusätzlich zugelassene Zeichen (neben Ziffern)
     * @return Ob der String nur aus Ziffern und "extraChars" besteht
     */
    public static boolean isValidNumberAndChars(String string, char... extraChars)
    {
        if(string == null || string.isEmpty())
            return false;

        String numberString = string;
        for(char ch : extraChars)
        {
            numberString = numberString.replaceAll(String.valueOf(ch), "");
        }

        if(numberString.isEmpty())
            return false;
        numberString = numberString.replaceAll("\\d+", "");

        return numberString.isEmpty();
    }

    /**
     * Validiert einen Datumsstring anhand eines Regulären Ausdrucks nach dem Format '31.12.'.
     * @param date Datumsstring
     * @return Ist der String korrekt?
     */
    public static boolean isValidDate(String date)
    {
        if(date == null || date.isEmpty())
            return false;

        return date.matches("\\d{1,2}[.]\\d{1,2}[.]");
    }
}
