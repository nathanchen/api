package info.chenqin.service.crawler;

import info.chenqin.apiresponse.crawler.OSChinaIndexPageNewsModel;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * User: nathanchen
 * <p/>
 * Date: 18/09/2016
 * <p/>
 * Time: 1:09 PM
 * <p/>
 * Description:
 */
public class OSChinaIndexPageCrawlerTest
{
    @Test
    public void testCrawlOSChinaIndexPage() throws Exception
    {
        OSChinaIndexPageCrawler osChinaIndexPageCrawler = new OSChinaIndexPageCrawler();
        List<OSChinaIndexPageNewsModel> osChinaIndexPageNewsModelList = osChinaIndexPageCrawler.crawlOSChinaIndexPage();
        assertNotNull(osChinaIndexPageNewsModelList);
        assertTrue(osChinaIndexPageNewsModelList.size() > 0);
    }
}