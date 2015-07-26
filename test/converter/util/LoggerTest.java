package converter.util;

import converter.core.Control;
import converter.modules.overview.OverviewView;
import java.awt.Color;
import junit.framework.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

public class LoggerTest
{
    @Test
    public void testLog()
    {
        System.out.println("log");
        int prio = 0;
        String what = "";
        String[] whyHelp = null;
        Logger.log(prio, what, whyHelp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testBuildErrorMessage()
    {
        System.out.println("buildErrorMessage");
        String what = "";
        String[] whyHelp = null;
        String expResult = "";
        String result = Logger.buildErrorMessage(what, whyHelp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testSelectColor()
    {
        Color info = Logger.selectColor(Logger.INFO);
        Assert.assertNotNull(info);
        Color hint = Logger.selectColor(Logger.HINT);
        Assert.assertNotNull(hint);
        Color error = Logger.selectColor(Logger.ERROR);
        Assert.assertNotNull(error);
        Color wrong = Logger.selectColor(-100);
        Assert.assertNotNull(wrong);
    }

    @Test
    public void testWriteInTextBox()
    {
        Control control = new Control();
        Logger.writeInTextBox("testmsg", Color.PINK);
        Assert.assertTrue(OverviewView.getLog().getText().contains("testmsg"));
    }

    @Test
    public void testSetLogInfos()
    {
        Logger.setLogInfos(true);
        Assert.assertTrue(Logger.logInfos);
        Logger.setLogInfos(false);
        Assert.assertFalse(Logger.logInfos);
    }
}
