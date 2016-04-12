package eu.convertron.basicmodules.html;

import javax.xml.bind.annotation.XmlElement;

public class CustomFormat
{
    private String fontSize;
    private String fontFamily;
    private String fontStyle;
    private String fontColor;
    private String backColor;

    public CustomFormat(String fontSize, String fontFamily, String fontStyle, String fontColor, String backColor)
    {
        this.fontSize = fontSize;
        this.fontFamily = fontFamily;
        this.fontStyle = fontStyle;
        this.fontColor = fontColor;
        this.backColor = backColor;
    }

    private CustomFormat()
    {
    }

    public String toCss()
    {
        return "    font: " + fontStyle + " " + fontSize + "px " + fontFamily + ";"
               + "    color: #" + fontColor + ";";
    }

    @XmlElement
    public String getFontSize()
    {
        return fontSize;
    }

    public void setFontSize(String fontSize)
    {
        this.fontSize = fontSize;
    }

    @XmlElement
    public String getFontFamily()
    {
        return fontFamily;
    }

    public void setFontFamily(String fontFamily)
    {
        this.fontFamily = fontFamily;
    }

    @XmlElement
    public String getFontStyle()
    {
        return fontStyle;
    }

    public void setFontStyle(String fontStyle)
    {
        this.fontStyle = fontStyle;
    }

    @XmlElement
    public String getFontColor()
    {
        return fontColor;
    }

    public void setFontColor(String fontColor)
    {
        this.fontColor = fontColor;
    }

    @XmlElement
    public String getBackColor()
    {
        return backColor;
    }

    public void setBackColor(String backColor)
    {
        this.backColor = backColor;
    }
}
