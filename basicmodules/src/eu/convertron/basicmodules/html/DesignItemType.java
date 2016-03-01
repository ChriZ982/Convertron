package eu.convertron.basicmodules.html;

public enum DesignItemType
{
    DEFAULT,
    FONTFAMILY,
    FONTSIZE,
    FONTSTYLE,
    FONTCOLOR,
    TEXT,
    NUMBER,
    COLOR;

    public String getExample(String value)
    {
        switch(this)
        {
            case FONTFAMILY:
                return "<html><p style=\"font-family:" + value + "\">Formatierter Text</p></html>";
            case FONTSTYLE:
                if(value.contains("bold") && value.contains("italic"))
                    return "<html><p style=\"font-style:italic; font-weight:bold\">Formatierter Text</p></html>";
                else if(value.equals("bold"))
                    return "<html><p style=\"font-weight:bold\">Formatierter Text</p></html>";
                else if(value.equals("italic"))
                    return "<html><p style=\"font-style:italic\">Formatierter Text</p></html>";
                else
                    return "";
            case FONTCOLOR:
                return "<html><p style=\"color:" + value + "\">Formatierter Text</p></html>";
            case COLOR:
                return "<html><p style=\"font-size:200px; color:" + value + "\">█</p></html>";
            default:
                return "";
        }

    }

    public String getName()
    {
        switch(this)
        {
            case FONTFAMILY:
                return "Schriftart";
            case FONTSIZE:
                return "Schrifgröße";
            case FONTSTYLE:
                return "Schriftstil";
            case FONTCOLOR:
                return "Schriftfarbe";
            case TEXT:
                return "Text";
            case NUMBER:
                return "Zahl";
            case COLOR:
                return "Farbe";
            default:
                return "";
        }
    }
}
