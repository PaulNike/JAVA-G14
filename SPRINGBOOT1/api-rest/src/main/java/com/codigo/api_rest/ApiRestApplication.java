package com.codigo.api_rest;

import com.codigo.api_rest.model.Alumno;
import com.codigo.api_rest.repository.AlumnoInMemoryRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class ApiRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestApplication.class, args);
		}
}
