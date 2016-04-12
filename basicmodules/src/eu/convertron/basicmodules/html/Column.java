package eu.convertron.basicmodules.html;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Column implements Unique
{
    private String id;
    private String name;
    private int position;
    private double width;

    public Column(String id, String name, int position, double width)
    {
        this.id = id;
        this.name = name;
        this.position = position;
        this.width = width;
    }

    private Column()
    {
    }

    public String[] toRow()
    {
        return new String[]
        {
            name,
            String.valueOf(position),
            String.valueOf(width)
        };
    }

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
    public double getWidth()
    {
        return width;
    }

    public void setWidth(double width)
    {
        this.width = width;
    }

    @XmlElement
    public int getPosition()
    {
        return position;
    }

    public void setPosition(int position)
    {
        this.position = position;
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
}
