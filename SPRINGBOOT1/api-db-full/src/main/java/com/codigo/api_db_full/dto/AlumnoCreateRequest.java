package com.codigo.api_db_full.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record AlumnoCreateRequest(@NotBlank @Size(min = 2, max = 120) String nombre,
                                  @NotBlank @Email String email,
                                  @NotBlank @Pattern(regexp = "^[0-9]{9}$") String telefono,
                                  @NotBlank @Size(min = 5, max = 120) String direccion) {
}
