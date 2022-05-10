package com.ninjaone.webservice.services;

import com.ninjaone.webservice.domain.WeatherData;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;

@Service
public class WeatherService {
    private final RestOperations restOperations;

    public WeatherService(RestOperations restOperations) {
        this.restOperations = restOperations;
    }

    public WeatherData retrieveWeather(String zipCode) {
        return restOperations.getForEntity(
                String.format("http://weather-service/weather?zip=%s", zipCode),
                WeatherData.class)
                .getBody();
    }
}
