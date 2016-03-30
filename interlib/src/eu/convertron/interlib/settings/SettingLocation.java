package eu.convertron.interlib.settings;

import eu.convertron.interlib.io.TextFile;

public enum SettingLocation implements SettingLocationID
{
    LOCAL,
    @Deprecated
    GLOBAL;

    @Override
    public TextFile getFile()
    {
        switch(this)
        {
            case LOCAL:
                return new TextFile("./local.settings");
            case GLOBAL:
                return new TextFile(Settings.load(SettingLocation.LOCAL.getFile(), "core.strings.pathData") + "/global.settings");
            default:
                return null;
        }
    }
}
