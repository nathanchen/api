package info.chenqin.api.robot;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * User: nathanchen
 * <p>
 * Date: 28/9/16
 * <p>
 * Time: 11:35 PM
 * <p>
 * Description:
 */
public class AutoTestControllerTest
{
    @Test
    public void testGetPackageTimestamp() throws Exception
    {
        AutoTestController autoTestController = new AutoTestController();
        assertNotNull(autoTestController.getPackageTimestamp());
        System.out.println(autoTestController.getPackageTimestamp());
    }
}