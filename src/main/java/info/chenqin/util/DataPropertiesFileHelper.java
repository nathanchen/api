package info.chenqin.util;

import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

/**
 * User: nathanchen
 * <p>
 * Date: 28/9/16
 * <p>
 * Time: 11:44 AM
 * <p>
 * Description:
 */
public class DataPropertiesFileHelper
{
    public static HashMap<String, String> readStockProperties()
    {
        return readProperties("data/stock.properties");
    }

    public static HashMap<String, String> readCurrencyExchangeProperties()
    {
        return readProperties("data/currency-exchange.properties");
    }

    private static HashMap<String, String> readProperties(String properties_file_path)
    {
        HashMap<String, String> stockNameUrlMap = new HashMap<>();
        try
        {
            Properties stockMarketProperties = PropertiesLoaderUtils.loadAllProperties(properties_file_path, PropertiesFileHelper.class.getClassLoader());
            for (String stockName : stockMarketProperties.stringPropertyNames())
            {
                stockNameUrlMap.put(stockName, stockMarketProperties.getProperty(stockName));
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return stockNameUrlMap;
    }
}
