package com.ninjaone.weatherservice.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Resources;
import com.ninjaone.weatherservice.domain.WeatherData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.*;
import org.springframework.web.client.RestOperations;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherServiceTest {

    @Mock
    private RestOperations restOperations;
    private WeatherService weatherService;

    @BeforeEach
    public void beforeEach() {
        weatherService = new WeatherService(restOperations, "http://localhost/weather", "api-key");
    }

    @Test
    public void retrieveWeatherForZipCallApi() throws IOException {
        URL resource = Resources.getResource("samples/plano-weather.json");
        String json = Resources.toString(resource, Charset.defaultCharset());

        ObjectMapper objectMapper = new ObjectMapper();
        WeatherData weatherData = objectMapper.readValue(json, WeatherData.class);

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Api-Key", "api-key");
        HttpEntity<WeatherData> request = new HttpEntity<>(headers);

        when(restOperations.exchange(
                "http://localhost/weather?zip=75023",
                HttpMethod.GET,
                request,
                WeatherData.class))
                .thenReturn(ResponseEntity.ok(weatherData));

        assertThat(weatherService.retrieveWeatherForZip("75023")).isEqualTo(weatherData);
    }

}