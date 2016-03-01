package eu.convertron.interlib.filter;

import eu.convertron.interlib.data.Lesson;
import java.util.Arrays;
import java.util.Comparator;

public class DefaultTableOptions
{
    public final static Comparator<Lesson> FIRSTHOUR = (Lesson o1, Lesson o2)
            -> o1.getFirstHour() - o2.getFirstHour();

    public static FilterOption getWhereFilter(String colummName, String... possibleValues)
    {
        return (Lesson lesson) -> lesson.contains(colummName)
                                  && Arrays.asList(possibleValues).contains(lesson.get(colummName));
    }

    public static Comparator<Lesson> getAlphabeticalLessonSorterByColumn(String column, boolean ignoreCase)
    {
        return (Lesson lesson1, Lesson lesson2) ->
        {
            if(!lesson1.contains(column) && !lesson2.contains(column))
                return 0;

            if(!lesson2.contains(column))
                return Integer.MAX_VALUE;

            if(!lesson1.contains(column))
                return Integer.MIN_VALUE;

            return ignoreCase
                   ? lesson1.get(column).compareToIgnoreCase(lesson2.get(column))
                   : lesson1.get(column).compareTo(lesson2.get(column));
        };
    }

    public static Comparator<Lesson> getAlphabeticalLessonSorterByColumn(String column)
    {
        return getAlphabeticalLessonSorterByColumn(column, true);
    }
}
