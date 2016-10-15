package info.chenqin.service.crawler;

import org.junit.Test;

/**
 * User: nathanchen
 * <p>
 * Date: 13/10/16
 * <p>
 * Time: 8:56 AM
 * <p>
 * Description:
 */
public class AmazonComDetailPageCrawlerTest
{
    @Test
    public void testGetPrice() throws Exception
    {
        AmazonComDetailPageCrawler amazonComDetailPageCrawler = new AmazonComDetailPageCrawler();
        amazonComDetailPageCrawler.getPrice();
    }
}