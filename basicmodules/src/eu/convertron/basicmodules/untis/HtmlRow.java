package eu.convertron.basicmodules.untis;

import java.util.ArrayList;
import java.util.regex.Matcher;

public class HtmlRow
{
    private HtmlCell[] cells;

    public HtmlRow(String source)
    {
        validateRow(source);

        Matcher allMatches = HtmlPatterns.TD.matcher(source);

        ArrayList<HtmlCell> cellsAsList = new ArrayList<>();

        while(allMatches.find())
        {
            cellsAsList.add(new HtmlCell(source.substring(allMatches.start(), allMatches.end())));
        }

        cells = cellsAsList.toArray(new HtmlCell[cellsAsList.size()]);
    }

    private void validateRow(String source)
    {
        source = source.toLowerCase();

        if(!source.startsWith("<tr"))
            throw new IllegalArgumentException("Source does not start with <td>");

        if(!source.endsWith("</tr>"))
            throw new IllegalArgumentException("Source does not end with </td>");
    }

    public HtmlCell[] getCells()
    {
        return cells;
    }

    public String[] getCellsAsString()
    {
        String[] cellsAsString = new String[cells.length];
        for(int i = 0; i < cells.length; i++)
        {
            cellsAsString[i] = cells[i].toString();
        }
        return cellsAsString;
    }
}
