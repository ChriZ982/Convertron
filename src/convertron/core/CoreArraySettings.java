/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertron.core;

import interlib.settings.SettingID;
import interlib.settings.SettingLocation;
import interlib.settings.Settings;

/**
 *
 * @author Mirko
 */
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
