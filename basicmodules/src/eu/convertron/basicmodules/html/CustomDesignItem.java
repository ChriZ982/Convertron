package eu.convertron.basicmodules.html;

public class CustomDesignItem
{
    private String columnName;
    private String columnValue;
    private String name;
    private DesignItemType type;
    private String value;

    public CustomDesignItem(String columnName, String columnValue, String name, DesignItemType type, String value)
    {
        this.columnName = columnName;
        this.columnValue = columnValue;
        this.name = name;
        this.type = type;
        this.value = value;
    }

    public String[] toRow()
    {
        return new String[]
        {
            columnName,
            columnValue,
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

    public String getColumnName()
    {
        return columnName;
    }

    public void setColumnName(String columnName)
    {
        this.columnName = columnName;
    }

    public String getColumnValue()
    {
        return columnValue;
    }

    public void setColumnValue(String columnValue)
    {
        this.columnValue = columnValue;
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
