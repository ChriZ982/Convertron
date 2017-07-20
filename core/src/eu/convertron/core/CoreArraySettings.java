package eu.convertron.core;

import eu.convertron.interlib.config.IniConfigFile;
import eu.convertron.interlib.settings.SettingID;
import eu.convertron.interlib.settings.Settings;

public enum CoreArraySettings implements SettingID
{
    locationOfImportedModules,
    activeOutputs;

    public static final String PREFIX = "core.arrays.";

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

    public void saveArray(String... values)
    {
        Settings.saveArray(this, values);
    }

    public String[] loadArray()
    {
        return Settings.loadArray(this);
    }
}
