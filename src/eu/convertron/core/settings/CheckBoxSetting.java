package eu.convertron.core.settings;

import eu.convertron.interlib.settings.SettingID;
import javax.swing.AbstractButton;

public class CheckBoxSetting extends ComponentSetting
{
    private AbstractButton comp;

    public CheckBoxSetting(AbstractButton comp, SettingID setting)
    {
        super(setting);
        this.comp = comp;
    }

    public CheckBoxSetting(AbstractButton comp, SettingID arraySetting, int index)
    {
        super(arraySetting, index);
        this.comp = comp;
    }

    @Override
    protected String getValue()
    {
        return String.valueOf(comp.isSelected());
    }

    @Override
    protected void setValue(String value)
    {
        comp.setSelected(value.trim().equals("true"));
    }

}
