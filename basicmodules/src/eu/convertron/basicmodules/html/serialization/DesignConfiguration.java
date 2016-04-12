package eu.convertron.basicmodules.html.serialization;

import eu.convertron.basicmodules.html.Column;
import eu.convertron.basicmodules.html.CustomDesignItem;
import eu.convertron.basicmodules.html.DesignItem;
import eu.convertron.basicmodules.html.Unique;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import javax.xml.bind.DataBindingException;
import javax.xml.bind.JAXB;
import javax.xml.bind.annotation.XmlElement;

public class DesignConfiguration
{
    private List<Column> colums;
    private List<DesignItem> designItems;
    private List<CustomDesignItem> customDesigns;

    public DesignConfiguration(Collection<Column> colums,
                               Collection<DesignItem> designItems,
                               Collection<CustomDesignItem> customDesigns)
    {
        this.colums = new ArrayList<>(colums);
        this.designItems = new ArrayList<>(designItems);
        this.customDesigns = new ArrayList<>(customDesigns);
    }

    private DesignConfiguration()
    {
        this.colums = new ArrayList<>();
        this.designItems = new ArrayList<>();
        this.customDesigns = new ArrayList<>();
    }

    @XmlElement(name = "column")
    public List<Column> getColums()
    {
        return colums;
    }

    public void setColums(List<Column> colums)
    {
        this.colums = colums == null ? new ArrayList<>() : colums;
    }

    @XmlElement(name = "designItem")
    public List<DesignItem> getDesignItems()
    {
        return designItems;
    }

    public void setDesignItems(List<DesignItem> designItems)
    {
        this.designItems = designItems == null ? new ArrayList<>() : designItems;
    }

    @XmlElement(name = "customDesign")
    public List<CustomDesignItem> getCustomDesigns()
    {
        return customDesigns;
    }

    public void setCustomDesigns(List<CustomDesignItem> customDesigns)
    {
        this.customDesigns = customDesigns == null ? new ArrayList<>() : customDesigns;
    }

    public static <T extends Unique> HashMap<String, T> map(Collection<T> coll)
    {
        HashMap<String, T> result = new HashMap<>();
        for(T obj : coll)
        {
            result.put(obj.getId(), obj);
        }
        return result;
    }

    public static DesignConfiguration deserialize(String xml)
    {
        try
        {
            return JAXB.unmarshal(new StringReader(xml), DesignConfiguration.class);
        }
        catch(DataBindingException ex)
        {
            throw new RuntimeException("Failed to deserialize DesignConfiguration", ex);
        }
    }

    public String serialize()
    {
        try
        {
            StringWriter writer = new StringWriter();
            JAXB.marshal(this, writer);
            return writer.toString();
        }
        catch(DataBindingException ex)
        {
            throw new RuntimeException("Failed to serialize DesignConfiguration", ex);
        }
    }
}
