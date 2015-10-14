 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertron.settings;

import interlib.settings.SettingID;
import interlib.settings.SettingLocation;
import interlib.settings.Settings;

public enum CoreSettings implements SettingID
{
    pathData,
    pathBackup,
    positionX,
    positionY,
    activeInput,
    autoMode,
    autoImport,
    autoExport,
    autoBackup,

    motdText,
    useCutHours,
    useCustomDate,
    customDateToday,
    customDateTomorrow,
    evenWeekChar;

    public static final String PREFIX = "core.strings.";

    @Override
    public SettingLocation getLocation()
    {
        switch(this)
        {
            case pathData:
            case pathBackup:
            case positionX:
            case positionY:
            case activeInput:
            case autoMode:
            case autoImport:
            case autoExport:
            case autoBackup:
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
