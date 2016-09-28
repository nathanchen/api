package info.chenqin.service.crawler;

import info.chenqin.apiresponse.crawler.BloombergFinancialDataInfoModel;
import org.junit.Test;

import java.util.List;

/**
 * User: nathanchen
 * <p>
 * Date: 28/9/16
 * <p>
 * Time: 10:58 AM
 * <p>
 * Description:
 */
public class StockMarketCrawlerTest extends BloombergFinancialDataPageCrawlerTest
{
    @Test
    public void testCrawlStockPricePages() throws Exception
    {
        StockMarketCrawler stockMarketCrawler = new StockMarketCrawler();
        List<BloombergFinancialDataInfoModel> bloombergFinancialDataInfoModelList = stockMarketCrawler.crawlStockPricePages();
        testBloombergFinancialDataInfoModelList(bloombergFinancialDataInfoModelList);
    }
}