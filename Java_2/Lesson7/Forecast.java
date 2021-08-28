package Lesson7;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
class Forecastday {
   @JsonProperty("forecastday")
    private List<Forecastday> forecastdays;
   @JsonProperty("location")
    private Object location;

    public Forecastday(){

    }


    public Forecastday(List<Forecastday> forecastdays) {
        this.forecastdays = forecastdays;
    }

    public Forecastday(Object location) {
        this.location = location;
    }

    public Object getLocation() {
        return location;

    }

    public void setLocation(Object location) {
        this.location = location;
    }

    public List<Forecastday> getForecastdays() {
        return forecastdays;
    }

    public void setForecastdays(List<Forecastday> forecastdays) {
        this.forecastdays = forecastdays;
    }
}
