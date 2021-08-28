package Lesson7;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class App_weather {
    private static final String HOST = "api.weatherapi.com";
    private static final String VERSION = "v1";
    private static final String FORECAST = "forecast.json";
    private static final String KEY = "9dc70175157447f5a1b145435212508";
    private static final String CITY = "20007";
    private static final String DAYS = "5";
    private static final String AQI = "no";
    private static final String ALERTS = "no";


    public static void main(String[] args) throws IOException {

        OkHttpClient client = new OkHttpClient();
        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host(HOST)
                .addPathSegment(VERSION)
                .addPathSegment(FORECAST)
                .addQueryParameter("key", KEY)
                .addQueryParameter("q", CITY)
                .addQueryParameter("days", DAYS)
                .addQueryParameter("aqt", AQI)
                .addQueryParameter("alerts", ALERTS)
                .build();


        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        ObjectMapper objectMapper = new ObjectMapper();
        WeatherResponse weatherResponse = objectMapper.readValue(response.body().byteStream(),WeatherResponse.class);
        System.out.println("City : " + weatherResponse.getLocation());
        System.out.println("Temperature C : " + weatherResponse.getTemp_c());
        System.out.println("Feels like : " + weatherResponse.getFeelslike_c());
        System.out.println("Max temperature : " + weatherResponse.getMaxtemp_c());
        System.out.println("Min temperature: " + weatherResponse.getMintemp_c());
        System.out.println(weatherResponse.getForecastdays());




//        System.out.println(weatherResponse.getName());
//        System.out.println(weatherResponse.getMaxtemp_c());

    }
    }




// JsonNode CityName = objectMapper
//                .readTree(response.body().string())
//                .at("/current/condition/text");
//
//        System.out.println("City: " + CityName);
//    }
//    }



//        System.out.println(response.body().string());
//    }
//}
//                System.out.println(Objects.requireNonNull(response.body()).string());








