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
    @Test
    void testRestaHappyPath(){
        //arrange
        int a = 10;
        int b = 5;

        //act
        int resultado = service.restar(a,b);

        //assert
        assertEquals(5,resultado, "El valor obtenido "
                + resultado + " no es igual al esperado");
    }
    @Test
    void testDividirHappyPath(){
        //arrange
        int a = 10;
        int b = 2;

        //act
        int resultado = service.dividir(a,b);

        //assert
        assertEquals(5,resultado, "El valor obtenido "
                + resultado + " no es igual al esperado");

    }
    @Test
    void testDividirErrorTesting(){
        //arrange
        int a = 10;
        int b = 0;

        //act + assert
        assertThrows(ArithmeticException.class,
                () -> service.dividir(a,b));

    }
    @Test
    void testEsParHappyPath() {
        // ARRANGE
        int numero = 4;

        // ACT
        boolean resultado = service.esPar(numero);

        // ASSERT
        assertTrue(resultado);
    }

    @Test
    void testEsParErrorTesting() {
        // ARRANGE
        int numero = 5;

        // ACT
        boolean resultado = service.esPar(numero);

        // ASSERT
        assertFalse(resultado);
    }

    @Test
    void testEstaEnRangoHappyPath() {
        // ARRANGE
        int valor = 5;
        int min = 1;
        int max = 10;

        // ACT
        boolean resultado = service.estaEnRango(valor, min, max);

        // ASSERT
        assertTrue(resultado);
    }

    @Test
    void testEstaEnRangoErrorTesting() {
        // ARRANGE
        int valor = 5;
        int min = 1;
        int max = 4;

        // ACT
        boolean resultado = service.estaEnRango(valor, min, max);

        // ASSERT
        assertFalse(resultado);
    }
    @Test
    void testEstaEnRangoMinErrorTesting() {
        // ARRANGE
        int valor = 0;
        int min = 1;
        int max = 4;

        // ACT
        boolean resultado = service.estaEnRango(valor, min, max);

        // ASSERT
        assertFalse(resultado);
    }

    @Test
    void testObtenerNombreHappyPath() {
        // ARRANGE
        String nombre = "paul";

        // ACT
        String resultado = service.obtenerNombre(nombre);

        // ASSERT
        assertEquals("PAUL", resultado);
    }

    @Test
    void testObtenerNombreErrorTesting() {
        // ARRANGE
        String nombre = "paul";

        // ACT
        String resultado = service.obtenerNombre(nombre);

        // ASSERT
        assertNotEquals("Paul", resultado);
    }

    @Test
    void testMostrarResultadoHappyPath() {
        // ARRANGE
        int valor = 10;

        // ACT + ASSERT (para void, es normal usar assertDoesNotThrow como verificación)
        assertDoesNotThrow(() -> service.mostrarResultado(valor));
    }

}