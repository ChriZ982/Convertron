package eu.convertron.applib.settings;

import eu.convertron.interlib.interfaces.View;
import eu.convertron.interlib.util.GuiBridge;

public class GuiSettingBridge extends GuiBridge
{
    private final SettingID setting;
    private final int index;

    public GuiSettingBridge(SettingID arraySettingID, int index, Object... comps)
    {
        super(comps);
        this.setting = arraySettingID;
        this.index = index;
    }

    public GuiSettingBridge(SettingID settingID, Object... comps)
    {
        this(settingID, -1, comps);
    }

    @Override
    public void load()
    {
        View.invokeLater(() ->
        {
            if(index < 0)
                setValue(Settings.load(setting));
            else
                setValue(Settings.loadArrayCell(setting, index));
        });
    }

    @Override
    public void save()
    {
        if(index < 0)
            Settings.save(setting, getValue());
        else
            Settings.saveArrayCell(setting, index, getValue());
    }
}
