package com.codigo.api_db_full.controller;

import com.codigo.api_db_full.dto.AlumnoCreateRequest;
import com.codigo.api_db_full.dto.BaseResponse;
import com.codigo.api_db_full.dto.response.AlumnoResponse;
import com.codigo.api_db_full.model.Alumno;
import com.codigo.api_db_full.service.AlumnoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {
    private final AlumnoService service;

    public AlumnoController(AlumnoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<BaseResponse<AlumnoResponse>> crear(@Valid @RequestBody AlumnoCreateRequest req) {
        Alumno alumno = service.crearConPerfil(req);

        AlumnoResponse response = new AlumnoResponse(
                alumno.getId(),
                alumno.getNombre(),
                alumno.getEmail()
        );

        return ResponseEntity.status(201).body(
                new BaseResponse<>(
                        2001,
                        "Alumno creado correctamente",
                        response
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<AlumnoResponse>> obtener(@PathVariable Long id){
        Alumno alumno = service.obtener(id);

        AlumnoResponse response = new AlumnoResponse(
                alumno.getId(),
                alumno.getNombre(),
                alumno.getEmail()
        );
        return ResponseEntity.ok(new BaseResponse<>(
                200,
                "Alumno obtenido correctamente",
                response
        ));
    }

    @GetMapping("/prueba/{id}")
    public String obtener2(@PathVariable Long id){
        Alumno alumno = service.obtener(id);
        return alumno.getNombre();
    }
}
