package eu.convertron.basicmodules.html.serialization;

import eu.convertron.basicmodules.html.Column;
import eu.convertron.basicmodules.html.CustomDesignItem;
import eu.convertron.basicmodules.html.DesignItem;
import java.util.HashMap;

public class DesignConfiguration
{
    private HashMap<String, Column> colums;
    private HashMap<String, DesignItem> designItems;
    private HashMap<String, HashMap<String, CustomDesignItem>> customDesigns;

    public DesignConfiguration(HashMap<String, Column> colums,
                               HashMap<String, DesignItem> designItems,
                               HashMap<String, HashMap<String, CustomDesignItem>> customDesigns)
    {
        this.colums = colums;
        this.designItems = designItems;
        this.customDesigns = customDesigns;
    }

    public HashMap<String, Column> getColums()
    {
        return colums;
    }

    public void setColums(HashMap<String, Column> colums)
    {
        this.colums = colums;
    }

    public HashMap<String, DesignItem> getDesignItems()
    {
        return designItems;
    }

    public void setDesignItems(HashMap<String, DesignItem> designItems)
    {
        this.designItems = designItems;
    }

    public HashMap<String, HashMap<String, CustomDesignItem>> getCustomDesigns()
    {
        return customDesigns;
    }

    public void setCustomDesigns(HashMap<String, HashMap<String, CustomDesignItem>> customDesigns)
    {
        this.customDesigns = customDesigns;
    }

    public static DesignConfiguration deserialize(String xml)
    {
        return new DesignDeserilization(xml).getDesign();
    }

    public String serialize()
    {
        return new DesignSerialization(this).toString();
    }
}
