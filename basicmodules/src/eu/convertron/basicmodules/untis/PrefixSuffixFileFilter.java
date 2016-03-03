package eu.convertron.basicmodules.untis;

import eu.convertron.basicmodules.settings.BasicSettings;
import java.io.File;
import java.io.FileFilter;

public class PrefixSuffixFileFilter implements FileFilter
{
    private String prefix, suffix;

    public PrefixSuffixFileFilter()
    {
        prefix = BasicSettings.filePrefix.load();
        suffix = BasicSettings.fileSuffix.load();
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

    public String getPrefix()
    {
        return prefix;
    }

    public String getSuffix()
    {
        return suffix;
    }
}
