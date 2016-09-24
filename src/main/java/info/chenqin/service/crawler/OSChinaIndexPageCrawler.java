package info.chenqin.service.crawler;

import info.chenqin.apiresponse.crawler.OSChinaIndexPageNewsModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * User: nathanchen
 * <p/>
 * Date: 18/09/2016
 * <p/>
 * Time: 12:33 PM
 * <p/>
 * Description:
 */
@Service
public class OSChinaIndexPageCrawler
{
    private static final String SITE_DOMAIN = "http://www.oschina.net";
    private static final String INDEX_PAGE_URL = SITE_DOMAIN + "/";

    public List<OSChinaIndexPageNewsModel> crawlOSChinaIndexPage()
    {
        Document doc;
        List<OSChinaIndexPageNewsModel> osChinaIndexPageNewsModelList = new ArrayList<>(20);
        try
        {
            doc = Jsoup.connect(INDEX_PAGE_URL).userAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 9_1 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Version/9.0 Mobile/13B143 Safari/601.1").get();
            Elements todayNews = doc.select("li.today>a");
            OSChinaIndexPageNewsModel osChinaIndexPageNewsModel;
            for (Element aNews : todayNews)
            {
                osChinaIndexPageNewsModel = new OSChinaIndexPageNewsModel();
                osChinaIndexPageNewsModel.setTitle(aNews.text());
                osChinaIndexPageNewsModel.setUrl(SITE_DOMAIN + aNews.attr("href"));
                osChinaIndexPageNewsModelList.add(osChinaIndexPageNewsModel);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return osChinaIndexPageNewsModelList;
    }
}
