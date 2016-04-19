package eu.convertron.basicmodules.untis;

import eu.convertron.basicmodules.LocalSettings;
import java.util.regex.Pattern;

public class HtmlPatterns
{
    public static final int PATTERNFLAGS = Pattern.DOTALL + Pattern.CASE_INSENSITIVE;

    public static final Pattern TR = compile(LocalSettings.patternTr.load());
    public static final Pattern TD = compile(LocalSettings.patternTd.load());
    public static final Pattern LESSONTABLE = compile(LocalSettings.patternTable.load());
    public static final Pattern SCHOOLCLASS = compile(LocalSettings.patternClass.load());

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
