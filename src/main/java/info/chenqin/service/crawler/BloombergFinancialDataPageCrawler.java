package info.chenqin.service.crawler;

import info.chenqin.apiresponse.crawler.BloombergFinancialDataInfoModel;
import info.chenqin.dao.crawler.ICrawlerTaskDao;
import info.chenqin.util.UserAgentPropertiesHelper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * User: nathanchen
 * <p>
 * Date: 28/9/16
 * <p>
 * Time: 10:37 AM
 * <p>
 * Description:
 */
abstract class BloombergFinancialDataPageCrawler
{
    @Resource
    ICrawlerTaskDao crawlerTaskDao;

    List<BloombergFinancialDataInfoModel> crawlFinancialInfoPages(final HashMap<String, String> stockNameUrlMap)
    {
        List<BloombergFinancialDataInfoModel> bloombergFinancialDataInfoModelList = new ArrayList<>();
        BloombergFinancialDataInfoModel bloombergFinancialDataInfoModel;
        if (null != stockNameUrlMap)
        {
            Random random = new Random();
            for (String key : stockNameUrlMap.keySet())
            {
                try
                {
                    Thread.sleep((random.nextInt(4) + 1) * 1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                bloombergFinancialDataInfoModel = crawlFinancialInfoPage(key, stockNameUrlMap.get(key));
                if (null != bloombergFinancialDataInfoModel)
                {
                    bloombergFinancialDataInfoModelList.add(bloombergFinancialDataInfoModel);
                }
            }
        }
        return bloombergFinancialDataInfoModelList;
    }

    private BloombergFinancialDataInfoModel crawlFinancialInfoPage(String key, String financial_info_page_url)
    {
        Document doc;
        BloombergFinancialDataInfoModel bloombergFinancialDataInfoModel = null;
        try
        {
            doc = Jsoup.connect(financial_info_page_url).userAgent(UserAgentPropertiesHelper.getUserAgent()).get();
            Element element = doc.select("meta[itemprop=\"price\"]").first();
            String exchangeRate = element.attr("content");

            element = doc.select("meta[itemprop=\"priceChange\"]").first();
            String changedValue = element.attr("content");

            bloombergFinancialDataInfoModel = new BloombergFinancialDataInfoModel();
            bloombergFinancialDataInfoModel.setName(key);
            bloombergFinancialDataInfoModel.setCurrentValue(exchangeRate);
            bloombergFinancialDataInfoModel.setChangeValue(changedValue);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return bloombergFinancialDataInfoModel;
    }
}
