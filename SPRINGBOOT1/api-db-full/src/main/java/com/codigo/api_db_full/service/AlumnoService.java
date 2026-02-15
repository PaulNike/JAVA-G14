package com.codigo.api_db_full.service;

import com.codigo.api_db_full.dto.AlumnoCreateRequest;
import com.codigo.api_db_full.model.Alumno;
import com.codigo.api_db_full.model.PerfilAlumno;
import com.codigo.api_db_full.repository.AlumnoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlumnoService {
    private final AlumnoRepository alumnoRepo;

    public AlumnoService(AlumnoRepository alumnoRepo) {
        this.alumnoRepo = alumnoRepo;
    }

    @Transactional
    public Alumno crearConPerfil(AlumnoCreateRequest req) {
        Alumno a = new Alumno();
        a.setNombre(req.nombre());
        a.setEmail(req.email());

        PerfilAlumno p = new PerfilAlumno();
        p.setTelefono(req.telefono());
        p.setDireccion(req.direccion());

        a.setPerfil(p);

        return alumnoRepo.save(a);
    }

    public Alumno obtener(Long id){
        return alumnoRepo.findById(id).orElseThrow();
    }
}
