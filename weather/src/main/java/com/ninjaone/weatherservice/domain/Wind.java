package com.ninjaone.weatherservice.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;

@Value
@Builder
@Jacksonized
public class Wind {

    BigDecimal speed;

    @JsonProperty("deg")
    Integer bearing;

    BigDecimal gust;

    public String description() {
        if (bearing >= 23 && bearing < 68) {
            return "North East";
        } else if (bearing >= 68 && bearing < 113) {
            return "East";
        } else if (bearing >= 113 && bearing < 158) {
            return "South East";
        } else if (bearing >= 158 && bearing < 203) {
            return "South";
        } else if (bearing >= 203 && bearing < 248) {
            return "South West";
        } else if (bearing >= 248 && bearing < 293) {
            return "West";
        } else if (bearing >= 293 && bearing < 338) {
            return "West";
        } else {
            return "North";
        }
    }
}
