package eu.convertron.applib.modules;

import eu.convertron.interlib.config.ConfigurationSource;
import java.io.File;
import java.util.HashMap;

public class IOConfigurationProvider implements ConfigurationSourceProvider
{
    private File folder;
    private HashMap<String, IOConfigurationSource> configs;

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
    public ConfigurationSource getOrCreateConfiguration(String moduleName)
    {
        String dic = normalize(moduleName);
        if(configs.containsKey(dic))
            return configs.get(dic);

        File subFolder = new File(folder, dic);
        subFolder.mkdirs();
        IOConfigurationSource conf = new IOConfigurationSource(subFolder);
        configs.put(dic, conf);
        return conf;
    }

    private String normalize(String moduleName)
    {
        return moduleName
                .replaceAll("\\.", "-")
                .replaceAll("\\$", ",");
    }

}
