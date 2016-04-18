package eu.convertron.interlib.data;

import eu.convertron.interlib.io.ResourceFile;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class IniConfigFile
{
    public static HashMap<String, String> deserialize(String s)
    {
        HashMap<String, String> result = new HashMap<>();
        String[] lines = s.split("\n");
        for(String line : lines)
        {
            if(!line.contains(":"))
                continue;

            String[] entry = line.trim().split(":", 2);
            result.put(entry[0], entry[1]);
        }
        return result;
    }

    public static String serialize(HashMap<String, String> map)
    {
        StringBuilder builder = new StringBuilder();
        Iterator<Entry<String, String>> it = map.entrySet().iterator();
        while(it.hasNext())
        {
            Entry<String, String> entry = it.next();
            builder.append(entry.getKey()).append(":")
                    .append(entry.getValue()).append("\n");
        }
        return builder.toString();
    }

    private Configuration configuration;
    private String configName;
    private boolean autoFlush;

    private HashMap<String, String> content;

    public IniConfigFile(Configuration configuration, String configName)
    {
        this(configuration, configName, true);
    }

    public IniConfigFile(Configuration configuration, String configName, ResourceFile defaults)
    {
        this(configuration, configName);
        loadDefaultsFromResource(defaults);
    }

    public IniConfigFile(Configuration configuration, String configName, boolean autoFlush)
    {
        this.configuration = configuration;
        this.configName = configName;
        this.autoFlush = autoFlush;

        this.content = new HashMap<>();

        configuration.addConfigListener(new SingleConfigurationListener(configName, (v) -> reload(v)));

        reload();
    }

    public HashMap<String, String> loadAll()
    {
        return new HashMap<>(content);
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

    public void insertDefaults(HashMap<String, String> defaults)
    {
        boolean af = autoFlush;
        autoFlush = false;
        Iterator<Entry<String, String>> it = defaults.entrySet().iterator();
        while(it.hasNext())
        {
            Entry<String, String> entry = it.next();
            if(!content.containsKey(entry.getKey()))
                save(entry.getKey(), entry.getValue());
        }
        autoFlush = af;
        flush();
    }

    public void loadDefaultsFromResource(String resource, Class<?> parent)
    {
        loadDefaultsFromResource(new ResourceFile(resource, parent));
    }

    public void loadDefaultsFromResource(ResourceFile f)
    {
        String resource = new String(f.readAllBytes(), StandardCharsets.UTF_8);
        HashMap<String, String> defaults = IniConfigFile.deserialize(resource);
        insertDefaults(defaults);
    }

    public void flush()
    {
        configuration.setConfig(configName, serialize(content).getBytes(StandardCharsets.UTF_8));
    }

    public void reload()
    {
        reload(configuration.getOrCreateConfig(configName));
    }

    private void reload(byte[] value)
    {
        content.clear();
        content.putAll(deserialize(new String(value, StandardCharsets.UTF_8)));
    }

    public void addConifgFileListener(SingleConfigurationListener.ConfigFileListener l)
    {
        configuration.addConfigListener(new SingleConfigurationListener(configName, l));
    }
}
