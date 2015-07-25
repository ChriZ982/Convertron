/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter.io;

import java.io.IOException;
import java.util.Arrays;
import org.junit.*;

/**
 *
 * @author Christopher
 */
public class FileTMPTest
{
    FileIO instance;

    @Before
    public void setUp()
    {
        instance = new FileIO("C:\\Users\\Christopher\\Desktop 2\\adds\\tt.txt");
    }

    @Test
    public void testCreate() throws IOException
    {
        instance.create();
        instance.write(new String[]
        {
            "one", "two", "", "four"
        });
        System.out.println(instance.read(1));
        System.out.println(Arrays.toString(instance.read()));
        System.out.println(instance.asString());
        instance.copy("C:\\Users\\Christopher\\Desktop 2\\adds2");
    }

}
