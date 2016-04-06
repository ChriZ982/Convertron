package eu.convertron.basicmodules.untis;

import eu.convertron.basicmodules.Resources;
import eu.convertron.interlib.data.Configuration;
import eu.convertron.interlib.data.IniConfigFile;
import eu.convertron.interlib.data.Lesson;
import eu.convertron.interlib.interfaces.Configurable;
import eu.convertron.interlib.interfaces.Input;
import eu.convertron.interlib.interfaces.View;
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

public class UntisIn implements Input, Configurable
{
    private IniConfigFile configFile;

    @Override
    public void setConfiguration(Configuration config)
    {
        configFile = new IniConfigFile(config, "untisin.cfg", Resources.file("untisin.cfg"));
    }

    @Override
    public String getName()
    {
        return "Untis Import V1.0";
    }

    @Override
    public View getView()
    {
        return null;
    }

    @Override
    public Lesson[] in()
    {
        try
        {
            PrefixSuffixFileFilter filter = new PrefixSuffixFileFilter();
            File dir = new File(configFile.load("sourcePath"));

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

                content.put("Klasse", schoolClass);

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
        private String prefix, suffix;

        private PrefixSuffixFileFilter()
        {
            prefix = configFile.load("filePrefix");
            suffix = configFile.load("fileSuffix");
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
