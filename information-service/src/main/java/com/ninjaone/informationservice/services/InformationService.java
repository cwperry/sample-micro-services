package com.ninjaone.informationservice.services;

import com.ninjaone.informationservice.domain.ConsumerInformation;
import com.ninjaone.informationservice.domain.WeatherData;
import org.springframework.stereotype.Service;

@Service
public class InformationService {
    private final WeatherService weatherService;
    private final FactService factService;

    public InformationService(WeatherService weatherService, FactService factService) {
        this.weatherService = weatherService;
        this.factService = factService;
    }

    public ConsumerInformation retrieveConsumerInformation(String zipCode) {
        WeatherData weatherData = weatherService.retrieveWeather(zipCode);
        String fact = factService.retrieveFact();

        return ConsumerInformation.builder()
                .weatherData(weatherData)
                .fact(fact)
                .build();
    }
}
