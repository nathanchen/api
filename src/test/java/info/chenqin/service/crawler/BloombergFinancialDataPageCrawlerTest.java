package info.chenqin.service.crawler;

import info.chenqin.apiresponse.crawler.BloombergFinancialDataInfoModel;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * User: nathanchen
 * <p>
 * Date: 28/9/16
 * <p>
 * Time: 11:00 AM
 * <p>
 * Description:
 */
class BloombergFinancialDataPageCrawlerTest
{
    void testBloombergFinancialDataInfoModelList(List<BloombergFinancialDataInfoModel> bloombergFinancialDataInfoModelList)
    {
        for (BloombergFinancialDataInfoModel bloombergFinancialDataInfoModel : bloombergFinancialDataInfoModelList)
        {
            testBloombergFinancialDataInfoModel(bloombergFinancialDataInfoModel);
        }
    }

    private void testBloombergFinancialDataInfoModel(BloombergFinancialDataInfoModel bloombergFinancialDataInfoModel)
    {
        assertNotNull(bloombergFinancialDataInfoModel);
        assertNotNull(bloombergFinancialDataInfoModel.getCurrentValue());
        assertTrue(Double.valueOf(bloombergFinancialDataInfoModel.getCurrentValue()) > 0);
        assertNotNull(bloombergFinancialDataInfoModel.getChangeValue());
        assertTrue(Double.valueOf(bloombergFinancialDataInfoModel.getChangeValue()) >= 0);
        System.out.println(bloombergFinancialDataInfoModel);
    }
}