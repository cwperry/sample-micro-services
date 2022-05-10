package com.ninjaone.informationservice.controllers;


import com.ninjaone.informationservice.domain.ConsumerInformation;
import com.ninjaone.informationservice.services.InformationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InformationServiceController {

    private final InformationService informationService;

    public InformationServiceController(InformationService informationService) {
        this.informationService = informationService;
    }

    @GetMapping("/info")
    @ResponseBody
    public ResponseEntity<ConsumerInformation> retrieveConsumerInformation(@RequestParam("zip") String zipCode) {
        return ResponseEntity.ok(informationService.retrieveConsumerInformation(zipCode));
    }
}
