package eu.convertron.interlib.filter;

import eu.convertron.interlib.data.Configuration;
import eu.convertron.interlib.data.IniConfigFile;
import eu.convertron.interlib.data.Lesson;
import eu.convertron.interlib.data.LessonFormatter;
import eu.convertron.interlib.interfaces.Configurable;
import eu.convertron.interlib.util.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

/**
 * Diese Klasse stellt verschiedene Möglichkeiten zur Verfügung, um das Stunden-Array zu formatieren.
 * Dabei wird das als Parameter gefordete Stunden-Array 'source' oder die Objekte, die darin enthalten sind NICHT VERÄNDERT.
 */
public class TableOptions implements Configurable
{
    private static TableOptions instance;

    static
    {
        instance = new TableOptions();
    }

    public static TableOptions getInstance()
    {
        return instance;
    }

    private IniConfigFile configFile;

    private TableOptions()
    {
    }

    /**
     * Filtert die Stunden nach den angegebenen Filtern.
     * Damit eine Stunde weiterhin im Array enthalten bleibt, müssen also alle Filter die Stunde akzeptieren.
     * @param source        Das Array, aus dem gefiltert werden soll
     * @param filterOptions Die Filter
     * @return Das gefilterte Array
     */
    public Lesson[] filterRows(Lesson[] source, FilterOption... filterOptions)
    {
        ArrayList<Lesson> filteredLessons = new ArrayList<>();
        for(Lesson lesson : source)
        {
            if(filtersAcceptLesson(lesson, filterOptions))
                filteredLessons.add(new Lesson(lesson));
        }
        return filteredLessons.toArray(new Lesson[filteredLessons.size()]);
    }

    /**
     * Prüft ob die Filter den angegebenen Vertretungseintrag akzeptieren.
     * @param lesson        Der zu prüfende Vertretungseintrag
     * @param filterOptions Die Filter die den Vertretungseintrag prüfen sollen
     * @return <code>true</code> wenn alle Filter den Vertretungseintrag akzeptiert haben, <code>false</code> wenn nicht
     */
    protected boolean filtersAcceptLesson(Lesson lesson, FilterOption... filterOptions)
    {
        for(FilterOption filter : filterOptions)
        {
            if(!filter.accept(lesson))
                return false;
        }
        return true;
    }

    /**
     * Entfernt bestimmte Spalten aus dem Stundenarray. Die Spalten 'Std' und 'Datum' bleiben immer enthalten.
     * Enthält ein Vertretungseintrag einen Key nicht, wird ein leerer String hinzugefügt.
     *
     * @param source          Das Array mit den Stunden, in denen gefiltert werden soll
     * @param colummsToSelect Die Spalten, die nach dem Filtern noch enthalten sein sollen, 'Std' und 'Datum' bleiben immer enthalten
     * @return Ein neues Array mit neuen Stunden-Objekten, welche nurnoch die gewünschten Spalten enthalten.
     */
    public Lesson[] filterColumms(Lesson[] source, String... colummsToSelect)
    {
        Lesson[] filtered = new Lesson[source.length];
        for(int i = 0; i < filtered.length; i++)
        {
            TreeMap<String, String> map = new TreeMap<>();

            map.put("Std", source[i].get("Std"));
            map.put("Datum", source[i].get("Datum"));

            for(String column : colummsToSelect)
                map.put(column, source[i].contains(column) ? source[i].get(column) : "");

            filtered[i] = new Lesson(map);
        }
        return filtered;
    }

    /**
     * Sortiert das Stunden-Array.
     * @param source Das zu sortierende Array
     * @param sorter Der Sortierer
     * @return Das sortierte Stundenarray
     * @see java.util.Comparator
     */
    public Lesson[] sort(Lesson[] source, Comparator<? super Lesson> sorter)
    {
        List<Lesson> asList = Arrays.asList(source);
        Collections.sort(asList, sorter);
        return asList.toArray(source);
    }

    /**
     * Komprimiert die Vertretungseinträge. Dadurch werden aufeinanderfolgende, aber ansonsten gleiche Stunden-Objekte zu einem zusammengefasst werden.
     * @param source Das unkomprimierte Stunden-Array
     * @return Das komprimierte Stunden-Array
     */
    @SuppressWarnings("AssignmentToForLoopParameter")
    public Lesson[] compress(Lesson[] source)
    {
        ArrayList<Lesson> asList = new ArrayList<>(Arrays.asList(
                sort(source, DefaultTableOptions.FIRSTHOUR)));

        for(int i = 0; i < asList.size(); i++)
        {
            for(int j = i + 1; j < asList.size(); j++)
            {
                Lesson lesson1 = asList.get(i);
                Lesson lesson2 = asList.get(j);
                if(lesson1.contentEquals(lesson2) || lessonEqualAndHoursFollowing(lesson1, lesson2))
                {
                    asList.set(i, compressLessons(lesson1, lesson2));
                    asList.remove(j);
                    i--;
                    break;
                }
            }
        }

        return asList.toArray(new Lesson[asList.size()]);
    }

    /**
     * Prüft ob die beiden Vertretungeinträge zusammengefügt werden können.
     * Dazu wird geprüft ob die Stunden aufeinander folgen und der Rest gleich ist.
     * @param lesson1 Der erste Vertretungseintrag
     * @param lesson2 Der zweite Vertretungseintrag
     * @return
     */
    protected boolean lessonEqualAndHoursFollowing(Lesson lesson1, Lesson lesson2)
    {
        for(String key : lesson1.getAllKeys())
        {
            if(!key.equals("Std"))
            {
                if(!lesson2.contains(key) || !lesson1.get(key).equals(lesson2.get(key)))
                    return false;
            }
        }

        for(String key : lesson2.getAllKeys())
        {
            if(!lesson1.contains(key))
                return false;
        }

        return hoursFollowing(lesson1.getFirstHour(), lesson1.getLastHour(),
                              lesson2.getFirstHour(), lesson2.getLastHour());
    }

    /**
     * Prüft ob die Stunden aufeinander folgen.
     * @param first1 erste Stunde des ersten Vertretungseintrags
     * @param last1  letzte Stunde des ersten Vertretungseintrags
     * @param first2 erste Stunde des zweiten Vertretungseintrags
     * @param last2  letzte Stunde des zweiten Vertretungseintrags
     * @return
     */
    protected boolean hoursFollowing(int first1, int last1, int first2, int last2)
    {
        return ((first1 >= first2 && first1 <= last2)
                || (last1 >= first2 && last1 <= last2)
                || (first2 >= first1 && first2 <= last1)
                || (last2 >= first1 && last2 <= last1)
                || (first1 == last2 + 1)
                || (first2 == last1 + 1));
    }

    /**
     * Fügt die beiden Vertretungseinträge zusammen.
     * @param lesson1 Der erste Vertretungeintrag
     * @param lesson2 Der zweite Vertretungeintrag
     * @return Ein Vertretungseintrag, welcher aus den beiden übergebenen zusammengeführt wurde
     */
    protected Lesson compressLessons(Lesson lesson1, Lesson lesson2)
    {
        if(lesson1.contentEquals(lesson2))
            return new Lesson(lesson1);

        int firstHour = Math.min(lesson1.getFirstHour(), lesson2.getFirstHour());
        int lastHour = Math.max(lesson1.getLastHour(), lesson2.getLastHour());

        Lesson result = new Lesson(lesson1);

        result.setHours(firstHour, lastHour);

        return result;
    }

    /**
     * Sorgt dafür, dass alle Vertretungseinträge dieselben Keys enthalten.
     * Falls hinter einem Key kein String hinterlegt ist, wird ein leerer String hinterlegt.
     * @param source Das nicht vereinheitlichte Stunden-Array
     * @return Das vereinheitlichte Stunden-Array
     */
    public Lesson[] unify(Lesson[] source)
    {
        ArrayList<String> allKeys = new ArrayList<>();

        for(Lesson lesson : source)
        {
            String[] keysOfLesson = lesson.getAllKeys();
            for(String key : keysOfLesson)
            {
                if(!allKeys.contains(key))
                    allKeys.add(key);
            }
        }

        return filterColumms(source, allKeys.toArray(new String[allKeys.size()]));
    }

    /**
     * Filtert die heutigen Vertretungseinträge heraus.
     * @param source Alle Vertretungseinträge
     * @return Alle Vertretungseinträge in 'source' die heute gültig sind
     */
    public Lesson[] today(Lesson[] source)
    {
        final String today = LessonFormatter.formatDate(
                useCustomDate()
                ? getCustomDateToday()
                : Time.getTodayAsDateString());

        return onlyDate(source, today);
    }

    /**
     * Filtert die Vertretungseinträge für den nächsten Tag mit Einträgen heraus. Es wird maximal 7 Tage in der Zukunft geprüft.
     * @param source Alle Vertretungseinträge
     * @return Alle Vertretungseinträge des nächsten Tags mit Einträgen
     */
    public Lesson[] nextDayWithLessons(Lesson[] source)
    {
        if(useCustomDate())
            return onlyDate(source, getCustomDateTomorrow());

        //Only try to find Lessons 7 days in future
        for(int daysInFuture = 1; daysInFuture <= 7; daysInFuture++)
        {
            String date = Time.getFutureDateAsDateString(daysInFuture);
            Lesson[] lessonsForDate = onlyDate(source, date);

            if(lessonsForDate != null && lessonsForDate.length > 0)
                return lessonsForDate;
        }

        return new Lesson[0];
    }

    /**
     * Filtert alle Vertretungseinträge eines bestimmten Datum heraus.
     * @param source Alle Vertretungseinträge
     * @param date   Das Datum für das die Einträge herausgefiltert werden sollen
     * @return Alle Vertretungseinträge des angegebenen Datums
     */
    public Lesson[] onlyDate(Lesson[] source, String date)
    {
        return filterRows(source, DefaultTableOptions.getWhereFilter("Datum", date));
    }

    /**
     * Filtert alle Vertretungseinträge heraus, die noch nicht abgeschnitten werden sollen.
     * @param source Alle Vertretungseinträge
     * @return Alle Vertretungseinträge die noch nicht abgeschnitten werden sollen
     */
    public Lesson[] notPast(Lesson[] source)
    {
        if(!useCutHours())
            return source;

        String[] cutHours = getCutHours();

        if(cutHours.length < 10)
            throw new RuntimeException("The saved 'cutHours' Array is shorter than 10");

        boolean[] lastLessonAccepted = new boolean[10];
        for(int i = 0; i < 10; i++)
        {
            lastLessonAccepted[i] = Time.isInFuture(cutHours[i]);
        }

        return filterRows(source, (Lesson lesson) -> lastLessonAccepted[lesson.getLastHour() - 1]);
    }

    public String getEvenWeekChar()
    {
        return configFile.load("evenWeekChar");
    }

    public String[] getCutHours()
    {
        return configFile.loadArray("cutHours");
    }

    public boolean useCutHours()
    {
        return configFile.load("useCutHours").equals("true");
    }

    public boolean useCustomDate()
    {
        return configFile.load("useCustomDate").equals("true");
    }

    public String getCustomDateToday()
    {
        return configFile.load("customDateToday");
    }

    public String getCustomDateTomorrow()
    {
        return configFile.load("customDateTomorrow");
    }

    @Override
    public void setConfiguration(Configuration config)
    {
        configFile = new IniConfigFile(config, "tableoptions.cfg");
        configFile.loadDefaultsFromResource("/eu/convertron/interlib/res/tableoptions.cfg", getClass());
    }
}
