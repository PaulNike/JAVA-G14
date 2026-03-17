package com.codigo.patternFacade;

import com.codigo.patternFacade.facade.PrecioFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prueba")
public class Controller {


    private final CalculadoraService calculadoraService;
    private final PrecioFacade precioFacade;


    public Controller(CalculadoraService calculadoraService, PrecioFacade precioFacade) {
        this.calculadoraService = calculadoraService;
        this.precioFacade = precioFacade;
    }

    @GetMapping()
    public double calculadoraDesc(@RequestParam String tipo,
                                  @RequestParam double monto){
        return calculadoraService.calcular(tipo,monto);
    }

    @GetMapping("/facade")
    public double calculoFacade(@RequestParam double monto){
        return precioFacade.calcularPreciFinal(monto);
    }
}
