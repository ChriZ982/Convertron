package eu.convertron.interlib.util;

public abstract class GuiBridge
{
    private final Object[] comps;

    protected GuiBridge(Object[] comps)
    {
        this.comps = comps;
    }

    public abstract void save();

    public abstract void load();

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
