package eu.convertron.basicmodules.settings;

import eu.convertron.interlib.io.ResourceFile;
import eu.convertron.interlib.io.TextFile;
import eu.convertron.interlib.settings.SettingID;
import eu.convertron.interlib.settings.SettingLocation;
import eu.convertron.interlib.settings.SettingLocationID;
import eu.convertron.interlib.settings.Settings;

public enum BasicSettings implements SettingID
{
    filePrefix,
    fileSuffix,
    sourcePath;

    public static final String PREFIX = "basicModules.strings.";

    @Override
    public SettingLocation getLocation()
    {
        switch(this)
        {
            case filePrefix:
            case fileSuffix:
            case sourcePath:
                return SettingLocation.LOCAL;
            default:
                return SettingLocation.GLOBAL;
        }
    }

    @Override
    public String getName()
    {
        return PREFIX + this.toString();
    }

    @Override
    public SettingLocationID getFileWithDefaultValues()
    {
        return () ->
        {
            new ResourceFile("/eu/convertron/basicmodules/res/default.settings", getClass()).copyIfNotExists(System.getProperty("java.io.tmpdir") + "convertron\\basicmodules");
            return new TextFile(System.getProperty("java.io.tmpdir") + "convertron\\basicmodules\\default.settings");
        };
    }

    public String load()
    {
        return Settings.load(this);
    }

    public void save(String value)
    {
        Settings.save(this, value);
    }
}
