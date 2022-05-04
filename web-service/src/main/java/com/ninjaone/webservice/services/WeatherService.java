package com.ninjaone.webservice.services;

import com.ninjaone.webservice.domain.WeatherData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;

@Service
public class WeatherService {
    private final RestOperations restOperations;
    private final String host;
    private final int port;

    public WeatherService(RestOperations restOperations,
                          @Value("${weather.service.host}") String host,
                          @Value("${weather.service.port}") int port) {
        this.restOperations = restOperations;
        this.host = host;
        this.port = port;
    }

    public WeatherData retrieveWeather(String zipCode) {
        return restOperations.getForEntity(
                String.format("http://%s:%d/weather?zip=%s", host, port, zipCode),
                WeatherData.class)
                .getBody();
    }
}
