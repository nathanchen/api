package info.chenqin.random;

import org.junit.Test;

/**
 * User: nathanchen
 * <p/>
 * Date: 19/09/2016
 * <p/>
 * Time: 3:21 PM
 * <p/>
 * Description:
 */
public class RandomTest
{
    @Test
    public void testInteger()
    {
        Integer i = 10;
        int j = 10;
        System.out.println(i == j);

        i = 127;
        j = 127;
        System.out.println(i == j);

        Integer x = 127;
        System.out.println(i == x);

        i = 128;
        x = 128;
        System.out.println(i == x);
    }
}
