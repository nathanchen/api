package info.chenqin.util;

import com.google.common.base.Strings;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * User: nathanchen
 * <p>
 * Date: 28/9/16
 * <p>
 * Time: 5:00 PM
 * <p>
 * Description:
 */
public class UserAgentPropertiesHelperTest
{
    @Test
    public void testGetUserAgent() throws Exception
    {
        String userAgent = UserAgentPropertiesHelper.getUserAgent();
        assertNotNull(userAgent);
        assertTrue(!Strings.isNullOrEmpty(userAgent));
        System.out.println(UserAgentPropertiesHelper.getUserAgent());
    }
}