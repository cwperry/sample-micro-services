package com.ninjaone.weatherservice.domain;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class WeatherSystem {
    Integer type;
    Integer id;
    String country;
    Integer sunrise;
    Integer sunset;
}
