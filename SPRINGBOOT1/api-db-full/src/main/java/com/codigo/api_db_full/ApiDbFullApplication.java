package com.codigo.api_db_full;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@SpringBootApplication
public class ApiDbFullApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiDbFullApplication.class, args);
	}

	/*public void leerarchivo() throws IOException{

			Files.readAllLines(Path.of("datos.txt"));

	}

	public int dividir(int a, int b){ // dividir entre 0
		return a/b;
	}

	public void setEdad(int edad){
		if(edad < 0){
			throw new IllegalArgumentException("Edad invalida");
		}
	}*/
}
