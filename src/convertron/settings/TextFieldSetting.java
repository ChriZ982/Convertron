package convertron.settings;

import interlib.settings.SettingID;
import javax.swing.text.JTextComponent;

public class TextFieldSetting extends ComponentSetting
{
    private JTextComponent comp;

    public TextFieldSetting(JTextComponent comp, SettingID setting)
    {
        super(setting);
        this.comp = comp;
    }

    public TextFieldSetting(JTextComponent comp, SettingID arraySetting, int index)
    {
        super(arraySetting, index);
        this.comp = comp;
    }

    @Override
    protected String getValue()
    {
        return comp.getText();
    }

    @Override
    protected void setValue(String value)
    {
        comp.setText(value);
    }
}
