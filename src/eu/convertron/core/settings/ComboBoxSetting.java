package eu.convertron.core.settings;

import eu.convertron.interlib.settings.SettingID;
import javax.swing.JComboBox;

public class ComboBoxSetting extends ComponentSetting
{
    private JComboBox<? extends Object> comp;

    public ComboBoxSetting(JComboBox<? extends Object> comp, SettingID setting)
    {
        super(setting);
        this.comp = comp;
    }

    public ComboBoxSetting(JComboBox<? extends Object> comp, SettingID arraySetting, int index)
    {
        super(arraySetting, index);
        this.comp = comp;
    }

    @Override
    protected String getValue()
    {
        return comp.getSelectedItem().toString();
    }

    @Override
    protected void setValue(String value)
    {
        for(int i = 0; i < comp.getItemCount(); i++)
        {
            if(comp.getItemAt(i).toString().equals(value))
                comp.setSelectedIndex(i);
        }
    }
}
