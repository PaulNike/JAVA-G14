package com.codigo.api_db_full.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "perfil_alumno")
public class PerfilAlumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Telfono es obligatorio")
    @Pattern(regexp = "^[0-9]{9}$", message = "Telefono debe teer 9 digitos")
    @Column(nullable = false)
    private String telefono;
    @NotBlank(message = "Direccion es obligatorio")
    @Size(min = 5, max = 120)
    @Column(nullable = false)
    private String direccion;

    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "alumno_id", nullable = false, unique = true)
    private Alumno alumno;

    //nombre_de_la_Tabla + id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
        if (alumno != null && alumno.getPerfil() != this) {
            alumno.setPerfil(this);
        }
    }
}
