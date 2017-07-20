package eu.convertron.basicmodules.untis;

import java.util.ArrayList;
import java.util.regex.Matcher;

public class HtmlTable
{
    private final HtmlRow[] rows;

    public HtmlTable(String source)
    {
        validateTable(source);

        Matcher allMatches = HtmlPatterns.TR.matcher(source);

        ArrayList<HtmlRow> rowsAsList = new ArrayList<>();

        while(allMatches.find())
        {
            rowsAsList.add(new HtmlRow(source.substring(allMatches.start(), allMatches.end())));
        }

        rows = rowsAsList.toArray(new HtmlRow[rowsAsList.size()]);
    }

    private void validateTable(String source)
    {
        source = source.toLowerCase();

        if(!source.contains("<table"))
            throw new IllegalArgumentException("Source does not start with <table");

        if(!source.endsWith("</table>"))
            throw new IllegalArgumentException("Source does not end with </table>");
    }

    public HtmlRow[] getRows()
    {
        return rows;
    }

    public String[][] getAllCellsAsString()
    {
        String[][] cells = new String[rows.length][];
        for(int i = 0; i < rows.length; i++)
        {
            cells[i] = rows[i].getCellsAsString();
        }
        return cells;
    }
}
