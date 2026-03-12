package com.codigo.patternBuilder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PatternBuilderApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatternBuilderApplication.class, args);
		Usuario usuario = Usuario.builder()
				.nombre("Paul")
				.apellido("Rodrige")
				.edad(29)
				.email("nike_1109@outlook.es")
				.ciudad("Lima")
				.activo(true)
				.rol("ADMIN")
				.build();

		System.out.println("USUARIO: " + usuario.getNombre() + " " + usuario.getApellido());
		System.out.println("ROL: " + usuario.getRol());
		//========================================================

		Usuario2 usuario2 = Usuario2.builder()
				.nombre("Nike")
				.apellido("")
				.email("nike_1109@outlook.es")
				.build();

		//aqui recien podria validarlo
		System.out.println(usuario2);
	}


}
