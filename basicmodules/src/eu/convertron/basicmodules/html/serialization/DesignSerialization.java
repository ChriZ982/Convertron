package eu.convertron.basicmodules.html.serialization;

import eu.convertron.basicmodules.html.Column;
import eu.convertron.basicmodules.html.CustomDesignItem;
import eu.convertron.basicmodules.html.DesignItem;
import java.io.File;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DesignSerialization
{
    private Document document;

    public DesignSerialization(DesignConfiguration design)
    {
        try
        {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.newDocument();

            document.appendChild(createDesignConfigurationElement(design));
        }
        catch(ParserConfigurationException ex)
        {
            throw new RuntimeException("Failed to create DocumentBuilder", ex);
        }
        catch(RuntimeException ex)
        {
            throw new RuntimeException("Failed to create document object", ex);
        }
    }

    private Element createDesignConfigurationElement(DesignConfiguration design)
    {
        Element designConfigurationElement = document.createElement("DesignConfiguration");
        designConfigurationElement.appendChild(createColumnsElement(design.getColums()));
        designConfigurationElement.appendChild(createDesignItemsElement(design.getDesignItems()));
        designConfigurationElement.appendChild(createCustomDesignGroupsElement(design.getCustomDesigns()));
        return designConfigurationElement;
    }

    private Element createColumnsElement(HashMap<String, Column> columns)
    {
        Element columnsElement = document.createElement("Columns");
        Set<String> importNames = columns.keySet();
        for(String importName : importNames)
        {
            columnsElement.appendChild(createColumnElement(importName, columns.get(importName)));
        }
        return columnsElement;
    }

    private Element createColumnElement(String importName, Column column)
    {
        Element columnElement = document.createElement("Column");
        columnElement.setAttribute("ImportName", importName);
        columnElement.appendChild(createTextElement("Name", column.getName()));
        columnElement.appendChild(createTextElement("Position", String.valueOf(column.getPosition())));
        columnElement.appendChild(createTextElement("Width", String.valueOf(column.getWidth())));
        return columnElement;
    }

    private Element createDesignItemsElement(HashMap<String, DesignItem> designItems)
    {
        Element designItemsElement = document.createElement("DesignItems");
        Set<String> ids = designItems.keySet();
        for(String id : ids)
        {
            designItemsElement.appendChild(createDesignItemElement(id, designItems.get(id)));
        }
        return designItemsElement;
    }

    private Element createDesignItemElement(String id, DesignItem designItem)
    {
        Element designItemElement = document.createElement("DesignItem");
        designItemElement.setAttribute("ID", id);
        designItemElement.appendChild(createTextElement("Name", designItem.getName()));
        designItemElement.appendChild(createTextElement("Type", String.valueOf(designItem.getType())));
        designItemElement.appendChild(createTextElement("Value", designItem.getValue()));
        return designItemElement;
    }

    private Element createCustomDesignGroupsElement(HashMap<String, HashMap<String, CustomDesignItem>> customDesignGroups)
    {
        Element customDesignGroupsElement = document.createElement("CustomDesignGroups");
        Set<String> ids = customDesignGroups.keySet();
        for(String id : ids)
        {
            customDesignGroupsElement.appendChild(createCustomDesignGroupElement(id, customDesignGroups.get(id)));
        }
        return customDesignGroupsElement;
    }

    private Element createCustomDesignGroupElement(String groupID, HashMap<String, CustomDesignItem> customDesignGroup)
    {
        Element customDesignGroupElement = document.createElement("CustomDesignGroup");
        customDesignGroupElement.setAttribute("ID", groupID);
        Set<String> ids = customDesignGroup.keySet();
        for(String id : ids)
        {
            customDesignGroupElement.appendChild(createCustomDesignItemElement(id, customDesignGroup.get(id)));
        }
        return customDesignGroupElement;
    }

    private Element createCustomDesignItemElement(String id, CustomDesignItem customDesignItem)
    {
        Element designItemElement = document.createElement("CustomDesignItem");
        designItemElement.setAttribute("ID", id);
        designItemElement.appendChild(createTextElement("ColumnName", customDesignItem.getColumnName()));
        designItemElement.appendChild(createTextElement("ColumnValue", customDesignItem.getColumnValue()));
        designItemElement.appendChild(createTextElement("Name", customDesignItem.getName()));
        designItemElement.appendChild(createTextElement("Type", String.valueOf(customDesignItem.getType())));
        designItemElement.appendChild(createTextElement("Value", customDesignItem.getValue()));
        return designItemElement;
    }

    private Element createTextElement(String tagName, String text)
    {
        Element textElement = document.createElement(tagName);
        textElement.setTextContent(text);
        return textElement;
    }

    @Override
    public String toString()
    {
        StringWriter writer = new StringWriter();
        copyTo(writer);
        return writer.toString();
    }

    public void copyTo(Writer writer)
    {
        copyTo(new StreamResult(writer));
    }

    public void copyTo(File f)
    {
        copyTo(new StreamResult(f));
    }

    public void copyTo(Result result)
    {
        try
        {
            DOMSource source = new DOMSource(document);
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.transform(source, result);
        }
        catch(TransformerException ex)
        {
            throw new RuntimeException("Failed to transform XML Document", ex);
        }
    }
}
