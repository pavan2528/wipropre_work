package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    @GetMapping("/weather")
    public String getWeather(@RequestParam String city, @RequestParam String day) {
        return "Weather in " + city + " for " + day + " is cloudy.";
    }
}
