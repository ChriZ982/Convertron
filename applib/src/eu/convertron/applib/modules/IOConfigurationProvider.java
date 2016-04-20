package eu.convertron.applib.modules;

import eu.convertron.interlib.data.Configuration;
import java.io.File;
import java.util.HashMap;

public class IOConfigurationProvider implements ConfigurationProvider
{
    private File folder;
    private HashMap<String, IOConfiguration> configs;

    public IOConfigurationProvider(String path)
    {
        this(new File(path));
    }

    public IOConfigurationProvider(File folder)
    {
        folder.mkdirs();
        this.folder = folder;
        this.configs = new HashMap<>();
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
        if(configs.containsKey(dic))
            return configs.get(dic);

        File subFolder = new File(folder, dic);
        subFolder.mkdirs();
        IOConfiguration conf = new IOConfiguration(subFolder);
        configs.put(dic, conf);
        return conf;
    }

    private String normalize(String moduleName)
    {
        return moduleName
                .replaceAll("\\.", "-")
                .replaceAll("$", ",");
    }

}
