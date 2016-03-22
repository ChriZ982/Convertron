package eu.convertron.interlib.data;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;

public class IniConfigFile
{
    private Configuration configuration;
    private String configName;
    private boolean autoFlush;

    private HashMap<String, String> content;

    public IniConfigFile(Configuration configuration, String configName)
    {
        this(configuration, configName, true);
    }

    public IniConfigFile(Configuration configuration, String configName, boolean autoFlush)
    {
        this.configuration = configuration;
        this.configName = configName;
        this.autoFlush = autoFlush;

        this.content = new HashMap<>();

        configuration.addConfigListener(new ConfigurationListener()
        {
            @Override
            public void configurationChanged(HashMap<String, byte[]> changed, boolean complete)
            {
                if(changed.containsKey(configName))
                    reload(changed.get(configName));
            }

            @Override
            public void newConfigurationAdded(String name)
            {
            }
        });

        reload();
    }

    public String load(String key)
    {
        return content.containsKey(key) ? content.get(key) : null;
    }

    public String[] loadArray(String key)
    {
        return content.containsKey(key) ? content.get(key).split(";") : null;
    }

    public void save(String key, String value)
    {
        if(key.contains(":"))
            throw new IllegalArgumentException("The key cannnot contain a ':'");

        content.put(key, value);
        if(autoFlush)
            flush();
    }

    public void saveArray(String key, String[] values)
    {
        for(String v : values)
        {
            if(v.contains(";"))
                throw new IllegalArgumentException("The values in the array that should be saved cannot contain a ';'");
        }

        save(key, String.join(";", values));
    }

    public void flush()
    {
        StringBuilder builder = new StringBuilder();
        Iterator<HashMap.Entry<String, String>> it = content.entrySet().iterator();
        while(it.hasNext())
        {
            HashMap.Entry<String, String> entry = it.next();
            builder.append(entry.getKey()).append(":")
                    .append(entry.getValue()).append("\n");
        }
        configuration.setConfig(configName, builder.toString().getBytes(StandardCharsets.UTF_8));
    }

    public void reload()
    {
        reload(configuration.getOrCreateConfig(configName));
    }

    private void reload(byte[] value)
    {
        content.clear();
        String file = new String(value, StandardCharsets.UTF_8);
        String[] lines = file.split("\n");
        for(String line : lines)
        {
            if(!line.contains(":"))
                continue;

            String[] entry = line.trim().split(":", 2);
            content.put(entry[0], entry[1]);
        }
    }
}
