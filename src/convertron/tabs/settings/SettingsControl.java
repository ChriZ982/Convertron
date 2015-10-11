package convertron.tabs.settings;

import convertron.core.Control;

public class SettingsControl
{
    private SettingsView view;
    private SettingHandler[] settingHandlers;

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
        for(SettingHandler handler : settingHandlers)
            handler.save();
    }

    public void load()
    {
        for(SettingHandler handler : settingHandlers)
            handler.load();
    }
}
