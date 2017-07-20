package eu.convertron.interlib;

import eu.convertron.interlib.util.Validators;
import java.util.Map;

public class LessonValidator
{
    /**
     * Prüft die Map die zum initialisieren eines Vertretungseintrags verwendet wird.
     * @param map Die zu prüfende Map
     */
    public static void validateMap(Map<String, String> map)
    {
        if(!map.containsKey("Std"))
            throw new IllegalArgumentException("The map does not contain the key 'Std'");

        if(!map.containsKey("Datum"))
            throw new IllegalArgumentException("The map does not contain the key 'Datum'");
    }

    /**
     * Prüft, ob das übergebene Datum richtig formatiert ist.
     * @param date Das zu prüfende Datum
     */
    public static void validateDateString(String date)
    {
        if(date == null)
            throw new IllegalArgumentException("'Std' can not be null");

        if(!Validators.isValidDate(date))
            throw new IllegalArgumentException("The key 'Datum' with value '" + date + "' is not formatted like 'dd.mm.'");
    }

    /**
     * Prüft, ob der übergebene Stunden-String richtig formatiert ist.
     * @param hour Der zu prüfende Stunden-String
     */
    public static void validateHourString(String hour)
    {
        if(hour == null)
            throw new IllegalArgumentException("'Std' can not be null");

        if(!Validators.isValidNumberAndChars(hour, ' ', '-'))
            throw new IllegalArgumentException("The key 'Std' with value '" + hour + "' has to represent one number or two numbers seperated with a '-'");

        if(hour.contains("-"))
        {
            String[] split = hour.split("-");
            if(split.length > 2)
                throw new IllegalArgumentException("The key 'Std' with value '" + hour + "' can not contain more than one '-'");

            if(!Validators.isValidNumberAndChars(split[0], ' ')
               || !Validators.isValidNumberAndChars(split[1], ' '))
                throw new IllegalArgumentException("The key 'Std' with value '" + hour + "' contains a wrong formatted start or end lesson");
        }
    }
}
