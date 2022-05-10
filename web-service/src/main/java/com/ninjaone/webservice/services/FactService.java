package com.ninjaone.webservice.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;

@Service
public class FactService {
    private final RestOperations restOperations;

    public FactService(RestOperations restOperations) {
        this.restOperations = restOperations;
    }

    public String retrieveFact() {
        return restOperations.getForEntity("http://fact-service/fact", String.class).getBody();
    }
}
