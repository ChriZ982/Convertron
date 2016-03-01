package eu.convertron.interlib.util;

import eu.convertron.interlib.util.Time;
import java.util.Date;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

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
