package eu.convertron.core.tabs;

import eu.convertron.applib.settings.ComponentSetting;

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
    }

    private void initializeListeners()
    {
        view.addSaveListener(()
                ->
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

    public SettingsView getView()
    {
        return view;
    }
}
