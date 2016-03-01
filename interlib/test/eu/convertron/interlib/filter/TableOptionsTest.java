package eu.convertron.interlib.filter;

import eu.convertron.interlib.filter.FilterOption;
import eu.convertron.interlib.filter.TableOptions;
import eu.convertron.interlib.data.Lesson;
import java.util.HashMap;
import java.util.TreeMap;
import org.junit.Assert;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TableOptionsTest
{
    public static Lesson getLessonByHour(int hour1, int hour2)
    {
        TreeMap<String, String> map = new TreeMap<>();
        map.put("Std", hour1 == hour2 ? String.valueOf(hour1) : hour1 + "-" + hour2);
        map.put("Datum", "1.1.");
        return new Lesson(map);
    }

    /**
     * Test of filterRows method, of class TableOptions.
     */
    @Test
    public void testFilterRows_FilterSaysNo()
    {
        Lesson[] source =
        {
            getDummyLesson(), getDummyLesson()
        };
        FilterOption[] filterOptions =
        {
            new FilterOption()
            {
                @Override
                public boolean accept(Lesson lesson)
                {
                    return false;
                }
            }, new FilterOption()
            {
                @Override
                public boolean accept(Lesson lesson)
                {
                    return true;
                }
            }
        };

        Lesson[] expResult = new Lesson[0];
        Lesson[] result = TableOptions.filterRows(source, filterOptions);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of filterRows method, of class TableOptions.
     */
    @Test
    public void testFilterRows_FilterSaysYes()
    {
        Lesson[] source =
        {
            getDummyLesson(), getDummyLesson()
        };
        FilterOption[] filterOptions =
        {
            new FilterOption()
            {
                @Override
                public boolean accept(Lesson lesson)
                {
                    return true;
                }
            }
        };

        Lesson[] result = TableOptions.filterRows(source, filterOptions);
        assertArrayEquals(source, result);
    }

    /**
     * Test of filtersAcceptLesson method, of class TableOptions.
     */
    @Test
    public void testFiltersAcceptLesson_filterSaysYes()
    {
        Lesson lesson = getDummyLesson();
        FilterOption[] filterOptions =
        {
            new FilterOption()
            {
                @Override
                public boolean accept(Lesson lesson)
                {
                    return true;
                }
            }
        };
        boolean expResult = true;
        boolean result = TableOptions.filtersAcceptLesson(lesson, filterOptions);
        assertEquals(expResult, result);
    }

    /**
     * Test of filtersAcceptLesson method, of class TableOptions.
     */
    @Test
    public void testFiltersAcceptLesson_filterSaysNo()
    {
        Lesson lesson = getDummyLesson();
        FilterOption[] filterOptions =
        {
            new FilterOption()
            {
                @Override
                public boolean accept(Lesson lesson)
                {
                    return false;
                }
            }, new FilterOption()
            {
                @Override
                public boolean accept(Lesson lesson)
                {
                    return true;
                }
            }
        };
        boolean expResult = false;
        boolean result = TableOptions.filtersAcceptLesson(lesson, filterOptions);
        assertEquals(expResult, result);
    }

    /**
     * Test of filterColumms method, of class TableOptions.
     */
    @Test
    public void testFilterColumms()
    {
        Lesson[] source =
        {
            getDummyLesson(), getDummyLesson()
        };

        String[] colummsToSelect =
        {
            "Datum",
        };

        Lesson[] result = TableOptions.filterColumms(source, colummsToSelect);

        Assert.assertTrue(result.length == 2);
        Assert.assertFalse(result[0].contains("Muell"));
        Assert.assertFalse(result[1].contains("Muell"));

        Assert.assertEquals("1-2", result[0].get("Std"));
        Assert.assertEquals("1-2", result[0].get("Std"));
        Assert.assertEquals("31.12.", result[0].get("Datum"));
        Assert.assertEquals("31.12.", result[0].get("Datum"));
    }

    private Lesson getDummyLesson()
    {
        HashMap<String, String> entrys = new HashMap<>();

        entrys.put("Datum", "31.12.");
        entrys.put("Std", "1 - 2");
        entrys.put("Muell", "Abfuhr");

        return new Lesson(entrys);
    }

    /**
     * Test of compress method, of class TableOptions.
     */
    @Test
    public void testCompress_noChanges()
    {
        Lesson[] source = new Lesson[]
        {
            getLessonByHour(1, 1),
            getLessonByHour(2, 2),
            getLessonByHour(3, 3)
        };
        Lesson[] result = TableOptions.compress(source);

        assertEquals(1, result.length);
        assertEquals(1, result[0].getFirstHour());
        assertEquals(3, result[0].getLastHour());
    }

    /**
     * Test of compress method, of class TableOptions.
     */
    @Test
    public void testCompress_changes()
    {
        Lesson[] source = new Lesson[]
        {
            getLessonByHour(3, 3),
            getLessonByHour(2, 2),
            getLessonByHour(1, 1)
        };
        Lesson[] result = TableOptions.compress(source);

        assertEquals(1, result.length);
        assertEquals(1, result[0].getFirstHour());
        assertEquals(3, result[0].getLastHour());
    }

    /**
     * Test of compress method, of class TableOptions.
     */
    @Test
    public void testCompress_zeroLength()
    {
        Lesson[] source = new Lesson[]
        {
        };
        Lesson[] result = TableOptions.compress(source);

        assertEquals(0, result.length);
    }

    public void testCompress_contentDiffer()
    {
        Lesson[] source = new Lesson[]
        {
            getLessonByHour(3, 3),
            getLessonByHour(2, 2),
            getLessonByHour(1, 1)
        };

        source[0].put("A", "B");
        source[1].put("A", "C");
        source[2].put("A", "B");

        Lesson[] result = TableOptions.compress(source);

        assertEquals(3, result.length);
    }

    public void testCompress_rangeChanges()
    {
        Lesson[] source = new Lesson[]
        {
            getLessonByHour(3, 7),
            getLessonByHour(2, 2),
            getLessonByHour(1, 1)
        };

        source[0].put("A", "B");
        source[1].put("A", "C");
        source[2].put("A", "B");

        Lesson[] result = TableOptions.compress(source);

        assertEquals(3, result.length);
    }
}
