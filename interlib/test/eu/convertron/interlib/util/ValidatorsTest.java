package eu.convertron.interlib.util;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidatorsTest
{
    @Test
    public void testValidateAsNumber_Valid()
    {
        assertTrue(Validators.isValidNumberAndChars("000", 'a', 'b'));
        assertTrue(Validators.isValidNumberAndChars("aa02516aaa", 'a', 'b'));
        assertTrue(Validators.isValidNumberAndChars("bbbb22231bb445", 'a', 'b'));
        assertTrue(Validators.isValidNumberAndChars("a02020bbbb555555aaaa", 'a', 'b'));
    }

    @Test
    public void testValidateAsNumber_NonValid()
    {
        assertFalse(Validators.isValidNumberAndChars("", 'a', 'b'));
        assertFalse(Validators.isValidNumberAndChars("aaaabbbbbaaabbbabaaba", 'a', 'b'));
        assertFalse(Validators.isValidNumberAndChars("aaababab65674855775ccccc.", 'a', 'b'));
    }

    @Test
    public void testValidateAsDate_Valid()
    {
        assertTrue(Validators.isValidDate("02.1."));
        assertTrue(Validators.isValidDate("2.01."));
        assertTrue(Validators.isValidDate("2.1."));
        assertTrue(Validators.isValidDate("21.11."));
    }

    @Test
    public void testValidateAsDate_NonValid()
    {
        assertFalse(Validators.isValidDate("2111"));
        assertFalse(Validators.isValidDate("2111."));
        assertFalse(Validators.isValidDate("21.11"));
        assertFalse(Validators.isValidDate("21a11d"));
        assertFalse(Validators.isValidDate("213.11."));
        assertFalse(Validators.isValidDate("21.113."));
        assertFalse(Validators.isValidDate("21a.d11."));
    }
}
