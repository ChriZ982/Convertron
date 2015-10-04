package convertron.tabs.settings;

import interlib.settings.SettingID;
import javax.swing.text.JTextComponent;

public class TextFieldHandler extends SettingHandler
{
    private JTextComponent comp;

    public TextFieldHandler(JTextComponent comp, SettingID setting)
    {
        super(setting);
        this.comp = comp;
    }

    public TextFieldHandler(JTextComponent comp, SettingID arraySetting, int index)
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
