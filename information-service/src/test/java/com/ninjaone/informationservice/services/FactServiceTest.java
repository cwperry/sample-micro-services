package com.ninjaone.informationservice.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestOperations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FactServiceTest {

    @Mock
    private RestOperations restOperations;

    private FactService factService;

    @BeforeEach
    public void beforeEach() {
        factService = new FactService(restOperations);
    }

    @Test
    public void retrieveFact() {
        when(restOperations.getForEntity("http://fact-service/fact", String.class))
                .thenReturn(ResponseEntity.ok("a fact"));

        assertThat(factService.retrieveFact()).isEqualTo("a fact");
    }

}