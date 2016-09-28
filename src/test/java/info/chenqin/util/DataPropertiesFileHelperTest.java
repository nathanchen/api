package info.chenqin.util;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * User: nathanchen
 * <p>
 * Date: 28/9/16
 * <p>
 * Time: 11:57 AM
 * <p>
 * Description:
 */
public class DataPropertiesFileHelperTest
{
    @Test
    public void readCurrencyExchangeProperties() throws Exception
    {
        HashMap<String, String> currencyExchangeNameUrlMap = DataPropertiesFileHelper.readCurrencyExchangeProperties();
        testHashMap(currencyExchangeNameUrlMap);
    }

    @Test
    public void readStockProperties() throws Exception
    {
        HashMap<String, String> stockNameUrlMap = DataPropertiesFileHelper.readStockProperties();
        testHashMap(stockNameUrlMap);
    }

    private void testHashMap(HashMap<String, String> nameUrlMap)
    {
        assertNotNull(nameUrlMap);
        assertTrue(nameUrlMap.size() > 0);
        for (String key : nameUrlMap.keySet())
        {
            System.out.println(key + "\t" + nameUrlMap.get(key));
        }
        System.out.println("==========");
    }
}