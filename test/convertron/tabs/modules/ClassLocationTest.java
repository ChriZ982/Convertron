/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertron.tabs.modules;

import java.io.File;
import java.net.URL;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Mirko
 */
@SuppressWarnings("javadoc")
public class ClassLocationTest
{
    public ClassLocationTest()
    {
    }

    /**
     * Test of constructors, of class ClassLocation.
     */
    @Test
    public void testConstructor_compareConstructors() throws Exception
    {
        ClassLocation instance = new ClassLocation("package1.package2.className@file:/C:/path1/path2/file.name");
        assertEquals(new ClassLocation(new URL("file:/C:/path1/path2/file.name"), "package1.package2.className"), instance);
    }

    /**
     * Test of constructor (single String), of class ClassLocation
     */
    @Test
    public void testConstructor_singleArgument() throws Exception
    {
        ClassLocation instance = new ClassLocation("package1.package2.className@file:/C:/path1/path2/file.name");
        String expectedName = "package1.package2.className";
        assertEquals(expectedName, instance.getClassName());

        URL expectedURL = new URL("file:/C:/path1/path2/file.name");
        assertEquals(expectedURL, instance.getJarFileUrl());
    }

    /**
     * Test of constructor (single String), of class ClassLocation
     */
    @Test
    public void testConstructor_singleArgumentWithSecondAt() throws Exception
    {
        ClassLocation instance = new ClassLocation("package1.package2.className@file:/C:/path1/path2/file.n@me");
        String expectedName = "package1.package2.className";
        assertEquals(expectedName, instance.getClassName());

        URL expectedURL = new URL("file:/C:/path1/path2/file.n@me");
        assertEquals(expectedURL, instance.getJarFileUrl());
    }

    /**
     * Test of forSaving method, of class ClassLocation.
     */
    @Test
    public void testForSaving() throws Exception
    {
        System.out.println("forSaving");
        ClassLocation instance = new ClassLocation(new File("/path1/path2/file.name").toURI().toURL(), "package1.package2.className");
        String expResult = "package1.package2.className@file:/C:/path1/path2/file.name";
        String result = instance.forSaving();
        assertEquals(expResult, result);
    }
}
