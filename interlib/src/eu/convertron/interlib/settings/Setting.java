package eu.convertron.interlib.settings;

public class Setting implements SettingID
{
    private String name;
    private SettingLocationID location, fileWithDefaultValues;

    public Setting(String name, SettingLocationID location, SettingLocationID fileWithDefaultValues)
    {
        this.name = name;
        this.location = location;
        this.fileWithDefaultValues = fileWithDefaultValues;
    }

    public Setting(String name, SettingLocation location)
    {
        this(name, location, null);
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public SettingLocationID getLocation()
    {
        return location;
    }

    @Override
    public SettingLocationID getFileWithDefaultValues()
    {
        return fileWithDefaultValues;
    }
}
