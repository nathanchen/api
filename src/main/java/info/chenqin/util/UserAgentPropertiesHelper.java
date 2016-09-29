package info.chenqin.util;

import java.util.Properties;
import java.util.Random;
import java.util.Set;

/**
 * User: nathanchen
 * <p>
 * Date: 28/9/16
 * <p>
 * Time: 4:54 PM
 * <p>
 * Description:
 */
public class UserAgentPropertiesHelper extends PropertiesFileHelper
{
    private static Properties userAgentProperties;
    private static final String USER_AGENT_PROPERTIES_FILE_PATH = "data/user-agent.properties";
    private static Random random = new Random();

    static {
        userAgentProperties = initProperties(userAgentProperties, USER_AGENT_PROPERTIES_FILE_PATH);
    }

    public static String getUserAgent()
    {
        Set<String> browsers = userAgentProperties.stringPropertyNames();
        int index = random.nextInt(browsers.size());
        return (String) userAgentProperties.get(browsers.toArray()[index]);
    }
}
