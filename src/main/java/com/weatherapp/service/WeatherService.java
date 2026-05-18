package com.weatherapp.service;

import com.weatherapp.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private final RestTemplate restTemplate;

    @Value("${weather.api.key}")
    private String apiKey;

    private final String API_URL = "https://api.openweathermap.org/data/2.5/weather?q={city}&appid={apiKey}&units=metric";

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherResponse getWeather(String city) {
        try {
            return restTemplate.getForObject(API_URL, WeatherResponse.class, city, apiKey);
        } catch (Exception e) {
            return null;
        }
    }
}
