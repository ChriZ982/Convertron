/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertron.tabs.modules;

import interlib.interfaces.Module;
import interlib.interfaces.View;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Mirko
 */
public class ModuleHolderTest
{
    public ModuleHolderTest()
    {
    }

    /**
     * Test of toString method, of class ModuleHolder.
     */
    @Test
    public void testToString()
    {
        System.out.println("toString");
        ModuleHolder instance = new ModuleHolder(new TestModule("TEST"));
        String expResult = "TEST";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class ModuleHolder.
     */
    @Test
    public void testToString_moduleNull()
    {
        System.out.println("toString");
        ModuleHolder instance = new ModuleHolder(null);
        String expResult = "null";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of toHolder method, of class ModuleHolder.
     */
    @Test
    public void testToHolder()
    {
        System.out.println("toHolder");

        Module module1 = new TestModule("1");
        Module module2 = new TestModule("2");

        Module[] modules =
        {
            module1, module2
        };
        ModuleHolder[] holders = ModuleHolder.toHolder(modules);

        assertEquals(module1, holders[0].module);
        assertEquals(module2, holders[1].module);
    }

    /**
     * Test of toModule method, of class ModuleHolder.
     */
    @Test
    public void testToModule()
    {
        System.out.println("toModule");

        Module module1 = new TestModule("1");
        Module module2 = new TestModule("2");

        ModuleHolder[] holders =
        {
            new ModuleHolder(module1), new ModuleHolder(module2)
        };

        Module[] modules = ModuleHolder.toModule(holders);

        assertEquals(module1, modules[0]);
        assertEquals(module2, modules[1]);
    }

    class TestModule implements Module
    {
        private String name;

        TestModule(String name)
        {
            this.name = name;
        }

        @Override
        public String getName()
        {
            return name;
        }

        @Override
        public View getView()
        {
            return null;
        }
    }
}
