package info.chenqin.service.crawler;

import com.github.fedy2.weather.YahooWeatherService;
import com.github.fedy2.weather.data.Channel;
import com.github.fedy2.weather.data.Forecast;
import com.github.fedy2.weather.data.unit.DegreeUnit;
import info.chenqin.apiresponse.crawler.WeatherForecastDailyInfoModel;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * User: nathanchen
 * <p/>
 * Date: 21/09/2016
 * <p/>
 * Time: 12:50 AM
 * <p/>
 * Description:
 */
@Service
public class YahooWeatherCrawler
{
    public List<WeatherForecastDailyInfoModel> getWeather()
    {
        final String HAYWARD_CODE = "2419175";
        List<WeatherForecastDailyInfoModel> weatherForecastDailyInfoModelList = new ArrayList<>(9);
        try
        {
            YahooWeatherService service = new YahooWeatherService();
            Channel channel = service.getForecast(HAYWARD_CODE, DegreeUnit.CELSIUS);
            WeatherForecastDailyInfoModel weatherForecastDailyInfoModel;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd E");
            for (Forecast forecast : channel.getItem().getForecasts())
            {
                weatherForecastDailyInfoModel = new WeatherForecastDailyInfoModel();
                weatherForecastDailyInfoModel.setDate(simpleDateFormat.format(forecast.getDate()));
                weatherForecastDailyInfoModel.setLowTemp(String.valueOf(forecast.getLow()));
                weatherForecastDailyInfoModel.setHighTemp(String.valueOf(forecast.getHigh()));
                weatherForecastDailyInfoModel.setWeather(forecast.getText());
                weatherForecastDailyInfoModelList.add(weatherForecastDailyInfoModel);
            }
        }
        catch (IOException | JAXBException e)
        {
            e.printStackTrace();
        }

        return weatherForecastDailyInfoModelList;
    }
}
