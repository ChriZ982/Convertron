package convertron.tabs.settings;

import interlib.settings.SettingID;
import javax.swing.AbstractButton;

public class CheckBoxHandler extends SettingHandler
{
    private AbstractButton comp;

    public CheckBoxHandler(AbstractButton comp, SettingID setting)
    {
        super(setting);
        this.comp = comp;
    }

    public CheckBoxHandler(AbstractButton comp, SettingID arraySetting, int index)
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
