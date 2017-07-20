package eu.convertron.applib;

import eu.convertron.applib.CsvStorage;
import eu.convertron.interlib.Lesson;
import eu.convertron.interlib.io.TextFile;
import java.util.ArrayList;
import static org.junit.Assert.assertArrayEquals;
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
        CsvStorage instance = new CsvStorage(new DummyTextfile());
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
        CsvStorage instance = new CsvStorage(new DummyTextfile());
        Lesson[] expResult = null;
        Lesson[] result = instance.load();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class DummyTextfile extends TextFile
    {
        String text;

        public DummyTextfile()
        {
            super("./notExisting.txt");
            text = "";
        }

        @Override
        public void writeLines(String... text)
        {
            this.text = String.join("\n", text);
        }

        @Override
        public String[] readAllToArray()
        {
            return text.split("\n");
        }

        @Override
        public boolean exists()
        {
            return true;
        }

        @Override
        public void appendLines(String... text)
        {
            this.text += String.join("\n", text);
        }

        @Override
        public void delete()
        {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean containsLineStartingWith(String prefix)
        {
            throw new UnsupportedOperationException();
        }

        @Override
        public void copy(String destination)
        {
            throw new UnsupportedOperationException();
        }

        @Override
        public void create()
        {
            throw new UnsupportedOperationException();
        }

        @Override
        public void createDirectories()
        {
            throw new UnsupportedOperationException();
        }

        @Override
        public void createIfNotExists()
        {
            throw new UnsupportedOperationException();
        }

        @Override
        public String getFileName()
        {
            return "DummyFile.txt";
        }

        @Override
        public int getLineCount()
        {
            return text.split("\n").length;
        }

        @Override
        public int getNumberOfLineStartingWith(String prefix)
        {
            throw new UnsupportedOperationException();
        }

        @Override
        public void writeLine(int lineNumber, String newText)
        {
            String[] lines = text.split("\n");
            lines[lineNumber] = newText;
            writeLines(lines);
        }

        @Override
        public String readLine(int lineNumber)
        {
            return readAllToArray()[lineNumber];
        }

        @Override
        public String readAllToString()
        {
            return text;
        }

        @Override
        public String readLineStartingWith(String prefix)
        {
            return readLine(getNumberOfLineStartingWith(prefix));
        }

        @Override
        public String[] readLinesStartingWith(String prefix)
        {
            ArrayList<String> result = new ArrayList<>();
            for(String line : readAllToArray())
            {
                if(line.startsWith(prefix))
                    result.add(line);
            }

            return result.toArray(new String[result.size()]);
        }

        @Override
        public void writeLineStartingWith(String prefix, String newText)
        {
            writeLine(getNumberOfLineStartingWith(prefix), newText);
        }
    }
}
