package com.weatherapp.controller;

import com.weatherapp.model.WeatherResponse;
import com.weatherapp.service.WeatherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/")
    public String index(@RequestParam(value = "city", required = false, defaultValue = "London") String city, Model model) {
        WeatherResponse weather = weatherService.getWeather(city);
        model.addAttribute("weather", weather);
        model.addAttribute("city", city);
        return "index";
    }
}
