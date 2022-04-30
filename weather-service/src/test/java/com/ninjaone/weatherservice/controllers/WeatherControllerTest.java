package com.ninjaone.weatherservice.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Resources;
import com.ninjaone.weatherservice.domain.WeatherData;
import com.ninjaone.weatherservice.services.WeatherService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


import java.net.URL;
import java.nio.charset.Charset;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WeatherController.class)
class WeatherControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WeatherService weatherService;

    @Test
    public void shouldReturnWeather() throws Exception {
        URL resource = Resources.getResource("samples/plano-weather.json");
        String json = Resources.toString(resource, Charset.defaultCharset());

        ObjectMapper objectMapper = new ObjectMapper();
        WeatherData weatherData = objectMapper.readValue(json, WeatherData.class);

        when(weatherService.retrieveWeatherForZip("75023")).thenReturn(weatherData);

        mockMvc.perform(
                get("/weather/75023"))
                .andExpect(status().isOk())
                .andExpect(content().json(json));
    }

}