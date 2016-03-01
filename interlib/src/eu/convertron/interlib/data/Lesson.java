package eu.convertron.interlib.data;

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
        this(LessonFormatter.hoursToString(firstHour, lastHour), date, content);
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
        LessonValidator.validateMap(this.columns);

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
        return LessonFormatter.parseFirstHour(get("Std"));
    }

    /**
     * Gibt die letzte Stunde, für die dieser Vertretungseintrag gilt.
     *
     * @return Letzte Stunde
     */
    public int getLastHour()
    {
        return LessonFormatter.parseLastHour(get("Std"));
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
        put("Std", LessonFormatter.hoursToString(first, last));
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
                LessonValidator.validateDateString(value);
                columns.put("Datum", LessonFormatter.formatDate(value));
                break;
            case "Std":
                LessonValidator.validateHourString(value);
                columns.put("Std", LessonFormatter.formatHours(value));
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
}
