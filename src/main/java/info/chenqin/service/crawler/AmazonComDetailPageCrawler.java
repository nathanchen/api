package info.chenqin.service.crawler;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * User: nathanchen
 * <p>
 * Date: 13/10/16
 * <p>
 * Time: 8:49 AM
 * <p>
 * Description:
 */
public class AmazonComDetailPageCrawler
{
    String url = "https://www.amazon.com/Medela-Pump-Style-Advanced-Breast/dp/B004HWXCJS/ref=sr_1_3_a_it?ie=UTF8&qid=1476376921&sr=8-3&keywords=milk+pump";

    public void getPrice()
    {
        HtmlUnitDriver webDriver = new HtmlUnitDriver(BrowserVersion.FIREFOX_45);
        webDriver.setJavascriptEnabled(true);
        webDriver.get(url);
        System.out.println(webDriver.getPageSource());
//        List<WebElement> elements = webDriver.findElements(By.id("productTitle"));
//        for (WebElement element : elements)
//        {
//            System.out.println(element.getText());
//        }
        webDriver.quit();
    }
}
