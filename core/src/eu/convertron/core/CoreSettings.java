/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.convertron.core;

import eu.convertron.interlib.config.IniConfigFile;
import eu.convertron.applib.settings.SettingID;
import eu.convertron.applib.settings.Settings;

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
    public String getName()
    {
        return PREFIX + this.toString();
    }

    @Override
    public String getDefaultValue()
    {
        return IniConfigFile.loadValueFromIniResource(Resources.file("stdData/default.settings"), PREFIX + this.toString());
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
