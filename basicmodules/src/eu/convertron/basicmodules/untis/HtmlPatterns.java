package eu.convertron.basicmodules.untis;

import java.util.regex.Pattern;

public class HtmlPatterns
{
    public static final int PATTERNFLAGS = Pattern.DOTALL + Pattern.CASE_INSENSITIVE;

    public static final Pattern TR = compile("<tr.*?</tr>");
    public static final Pattern TD = compile("<td.*?</td>");
    public static final Pattern LESSONTABLE = compile("<br>\\s*<table.*?</table>");
    public static final Pattern SCHOOLCLASS = compile("<br>\\s*<font size=\"6\".*?</font>\\s*<br>");

    /**
     * Kompiliert den regulären Ausdruck unter Verwendung der Flags.
     * @param regex Der zum kompilierende reguläre Ausdruck
     * @return Das Pattern
     */
    public static Pattern compile(String regex)
    {
        return Pattern.compile(regex, PATTERNFLAGS);
    }
}
