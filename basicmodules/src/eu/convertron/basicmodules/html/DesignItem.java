package eu.convertron.basicmodules.html;

public class DesignItem
{
    private String name;
    private DesignItemType type;
    private String value;

    public DesignItem(String name, DesignItemType type, String value)
    {
        this.name = name;
        this.type = type;
        this.value = value;
    }

    public String[] toRow()
    {
        return new String[]
        {
            name,
            type.getName(),
            value,
            type.getExample(value)
        };
    }

    //<editor-fold defaultstate="collapsed" desc="Getters & Setters">
    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public DesignItemType getType()
    {
        return type;
    }

    public void setType(DesignItemType type)
    {
        this.type = type;
    }
    //</editor-fold>
}
