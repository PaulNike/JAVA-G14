package com.codigo.patternFacade;

import com.codigo.patternFacade.aggregates.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PatternFacadeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatternFacadeApplication.class, args);

		//Defino  una strategia que voy a utilizar
		CalculadoraPrecio calculadora = new CalculadoraPrecio(new DescuentoNormal());

		System.out.println("Precio Normal: " + calculadora.calcular(500));

		calculadora.setDescuentoStrategy(new DescuentoClienteVip());
		System.out.println("Precio VIP: " + calculadora.calcular(500));

		calculadora.setDescuentoStrategy(new DescuentoPromocion());
		System.out.println("Precio PROMO: " + calculadora.calcular(500));
		calculadora.setDescuentoStrategy(new DescuentoBF());
		System.out.println("Precio PROMO: " + calculadora.calcular(500));


		String a = new String("hola");
		String b = new String("hola");

		System.out.println(a == b);
		System.out.println(a.equals(b));


		Integer d = 127;
		Integer e = 127;
		System.out.println( d == e);

		//-128 | 127

		Integer f = 128;
		Integer g = 128;
		System.out.println( f == g);
	}

}
