package com.codigo.patternSingleton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PatternSingletonApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatternSingletonApplication.class, args);

		ConfiguracionGlobal config1 = ConfiguracionGlobal.getINSTANCE();
		ConfiguracionGlobal config2 = ConfiguracionGlobal.getINSTANCE();

		config1.setAmbiente("PROD");

		System.out.println(config1.getAmbiente());
		System.out.println(config2.getAmbiente());
		System.out.println(config1 == config2);


	}

}
