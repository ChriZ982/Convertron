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
        folder.mkdirs();
        this.folder = folder;
    }

    @Override
    public Configuration getOrCreateConfiguration(Class<?> module)
    {
        return getOrCreateConfiguration(module.getName());
    }

    @Override
    public Configuration getOrCreateConfiguration(String moduleName)
    {
        String dic = normalize(moduleName);
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
