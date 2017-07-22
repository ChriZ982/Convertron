package eu.convertron.core.tabs;

import eu.convertron.interlib.TableOptions;
import eu.convertron.interlib.config.ModuleConfiguration;
import eu.convertron.interlib.util.GuiBridge;

public class SettingsControl
{
    private final SettingsView view;
    private final GuiBridge[] bridges;

    public SettingsControl(ModuleConfiguration config)
    {
        view = new SettingsView();
        bridges = view.createBridges();

        TableOptions.getInstance().getConfigFile().addConfigFileListener((v) -> load());

        load();

        initializeListeners();
    }

    private void initializeListeners()
    {
        view.addSaveListener(() -> save());
    }

    public void save()
    {
        for(GuiBridge b : bridges)
            b.save();
        TableOptions.getInstance().getConfigFile().flush();
    }

    public void load()
    {
        for(GuiBridge b : bridges)
            b.load();
    }

    public SettingsView getView()
    {
        return view;
    }
}
