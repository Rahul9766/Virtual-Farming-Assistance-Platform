package com.developer.virtualFarming.dto;

public class WeatherForecastDTO {
    private String day;
    private String temp;

    public WeatherForecastDTO(String day, String temp) {
        this.day = day;
        this.temp = temp;
    }

    public String getDay() {
        return day;
    }

    public String getTemp() {
        return temp;
    }
}
