package com.ninjaone.weatherservice.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;

@Value
@Builder
@Jacksonized
public class CurrentConditions {

    @JsonProperty("temp")
    BigDecimal temperature;

    @JsonProperty("feels_like")
    BigDecimal feelsLike;

    @JsonProperty("temp_min")
    BigDecimal lowTemperature;

    @JsonProperty("temp_max")
    BigDecimal highTemperature;

    Integer pressure;

    Integer humidity;

}
