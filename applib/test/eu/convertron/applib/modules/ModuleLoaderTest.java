package eu.convertron.applib.modules;

import eu.convertron.interlib.interfaces.Input;
import eu.convertron.interlib.interfaces.Module;
import eu.convertron.interlib.interfaces.Output;
import eu.convertron.interlib.interfaces.View;
import eu.convertron.interlib.io.TextFile;
import eu.convertron.interlib.settings.SettingLocation;
import eu.convertron.interlib.settings.Settings;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.jar.JarEntry;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ModuleLoaderTest
{
    public ModuleLoaderTest() throws IOException
    {
        TextFile file = new TextFile("./local.settings");
        file.create();
        file.writeLines("pathBackup: \"./TestBackup\"",
                        "pathData: ",
                        "pathDests: {\"./TestZiel1\",\"./TestZiel2\",\"./TestZiel3\"}",
                        "pathSource: \"./TestDateien\"",
                        "position: {\"335\",\"101\"}");
        String[] imported = Settings.loadArray(SettingLocation.LOCAL.getFile(), "locationOfImportedModules");
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
        ModuleLoader<Module> instance = new ModuleLoader<>(Module.class, null);
        ClassLocation[] expResult =
        {
            new ClassLocation(jarFile, "testmodules.main.ModuleI"),
            new ClassLocation(jarFile, "testmodules.main.ModuleIO"),
            new ClassLocation(jarFile, "testmodules.main.ModuleO"),
            new ClassLocation(jarFile, "testmodules.main.RawModule"),
        };
        ArrayList<ClassLocation> result = instance.getAvailableModules(jarFile);
        assertArrayEquals(expResult, result.toArray());
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

        ModuleLoader<Module> instance = new ModuleLoader<>(Module.class, null);

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

        ModuleLoader<Module> instance = new ModuleLoader<>(Module.class, null);

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

        ModuleLoader<Module> instance = new ModuleLoader<>(Module.class, null);

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

        ModuleLoader<Module> instance = new ModuleLoader<>(Module.class, null);

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

        ModuleLoader<Module> instance = new ModuleLoader<>(Module.class, null);

        Class<?> c = new eu.convertron.interlib.interfaces.Module()
        {
            @Override
            public String getName()
            {
                throw new RuntimeException("Dummy here");
            }

            @Override
            public View getView()
            {
                throw new RuntimeException("Dummy here");
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

        ModuleLoader<Module> instance = new ModuleLoader<>(Module.class, null);

        Class<?> c = Object.class;
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

        ModuleLoader<Module> instance = new ModuleLoader<>(Module.class, null);

        Class<?> c = Module.class;
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

        ModuleLoader<Module> instance = new ModuleLoader<>(Module.class, null);

        Class<?> c = null;
        boolean expResult = false;
        boolean result = instance.isModule(c);
        assertEquals(expResult, result);
    }

}
