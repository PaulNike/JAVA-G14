package com.codigo.patternFacade;

import com.codigo.patternFacade.aggregates.DescuentoStrategy;
import org.springframework.stereotype.Service;

public class CalculadoraPrecio {

    private DescuentoStrategy descuentoStrategy;
    //CONSTRUCTOR
    public CalculadoraPrecio(DescuentoStrategy descuentoStrategy) {
        this.descuentoStrategy = descuentoStrategy;
    }
    //METODO CALCULAR, PERO QUE NO CONOCE LA IMPLEMENTACION QUE USARA (STRATEGIA)
    public double calcular(double monto){
        return descuentoStrategy.aplicarDescuento(monto);
    }
    //mETODO SET PARA CAMBIAR DE ESTRATEGIA DE MANERA DINAMICA EN TIEMPO DE EJECUCIÓN.
    public void setDescuentoStrategy(DescuentoStrategy descuentoStrategy) {
        this.descuentoStrategy = descuentoStrategy;
    }
}
