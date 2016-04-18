package eu.convertron.interlib.settings;

public class Setting implements SettingID
{
    private String name, defaultValue;

    public Setting(String name, String defaultValue)
    {
        this.name = name;
        this.defaultValue = defaultValue;
    }

    public Setting(String name)
    {
        this(name, null);
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public String getDefaultValue()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
