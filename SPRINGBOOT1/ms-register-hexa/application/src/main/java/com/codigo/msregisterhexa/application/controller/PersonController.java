package com.codigo.msregisterhexa.application.controller;

import com.codigo.msregisterhexa.domain.aggregates.DTO.PersonDTO;
import com.codigo.msregisterhexa.domain.ports.in.PersonServiceIn;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/hexa/")
public class PersonController {

    private final PersonServiceIn serviceIn;

    public PersonController(PersonServiceIn serviceIn) {
        this.serviceIn = serviceIn;
    }
    @PostMapping("/save")
    public ResponseEntity<PersonDTO> createPerson(
            @RequestParam("dni") String dni){
        return ResponseEntity.ok(serviceIn.createPersonIn(dni));
    }
}
