package info.chenqin.service.crawler;

import org.junit.Test;

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
        yahooWeatherCrawler.getWeather();
    }
}