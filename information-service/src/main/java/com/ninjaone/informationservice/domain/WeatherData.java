package com.ninjaone.informationservice.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;

@Value
@Builder
@Jacksonized
public class WeatherData {

    @JsonProperty("cloud_pct")
    Integer cloudPercentage;

    @JsonProperty("temp")
    Integer temperature;

    @JsonProperty("feels_like")
    Integer feelsLike;

    Integer humidity;

    @JsonProperty("min_temp")
    Integer lowTemperature;

    @JsonProperty("max_temp")
    Integer highTemperature;

    @JsonProperty("wind_speed")
    BigDecimal windSpeed;

    @JsonProperty("wind_degrees")
    Integer windDegrees;

    Integer sunrise;

    Integer sunset;

    @JsonProperty("wind_direction")
    public String windDirection;

}
