package eu.convertron.interlib.util;

import eu.convertron.interlib.config.IniConfigFile;

public class GuiIniBridge extends GuiBridge
{
    private final IniConfigFile ini;
    private final String settingName;

    public GuiIniBridge(IniConfigFile ini, String settingName, Object... comps)
    {
        super(comps);
        this.ini = ini;
        this.settingName = settingName;
    }

    @Override
    public void save()
    {
        ini.save(settingName, getValue());
    }

    @Override
    public void load()
    {
        setValue(ini.load(settingName));
    }
}
