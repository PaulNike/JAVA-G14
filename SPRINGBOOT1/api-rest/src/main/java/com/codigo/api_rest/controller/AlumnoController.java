package com.codigo.api_rest.controller;

import com.codigo.api_rest.dto.AlumnoCreateRequest;
import com.codigo.api_rest.dto.AlumnoResponse;
import com.codigo.api_rest.service.AlumnoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/alumnos")
public class AlumnoController {

    private final AlumnoService service;

    public AlumnoController(AlumnoService service) {
        this.service = service;
    }


    @GetMapping
    public List<AlumnoResponse> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public AlumnoResponse obtener(@PathVariable UUID id) {
        return service.obtener(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AlumnoResponse crear(@Valid @RequestBody AlumnoCreateRequest request) {
        return service.crear(request);
    }

}
