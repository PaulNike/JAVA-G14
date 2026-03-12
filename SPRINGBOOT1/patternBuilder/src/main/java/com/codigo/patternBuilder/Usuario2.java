package com.codigo.patternBuilder;

import lombok.*;

@Getter
@Builder
@ToString
public class Usuario2 {
    @NonNull
    private String nombre;
    @NonNull
    private String apellido;

    private Integer edad;
    @NonNull
    private String email;
    private String ciudad;
    private boolean activo;
    private String rol;

    //DTO + Lombok (@GETTER, @SETTER, @DATA) + VALIDATION

}
