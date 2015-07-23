/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter.core;

import converter.modules.overview.OverviewView;
import org.junit.*;

/**
 *
 * @author Christopher
 */
public class WindowTest
{
    Window instance;

    @Before
    public void setUp()
    {
        instance = new Window();
    }

    @Test
    public void testAddTab()
    {
        int before = instance.tabCount();
        instance.addTab(new OverviewView());
        int after = instance.tabCount();

        Assert.assertEquals(before + 1, after);
    }
}
