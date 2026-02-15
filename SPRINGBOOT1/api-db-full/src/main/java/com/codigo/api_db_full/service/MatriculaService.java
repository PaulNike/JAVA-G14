package com.codigo.api_db_full.service;

import com.codigo.api_db_full.dto.MatriculaCreateRequest;
import com.codigo.api_db_full.model.Alumno;
import com.codigo.api_db_full.model.Curso;
import com.codigo.api_db_full.model.Matricula;
import com.codigo.api_db_full.repository.AlumnoRepository;
import com.codigo.api_db_full.repository.CursoRepository;
import com.codigo.api_db_full.repository.MatriculaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MatriculaService {

    private final AlumnoRepository alumnoRepo;
    private final CursoRepository cursoRepo;
    private final MatriculaRepository matriculaRepo;

    public MatriculaService(AlumnoRepository alumnoRepo, CursoRepository cursoRepo, MatriculaRepository matriculaRepo) {
        this.alumnoRepo = alumnoRepo;
        this.cursoRepo = cursoRepo;
        this.matriculaRepo = matriculaRepo;
    }

    @Transactional
    public Matricula matricular(MatriculaCreateRequest req) {
        Alumno alumno = alumnoRepo.findById(req.alumnoId()).orElseThrow();
        Curso curso = cursoRepo.findById(req.cursoId()).orElseThrow();

        Matricula m = new Matricula();
        m.setAlumno(alumno);
        m.setCurso(curso);

        return matriculaRepo.save(m);
    }
}