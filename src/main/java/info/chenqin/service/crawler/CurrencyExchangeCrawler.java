package info.chenqin.service.crawler;

import info.chenqin.apiresponse.crawler.BloombergFinancialDataInfoModel;
import info.chenqin.entity.crawler.CrawlerTaskEntity;
import info.chenqin.util.DataPropertiesFileHelper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: nathanchen
 * <p>
 * Date: 23/9/16
 * <p>
 * Time: 12:01 AM
 * <p>
 * Description:
 */
@Service
public class CurrencyExchangeCrawler extends BloombergFinancialDataPageCrawler
{
    public List<BloombergFinancialDataInfoModel> crawlCurrencyExchangeInfoPage()
    {
        return crawlFinancialInfoPages(DataPropertiesFileHelper.readCurrencyExchangeProperties());
    }

    public void addNewTask(CrawlerTaskEntity crawlerTaskEntity)
    {
        crawlerTaskDao.insertANewTask(crawlerTaskEntity);
    }
}
