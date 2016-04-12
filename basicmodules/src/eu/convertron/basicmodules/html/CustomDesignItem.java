package eu.convertron.basicmodules.html;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class CustomDesignItem implements Unique
{
    private String id;
    private String columnName;
    private String columnValue;
    private CustomFormat format;

    public CustomDesignItem(String id, String columnName, String columnValue, CustomFormat format)
    {
        this.id = id;
        this.columnName = columnName;
        this.columnValue = columnValue;
        this.format = format;
    }

    private CustomDesignItem()
    {
    }

    //<editor-fold defaultstate="collapsed" desc="Getters & Setters">
    @XmlAttribute
    @Override
    public String getId()
    {
        return id;
    }

    @Override
    public void setId(String id)
    {
        this.id = id;
    }

    @XmlElement
    public CustomFormat getFormat()
    {
        return format;
    }

    public void setFormat(CustomFormat format)
    {
        this.format = format;
    }

    @XmlElement
    public String getColumnName()
    {
        return columnName;
    }

    public void setColumnName(String columnName)
    {
        this.columnName = columnName;
    }

    @XmlElement
    public String getColumnValue()
    {
        return columnValue;
    }

    public void setColumnValue(String columnValue)
    {
        this.columnValue = columnValue;
    }
    //</editor-fold>
}
