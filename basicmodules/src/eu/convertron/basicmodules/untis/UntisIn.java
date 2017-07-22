package eu.convertron.basicmodules.untis;

import eu.convertron.basicmodules.Resources;
import eu.convertron.interlib.Lesson;
import eu.convertron.interlib.config.DesiredLocation;
import eu.convertron.interlib.config.IniConfigFile;
import eu.convertron.interlib.config.LoadingContext;
import eu.convertron.interlib.config.ModuleConfiguration;
import eu.convertron.interlib.config.ModuleInitializationResult;
import eu.convertron.interlib.interfaces.Input;
import eu.convertron.interlib.io.Folder;
import eu.convertron.interlib.io.TextFile;
import eu.convertron.interlib.logging.LogPriority;
import eu.convertron.interlib.logging.Logger;
import java.io.File;
import java.io.FileFilter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;

public class UntisIn implements Input
{
    private IniConfigFile configFile;

    public static final String SOURCEPATH = "sourcePath";
    public static final String FILESUFFIX = "fileSuffix";
    public static final String FILEPREFIX = "filePrefix";

    public static final String PATTERN_TR = "patternTr";
    public static final String PATTERN_TD = "patternTd";
    public static final String PATTERN_TABLE = "patternTable";
    public static final String PATTERN_CLASS = "patternClass";

    @Override
    public ModuleInitializationResult init(ModuleConfiguration moduleconfig, LoadingContext context)
    {
        this.configFile = new IniConfigFile(moduleconfig, "untisinlocal.cfg", DesiredLocation.ForceLocal,
                                            Resources.file("untisinlocal.cfg"));

        return new ModuleInitializationResult(new UntisInView(configFile), "Untis Import V1.0");
    }

    @Override
    public Lesson[] in()
    {
        try
        {
            PrefixSuffixFileFilter filter = new PrefixSuffixFileFilter();
            File dir = new File(configFile.load(SOURCEPATH));

            if(!dir.isDirectory() || !dir.exists())
            {
                throw new RuntimeException(dir.getName() + " does not exists or is not a folder");
            }

            if(dir.listFiles().length <= 0)
                return null;

            File[] files = getFiles(dir, filter);

            ArrayList<Lesson> result = new ArrayList<>();

            for(File f : files)
            {
                result.addAll(Arrays.asList(readFromHtmlFile(f)));
            }

            new Folder(dir).deleteContent();
            return result.toArray(new Lesson[result.size()]);
        }
        catch(Exception ex)
        {
            Logger.logError(LogPriority.WARNING, "Fehler beim einlesen der Vertretungeinträge per Html", ex);
        }
        return null;
    }

    private File[] getFiles(File file, PrefixSuffixFileFilter filter)
    {
        ArrayList<File> result = new ArrayList<>();

        if(file.isDirectory())
        {
            for(File subFile : file.listFiles())
            {
                result.addAll(Arrays.asList(getFiles(subFile, filter)));
            }
        }
        else if(filter.accept(file))
        {
            result.add(file);
        }

        return result.toArray(new File[result.size()]);
    }

    private Lesson[] readFromHtmlFile(File f)
    {
        String source = new TextFile(f, Charset.forName("ISO-8859-1")).readAllToString();
        String schoolClass = getSchoolClass(source);
        HtmlTable table = new HtmlTable(getTable(source));

        String[][] cells = table.getAllCellsAsString();
        String[] keys = cells[0];

        ArrayList<Lesson> result = new ArrayList<>();

        for(int i = 1; i < cells.length; i++)
        {
            try
            {
                TreeMap<String, String> content = new TreeMap<>();
                String[] row = cells[i];

                for(int j = 0; j < row.length; j++)
                {
                    content.put(keys[j], row[j]);
                }

                if(isAdditionalRow(content))
                {
                    Lesson lastLesson = result.get(result.size() - 1);

                    for(String key : content.keySet())
                    {
                        String value = content.get(key);
                        if(isNotNullOrEmpty(value))
                            lastLesson.append(key, value);
                    }
                }
                else
                {
                    content.put("Klasse", schoolClass);
                    result.add(new Lesson(content));
                }
            }
            catch(Exception ex)
            {
                Logger.logError(LogPriority.WARNING, "Fehlerhafter Datensatz in der Datei " + f.getName()
                                                     + " Datensatz Nummer: " + i, ex);
            }
        }

        return result.toArray(new Lesson[result.size()]);
    }

    private boolean isAdditionalRow(TreeMap<String, String> content)
    {
        if(!content.containsKey("Std") || !content.containsKey("Datum"))
            return false;

        if(isNotNullOrEmpty(content.get("Std"))
           || isNotNullOrEmpty(content.get("Datum")))
            return false;

        return true;
    }

    private boolean isNotNullOrEmpty(String value)
    {
        return value != null
               && !value.isEmpty()
               && !value.trim().equalsIgnoreCase("&nbsp;");
    }

    private String getTable(String source)
    {
        Matcher allMatches = HtmlPatterns.LESSONTABLE.matcher(source);

        if(!allMatches.find())
        {
            throw new IllegalArgumentException("The source does not contain the table "
                                               + "which should be found by Regex: "
                                               + HtmlPatterns.LESSONTABLE.pattern());
        }
        MatchResult tableMatch = allMatches.toMatchResult();

        return source.substring(tableMatch.start(), tableMatch.end());
    }

    private String getSchoolClass(String source)
    {
        Matcher allMatches = HtmlPatterns.SCHOOLCLASS.matcher(source);

        if(!allMatches.find())
        {
            throw new IllegalArgumentException("The source does not contain the SchoolClass "
                                               + "which should be found by Regex: "
                                               + HtmlPatterns.SCHOOLCLASS.pattern());
        }
        MatchResult tableMatch = allMatches.toMatchResult();

        return source
                .substring(tableMatch.start(), tableMatch.end())
                .replaceAll("\n", "")
                .replaceAll("\\s", "")
                .replaceAll("<[^>]*>", "");
    }

    private class PrefixSuffixFileFilter implements FileFilter
    {
        private final String prefix;
        private final String suffix;

        private PrefixSuffixFileFilter()
        {
            prefix = configFile.load(FILEPREFIX);
            suffix = configFile.load(FILESUFFIX);
        }

        @Override
        public boolean accept(File pathname)
        {
            if(prefix != null && !prefix.isEmpty())
            {
                if(!pathname.getName().startsWith(prefix))
                    return false;
            }

            if(suffix != null && !suffix.isEmpty())
            {
                if(!pathname.getName().endsWith(suffix))
                    return false;
            }

            return true;
        }
    }
}
