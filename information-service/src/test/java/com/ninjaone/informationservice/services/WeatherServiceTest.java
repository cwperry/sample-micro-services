package com.ninjaone.informationservice.services;

import com.ninjaone.informationservice.domain.WeatherData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestOperations;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherServiceTest {

    @Mock
    private RestOperations restOperations;

    private WeatherService weatherService;

    @BeforeEach
    public void beforeEach() {
        weatherService = new WeatherService(restOperations);
    }

    @Test
    public void retrieveWeather() {
        WeatherData weather = WeatherData.builder()
                .cloudPercentage(10)
                .temperature(10)
                .feelsLike(10)
                .humidity(10)
                .lowTemperature(10)
                .highTemperature(10)
                .windSpeed(BigDecimal.TEN)
                .windDegrees(10)
                .sunrise(10)
                .sunset(10)
                .build();

        when(restOperations.getForEntity("http://weather-service/weather/75023", WeatherData.class))
                .thenReturn(ResponseEntity.ok(weather));

        assertThat(weatherService.retrieveWeather("75023")).isEqualTo(weather);
    }
}