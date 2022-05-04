package com.ninjaone.webservice.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;

@Service
public class FactService {
    private final RestOperations restOperations;
    private final String host;
    private final int port;

    public FactService(RestOperations restOperations,
                       @Value("${fact.service.host}") String host,
                       @Value("${fact.service.port}") int port) {
        this.restOperations = restOperations;
        this.host = host;
        this.port = port;
    }

    public String retrieveFact() {
        return restOperations.getForEntity(String.format("http://%s:%d/fact", host, port), String.class).getBody();
    }
}
