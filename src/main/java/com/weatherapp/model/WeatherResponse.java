package com.weatherapp.model;

import lombok.Data;
import java.util.List;

@Data
public class WeatherResponse {
    private List<Weather> weather;
    private Main main;
    private Wind wind;
    private String name;
    private Sys sys;

    @Data
    public static class Weather {
        private String main;
        private String description;
        private String icon;
    }

    @Data
    public static class Main {
        private double temp;
        private double feels_like;
        private int humidity;
        private int pressure;
    }

    @Data
    public static class Wind {
        private double speed;
    }

    @Data
    public static class Sys {
        private String country;
    }
}
