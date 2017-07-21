package eu.convertron.core.tabs;

import eu.convertron.interlib.config.ConfigurationSource;
import eu.convertron.interlib.config.IniConfigFile;
import eu.convertron.interlib.config.SingleConfigurationListener;
import eu.convertron.interlib.util.GuiBridge;
import static eu.convertron.interlib.TableOptions.TABLEOPTIONS_CONFIGFILE;

public class SettingsControl
{
    private final SettingsView view;
    private final GuiBridge[] bridges;

    private final IniConfigFile iniConfig;

    public SettingsControl(ConfigurationSource config)
    {
        iniConfig = new IniConfigFile(config, TABLEOPTIONS_CONFIGFILE, false);
        view = new SettingsView(iniConfig);
        bridges = view.createBridges();

        config.addConfigListener(new SingleConfigurationListener(TABLEOPTIONS_CONFIGFILE, (v) -> load()));

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
        iniConfig.flush();
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
