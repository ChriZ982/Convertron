package eu.convertron.applib.settings;

import eu.convertron.interlib.settings.SettingID;
import eu.convertron.interlib.settings.Settings;

public abstract class ComponentSetting
{
    protected SettingID setting;
    protected int index;

    public ComponentSetting(SettingID setting)
    {
        this(setting, -1);
    }

    public ComponentSetting(SettingID arraySetting, int index)
    {
        this.setting = arraySetting;
        this.index = index;
    }

    public void save()
    {
        if(index < 0)
            Settings.save(setting, getValue());
        else
            Settings.saveArrayCell(setting, index, getValue());
    }

    public void load()
    {
        if(index < 0)
            setValue(Settings.load(setting));
        else
            setValue(Settings.loadArrayCell(setting, index));
    }

    protected abstract void setValue(String value);

    protected abstract String getValue();
}
