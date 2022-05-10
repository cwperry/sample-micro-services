package com.ninjaone.informationservice.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class ConsumerInformation {

    @JsonProperty("weather-data")
    WeatherData weatherData;

    String fact;
}
