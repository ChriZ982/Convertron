package convertron.modules;

import convertron.modules.ClassLocation;
import java.io.File;
import java.net.URL;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

@SuppressWarnings("javadoc")
public class ClassLocationTest
{
    public ClassLocationTest()
    {
    }

    /**
     * Test of constructors, of class ClassLocation.
     * @throws java.lang.Exception
     */
    @Test
    public void testConstructor_compareConstructors() throws Exception
    {
        System.out.println("constructor");

        ClassLocation instance = new ClassLocation("package1.package2.className@file:/C:/path1/path2/file.name");
        assertEquals(new ClassLocation(new URL("file:/C:/path1/path2/file.name"), "package1.package2.className"), instance);
    }

    /**
     * Test of constructor (single String), of class ClassLocation
     * @throws java.lang.Exception
     */
    @Test
    public void testConstructor_singleArgument() throws Exception
    {
        System.out.println("constructor");

        ClassLocation instance = new ClassLocation("package1.package2.className@file:/C:/path1/path2/file.name");
        String expectedName = "package1.package2.className";
        assertEquals(expectedName, instance.getClassName());

        URL expectedURL = new URL("file:/C:/path1/path2/file.name");
        assertEquals(expectedURL, instance.getJarFileUrl());
    }

    /**
     * Test of constructor (single String), of class ClassLocation
     * @throws java.lang.Exception
     */
    @Test
    public void testConstructor_singleArgumentWrong() throws Exception
    {
        System.out.println("constructor");

        try
        {
            ClassLocation instance = new ClassLocation("package1.package2.className:file:/C:/path1/path2/file.name");
            fail("An IllegalArgumentException should have been thrown here");
        }
        catch(IllegalArgumentException ex)
        {
        }
    }

    /**
     * Test of constructor (single String), of class ClassLocation
     * @throws java.lang.Exception
     */
    @Test
    public void testConstructor_singleArgumentWithSecondAt() throws Exception
    {
        System.out.println("constructor");

        ClassLocation instance = new ClassLocation("package1.package2.className@file:/C:/path1/path2/file.n@me");
        String expectedName = "package1.package2.className";
        assertEquals(expectedName, instance.getClassName());

        URL expectedURL = new URL("file:/C:/path1/path2/file.n@me");
        assertEquals(expectedURL, instance.getJarFileUrl());
    }

    /**
     * Test of forSaving method, of class ClassLocation.
     * @throws java.lang.Exception
     */
    @Test
    public void testForSaving() throws Exception
    {
        System.out.println("forSaving");
        ClassLocation instance = new ClassLocation(new File("C:/path1/path2/file.name").toURI().toURL(), "package1.package2.className");
        String expResult = "package1.package2.className@file:/C:/path1/path2/file.name";
        String result = instance.forSaving();
        assertEquals(expResult, result);
    }
}
