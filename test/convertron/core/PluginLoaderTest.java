/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertron.core;

import interlib.interfaces.View;
import java.util.jar.JarEntry;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Mirko
 */
public class PluginLoaderTest
{

    public PluginLoaderTest()
    {
    }

    @BeforeClass
    public static void setUpClass()
    {
    }

    @AfterClass
    public static void tearDownClass()
    {
    }

    @Before
    public void setUp()
    {
    }

    @After
    public void tearDown()
    {
    }

//    /**
//     * Test of loadAllModuleClasses method, of class PluginLoader.
//     */
//    @Test
//    public void testLoadAllModuleClasses()
//    {
//        System.out.println("loadAllModuleClasses");
//        File jarFile = null;
//        PluginLoader instance = new PluginLoader();
//        Class[] expResult = null;
//        Class[] result = instance.loadAllModuleClasses(jarFile);
//        assertArrayEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of parseClassName method, of class PluginLoader.
     */
    @Test
    public void testParseClassName()
    {
        System.out.println("parseClassName");
        String jarEntryName = "package/anotherpackage/testclass.class";
        String expResult = "package.anotherpackage.testclass";
        String result = PluginLoader.parseClassName(jarEntryName);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateJarEntryAsClass method, of class PluginLoader.
     */
    @Test
    public void testValidateJarEntryAsClass()
    {
        System.out.println("validateJarEntryAsClass");
        JarEntry e = new JarEntry("package/classname.class");
        boolean expResult = true;
        boolean result = PluginLoader.validateJarEntryAsClass(e);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateJarEntryAsClass method, of class PluginLoader.
     */
    @Test
    public void testValidateJarEntryAsClass2()
    {
        System.out.println("validateJarEntryAsClass");
        JarEntry e = new JarEntry("package/classname.notclass");
        boolean expResult = false;
        boolean result = PluginLoader.validateJarEntryAsClass(e);
        assertEquals(expResult, result);
    }

    /**
     * Test of isModule method, of class PluginLoader.
     */
    @Test
    public void testIsModule()
    {
        System.out.println("isModule");
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
        boolean result = PluginLoader.isModule(c);
        assertEquals(expResult, result);
    }

    /**
     * Test of isModule method, of class PluginLoader.
     */
    @Test
    public void testIsModule2()
    {
        System.out.println("isModule");
        Class c = new Object().getClass();
        boolean expResult = false;
        boolean result = PluginLoader.isModule(c);
        assertEquals(expResult, result);
    }

    /**
     * Test of isModule method, of class PluginLoader.
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
        Class c = new Module().getClass();
        boolean expResult = false;
        boolean result = PluginLoader.isModule(c);
        assertEquals(expResult, result);
    }

    public void testIsModule4()
    {
        System.out.println("isModule");
        Class c = null;
        boolean expResult = false;
        boolean result = PluginLoader.isModule(c);
        assertEquals(expResult, result);
    }
}
