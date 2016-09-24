package info.chenqin.util;

import java.util.Properties;

/**
 * User: nathanchen
 * <p/>
 * Date: 20/09/2016
 * <p/>
 * Time: 5:53 PM
 * <p/>
 * Description:
 */
public class ApiProjectPropertiesFileHelper extends PropertiesFileHelper
{
    private static Properties apiProjectConfigProperties;
    private static final String API_PROJECT_CONFIG_PROPERTIES_FILE_PATH = "conf/api-project-config.properties";

    static {
        apiProjectConfigProperties = initProperties(apiProjectConfigProperties, API_PROJECT_CONFIG_PROPERTIES_FILE_PATH);
    }
}
