package eu.convertron.core.tabs;

import eu.convertron.interlib.data.Configuration;
import eu.convertron.interlib.data.ConfigurationListener;
import eu.convertron.interlib.data.IniConfigFile;
import eu.convertron.interlib.guiutil.GuiBridge;
import java.util.HashMap;
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

        config.addConfigListener(new ConfigurationListener()
        {
            @Override
            public void configurationChanged(HashMap<String, byte[]> changed, boolean complete)
            {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void newConfigurationAdded(String name)
            {
            }
        });

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
