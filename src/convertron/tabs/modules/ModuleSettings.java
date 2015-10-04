/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertron.tabs.modules;

import interlib.settings.SettingID;
import interlib.settings.SettingLocation;
import interlib.settings.Settings;

public enum ModuleSettings implements SettingID
{
    locationOfImportedModules,
    activeInput,
    activeOutputs;

    public static final String PREFIX = "core.modules.";

    @Override
    public SettingLocation getLocation()
    {
        return SettingLocation.LOCAL;
    }

    @Override
    public String getName()
    {
        return PREFIX + this.toString();
    }

    public void save(String value)
    {
        Settings.save(this, value);
    }

    public String load()
    {
        return Settings.load(this);
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
