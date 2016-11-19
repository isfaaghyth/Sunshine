package belajar.app.sunshine.Controllers;

/**
 * Created by isfaaghyth on 05/11/16.
 */

public class CloudURL {

    final static private String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    final static private String API_KEY = "2179f78744d032ca7c25006a0e0f3541";
    final static private String COUNTRY = "Jakarta";
    final static private String UNITS = "metric"; //imperial (F) || metric (C)
    final static private String DATA_FORMAT = "json"; //json || xml
    final static private String DATA_COUNT = "7";

    public static String getCurrentWeather() {
        return BASE_URL + "weather?q=" + COUNTRY
                + "&units=" + UNITS
                + "&appid=" + API_KEY;
    }

    public static String getListWeather() {
        return BASE_URL + "forecast/daily?q=" + COUNTRY
                + "&mode=" + DATA_FORMAT
                + "&units=" + UNITS
                + "&cnt=" + DATA_COUNT
                + "&appid=" + API_KEY;
    }

}
