package info.chenqin.service.crawler;

import info.chenqin.apiresponse.crawler.OSChinaIndexPageNewsModel;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * User: nathanchen
 * <p>
 * Date: 23/9/16
 * <p>
 * Time: 12:04 AM
 * <p>
 * Description:
 */
public class CurrencyExchangeCrawlerTest
{
    @Test
    public void crawlCurrencyExchangeInfoPage() throws Exception
    {
        CurrencyExchangeCrawler currencyExchangeCrawler = new CurrencyExchangeCrawler();
//        System.out.println(currencyExchangeCrawler == null);

        List<OSChinaIndexPageNewsModel> osChinaIndexPageNewsModelList = new ArrayList<>(20);
        System.out.println(osChinaIndexPageNewsModelList.isEmpty());
//        currencyExchangeCrawler.crawlCurrencyExchangeInfoPage();
    }

}