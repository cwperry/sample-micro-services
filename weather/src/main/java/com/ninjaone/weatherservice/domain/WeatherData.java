package com.ninjaone.weatherservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Value
@Builder
@Jacksonized
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherData {

    @JsonProperty("coord")
    Coordinates coordinates;

    @JsonProperty("weather")
    List<WeatherSummary> summaries;

    String base;

    @JsonProperty("main")
    CurrentConditions currentConditions;

    Integer visibility;

    Wind wind;

    Clouds clouds;

    Integer dt;

    Integer timezone;

    Integer id;

    String name;

    Integer cod;

    @JsonProperty("sys")
    WeatherSystem weatherSystem;

}

