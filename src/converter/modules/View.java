package converter.modules;

import javax.swing.JPanel;

public abstract class View extends JPanel
{
    private static final long serialVersionUID = 1L;

    public abstract String getTabTitle();
}
