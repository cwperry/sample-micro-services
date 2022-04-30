package com.ninjaone.weatherservice.domain;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;
import java.util.List;

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

    @JsonGetter("wind_direction")
    public String windDirection() {
        if (windDegrees >= 23 && windDegrees < 68) {
            return "North East";
        } else if (windDegrees >= 68 && windDegrees < 113) {
            return "East";
        } else if (windDegrees >= 113 && windDegrees < 158) {
            return "South East";
        } else if (windDegrees >= 158 && windDegrees < 203) {
            return "South";
        } else if (windDegrees >= 203 && windDegrees < 248) {
            return "South West";
        } else if (windDegrees >= 248 && windDegrees < 293) {
            return "West";
        } else if (windDegrees >= 293 && windDegrees < 338) {
            return "West";
        } else {
            return "North";
        }
    }

}

