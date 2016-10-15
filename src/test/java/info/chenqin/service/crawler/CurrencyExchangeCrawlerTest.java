package info.chenqin.service.crawler;

import info.chenqin.entity.crawler.CrawlerTaskEntity;
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
    public void testAddNewTask() throws Exception
    {
        CrawlerTaskEntity crawlerTaskEntity = CrawlerTaskEntity.builder()
                .title("test").url("http://baidyu.com").website("Amazon").build();
        CurrencyExchangeCrawler currencyExchangeCrawler = new CurrencyExchangeCrawler();
        currencyExchangeCrawler.addNewTask(crawlerTaskEntity);
    }

    @Test
    public void testCrawlCurrencyExchangeInfoPage() throws Exception
    {
        CurrencyExchangeCrawler currencyExchangeCrawler = new CurrencyExchangeCrawler();
        testBloombergFinancialDataInfoModelList(currencyExchangeCrawler.crawlCurrencyExchangeInfoPage());
    }
}