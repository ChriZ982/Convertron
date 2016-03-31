package eu.convertron.server;

import eu.convertron.interlib.io.TextFile;
import eu.convertron.interlib.settings.SettingID;
import eu.convertron.interlib.settings.SettingLocationID;
import eu.convertron.interlib.settings.Settings;

public enum ServerSettings implements SettingID
{
    ;

    public static final String PREFIX = "server.strings.";

    @Override
    public SettingLocationID getLocation()
    {
        return () -> new TextFile("./local.settings");
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

    public void save(String value)
    {
        Settings.save(this, value);
    }
}
