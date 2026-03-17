package com.codigo.patternFacade.facade;

import org.springframework.stereotype.Service;

@Service
public class PrecioFacade {
    private final DescuentoService descuentoService;
    private final ImpuestoService impuestoService;
    private final EnvioService envioService;

    public PrecioFacade(DescuentoService descuentoService, ImpuestoService impuestoService, EnvioService envioService) {
        this.descuentoService = descuentoService;
        this.impuestoService = impuestoService;
        this.envioService = envioService;
    }

    public double calcularPreciFinal(double monto){
        double descuento = descuentoService.aplicar(monto);
        double impuesto = impuestoService.calcular(monto);
        double envio = envioService.calcular();

        return monto - descuento + impuesto + envio;
    }

}
