package com.codigo.api_rest.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record AlumnoCreateRequest(@NotBlank String nombre,
                                  @Min(1) int edad) {
}
