package info.chenqin.service.crawler;

import info.chenqin.apiresponse.crawler.CurrencyExchangeRateInfoModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.IOException;

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
public class CurrencyExchangeCrawler
{

    public CurrencyExchangeRateInfoModel crawlCurrencyExchangeInfoPage()
    {
        Document doc;
        CurrencyExchangeRateInfoModel currencyExchangeRateInfoModel = null;
        try
        {
            final String CURRENCY_EXCHANGE_INFO_PAGE_URL = "http://www.bloomberg.com/quote/USDCNY:CUR";
            doc = Jsoup.connect(CURRENCY_EXCHANGE_INFO_PAGE_URL).userAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 9_1 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Version/9.0 Mobile/13B143 Safari/601.1").get();
            Element element = doc.select("meta[itemprop=\"price\"]").first();
            String exchangeRate = element.attr("content");

            element = doc.select("meta[itemprop=\"priceChange\"]").first();
            String changedValue = element.attr("content");

            currencyExchangeRateInfoModel = new CurrencyExchangeRateInfoModel();
            currencyExchangeRateInfoModel.setCurrencyExchangeRate(exchangeRate);
            currencyExchangeRateInfoModel.setChangeValue(changedValue);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return currencyExchangeRateInfoModel;
    }
}
