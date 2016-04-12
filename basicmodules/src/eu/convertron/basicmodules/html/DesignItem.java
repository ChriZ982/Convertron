package eu.convertron.basicmodules.html;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class DesignItem implements Unique
{
    private String id;
    private String name;
    private DesignItemType type;
    private String value;

    public DesignItem(String id, String name, DesignItemType type, String value)
    {
        this.id = id;
        this.name = name;
        this.type = type;
        this.value = value;
    }

    private DesignItem()
    {
    }

    public String[] toRow()
    {
        return new String[]
        {
            id,
            name,
            type.getName(),
            value,
            type.getExample(value)
        };
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
    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    @XmlElement
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @XmlElement
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
