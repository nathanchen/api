package info.chenqin.service.crawler;

import org.junit.Test;

/**
 * User: nathanchen
 * <p>
 * Date: 23/9/16
 * <p>
 * Time: 12:04 AM
 * <p>
 * Description:
 */
public class CurrencyExchangeCrawlerTest extends BloombergFinancialDataPageCrawlerTest
{
    @Test
    public void testCrawlCurrencyExchangeInfoPage() throws Exception
    {
        CurrencyExchangeCrawler currencyExchangeCrawler = new CurrencyExchangeCrawler();
        testBloombergFinancialDataInfoModelList(currencyExchangeCrawler.crawlCurrencyExchangeInfoPage());
    }
}