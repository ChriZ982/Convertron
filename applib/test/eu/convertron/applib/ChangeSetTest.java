package eu.convertron.applib;

import eu.convertron.applib.ChangeSet;
import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Mirko Ruether
 */
public class ChangeSetTest
{
    public ChangeSetTest()
    {
    }

    @Test
    public void testClear()
    {
        System.out.println("clear");
        ChangeSet instance = new ChangeSet();
        instance.configChanged("h", "b");
        instance.clear();
        assertTrue("Clear doesnt work", instance.isEmpty());
    }

    @Test
    public void testIsEmpty()
    {
        System.out.println("isEmpty");
        ChangeSet instance = new ChangeSet();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    @Test
    public void testConfigChanged()
    {
        System.out.println("configChanged");
        String configName = "a";
        String configPart = "ab";
        ChangeSet instance = new ChangeSet();
        instance.configChanged(configName, configPart);
        assertTrue(instance.getEntrysCopy().containsKey(configName));
        assertTrue(instance.getEntrysCopy().get(configName).getChangedConfigsParts().contains(configPart));
    }

    @Test
    public void testConfigAdded()
    {
        System.out.println("configAdded");
        String configName = "a";
        String configPart = "ab";
        ChangeSet instance = new ChangeSet();
        instance.configAdded(configName, configPart);
        assertTrue(instance.getEntrysCopy().containsKey(configName));
        assertTrue(instance.getEntrysCopy().get(configName).getAddedConfigParts().contains(configPart));
    }

    @Test
    public void testGetEntrysCopy()
    {
        System.out.println("getEntrysCopy");
        ChangeSet instance = new ChangeSet();

        HashMap<String, ChangeSet.ConfigEntry> expResult = new HashMap<>();
        ChangeSet.ConfigEntry e = new ChangeSet.ConfigEntry();
        e.configChanged("ab");
        e.configAdded("ac");
        expResult.put("b", e);

        instance.configChanged("b", "ab");
        instance.configAdded("b", "ac");

        HashMap<String, ChangeSet.ConfigEntry> result = instance.getEntrysCopy();
        assertEquals(expResult, result);
    }

    @Test
    public void testSerializeAndDeserialize()
    {
        System.out.println("serialize");
        ChangeSet instance = new ChangeSet();

        instance.configAdded("a", "ab");
        instance.configAdded("b", "abc");
        instance.configChanged("c", "bc");

        byte[] ser = instance.serialize();

        ChangeSet result = ChangeSet.deserialize(ser);

        assertEquals(instance, result);
    }
}
