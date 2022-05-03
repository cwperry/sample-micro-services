package com.ninjaone.factservice.controllers;

import com.ninjaone.factservice.domain.Fact;
import com.ninjaone.factservice.services.FactService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FactController {

    private final FactService factService;

    public FactController(FactService factService) {
        this.factService = factService;
    }

    @GetMapping("/fact")
    @ResponseBody
    public ResponseEntity<String> retrieveWeather() {
        return ResponseEntity.ok(factService.retrieveFact());
    }
}
