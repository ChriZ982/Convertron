package eu.convertron.server;

import eu.convertron.interlib.data.IniConfigFile;
import eu.convertron.interlib.settings.SettingID;
import eu.convertron.interlib.settings.Settings;

public enum ServerArraySettings implements SettingID
{
    locationOfImportedOutputs;

    public static final String PREFIX = "server.arrays.";

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

    public String[] load()
    {
        return Settings.loadArray(this);
    }

    public void save(String[] values)
    {
        Settings.saveArray(this, values);
    }
}
