package com.ninjaone.factservice.services;

import com.ninjaone.factservice.domain.Fact;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;

import java.util.List;
import java.util.Objects;

@Service
public class FactService {
    private final RestOperations restOperations;
    private final String url;
    private final String apiKey;

    public FactService(RestOperations restOperations,
                       @Value("${weather.api.url}") String url,
                       @Value("${weather.api.key}") String apiKey) {
        this.restOperations = restOperations;
        this.url = url;
        this.apiKey = apiKey;
    }

    public Fact retrieveFact() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Api-Key", apiKey);

        HttpEntity<List<Fact>> request = new HttpEntity<>(headers);

        List<Fact> facts = restOperations.exchange(
                url,
                HttpMethod.GET,
                request,
                new ParameterizedTypeReference<List<Fact>>() {
                }).getBody();
        return Objects.requireNonNull(facts).stream().findFirst().orElse(null);
    }
}
