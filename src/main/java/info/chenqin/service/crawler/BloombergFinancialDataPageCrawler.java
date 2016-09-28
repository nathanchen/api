package info.chenqin.service.crawler;

import info.chenqin.apiresponse.crawler.BloombergFinancialDataInfoModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.*;

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
    private final ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(3);

    List<BloombergFinancialDataInfoModel> crawlFinancialInfoPages(final HashMap<String, String> stockNameUrlMap)
    {
        List<BloombergFinancialDataInfoModel> bloombergFinancialDataInfoModelList = new ArrayList<>();
        List<Future<BloombergFinancialDataInfoModel>> bloombergFinancialDataInfoModelFutureList = new ArrayList<>();
        if (null != stockNameUrlMap)
        {
            for (String key : stockNameUrlMap.keySet())
            {
                bloombergFinancialDataInfoModelFutureList.add(getBloombergFinancialDataInfoModel(stockNameUrlMap.get(key)));
            }

            if (!bloombergFinancialDataInfoModelFutureList.isEmpty())
            {
                for (Future<BloombergFinancialDataInfoModel> bloombergFinancialDataInfoModelFuture : bloombergFinancialDataInfoModelFutureList)
                {
                    try
                    {
                        bloombergFinancialDataInfoModelList.add(bloombergFinancialDataInfoModelFuture.get());
                    }
                    catch (InterruptedException | ExecutionException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }
        return bloombergFinancialDataInfoModelList;
    }

    private BloombergFinancialDataInfoModel crawlFinancialInfoPage(String financial_info_page_url)
    {
        Document doc;
        BloombergFinancialDataInfoModel bloombergFinancialDataInfoModel = null;
        try
        {
            doc = Jsoup.connect(financial_info_page_url).userAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 9_1 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Version/9.0 Mobile/13B143 Safari/601.1").get();
            Element element = doc.select("meta[itemprop=\"price\"]").first();
            String exchangeRate = element.attr("content");

            element = doc.select("meta[itemprop=\"priceChange\"]").first();
            String changedValue = element.attr("content");

            bloombergFinancialDataInfoModel = new BloombergFinancialDataInfoModel();
            bloombergFinancialDataInfoModel.setCurrentValue(exchangeRate);
            bloombergFinancialDataInfoModel.setChangeValue(changedValue);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return bloombergFinancialDataInfoModel;
    }

    private Future<BloombergFinancialDataInfoModel> getBloombergFinancialDataInfoModel(final String url)
    {
        return threadPoolExecutor.submit(new Callable<BloombergFinancialDataInfoModel>()
        {
            @Override
            public BloombergFinancialDataInfoModel call() throws Exception
            {
                return crawlFinancialInfoPage(url);
            }
        });
    }
}
