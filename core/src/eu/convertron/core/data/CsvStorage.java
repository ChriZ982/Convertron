package eu.convertron.core.data;

import eu.convertron.core.settings.CoreSettings;
import eu.convertron.interlib.data.Lesson;
import eu.convertron.interlib.io.TextFile;
import eu.convertron.interlib.logging.Logger;
import eu.convertron.interlib.logging.messages.LogPriority;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Die Klasse zum Zwischenspeichern von Stunden-Array und Laufschrift mithilfe von Csv-Dateien.
 */
public class CsvStorage implements Storage
{
    private static final String lineSpliterator = "\n";
    private static final String columnSpliterator = ";";
    private static final String cellBorders = "\"";

    private TextFile csvFile;

    public CsvStorage()
    {
        this(new TextFile(CoreSettings.pathData.load() + "/data.csv"));
    }

    public CsvStorage(TextFile csvFile)
    {
        this.csvFile = csvFile;
    }

    @Override
    public void save(Lesson[] lessons)
    {
        try
        {
            ArrayList<String> columnNames = new ArrayList<>();
            ArrayList<Row> rows = new ArrayList<>();

            for(Lesson lesson : lessons)
            {
                rows.add(new Row(lesson, columnNames));
            }

            ArrayList<String[]> rowsAsStringArray = new ArrayList<>();
            rowsAsStringArray.add(columnNames.toArray(new String[columnNames.size()]));

            for(Row row : rows)
            {
                rowsAsStringArray.add(row.toArray());
            }

            String toWrite = toCsvText(rowsAsStringArray.toArray(new String[0][]));

            csvFile.writeLines(toWrite);
        }
        catch(Exception ex)
        {
            Logger.logError(LogPriority.ERROR, "Fehler beim Speichern der Vertretungsplaninformationen", ex);
        }
    }

    @Override
    public Lesson[] load()
    {
        ArrayList<Lesson> result = new ArrayList<>();
        try
        {
            String fileAsString = csvFile.readAllToString().trim();
            assertValidFile(fileAsString);

            fileAsString = fileAsString.substring(cellBorders.length(),
                                                  fileAsString.length() - cellBorders.length());

            String[] rows = fileAsString.split((cellBorders + lineSpliterator + cellBorders)
                    .replaceAll("\\\\", "\\\\"));

            String[] columnNames = getColumns(rows[0]);

            for(int i = 1; i < rows.length; i++)
            {
                String[] columns = getColumns(rows[i]);

                TreeMap<String, String> content = new TreeMap<>();
                putAll(content, columnNames, columns);
                result.add(new Lesson(content));
            }
        }
        catch(Exception ex)
        {
            Logger.logError(LogPriority.ERROR, "Fehler beim Laden der Vertretungsplaninformationen", ex);
        }
        return result.toArray(new Lesson[result.size()]);
    }

    protected String[] getColumns(String row)
    {
        return row.split((cellBorders + columnSpliterator + cellBorders)
                .replaceAll("\\\\", "\\\\"));
    }

    protected void putAll(Map<String, String> map, String[] keys, String[] values)
    {
        if(keys.length != values.length)
            throw new IllegalArgumentException("Keys and Values differ in length");

        for(int i = 0; i < keys.length; i++)
        {
            map.put(keys[i], values[i]);
        }
    }

    protected void assertValidFile(String fileAsString)
    {
        if(!fileAsString.startsWith(cellBorders) || !fileAsString.endsWith(cellBorders))
            throw new RuntimeException("Malformed Csv-File: The File must start and end with " + cellBorders);
    }

    protected String toCsvText(String[][] table)
    {
        String result = "";
        for(String[] row : table)
            result += toCsvLine(row) + lineSpliterator;

        return result;
    }

    protected String toCsvLine(String[] row)
    {
        String result = "";
        for(String cell : row)
        {
            result += toCsvCell(cell) + columnSpliterator;
        }
        if(result.endsWith(columnSpliterator))
            result = result.substring(0, result.length() - columnSpliterator.length());

        return result;
    }

    protected String toCsvCell(String s)
    {
        if(s == null)
            return cellBorders + cellBorders;
        return cellBorders + (s.replaceAll("\"", "'")) + cellBorders;
    }

    protected int getIndexOfColumnByName(ArrayList<String> columms, String colummName)
    {
        if(!columms.contains(colummName))
            columms.add(colummName);

        return columms.indexOf(colummName);
    }

    protected class Row
    {
        private Lesson lesson;
        private ArrayList<String> columnNames;
        private Entry[] entrys;

        protected Row(Lesson lesson, ArrayList<String> columnNames)
        {
            this.lesson = lesson;
            this.columnNames = columnNames;
            generateEntrys();
        }

        private void generateEntrys()
        {
            ArrayList<Entry> result = new ArrayList<>();
            String[] columns = lesson.getAllKeys();

            for(String column : columns)
            {
                if(lesson.contains(column))
                    result.add(new Entry(getIndexOfColumnByName(columnNames, column), lesson.get(column)));
            }

            entrys = result.toArray(new Entry[result.size()]);
        }

        protected String[] toArray()
        {
            String[] result = new String[columnNames.size()];
            for(Entry entry : entrys)
                result[entry.index] = entry.content;
            return result;
        }

        private class Entry
        {
            int index;
            String content;

            Entry(int index, String content)
            {
                this.index = index;
                this.content = content == null ? "" : content;
            }
        }
    }
}