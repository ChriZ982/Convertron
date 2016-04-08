package eu.convertron.basicmodules;

import eu.convertron.interlib.io.TextFile;
import eu.convertron.interlib.settings.SettingID;
import eu.convertron.interlib.settings.SettingLocation;
import eu.convertron.interlib.settings.SettingLocationID;
import eu.convertron.interlib.settings.Settings;

public enum LocalSettings implements SettingID
{
    targets,
    sourcePath,
    fileSuffix,
    filePrefix;

    private static final String PREFIX = "basicmodules.";

    @Override
    public SettingLocationID getFileWithDefaultValues()
    {
        return ()
                ->
                {
                    Resources.copyRes("default.settings", System.getProperty("java.io.tmpdir") + "convertron/basicmodules");
                    return new TextFile(System.getProperty("java.io.tmpdir") + "convertron/basicmodules/default.settings");
        };
    }

    @Override
    public SettingLocationID getLocation()
    {
        return SettingLocation.LOCAL;
    }

    @Override
    public String getName()
    {
        return PREFIX + this.toString();
    }

    public String load()
    {
        return Settings.load(this);
    }

    public boolean isTrue()
    {
        return this.load().equalsIgnoreCase("true");
    }

    public void save(String value)
    {
        Settings.save(this, value);
    }

    public void saveArray(String... values)
    {
        Settings.saveArray(this, values);
    }

    public String[] loadArray()
    {
        return Settings.loadArray(this);
    }
}
