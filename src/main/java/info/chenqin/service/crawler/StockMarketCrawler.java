package info.chenqin.service.crawler;

import info.chenqin.apiresponse.crawler.BloombergFinancialDataInfoModel;
import info.chenqin.util.DataPropertiesFileHelper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: nathanchen
 * <p>
 * Date: 28/9/16
 * <p>
 * Time: 10:35 AM
 * <p>
 * Description:
 */
@Service
public class StockMarketCrawler extends BloombergFinancialDataPageCrawler
{
    public List<BloombergFinancialDataInfoModel> crawlStockPricePages()
    {
        return crawlFinancialInfoPages(DataPropertiesFileHelper.readStockProperties());
    }
}
