package eu.convertron.core.tabs;

import eu.convertron.interlib.data.Configuration;
import eu.convertron.interlib.data.IniConfigFile;
import eu.convertron.interlib.data.SingleConfigurationListener;
import eu.convertron.interlib.guiutil.GuiBridge;
import static eu.convertron.interlib.filter.TableOptions.TABLEOPTIONS_CONFIGFILE;

public class SettingsControl
{
    private SettingsView view;
    private GuiBridge[] bridges;

    private Configuration config;

    public SettingsControl(Configuration config)
    {
        view = new SettingsView(new IniConfigFile(config, TABLEOPTIONS_CONFIGFILE));
        bridges = view.createBridges();

        config.addConfigListener(new SingleConfigurationListener(config, TABLEOPTIONS_CONFIGFILE, (v) -> load()));

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
        for(GuiBridge b : bridges)
            b.save();
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
