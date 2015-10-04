package convertron.tabs.settings;

import interlib.settings.SettingID;
import interlib.settings.Settings;

public abstract class SettingHandler
{
    protected SettingID setting;
    protected int index;

    public SettingHandler(SettingID setting)
    {
        this(setting, -1);
    }

    public SettingHandler(SettingID arraySetting, int index)
    {
        this.setting = arraySetting;
        this.index = index;
    }

    public void save()
    {
        if(index < 0)
        {
            Settings.save(setting, getValue());
        }
        else
        {
            String[] loaded = Settings.loadArray(setting);
            String arr[] = new String[Math.max(index + 1, loaded.length)];
            System.arraycopy(loaded, 0, arr, 0, loaded.length);

            arr[index] = getValue();
            Settings.saveArray(setting, arr);
        }
    }

    public void load()
    {
        if(index < 0)
        {
            setValue(Settings.load(setting));
        }
        else
        {
            String[] arr = Settings.loadArray(setting);
            setValue(index < arr.length ? arr[index] : "");
        }
    }

    protected abstract void setValue(String value);

    protected abstract String getValue();
}
