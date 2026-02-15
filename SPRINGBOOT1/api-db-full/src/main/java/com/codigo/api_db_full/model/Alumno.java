package com.codigo.api_db_full.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "alumno")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Nombre es obligatorio")
    @Size(min = 2, max = 120)
    @Column(nullable = false)
    private String nombre;
    @NotBlank(message = "Email es obligatorio")
    @Email(message = "email invalido")
    @Column(nullable = false, unique = true)
    private String email;
    @JsonManagedReference
    @OneToOne(
            mappedBy = "alumno",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    private PerfilAlumno perfil;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "alumno_curso",  //NOMBRE DE LA TABLA
            joinColumns = @JoinColumn(name = "alumno_id"),  // FK HACIA ALUMNO
            inverseJoinColumns = @JoinColumn(name = "curso_id") // FK HACIA CURSO
    )
    private Set<Curso> cursos = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Matricula> matriculas = new HashSet<>();
    public void addCurso(Curso c) {
        this.cursos.add(c);
        c.getAlumnos().add(this);
    }

    public void removeCurso(Curso c) {
        this.cursos.remove(c);
        c.getAlumnos().remove(this);
    }

    public void addMatricula(Matricula m) {
        matriculas.add(m);
        m.setAlumno(this);
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PerfilAlumno getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilAlumno perfil) {
        this.perfil = perfil;
        if (perfil != null) perfil.setAlumno(this);
    }


    public Set<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }

}
