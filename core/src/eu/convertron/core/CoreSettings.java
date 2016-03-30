/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.convertron.core;

import eu.convertron.interlib.io.TextFile;
import eu.convertron.interlib.settings.SettingID;
import eu.convertron.interlib.settings.SettingLocation;
import eu.convertron.interlib.settings.SettingLocationID;
import eu.convertron.interlib.settings.Settings;

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
    useRemote,
    useCustomWsdl,
    remoteHost,
    remotePort,
    remoteWsdl;

    public static final String PREFIX = "core.strings.";

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

    public String load()
    {
        return Settings.load(this);
    }

    public boolean isTrue()
    {
        return this.load().equalsIgnoreCase("true");
    }

    public void save(String value)
    {
        Settings.save(this, value);
    }
}
