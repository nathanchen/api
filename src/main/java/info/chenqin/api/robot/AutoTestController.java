package info.chenqin.api.robot;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Controller;

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
