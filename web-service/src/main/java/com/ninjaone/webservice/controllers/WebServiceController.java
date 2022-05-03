package com.ninjaone.webservice.controllers;

import com.ninjaone.webservice.domain.ConsumerInformation;
import com.ninjaone.webservice.services.InformationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class WebServiceController {

    private final InformationService informationService;

    public WebServiceController(InformationService informationService) {
        this.informationService = informationService;
    }

    @GetMapping("/info")
    @ResponseBody
    public ResponseEntity<ConsumerInformation> retrieveConsumerInformation(@RequestParam("zip") String zipCode) {
        return ResponseEntity.ok(informationService.retrieveConsumerInformation(zipCode));
    }
}
