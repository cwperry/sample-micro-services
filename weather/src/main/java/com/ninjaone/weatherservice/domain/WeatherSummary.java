package com.ninjaone.weatherservice.domain;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class WeatherSummary {
    Integer id;
    String main;
    String description;
    String icon;
}
