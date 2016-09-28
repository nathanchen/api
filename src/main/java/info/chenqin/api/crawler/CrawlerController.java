package info.chenqin.api.crawler;

import info.chenqin.apirequest.BaseAPIRequestModel;
import info.chenqin.apiresponse.crawler.*;
import info.chenqin.common.ApiResponseCodeEnum;
import info.chenqin.service.crawler.CurrencyExchangeCrawler;
import info.chenqin.service.crawler.OSChinaIndexPageCrawler;
import info.chenqin.service.crawler.StockMarketCrawler;
import info.chenqin.service.crawler.YahooWeatherCrawler;
import info.chenqin.url.APIURL;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

/**
 * User: nathanchen
 * <p/>
 * Date: 18/09/2016
 * <p/>
 * Time: 1:21 PM
 * <p/>
 * Description:
 */
@Slf4j
@Controller
public class CrawlerController
{
    @Autowired
    private OSChinaIndexPageCrawler osChinaIndexPageCrawler;

    @Autowired
    private CurrencyExchangeCrawler currencyExchangeCrawler;

    @Autowired
    private YahooWeatherCrawler yahooWeatherCrawler;

    @Autowired
    private StockMarketCrawler stockMarketCrawler;

    @ResponseBody
    @RequestMapping(value = APIURL.API_CRAWL_OSCHINA_INDEX_PAGE_URL, method = RequestMethod.GET)
    public OSChinaIndexPageCrawlerApiResponse crawlOSChinaIndexPage(@Valid @ModelAttribute() BaseAPIRequestModel baseAPIRequestModel, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {
            log.warn("{} - {}", ApiResponseCodeEnum.REQUEST_PARAM_ERROR.getMsg(), baseAPIRequestModel);
            return new OSChinaIndexPageCrawlerApiResponse(ApiResponseCodeEnum.REQUEST_PARAM_ERROR.getCode(), ApiResponseCodeEnum.REQUEST_PARAM_ERROR.getMsg());
        }
        List<OSChinaIndexPageNewsModel> osChinaIndexPageNewsModelList = osChinaIndexPageCrawler.crawlOSChinaIndexPage();
        if (!osChinaIndexPageNewsModelList.isEmpty())
        {
            return new OSChinaIndexPageCrawlerApiResponse(ApiResponseCodeEnum.SUCCESS.getCode(), osChinaIndexPageNewsModelList);
        }
        else
        {
            return new OSChinaIndexPageCrawlerApiResponse(ApiResponseCodeEnum.CRAWLER_RETURNS_EMPTY.getCode(), ApiResponseCodeEnum.CRAWLER_RETURNS_EMPTY.getMsg());
        }
    }

    @ResponseBody
    @RequestMapping(value = APIURL.API_CURRENCY_EXCHANGE_RATE_URL, method = RequestMethod.GET)
    public BloombergFinancialDataInfoApiResponse getCurrencyExchangeRate(@Valid @ModelAttribute() BaseAPIRequestModel baseAPIRequestModel, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {
            log.warn("{} - {}", ApiResponseCodeEnum.REQUEST_PARAM_ERROR.getMsg(), baseAPIRequestModel);
            return new BloombergFinancialDataInfoApiResponse(ApiResponseCodeEnum.REQUEST_PARAM_ERROR.getCode(), ApiResponseCodeEnum.REQUEST_PARAM_ERROR.getMsg());
        }
        List<BloombergFinancialDataInfoModel> bloombergFinancialDataInfoModelList = currencyExchangeCrawler.crawlCurrencyExchangeInfoPage();
        if (bloombergFinancialDataInfoModelList != null)
        {
            return new BloombergFinancialDataInfoApiResponse(ApiResponseCodeEnum.SUCCESS.getCode(), bloombergFinancialDataInfoModelList);
        }
        else
        {
            return new BloombergFinancialDataInfoApiResponse(ApiResponseCodeEnum.CRAWLER_RETURNS_EMPTY.getCode(), ApiResponseCodeEnum.CRAWLER_RETURNS_EMPTY.getMsg());
        }
    }

    @ResponseBody
    @RequestMapping(value = APIURL.API_STOCK_PRICE_URL, method = RequestMethod.GET)
    public BloombergFinancialDataInfoApiResponse getStockPrice(@Valid @ModelAttribute() BaseAPIRequestModel baseAPIRequestModel, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {
            log.warn("{} - {}", ApiResponseCodeEnum.REQUEST_PARAM_ERROR.getMsg(), baseAPIRequestModel);
            return new BloombergFinancialDataInfoApiResponse(ApiResponseCodeEnum.REQUEST_PARAM_ERROR.getCode(), ApiResponseCodeEnum.REQUEST_PARAM_ERROR.getMsg());
        }
        List<BloombergFinancialDataInfoModel> bloombergFinancialDataInfoModelList = stockMarketCrawler.crawlStockPricePages();
        if (bloombergFinancialDataInfoModelList != null)
        {
            return new BloombergFinancialDataInfoApiResponse(ApiResponseCodeEnum.SUCCESS.getCode(), bloombergFinancialDataInfoModelList);
        }
        else
        {
            return new BloombergFinancialDataInfoApiResponse(ApiResponseCodeEnum.CRAWLER_RETURNS_EMPTY.getCode(), ApiResponseCodeEnum.CRAWLER_RETURNS_EMPTY.getMsg());
        }
    }

    @ResponseBody
    @RequestMapping(value = APIURL.API_CRAWL_YAHOO_WEATHER_URL, method = RequestMethod.GET)
    public YahooWeatherAPIResponse getWeatherForecast(@Valid @ModelAttribute() BaseAPIRequestModel baseAPIRequestModel, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {
            log.warn("{} - {}", ApiResponseCodeEnum.REQUEST_PARAM_ERROR.getMsg(), baseAPIRequestModel);
            return new YahooWeatherAPIResponse(ApiResponseCodeEnum.REQUEST_PARAM_ERROR.getCode(), ApiResponseCodeEnum.REQUEST_PARAM_ERROR.getMsg());
        }
        List<WeatherForecastDailyInfoModel> weatherForecastDailyInfoModelList = yahooWeatherCrawler.getWeather();
        if (!weatherForecastDailyInfoModelList.isEmpty())
        {
            return new YahooWeatherAPIResponse(ApiResponseCodeEnum.SUCCESS.getCode(), weatherForecastDailyInfoModelList);
        }
        else
        {
            return new YahooWeatherAPIResponse(ApiResponseCodeEnum.CRAWLER_RETURNS_EMPTY.getCode(), ApiResponseCodeEnum.CRAWLER_RETURNS_EMPTY.getMsg());
        }
    }
}
