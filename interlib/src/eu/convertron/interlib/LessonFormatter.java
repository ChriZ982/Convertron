package eu.convertron.interlib;

/**
 * Formatiert Datum und Stunde innerhalb eines Vertretungseintrags ('Lesson' Klasse).
 */
public class LessonFormatter
{
    /**
     * Gibt einen Stunden-String zurück, welcher aus zwei ints zusammengesetzt wurde.
     * @param first erste Stunde
     * @param last  letzte Stunde
     * @return Den Stunden-String aus den beiden Zahlen
     */
    public static String hoursToString(int first, int last)
    {
        return first == last ? String.valueOf(first) : first + "-" + last;
    }

    /**
     * Extrahiert eine Stunde aus dem Stunden-String.
     * @param first       Gibt an on die erste oder letzte Stunde zurückgegeben werden soll
     * @param hoursString Der Stunden-String
     * @return Das erste oder letzte Datum aus dem Stunden-String
     */
    protected static int parseHour(boolean first, String hoursString)
    {
        if(!hoursString.contains("-"))
            return Integer.parseInt(hoursString);

        String[] lessons = hoursString.replaceAll(" ", "").split("-");
        return Integer.parseInt(lessons[first ? 0 : 1]);
    }

    /**
     * Extrahiert die erste Stunde aus dem Stunden-String.
     * @param hoursString Der Stunden-String
     * @return Die erste Stunde oder die einzige Stunde, die von diesem Stunden-String reprÃ€sentiert wird
     */
    public static int parseFirstHour(String hoursString)
    {
        return parseHour(true, hoursString);
    }

    /**
     * Extrahiert die letzte Stunde aus dem Stunden-String.
     * @param hoursString Der Stunden-String
     * @return Die letzte Stunde oder die einzige Stunde, die von diesem Stunden-String reprÃ€sentiert wird
     */
    public static int parseLastHour(String hoursString)
    {
        return parseHour(false, hoursString);
    }

    /**
     * Formatiert das Datum. Dieses Datum muss jedoch von <code>LessonValidator.validateDateString</code> akzeptiert werden
     * @param date Das unformatierte Datum
     * @return Das formatierte Datum
     */
    public static String formatDate(String date)
    {
        return date;
    }

    /**
     * Formatiert den Stunden-String. Dieser muss jedoch von <code>LessonValidator.validateHourString</code> akzeptiert werden
     * @param hoursString Der unformatierte Stunden-String
     * @return Der formatierte Stunden-String
     */
    public static String formatHours(String hoursString)
    {
        int first = parseFirstHour(hoursString);
        int last = parseLastHour(hoursString);

        if(last == first)
            return String.valueOf(first);

        return last > first ? first + "-" + last : last + "-" + first;
    }
}
