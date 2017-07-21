package eu.convertron.basicmodules.untis;

import eu.convertron.interlib.config.IniConfigFile;
import java.util.regex.Pattern;

public class HtmlPatterns
{
    public static final int PATTERNFLAGS = Pattern.DOTALL + Pattern.CASE_INSENSITIVE;

    public static void loadConfig(IniConfigFile config)
    {

    }

    public static Pattern TR;
    public static Pattern TD;
    public static Pattern LESSONTABLE;
    public static Pattern SCHOOLCLASS;

    /**
     * Kompiliert den regulären Ausdruck unter Verwendung der Flags.
     * @param regex Der zum kompilierende reguläre Ausdruck
     * @return Das Pattern
     */
    public static Pattern compile(String regex)
    {
        return Pattern.compile(regex, PATTERNFLAGS);
    }

    private HtmlPatterns()
    {
    }
}
