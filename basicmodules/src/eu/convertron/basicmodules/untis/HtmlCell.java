package eu.convertron.basicmodules.untis;

public class HtmlCell
{
    private final String textContent;

    public HtmlCell(String source)
    {
        validateSource(source);
        source = source.replaceAll("\n", "");
        source = source.replaceAll("&nbsp;", " ");
        source = source.replaceAll("\\s*<[^>]*>\\s*", "");
        textContent = source.trim();
    }

    private void validateSource(String source)
    {
        source = source.toLowerCase();

        if(!source.startsWith("<td"))
            throw new IllegalArgumentException("Source does not start with <td>");

        if(!source.endsWith("</td>"))
            throw new IllegalArgumentException("Source does not end with </td>");
    }

    @Override
    public String toString()
    {
        return textContent;
    }
}
