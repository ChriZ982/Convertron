/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertron.core;

import interlib.data.Lesson;
import java.util.ArrayList;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author Mirko
 */
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
     * Test of splitOutsideCellBorders method, of class CsvStorage.
     */
//    @Test
    public void testSplit()
    {
        System.out.println("split");
        String source = "";
        String spliterator = "";
        CsvStorage instance = new CsvStorage();
        String[] expResult = null;
        String[] result = instance.splitOutsideCellBorders(source, spliterator);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of indexOfSingleCellBorder method, of class CsvStorage.
     */
    @Test
    public void testIndexOfSingleCellBorder()
    {
        System.out.println("indexOfSingleCellBorder");
        String source = "";
        int start = 0;
        CsvStorage instance = new CsvStorage();
        int expResult = -1;
        int result = instance.indexOfSingleCellBorder(source, start);
        assertEquals(expResult, result);
    }

    /**
     * Test of indexOfSingleCellBorder method, of class CsvStorage.
     */
    @Test
    public void testIndexOfSingleCellBorder1()
    {
        System.out.println("indexOfSingleCellBorder");
        String source = "ioauvbasoivb";
        int start = 0;
        CsvStorage instance = new CsvStorage();
        int expResult = -1;
        int result = instance.indexOfSingleCellBorder(source, start);
        assertEquals(expResult, result);
    }

    /**
     * Test of indexOfSingleCellBorder method, of class CsvStorage.
     */
    @Test
    public void testIndexOfSingleCellBorder2()
    {
        System.out.println("indexOfSingleCellBorder");
        String source = "\"\"";
        int start = 0;
        CsvStorage instance = new CsvStorage();
        int expResult = -1;
        int result = instance.indexOfSingleCellBorder(source, start);
        assertEquals(expResult, result);
    }

    /**
     * Test of indexOfSingleCellBorder method, of class CsvStorage.
     */
    @Test
    public void testIndexOfSingleCellBorder3()
    {
        System.out.println("indexOfSingleCellBorder");
        String source = "\"";
        int start = 0;
        CsvStorage instance = new CsvStorage();
        int expResult = 0;
        int result = instance.indexOfSingleCellBorder(source, start);
        assertEquals(expResult, result);
    }

    /**
     * Test of indexOfSingleCellBorder method, of class CsvStorage.
     */
    @Test
    public void testIndexOfSingleCellBorder4()
    {
        System.out.println("indexOfSingleCellBorder");
        String source = "\"\"\"";
        int start = 0;
        CsvStorage instance = new CsvStorage();
        int expResult = 2;
        int result = instance.indexOfSingleCellBorder(source, start);
        assertEquals(expResult, result);
    }

    /**
     * Test of indexOfSingleCellBorder method, of class CsvStorage.
     */
    @Test
    public void testIndexOfSingleCellBorder5()
    {
        System.out.println("indexOfSingleCellBorder");
        String source = "\"\"\"\"\"";
        int start = 0;
        CsvStorage instance = new CsvStorage();
        int expResult = 4;
        int result = instance.indexOfSingleCellBorder(source, start);
        assertEquals(expResult, result);
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
     * Test of clearString method, of class CsvStorage.
     */
//    @Test
    public void testClearString()
    {
        System.out.println("clearString");
        String s = "";
        CsvStorage instance = new CsvStorage();
        String expResult = "";
        String result = instance.clearString(s);
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
