package eu.convertron.core.tabs;

import eu.convertron.core.Window;
import eu.convertron.interlib.util.GuiBridge;

public class SystemSettingsControl
{
    private final SystemSettingsView view;
    private final GuiBridge[] bridges;
    private final Window window;

    public SystemSettingsControl(Window window)
    {
        this.window = window;
        view = new SystemSettingsView();
        bridges = view.createBridges();

        load();

        initializeListeners();
    }

    private void initializeListeners()
    {
        view.addSaveListener(() ->
        {
            save();
            window.restart();
        });
    }

    public void save()
    {
        for(GuiBridge b : bridges)
            b.save();
    }

    public void load()
    {
        for(GuiBridge b : bridges)
            b.load();
    }

    public SystemSettingsView getView()
    {
        return view;
    }
}
