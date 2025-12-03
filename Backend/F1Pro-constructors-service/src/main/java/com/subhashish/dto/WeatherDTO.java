package com.subhashish.dto;

public class WeatherDTO {

    private String city;
    private String region;
    private String country;
    private Double temperatureC;
    private Double temperatureF;
    private Double windSpeed;
    private Integer humidity;
    private Integer cloud;
    private String condition;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getTemperatureC() {
        return temperatureC;
    }

    public void setTemperatureC(Double temperatureC) {
        this.temperatureC = temperatureC;
    }

    public Double getTemperatureF() {
        return temperatureF;
    }

    public void setTemperatureF(Double temperatureF) {
        this.temperatureF = temperatureF;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Integer getCloud() {
        return cloud;
    }

    public void setCloud(Integer cloud) {
        this.cloud = cloud;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "WeatherDTO{" +
                "city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", country='" + country + '\'' +
                ", temperatureC=" + temperatureC +
                ", temperatureF=" + temperatureF +
                ", windSpeed=" + windSpeed +
                ", humidity=" + humidity +
                ", cloud=" + cloud +
                ", condition='" + condition + '\'' +
                '}';
    }
}


