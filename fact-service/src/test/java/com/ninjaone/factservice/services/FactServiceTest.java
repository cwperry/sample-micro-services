package com.ninjaone.factservice.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Resources;
import com.ninjaone.factservice.domain.Fact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestOperations;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FactServiceTest {

    @Mock
    private RestOperations restOperations;

    private FactService factService;

    @BeforeEach
    public void beforeEach() {
        factService = new FactService(restOperations, "http://localhost/fact", "api-key");
    }

    @Test
    public void retrieveFact() throws IOException {
        URL resource = Resources.getResource("samples/facts.json");
        String json = Resources.toString(resource, Charset.defaultCharset());

        ObjectMapper objectMapper = new ObjectMapper();
        List<Fact> facts = objectMapper.readValue(json, new TypeReference<>() {});

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Api-Key", "api-key");
        HttpEntity<Fact> request = new HttpEntity<>(headers);

        when(restOperations.exchange(
                "http://localhost/fact",
                HttpMethod.GET,
                request,
                new ParameterizedTypeReference<List<Fact>>(){}))
                .thenReturn(ResponseEntity.ok(facts));

        assertThat(factService.retrieveFact()).isEqualTo(facts.get(0).getFact());
    }

}