/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertron.tabs.modules;

import interlib.interfaces.Input;
import interlib.interfaces.Module;
import interlib.interfaces.Output;
import interlib.interfaces.View;
import interlib.io.FileIO;
import interlib.util.Settings;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.jar.JarEntry;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Mirko
 */
public class ModuleLoaderTest
{
    public ModuleLoaderTest() throws IOException
    {
        FileIO file = new FileIO("./local.settings");
        file.create();
        file.writeLines("pathBackup: \".\\TestBackup\"",
                        "pathData: ",
                        "pathDests: {\".\\TestZiel1\",\".\\TestZiel2\",\".\\TestZiel3\"}",
                        "pathSource: \".\\TestDateien\"",
                        "position: {\"335\",\"101\"}");
        String[] imported = Settings.loadArray(true, "locationOfImportedModules");
        System.out.println(imported.length);
    }

    /**
     * Test of getAvailableModules method, of class ModuleLoader.
     * @throws java.io.IOException
     */
    @Test
    public void testGetAvailableModules() throws IOException
    {
        System.out.println("getAvailableModules");
        File jarFile = new File("test/testRessources/TestModules.jar");
        ModuleLoader instance = new ModuleLoader();
        ClassLocation[] expResult =
        {
            new ClassLocation(jarFile, "testmodules.main.ModuleI"),
            new ClassLocation(jarFile, "testmodules.main.ModuleIO"),
            new ClassLocation(jarFile, "testmodules.main.ModuleO"),
            new ClassLocation(jarFile, "testmodules.main.RawModule"),
        };
        ClassLocation[] result = instance.getAvailableModules(jarFile);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of loadClass method, of class ModuleLoader.
     * @throws java.net.MalformedURLException
     */
    @Test
    public void testLoadClass() throws MalformedURLException
    {
        System.out.println("loadClass");
        ClassLocation loc = new ClassLocation(new File("test/testRessources/TestModules.jar"), "testmodules.main.ModuleIO");

        ModuleLoader instance = new ModuleLoader();

        Module m = instance.loadModule(loc);

        assertEquals("testmodules.main.ModuleIO", m.getClass().getName());
        assertTrue(m instanceof Input);
        assertTrue(m instanceof Output);
    }

    /**
     * Test of parseClassName method, of class ModuleLoader.
     */
    @Test
    public void testParseClassName()
    {
        System.out.println("parseClassName");

        ModuleLoader instance = new ModuleLoader();

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

        ModuleLoader instance = new ModuleLoader();

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

        ModuleLoader instance = new ModuleLoader();

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

        ModuleLoader instance = new ModuleLoader();

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

        ModuleLoader instance = new ModuleLoader();

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

        ModuleLoader instance = new ModuleLoader();

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

        ModuleLoader instance = new ModuleLoader();

        Class c = null;
        boolean expResult = false;
        boolean result = instance.isModule(c);
        assertEquals(expResult, result);
    }

}
