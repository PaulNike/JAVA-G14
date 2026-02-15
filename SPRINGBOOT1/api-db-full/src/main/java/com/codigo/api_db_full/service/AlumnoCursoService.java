package com.codigo.api_db_full.service;

import com.codigo.api_db_full.model.Alumno;
import com.codigo.api_db_full.model.Curso;
import com.codigo.api_db_full.repository.AlumnoRepository;
import com.codigo.api_db_full.repository.CursoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlumnoCursoService {

    private final AlumnoRepository alumnoRepo;
    private final CursoRepository cursoRepo;

    public AlumnoCursoService(AlumnoRepository alumnoRepo, CursoRepository cursoRepo) {
        this.alumnoRepo = alumnoRepo;
        this.cursoRepo = cursoRepo;
    }

    @Transactional
    public Alumno agregarCurso(Long alumnoId, Long cursoId) {
        Alumno a = alumnoRepo.findById(alumnoId).orElseThrow();
        Curso c = cursoRepo.findById(cursoId).orElseThrow();

        a.addCurso(c); // sincroniza ambos lados
        return a;
    }
}
