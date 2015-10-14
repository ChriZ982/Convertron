package convertron.settings;

import interlib.settings.SettingID;
import interlib.settings.SettingLocation;
import interlib.settings.Settings;

public enum CoreArraySettings implements SettingID
{
    locationOfImportedModules,
    activeOutputs,

    cutHours;

    public static final String PREFIX = "core.arrays.";

    @Override
    public SettingLocation getLocation()
    {
        switch(this)
        {
            case locationOfImportedModules:
            case activeOutputs:
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

    public void saveArray(String... values)
    {
        Settings.saveArray(this, values);
    }

    public String[] loadArray()
    {
        return Settings.loadArray(this);
    }
}
