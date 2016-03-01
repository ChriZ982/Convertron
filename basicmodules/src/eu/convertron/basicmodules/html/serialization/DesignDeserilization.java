package eu.convertron.basicmodules.html.serialization;

import eu.convertron.basicmodules.html.Column;
import eu.convertron.basicmodules.html.CustomDesignItem;
import eu.convertron.basicmodules.html.DesignItem;
import eu.convertron.basicmodules.html.DesignItemType;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DesignDeserilization
{
    private DesignConfiguration design;

    public DesignDeserilization(String xml)
    {
        try
        {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new ByteArrayInputStream(xml.getBytes("UTF-8")));

            if(!document.hasChildNodes())
                throw new IllegalMarkupException("The serialazation has no root element");

            Node root = document.getFirstChild();

            if(!root.getNodeName().equals("DesignConfiguration"))
                throw new IllegalMarkupException("Wrong root Element: " + root.getNodeName());

            design = parseDesignConfiguration(root);
        }
        catch(ParserConfigurationException ex)
        {
            throw new RuntimeException("Failed to create DocumentBuilder", ex);
        }
        catch(Exception ex)
        {
            throw new RuntimeException("Failed to parse DesignConfiguration", ex);
        }
    }

    private DesignConfiguration parseDesignConfiguration(Node rootNode)
    {
        NodeList childs = rootNode.getChildNodes();
        Node columnsNode = null;
        Node designItemsNode = null;
        Node customDesignItemsNode = null;

        for(int i = 0; i < childs.getLength(); i++)
        {
            Node n = childs.item(i);
            switch(n.getNodeName())
            {
                case "Columns":
                    columnsNode = n;
                    break;
                case "DesignItems":
                    designItemsNode = n;
                    break;
                case "CustomDesignGroups":
                    customDesignItemsNode = n;
                    break;
                default:
                    throw new IllegalMarkupException("The root element does not support an " + n.getNodeName() + " element");
            }
        }

        if(columnsNode == null || designItemsNode == null || customDesignItemsNode == null)
            throw new IllegalMarkupException("The root element does not cotain all needed elements");

        return new DesignConfiguration(
                parseColumns(columnsNode),
                parseDesignItems(designItemsNode),
                parseCustomDesignGroups(customDesignItemsNode));
    }

    private HashMap<String, Column> parseColumns(Node columnsNode)
    {
        HashMap<String, Column> columns = new HashMap<>();
        NodeList childs = columnsNode.getChildNodes();
        for(int i = 0; i < childs.getLength(); i++)
        {
            Node child = childs.item(i);
            if(!child.getNodeName().equals("Column"))
                throw new IllegalMarkupException("The Columns element only supports Column elements");
            if(child.getAttributes().getNamedItem("ImportName") == null)
                throw new IllegalMarkupException("The Column element does not cotain an ImportName attribute");

            columns.put(child.getAttributes().getNamedItem("ImportName").getNodeValue(), parseColumn(child));
        }
        return columns;
    }

    private Column parseColumn(Node columnNode)
    {
        NodeList childs = columnNode.getChildNodes();
        return new Column(
                parseTextValue(childs, "Name"),
                Integer.parseInt(parseTextValue(childs, "Position")),
                Double.parseDouble(parseTextValue(childs, "Width")));
    }

    private HashMap<String, DesignItem> parseDesignItems(Node designItemsNode)
    {
        HashMap<String, DesignItem> designItems = new HashMap<>();
        NodeList childs = designItemsNode.getChildNodes();
        for(int i = 0; i < childs.getLength(); i++)
        {
            Node child = childs.item(i);
            if(!child.getNodeName().equals("DesignItem"))
                throw new IllegalMarkupException("The DesignItems element only supports DesignItem elements");
            if(child.getAttributes().getNamedItem("ID") == null)
                throw new IllegalMarkupException("The DesignItem element does not cotain an ID attribute");

            designItems.put(child.getAttributes().getNamedItem("ID").getNodeValue(), parseDesignItem(child));
        }
        return designItems;
    }

    private DesignItem parseDesignItem(Node designItemNode)
    {
        NodeList childs = designItemNode.getChildNodes();
        return new DesignItem(
                parseTextValue(childs, "Name"),
                DesignItemType.valueOf(parseTextValue(childs, "Type")),
                parseTextValue(childs, "Value"));
    }

    private HashMap<String, HashMap<String, CustomDesignItem>> parseCustomDesignGroups(Node customDesignGroupsNode)
    {
        HashMap<String, HashMap<String, CustomDesignItem>> customDesignGroups = new HashMap<>();
        NodeList childs = customDesignGroupsNode.getChildNodes();
        for(int i = 0; i < childs.getLength(); i++)
        {
            Node child = childs.item(i);
            if(!child.getNodeName().equals("CustomDesignGroup"))
                throw new IllegalMarkupException("The CustomDesignGroups element only supports CustomDesignGroup elements");
            if(child.getAttributes().getNamedItem("ID") == null)
                throw new IllegalMarkupException("The CustomDesignGroup element does not cotain an ID attribute");

            customDesignGroups.put(child.getAttributes().getNamedItem("ID").getNodeValue(), parseCustomDesignGroup(child));
        }
        return customDesignGroups;
    }

    private HashMap<String, CustomDesignItem> parseCustomDesignGroup(Node customDesignGroupNode)
    {
        HashMap<String, CustomDesignItem> customDesignGroup = new HashMap<>();
        NodeList childs = customDesignGroupNode.getChildNodes();
        for(int i = 0; i < childs.getLength(); i++)
        {
            Node child = childs.item(i);
            if(!child.getNodeName().equals("CustomDesignItem"))
                throw new IllegalMarkupException("The CustomDesignGroup element only supports CustomDesignItem elements");
            if(child.getAttributes().getNamedItem("ID") == null)
                throw new IllegalMarkupException("The CustomDesignItem element does not cotain an ID attribute");

            customDesignGroup.put(child.getAttributes().getNamedItem("ID").getNodeValue(), parseCustomDesignItem(child));
        }
        return customDesignGroup;
    }

    private CustomDesignItem parseCustomDesignItem(Node customDesignItemNode)
    {
        NodeList childs = customDesignItemNode.getChildNodes();
        return new CustomDesignItem(
                parseTextValue(childs, "ColumnName"),
                parseTextValue(childs, "ColumnValue"),
                parseTextValue(childs, "Name"),
                DesignItemType.valueOf(parseTextValue(childs, "Type")),
                parseTextValue(childs, "Value"));
    }

    private String parseTextValue(NodeList childs, String tagName)
    {
        for(int i = 0; i < childs.getLength(); i++)
        {
            Node child = childs.item(i);
            if(child.getNodeName().equals(tagName))
                return child.getTextContent();
        }
        throw new IllegalMarkupException("A " + tagName + " element couldn't be found");
    }

    public DesignConfiguration getDesign()
    {
        return design;
    }
}
