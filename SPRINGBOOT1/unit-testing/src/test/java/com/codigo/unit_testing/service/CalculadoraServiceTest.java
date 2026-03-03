package com.codigo.unit_testing.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraServiceTest {

    private CalculadoraService service;

    @BeforeEach
    void setUp(){
        service = new CalculadoraService();
    }

    @Test
    void testSumarHappyPath(){
        //arrange
        int a = 2;
        int b = 3;

        //act
        int resultado = service.sumar(a,b);

        //assert
        assertEquals(5,resultado, "El valor obtenido "
                + resultado + " no es igual al esperado");
    }

}