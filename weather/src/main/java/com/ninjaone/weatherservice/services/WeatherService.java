package com.ninjaone.weatherservice.services;

import com.ninjaone.weatherservice.domain.WeatherData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;

@Service
public class WeatherService {
    private final RestOperations restOperations;
    private final String url;
    private final String apiKey;

    public WeatherService(RestOperations restOperations,
                          @Value("${weather.api.url}")String url,
                          @Value("${weather.api.key}") String apiKey) {
        this.restOperations = restOperations;
        this.url = url;
        this.apiKey = apiKey;
    }

    public WeatherData retrieveWeatherForZip(String zipCode) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Api-Key", apiKey);

        HttpEntity<WeatherData> request = new HttpEntity<>(headers);

        return restOperations.exchange(
                String.format("%s?zip=%s", url, zipCode),
                HttpMethod.GET,
                request,
                WeatherData.class).getBody();
    }
}
