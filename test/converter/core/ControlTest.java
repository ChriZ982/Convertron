/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter.core;

import javax.swing.UIManager;
import org.junit.*;

public class ControlTest
{
    Control instance;

    @Before
    public void setUp() throws Exception
    {
        instance = new Control();
    }

    @Test
    public void fileEncoding()
    {
        Assert.assertEquals("ISO-8859-1", System.getProperty("file.encoding"));
    }

    @Test
    public void javaLookAndFeel()
    {
        Assert.assertEquals(UIManager.getSystemLookAndFeelClassName(), UIManager.getLookAndFeel().getClass().getName());
    }

    @Test
    public void windowSetup()
    {
        Assert.assertNotNull(instance.getWindow());
        Assert.assertTrue(instance.getWindow().isVisible());
        Assert.assertTrue(instance.getWindow().tabCount() >= 1);
    }
}
