package com.codigo.patternFacade.aggregates;

import org.springframework.stereotype.Service;

public class DescuentoClienteVip implements DescuentoStrategy{
    @Override
    public double aplicarDescuento(double monto) {
        return monto * 0.90;
    }
}
