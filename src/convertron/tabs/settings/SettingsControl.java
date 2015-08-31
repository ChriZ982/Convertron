package convertron.tabs.settings;

import convertron.core.Control;

public class SettingsControl
{
    private SettingsView view;

    public SettingsControl()
    {
        view = new SettingsView();

        Control.addViewToWindow(view);

        initializeListeners();
    }

    private void initializeListeners()
    {
        view.addSaveListener(() ->
        {
            saveAction();
        });
    }

    private void saveAction()
    {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
