package eu.convertron.applib.etc;

import eu.convertron.interlib.data.Lesson;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class CsvLessonSerializer
{
    private static final String LINESPERATOR = "\n";
    private static final String COLUMNSEPERATOR = ";";
    private static final String CELLBORDERS = "\"";

    public String serializeMultiple(Lesson[] lessons)
    {
        if(lessons == null)
            throw new IllegalArgumentException();

        ArrayList<String> columnNames = new ArrayList<>();
        ArrayList<CsvLessonSerializer.Row> rows = new ArrayList<>();

        for(Lesson lesson : lessons)
        {
            rows.add(new CsvLessonSerializer.Row(lesson, columnNames));
        }

        ArrayList<String[]> rowsAsStringArray = new ArrayList<>();
        rowsAsStringArray.add(columnNames.toArray(new String[columnNames.size()]));

        for(CsvLessonSerializer.Row row : rows)
        {
            rowsAsStringArray.add(row.toArray());
        }

        return toCsvText(rowsAsStringArray.toArray(new String[rowsAsStringArray.size()][]));

    }

    public Lesson[] deserializeMultiple(String string)
    {
        ArrayList<Lesson> result = new ArrayList<>();
        String serilazation = string.trim();
        assertValidFile(serilazation);

        serilazation = serilazation.substring(CELLBORDERS.length(),
                                              serilazation.length() - CELLBORDERS.length());

        String[] rows = serilazation.split((CELLBORDERS + LINESPERATOR + CELLBORDERS)
                .replaceAll("\\\\", "\\\\"));

        String[] columnNames = getColumns(rows[0]);

        for(int i = 1; i < rows.length; i++)
        {
            String[] columns = getColumns(rows[i]);

            TreeMap<String, String> content = new TreeMap<>();
            putAll(content, columnNames, columns);
            result.add(new Lesson(content));
        }
        return result.toArray(new Lesson[result.size()]);
    }

    protected String[] getColumns(String row)
    {
        return row.split((CELLBORDERS + COLUMNSEPERATOR + CELLBORDERS)
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
        if(!fileAsString.startsWith(CELLBORDERS) || !fileAsString.endsWith(CELLBORDERS))
            throw new RuntimeException("Malformed Csv-File: The File must start and end with " + CELLBORDERS);
    }

    protected String toCsvText(String[][] table)
    {
        String result = "";
        for(String[] row : table)
            result += toCsvLine(row) + LINESPERATOR;

        return result;
    }

    protected String toCsvLine(String[] row)
    {
        String result = "";
        for(String cell : row)
        {
            result += toCsvCell(cell) + COLUMNSEPERATOR;
        }
        if(result.endsWith(COLUMNSEPERATOR))
            result = result.substring(0, result.length() - COLUMNSEPERATOR.length());

        return result;
    }

    protected String toCsvCell(String s)
    {
        if(s == null)
            return CELLBORDERS + CELLBORDERS;
        return CELLBORDERS + (s.replaceAll("\"", "'")) + CELLBORDERS;
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