package eu.convertron.core.tabs.settings;

import eu.convertron.core.settings.ComponentSetting;
import eu.convertron.core.Control;

public class SettingsControl
{
    private SettingsView view;
    private ComponentSetting[] settingHandlers;

    public SettingsControl()
    {
        view = new SettingsView();
        settingHandlers = view.createHandlers();
        load();

        initializeListeners();
        Control.addViewToWindow(view);
    }

    private void initializeListeners()
    {
        view.addSaveListener(() ->
        {
            save();
        });
    }

    public void save()
    {
        for(ComponentSetting handler : settingHandlers)
            handler.save();
    }

    public void load()
    {
        for(ComponentSetting handler : settingHandlers)
            handler.load();
    }
}
