package eu.convertron.interlib.guiutil;

import eu.convertron.interlib.data.IniConfigFile;

public class GuiIniBridge implements GuiBridge
{
    private IniConfigFile ini;
    private String settingName;
    private Object[] comps;

    public GuiIniBridge(IniConfigFile ini, String settingName, Object... comps)
    {
        this.ini = ini;
        this.settingName = settingName;
        this.comps = comps;
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

    protected void setValue(String value)
    {
        String[] values = value.split(";");
        if(values.length != comps.length)
            throw new IllegalArgumentException();
        for(int i = 0; i < comps.length; i++)
        {
            GuiUtils.setValue(comps[i], values[i]);
        }
    }

    protected String getValue()
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < comps.length; i++)
        {
            if(i > 0)
                sb.append(";");
            sb.append(GuiUtils.getValue(comps[i]).replaceAll(";", ""));
        }
        return sb.toString();
    }
}
