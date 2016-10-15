package info.chenqin.api.robot;

import info.chenqin.url.APIURL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * User: nathanchen
 * <p>
 * Date: 28/9/16
 * <p>
 * Time: 9:27 PM
 * <p>
 * Description:
 */
@Controller
public class AutoTestController
{
    @RequestMapping(value = APIURL.API_AUTO_TEST_URL, method = RequestMethod.GET)
    public void runApiTests()
    {

    }

    void getAllTestClasses()
    {
        File d = new File("");
        File[] f = d.listFiles();
    }

    String getPackageTimestamp()
    {
        String statusUrlStr = "http://chenqin.info/status.html";
        try
        {
            Element element = Jsoup.connect(statusUrlStr).get().getElementById("build_time");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            return simpleDateFormat.parse(element.html()).toString();
        }
        catch (IOException | ParseException e)
        {
            e.printStackTrace();
        }
        return "";
    }
}
