package eu.convertron.interlib;

import eu.convertron.interlib.util.Validators;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Einzelne Vertretung innerhalb einer Schulklasse.
 */
public class Lesson
{
    /**
     * Daten des Vertretungseintrags.
     */
    private final TreeMap<String, String> columns;

    /**
     * Initialisiert einen neuen Vertretungseintrag.
     *
     * @param content Inhalt des Eintrags, welche Informationen über Stunde und Datum enthalten muss
     */
    public Lesson(Map<String, String> content)
    {
        this.columns = new TreeMap<>(content);
        validateAndFormat();
    }

    /**
     * Initialisiert einen neuen Vertretungseintrag.
     *
     * @param hour    Die Stunde bzw der Stundenzeitraum, für den dieser Eintrag gültig ist
     * @param date    Das Datum, für welches dieser Eintrag gültig ist
     * @param content Der restliche Inhalt des Eintrags
     */
    public Lesson(String hour, String date, Map<String, String> content)
    {
        content.put("Datum", date);
        content.put("Std", hour);
        this.columns = new TreeMap<>(content);
        validateAndFormat();
    }

    /**
     * Initialisiert einen neuen Vertretungseintrag.
     *
     * @param firstHour Die erste Stunde, für den dieser Eintrag gültig ist
     * @param lastHour  Die letzte Stunde, für den dieser Eintrag gültig ist
     * @param date      Das Datum, für welches dieser Eintrag gültig ist
     * @param content   Der restliche Inhalt des Eintrags
     */
    public Lesson(int firstHour, int lastHour, String date, Map<String, String> content)
    {
        this(FormatActions.hoursToString(firstHour, lastHour), date, content);
    }

    /**
     * Initialisiert einen neuen Vertretungseintrag. Dabei wird der übergebene kopiert
     * @param lessonToCopy Der Vertretungseintrag, welcher kopiert werden soll
     */
    public Lesson(Lesson lessonToCopy)
    {
        TreeMap<String, String> contents = new TreeMap<>();
        for(String key : lessonToCopy.getAllKeys())
        {
            contents.put(key, lessonToCopy.get(key));
        }

        this.columns = contents;
        validateAndFormat();
    }

    /**
     * Formatiert und validiert den Vertretungseintrag.
     */
    private void validateAndFormat()
    {
        ValidateActions.validateMap(this.columns);

        put("Std", get("Std"));
        put("Datum", get("Datum"));
    }

    /**
     * Gibt Datum.
     *
     * @return Datum
     */
    public String getDate()
    {
        return get("Datum");
    }

    /**
     * Gibt die erste Stunde, für die dieser Vertretungseintrag gilt.
     *
     * @return Erste Stunde
     */
    public int getFirstHour()
    {
        return FormatActions.parseFirstHour(get("Std"));
    }

    /**
     * Gibt die letzte Stunde, für die dieser Vertretungseintrag gilt.
     *
     * @return Letzte Stunde
     */
    public int getLastHour()
    {
        return FormatActions.parseLastHour(get("Std"));
    }

    /**
     * Setzte die letzte Stunde, für die dieser Vertretungseintrag gilt.
     * @param last Die neue letzte Stunde
     */
    public void setLastHour(int last)
    {
        setHours(getFirstHour(), last);
    }

    /**
     * Setzte die erste Stunde, für die dieser Vertretungseintrag gilt.
     * @param first Die neue erste Stunde
     */
    public void setFirstHour(int first)
    {
        setHours(first, getLastHour());
    }

    /**
     * Setzt die beiden Stunden-Grenzen, für die dieser Vertretungseintrag gilt.
     * @param first
     * @param last
     */
    public void setHours(int first, int last)
    {
        put("Std", FormatActions.hoursToString(first, last));
    }

    /**
     * Fügt 'value' an den gespeicherten String unter 'key' getrennt mit einem Leerzeichen (#10) an.
     * Falls noch kein String unter 'key' gespeichert ist, wird 'value' hinterlegt
     * @param key   Der Key, an dessen hinterlegten String 'value' angefügt werden soll
     * @param value Der String der angefügt werden soll
     */
    public void append(String key, String value)
    {
        if(contains(key))
        {
            put(key, get(key) + " " + value);
        }
        else
        {
            put(key, value);
        }
    }

    /**
     * Hinterlegt 'value' in 'key' innerhalb des Eintrags.
     * Falls für diesen Key bereits ein String hinterlegt ist, wird dieser überschrieben.
     * @param key   Der Key, hinter dem der String hinterlegt werden soll
     * @param value Der String der hinterlegt werden soll
     */
    public void put(String key, String value)
    {
        switch(key)
        {
            case "Datum":
                ValidateActions.validateDateString(value);
                columns.put("Datum", FormatActions.formatDate(value));
                break;
            case "Std":
                ValidateActions.validateHourString(value);
                columns.put("Std", FormatActions.formatHours(value));
                break;
            default:
                columns.put(key, value);
                break;
        }
    }

    /**
     * Prüft ob hinter dem angegebenen Key ein String hinterlegt ist.
     * @param key Der Key, der geprüft werden soll
     * @return <code>true</code> wenn hinter 'key' ein String hinterlegt ist, <code>false</code> wenn nicht
     */
    public boolean contains(String key)
    {
        return columns.containsKey(key);
    }

    /**
     * Prüft ob hinter dem angegebenen Key ein String hinterlegt ist, und wenn ja dieser nicht <code>null</code> oder leer ist.
     * @param key Der Key, der geprüft werden soll
     * @return <code>true</code> wenn hinter 'key' ein "echter" String hinterlegt ist, <code>false</code> wenn nicht
     */
    public boolean containsKeyAndValueNotNullOrEmpty(String key)
    {
        if(!contains(key))
            return false;

        String value = get(key);
        return value != null && !value.isEmpty();
    }

    /**
     * Gibt den String zurück, welcher hinter dem angegebenen Key hinterlegt ist.
     * @param key Der Key, dessen hinterlegter String zurückgegeben werden soll
     * @return Den String, der hinter dem Key hinterlegt ist, oder <code>null</code> wenn kein String hinterlegt wurde
     */
    public String get(String key)
    {
        return columns.get(key);
    }

    /**
     * Gibt die hinterlegten Strings von mehreren Keys zurück. Dabei bleibt die Reihenfolge erhalten
     * @param keys Die Keys, dessen hinterlegten String abgefragt werden sollen
     * @return Ein Array der Strings, welche hinter 'keys' hinterlegt wurden
     */
    public String[] getMultiple(String[] keys)
    {
        String[] result = new String[keys.length];
        for(int i = 0; i < keys.length; i++)
        {
            result[i] = contains(keys[i]) ? get(keys[i]) : null;
        }
        return result;
    }

    /**
     * Gibt alle Keys zurück, hinter denen String hinterlegt wurden.
     * @return Ein Array aller Keys, welche einen String hinterlegt haben
     */
    public String[] getAllKeys()
    {
        Set<String> keys = columns.keySet();
        return keys.toArray(new String[keys.size()]);
    }

    public boolean contentEquals(Lesson lesson)
    {
        String[] keysOfLesson = lesson.getAllKeys();
        String[] keysOfThis = getAllKeys();

        if(keysOfLesson.length != keysOfThis.length)
            return false;

        for(String key : keysOfLesson)
        {
            if(!contains(key) || !get(key).equals(lesson.get(key)))
                return false;
        }

        for(String key : keysOfThis)
        {
            if(!lesson.contains(key))
                return false;
        }

        return true;
    }

    public static class ValidateActions
    {
        private ValidateActions()
        {
        }

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

    public static class FormatActions
    {
        private FormatActions()
        {
        }

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
}
