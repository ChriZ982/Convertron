package eu.convertron.applib.gui;

import eu.convertron.applib.modules.LoadedModule;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

@SuppressWarnings("serial")
public class ModuleListRenderer extends DefaultListCellRenderer
{
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus)
    {
        Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        if(value != null && value instanceof LoadedModule)
            setText(((LoadedModule)value).getName());

        return c;
    }
}
