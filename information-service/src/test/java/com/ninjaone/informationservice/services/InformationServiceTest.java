package com.ninjaone.informationservice.services;

import com.ninjaone.informationservice.domain.ConsumerInformation;
import com.ninjaone.informationservice.domain.WeatherData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InformationServiceTest {

    public static final String A_FACT = "a fact";
    @Mock
    private WeatherService weatherService;

    @Mock
    private FactService factService;
    private InformationService informationService;

    @BeforeEach
    public void beforeEach() {
        informationService = new InformationService(weatherService, factService);
    }

    @Test
    public void retrieveWeatherAndFact() {
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

        when(weatherService.retrieveWeather("75023")).thenReturn(weather);
        when(factService.retrieveFact()).thenReturn(A_FACT);

        ConsumerInformation consumerInformation = ConsumerInformation.builder()
                .weatherData(weather)
                .fact(A_FACT)
                .build();

        assertThat(informationService.retrieveConsumerInformation("75023")).isEqualTo(consumerInformation);
    }

}