package com.codigo.api_db_full.controller;

import com.codigo.api_db_full.model.Curso;
import com.codigo.api_db_full.repository.CursoRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    private final CursoRepository repo;

    public CursoController(CursoRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public ResponseEntity<Curso> crear(@Valid @RequestBody Curso c) {
        return ResponseEntity.status(201).body(repo.save(c));
    }
}
