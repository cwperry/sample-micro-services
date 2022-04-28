package com.ninjaone.weatherservice.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;

@Value
@Builder
@Jacksonized
public class Coordinates {

    @JsonProperty("lon")
    BigDecimal longitude;

    @JsonProperty("lat")
    BigDecimal latitude;
}
