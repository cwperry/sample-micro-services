package com.ninjaone.factservice.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Resources;
import com.ninjaone.factservice.domain.Fact;
import com.ninjaone.factservice.services.FactService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FactController.class)
class FactControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FactService factService;

    @Test
    public void shouldReturnFacts() throws Exception {
        URL resource = Resources.getResource("samples/facts.json");
        String json = Resources.toString(resource, Charset.defaultCharset());

        ObjectMapper objectMapper = new ObjectMapper();
        List<Fact> facts = objectMapper.readValue(json, new TypeReference<>() {
        });

        when(factService.retrieveFact()).thenReturn(facts.get(0));

        mockMvc.perform(
                        get("/fact"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(facts.get(0))));
    }

}