package com.ninjaone.informationservice.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Resources;
import com.ninjaone.informationservice.domain.ConsumerInformation;
import com.ninjaone.informationservice.services.InformationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.net.URL;
import java.nio.charset.Charset;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(InformationServiceController.class)
class InformationServiceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InformationService informationService;

    @Test
    public void shouldReturnConsumerInformation() throws Exception {
        URL resource = Resources.getResource("samples/consumer-information.json");
        String json = Resources.toString(resource, Charset.defaultCharset());

        ObjectMapper objectMapper = new ObjectMapper();
        ConsumerInformation consumerInformation = objectMapper.readValue(json, ConsumerInformation.class);

        when(informationService.retrieveConsumerInformation("75023")).thenReturn(consumerInformation);

        mockMvc.perform(
                        get("/info?zip=75023"))
                .andExpect(status().isOk())
                .andExpect(content().json(json));
    }
}