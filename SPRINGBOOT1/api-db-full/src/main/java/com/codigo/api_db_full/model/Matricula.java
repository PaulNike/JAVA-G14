package com.codigo.api_db_full.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "matricula")
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fecha = LocalDate.now();
    //ManyToOne -> muchas matrivculas pertenecen a un alumno
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "alumno_id", nullable = false)
    private Alumno alumno;
    //ManyToOne Muchas matriculas pertenecen a un curso
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id",nullable = false)
    private Curso curso;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
