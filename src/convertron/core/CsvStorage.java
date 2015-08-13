package convertron.core;

import interlib.data.Lesson;
import interlib.io.FileIO;
import interlib.util.Logger;
import java.util.ArrayList;

public class CsvStorage implements Storage
{
    private FileIO csvFileIO;

    private static final String lineSpliterator = System.getProperty("line.seperator");
    private static final String columnSpliterator = ";";
    private static final String cellBorders = "\"";

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

            csvFileIO.writeLines(toWrite);
        }
        catch(Exception ex)
        {
            Logger.logMessage(Logger.ERROR, "Fehler beim Speichern der Vertretungsplaninformationen");
            Logger.logError(Logger.ERROR, ex);
        }
    }

    @Override
    public Lesson[] load()
    {
        throw new UnsupportedOperationException("Not yet implemtented"); //TODO implement
    }

    protected String[] splitOutsideCellBorders(String source, String spliterator)
    {
        ArrayList<String> parts = new ArrayList<>();

        int beginIndex = 0;
        int endIndex = 0;

        if(indexOfSingleCellBorder(source, 0) < 0)
            return source.split(spliterator.replaceAll("\\\\", "\\\\"));

        while(source.indexOf(spliterator, beginIndex) >= 0)
        {
            //TODO add Code
        }

        parts.add(source.substring(beginIndex));
        return parts.toArray(new String[parts.size()]);
    }

    protected int indexOfSingleCellBorder(String source, int start)
    {
        int i = start;
        while(source.indexOf(cellBorders + cellBorders, i) >= 0
              && source.indexOf(cellBorders + cellBorders, i) <= source.indexOf(cellBorders, i))
        {
            i = source.indexOf(cellBorders + cellBorders, i) + 2;
        }
        return source.indexOf(cellBorders, i);
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
            result += clearString(cell) + columnSpliterator;
        }
        if(result.endsWith(columnSpliterator))
            result = result.substring(0, result.length() - columnSpliterator.length());

        return result;
    }

    protected String clearString(String s)
    {
        boolean needsDoubleQuotes = s.contains(lineSpliterator) || s.contains(columnSpliterator);
        s = s.replaceAll(cellBorders, cellBorders + cellBorders);

        if(needsDoubleQuotes)
            s = cellBorders + s + cellBorders;

        return s;
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
                if(lesson.containsKeyAndValueNotNullOrEmpty(column))
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
                this.content = content;
            }
        }
    }
}
