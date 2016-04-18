package eu.convertron.basicmodules;

import eu.convertron.interlib.data.IniConfigFile;
import eu.convertron.interlib.settings.SettingID;
import eu.convertron.interlib.settings.Settings;

public enum LocalSettings implements SettingID
{
    targets,
    sourcePath,
    fileSuffix,
    filePrefix;

    private static final String PREFIX = "basicmodules.";

    @Override
    public String getDefaultValue()
    {
        return IniConfigFile.loadValueFromIniResource(Resources.file("default.settings"), PREFIX + this.toString());
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
