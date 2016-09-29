package info.chenqin.service.crawler;

import info.chenqin.apiresponse.crawler.WeatherForecastDailyInfoModel;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * User: nathanchen
 * <p/>
 * Date: 21/09/2016
 * <p/>
 * Time: 1:07 AM
 * <p/>
 * Description:
 */
public class YahooWeatherCrawlerTest
{
    @Test
    public void testGetWeather() throws Exception
    {
        YahooWeatherCrawler yahooWeatherCrawler = new YahooWeatherCrawler();
        List<WeatherForecastDailyInfoModel> weatherForecastDailyInfoModelList = yahooWeatherCrawler.getWeather();
        assertNotNull(weatherForecastDailyInfoModelList);
        assertTrue(weatherForecastDailyInfoModelList.size() > 0);
    }
}