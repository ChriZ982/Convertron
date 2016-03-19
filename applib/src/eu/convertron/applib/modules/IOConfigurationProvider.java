package eu.convertron.applib.modules;

import eu.convertron.interlib.data.Configuration;
import java.io.File;

public class IOConfigurationProvider implements ConfigurationProvider
{
    private File folder;

    public IOConfigurationProvider(String path)
    {
        this(new File(path));
    }

    public IOConfigurationProvider(File folder)
    {
        if(!folder.isDirectory())
            throw new IllegalArgumentException();
        folder.mkdirs();
        this.folder = folder;
    }

    @Override
    public Configuration getOrCreateConfiguration(String module)
    {
        String dic = normalize(module);
        File subFolder = new File(folder, dic);
        subFolder.mkdirs();
        return new IOConfiguration(subFolder);
    }

    private String normalize(String moduleName)
    {
        return moduleName
                .replaceAll("\\.", "-")
                .replaceAll("$", ",");
    }

}
