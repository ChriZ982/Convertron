package eu.convertron.interlib.guiutil;

import javax.swing.AbstractButton;
import javax.swing.JComboBox;
import javax.swing.text.JTextComponent;

public class GuiUtils
{
    public static String getValue(Object comp)
    {
        if(comp instanceof JTextComponent)
        {
            return ((JTextComponent)comp).getText();
        }
        if(comp instanceof AbstractButton)
        {
            return ((AbstractButton)comp).isSelected() ? "true" : "false";
        }
        if(comp instanceof JComboBox<?>)
        {
            return ((JComboBox<?>)comp).getSelectedItem().toString();
        }
        throw new UnsupportedOperationException("Unsupported Component");
    }

    public static void setValue(Object comp, String value)
    {
        if(comp instanceof JTextComponent)
        {
            ((JTextComponent)comp).setText(value);
            return;
        }
        if(comp instanceof AbstractButton)
        {
            ((AbstractButton)comp).setSelected("true".equalsIgnoreCase(value));
            return;
        }
        if(comp instanceof JComboBox<?>)
        {
            JComboBox<?> box = (JComboBox<?>)comp;
            for(int i = 0; i < box.getItemCount(); i++)
            {
                if(box.getItemAt(i).toString().equals(value))
                    box.setSelectedIndex(i);
            }
            return;
        }
        throw new UnsupportedOperationException("Unsupported Component");
    }

    private GuiUtils()
    {
    }
}
