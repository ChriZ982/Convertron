package eu.convertron.server;

import eu.convertron.applib.settings.SettingID;
import eu.convertron.applib.settings.Settings;
import eu.convertron.interlib.config.IniConfigFile;

public enum ServerSettings implements SettingID
{
    pathGlobalData,
    pathLocalData,
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
