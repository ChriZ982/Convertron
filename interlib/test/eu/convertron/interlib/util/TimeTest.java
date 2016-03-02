package eu.convertron.interlib.util;

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TimeTest
{
    @Test
    public void testFormatNow()
    {
        assertTrue(Time.formatNow("yyyy-MM-dd").contains("-") && Time.formatNow("yyyy-MM-dd").startsWith("2"));
    }

    @Test
    public void testFormat()
    {
        assertEquals(Time.format(new Date(1444654181462L), "yyyy-MM-dd"), "2015-10-12");
    }
}
