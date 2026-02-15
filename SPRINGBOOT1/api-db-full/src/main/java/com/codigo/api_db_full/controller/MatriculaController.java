package com.codigo.api_db_full.controller;

import com.codigo.api_db_full.dto.MatriculaCreateRequest;
import com.codigo.api_db_full.model.Matricula;
import com.codigo.api_db_full.service.MatriculaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    private final MatriculaService service;

    public MatriculaController(MatriculaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Matricula> crear(@RequestBody MatriculaCreateRequest req) {
        return ResponseEntity.status(201).body(service.matricular(req));
    }
}