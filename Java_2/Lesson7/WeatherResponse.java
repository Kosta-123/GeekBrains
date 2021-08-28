package Lesson7;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {
    @JsonProperty("forecastdays")
    private List <Forecastday>  forecastdays;
    @JsonProperty("location")
    private Object location;
    @JsonProperty("temp_c")
    private double temp_c;

    private double feelslike_c;
    private double maxtemp_c;
    private double mintemp_c;
    public WeatherResponse(){

    }

    public double getMintemp_c() {
        return mintemp_c;
    }

    public void setMintemp_c(double mintemp_c) {
        this.mintemp_c = mintemp_c;
    }

    public double getMaxtemp_c() {
        return maxtemp_c;
    }

    public void setMaxtemp_c(double maxtemp_c) {
        this.maxtemp_c = maxtemp_c;
    }

    public double getFeelslike_c() {
        return feelslike_c;
    }

    public void setFeelslike_c(double feelslike_c) {
        this.feelslike_c = feelslike_c;
    }

    public double getTemp_c() {
        return temp_c;
    }

    public void setTemp_c(double temp_c) {
        this.temp_c = temp_c;
    }

    public Object getLocation() {
        return location;
    }

    public void setLocation(Object location) {
        this.location = location;
    }

    public WeatherResponse(List<Forecastday> forecastdays) {
        this.forecastdays = forecastdays;
    }

    public List<Forecastday> getForecastdays() {
        return forecastdays;
    }

    public void setForecastdays(List<Forecastday> forecastdays) {
        this.forecastdays = forecastdays;
    }
}




