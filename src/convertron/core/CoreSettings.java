/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertron.core;

import interlib.settings.SettingID;
import interlib.settings.SettingLocation;
import interlib.settings.Settings;

public enum CoreSettings implements SettingID
{
    pathData,
    positionX,
    positionY,
    motdText;

    public static final String PREFIX = "core.";

    @Override
    public SettingLocation getLocation()
    {
        switch(this)
        {
            case pathData:
            case positionX:
            case positionY:
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

    public String load()
    {
        return Settings.load(this);
    }

    public void save(String value)
    {
        Settings.save(this, value);
    }
}
