package eu.convertron.interlib.util;

import eu.convertron.interlib.interfaces.View;
import java.awt.GridLayout;
import javax.swing.JTabbedPane;

public class SubTabView extends View
{
    private static final long serialVersionUID = 1L;

    private JTabbedPane tabsPane;
    private View[] subViews;
    private String tabTitle;

    /**
     * Erstellt ein neues SubTabView.
     * @param tabTitle Titel der Seite
     * @param subViews Untertabs
     */
    public SubTabView(String tabTitle, View... subViews)
    {
        invokeAndWait(()
                ->
                {
                    tabsPane = new JTabbedPane();
                    GridLayout layout = new GridLayout(1, 1);
                    setLayout(layout);
                    add(tabsPane);

                    this.tabTitle = tabTitle;
                    this.subViews = subViews;
                    for(View view : subViews)
                    {
                        tabsPane.add(view);
                        tabsPane.setTitleAt(tabsPane.getTabCount() - 1, view.getTabTitle());
                    }
        });
    }

    @Override
    public String getTabTitle()
    {
        return tabTitle;
    }

    public View[] getViews()
    {
        return subViews;
    }
}
