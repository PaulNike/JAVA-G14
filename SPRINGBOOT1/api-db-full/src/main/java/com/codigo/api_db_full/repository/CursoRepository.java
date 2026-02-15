package com.codigo.api_db_full.repository;

import com.codigo.api_db_full.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso,Long> {
}
