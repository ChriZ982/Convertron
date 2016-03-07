package eu.convertron.applib.etc;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 *
 * @author Mirko Ruether
 */
public class CsvLessonSerializerTest
{

    public CsvLessonSerializerTest()
    {
    }

    /**
     * Test of toCsvText method, of class CsvStorage.
     */
//    @Test
    public void testToCsvText()
    {
        System.out.println("toCsvText");
        String[][] table = null;
        CsvLessonSerializer instance = new CsvLessonSerializer();
        String expResult = "";
        String result = instance.toCsvText(table);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toCsvLine method, of class CsvStorage.
     */
//    @Test
    public void testToCsvLine()
    {
        System.out.println("toCsvLine");
        String[] row = null;
        CsvLessonSerializer instance = new CsvLessonSerializer();
        String expResult = "";
        String result = instance.toCsvLine(row);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toCsvCell method, of class CsvStorage.
     */
//    @Test
    public void testClearString()
    {
        System.out.println("clearString");
        String s = "";
        CsvLessonSerializer instance = new CsvLessonSerializer();
        String expResult = "";
        String result = instance.toCsvCell(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIndexOfColumnByName method, of class CsvStorage.
     */
//    @Test
    public void testGetIndexOfColumnByName()
    {
        System.out.println("getIndexOfColumnByName");
        ArrayList<String> columms = null;
        String colummName = "";
        CsvLessonSerializer instance = new CsvLessonSerializer();
        int expResult = 0;
        int result = instance.getIndexOfColumnByName(columms, colummName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
