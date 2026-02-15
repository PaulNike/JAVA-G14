package com.codigo.api_db_full.controller;


import com.codigo.api_db_full.model.Alumno;
import com.codigo.api_db_full.service.AlumnoCursoService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alumnos")
public class AlumnoCursoController {

    private final AlumnoCursoService service;

    public AlumnoCursoController(AlumnoCursoService service) {
        this.service = service;
    }

    @PostMapping("/{alumnoId}/cursos/{cursoId}")
    public Alumno agregarCurso(@PathVariable Long alumnoId, @PathVariable Long cursoId) {
        return service.agregarCurso(alumnoId, cursoId);
    }
}