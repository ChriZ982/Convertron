package eu.convertron.core;

import eu.convertron.interlib.io.TextFile;
import eu.convertron.interlib.settings.SettingID;
import eu.convertron.interlib.settings.SettingLocation;
import eu.convertron.interlib.settings.SettingLocationID;
import eu.convertron.interlib.settings.Settings;

public enum CoreArraySettings implements SettingID
{
    locationOfImportedModules,
    activeOutputs;

    public static final String PREFIX = "core.arrays.";

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

    @Override
    public SettingLocationID getFileWithDefaultValues()
    {
        return ()
                ->
                {
                    Resources.copyRes("stdData/default.settings", System.getProperty("java.io.tmpdir") + "convertron/core");
                    return new TextFile(System.getProperty("java.io.tmpdir") + "convertron/core/default.settings");
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
