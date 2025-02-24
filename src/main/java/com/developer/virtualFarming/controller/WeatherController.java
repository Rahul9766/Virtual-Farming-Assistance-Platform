package com.developer.virtualFarming.controller;

import com.developer.virtualFarming.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/{location}")
    public ResponseEntity<Map<String, Object>> getWeather(@PathVariable String location) {
        Map<String, Object> weatherData = weatherService.getWeather(location);
        return ResponseEntity.ok(weatherData);
    }
}
