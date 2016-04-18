package eu.convertron.server;

import eu.convertron.interlib.data.IniConfigFile;
import eu.convertron.interlib.settings.SettingID;
import eu.convertron.interlib.settings.Settings;

public enum ServerSettings implements SettingID
{
    pathData,
    autoInterval;

    public static final String PREFIX = "server.strings.";

    @Override
    public String getName()
    {
        return PREFIX + this.toString();
    }

    @Override
    public String getDefaultValue()
    {
        return IniConfigFile.loadValueFromIniResource(Resources.file("stdData/default.settings"), PREFIX + this.toString());
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
