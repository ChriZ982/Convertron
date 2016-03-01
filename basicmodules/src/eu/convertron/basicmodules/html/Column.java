package eu.convertron.basicmodules.html;

public class Column
{
    private String name;
    private int position;
    private double width;

    public Column(String name, int position, double width)
    {
        this.name = name;
        this.position = position;
        this.width = width;
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

    public void setWidth(double width)
    {
        this.width = width;
    }

    public int getPosition()
    {
        return position;
    }

    public void setPosition(int position)
    {
        this.position = position;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getWidth()
    {
        return width;
    }
}
