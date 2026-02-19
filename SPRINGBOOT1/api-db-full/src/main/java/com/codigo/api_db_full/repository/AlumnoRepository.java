package com.codigo.api_db_full.repository;

import com.codigo.api_db_full.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno,Long> {

    boolean existsByEmail(String email);
    boolean existsByTelefono(String telefono);
}
