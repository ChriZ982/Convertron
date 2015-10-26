package convertron.settings;

import interlib.io.ResourceFile;
import interlib.io.TextFile;
import interlib.settings.SettingID;
import interlib.settings.SettingLocation;
import interlib.settings.SettingLocationID;
import interlib.settings.Settings;

public enum CoreArraySettings implements SettingID
{
    locationOfImportedModules,
    activeOutputs,

    cutHours;

    public static final String PREFIX = "core.arrays.";

    @Override
    public SettingLocationID getLocation()
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

    @Override
    public SettingLocationID getFileWithDefaultValues()
    {
        return () ->
        {
            new ResourceFile("/convertron/res/stdData/default.settings").copyIfNotExists(System.getProperty("java.io.tmpdir") + "/convertron/core");
            return new TextFile(System.getProperty("java.io.tmpdir") + "/convertron/core/default.settings");
        };
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
