package convertron.core;

import convertron.data.CsvStorage;
import interlib.data.Lesson;
import java.util.ArrayList;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CsvStorageTest
{

    public CsvStorageTest()
    {
    }

    /**
     * Test of save method, of class CsvStorage.
     */
//    @Test
    public void testSave()
    {
        System.out.println("save");
        Lesson[] lessons = null;
        CsvStorage instance = new CsvStorage();
        instance.save(lessons);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of load method, of class CsvStorage.
     */
//    @Test
    public void testLoad()
    {
        System.out.println("load");
        CsvStorage instance = new CsvStorage();
        Lesson[] expResult = null;
        Lesson[] result = instance.load();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toCsvText method, of class CsvStorage.
     */
//    @Test
    public void testToCsvText()
    {
        System.out.println("toCsvText");
        String[][] table = null;
        CsvStorage instance = new CsvStorage();
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
        CsvStorage instance = new CsvStorage();
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
        CsvStorage instance = new CsvStorage();
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
        CsvStorage instance = new CsvStorage();
        int expResult = 0;
        int result = instance.getIndexOfColumnByName(columms, colummName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
