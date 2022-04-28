package com.ninjaone.weatherservice.controllers;

import com.ninjaone.weatherservice.domain.WeatherData;
import com.ninjaone.weatherservice.services.WeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class WeatherController {

    private WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather/{zipCode}")
    @ResponseBody
    public ResponseEntity<WeatherData> retrieveWeather(@PathVariable String zipCode) {
        return ResponseEntity.ok(weatherService.retrieveWeatherForZip(zipCode));
    }

}
