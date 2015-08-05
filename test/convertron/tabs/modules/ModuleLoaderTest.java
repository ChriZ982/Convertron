/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertron.tabs.modules;

import interlib.interfaces.View;
import java.util.jar.JarEntry;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Mirko
 */
public class ModuleLoaderTest
{
    public ModuleLoaderTest()
    {
    }

    /**
     * Test of getAvailableModules method, of class ModuleLoader.
     */
    @Test
    public void testGetAvailableModuleClasses()
    {
//        System.out.println("getAvailableModules");
//        File jarFile = null;
//        ModuleLoader instance = new ModuleLoader(null);
//        ClassLocation[] expResult = null;
//        ClassLocation[] result = instance.getAvailableModules(jarFile);
//        assertArrayEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of loadClass method, of class ModuleLoader.
     */
    @Test
    public void testLoadClass()
    {
//        System.out.println("loadClass");
//        ClassLocation location = null;
//        Class expResult = null;
//        Class result = ModuleLoader.loadClass(location);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of parseClassName method, of class ModuleLoader.
     */
    @Test
    public void testParseClassName()
    {
        System.out.println("parseClassName");

        ModuleLoader instance = new ModuleLoader(null);

        String jarEntryName = "package/anotherpackage/testclass.class";
        String expResult = "package.anotherpackage.testclass";
        String result = instance.parseClassName(jarEntryName);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateJarEntryAsClass method, of class ModuleLoader.
     */
    @Test
    public void testValidateJarEntryAsClass()
    {
        System.out.println("validateJarEntryAsClass");

        ModuleLoader instance = new ModuleLoader(null);

        JarEntry e = new JarEntry("package/classname.class");
        boolean expResult = true;
        boolean result = instance.validateJarEntryAsClass(e);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateJarEntryAsClass method, of class ModuleLoader.
     */
    @Test
    public void testValidateJarEntryAsClass2()
    {
        System.out.println("validateJarEntryAsClass");

        ModuleLoader instance = new ModuleLoader(null);

        JarEntry e = new JarEntry("package/classname.notclass");
        boolean expResult = false;
        boolean result = instance.validateJarEntryAsClass(e);
        assertEquals(expResult, result);
    }

    /**
     * Test of isModule method, of class ModuleLoader.
     */
    @Test
    public void testIsModule()
    {
        System.out.println("isModule");

        ModuleLoader instance = new ModuleLoader(null);

        Class c = new interlib.interfaces.Module()
        {
            @Override
            public String getName()
            {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public View getView()
            {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        }.getClass();
        boolean expResult = true;
        boolean result = instance.isModule(c);
        assertEquals(expResult, result);
    }

    /**
     * Test of isModule method, of class ModuleLoader.
     */
    @Test
    public void testIsModule2()
    {
        System.out.println("isModule");

        ModuleLoader instance = new ModuleLoader(null);

        Class c = new Object().getClass();
        boolean expResult = false;
        boolean result = instance.isModule(c);
        assertEquals(expResult, result);
    }

    /**
     * Test of isModule method, of class ModuleLoader.
     */
    @Test
    public void testIsModule3()
    {
        class Module
        {
            public void doSomething()
            {
            }
        }

        System.out.println("isModule");

        ModuleLoader instance = new ModuleLoader(null);

        Class c = new Module().getClass();
        boolean expResult = false;
        boolean result = instance.isModule(c);
        assertEquals(expResult, result);
    }

    /**
     * Test of isModule method, of class ModuleLoader.
     */
    public void testIsModule4()
    {
        System.out.println("isModule");

        ModuleLoader instance = new ModuleLoader(null);

        Class c = null;
        boolean expResult = false;
        boolean result = instance.isModule(c);
        assertEquals(expResult, result);
    }

}
