package com.codigo.patternFacade.aggregates;

import org.springframework.stereotype.Service;

public class DescuentoPromocion implements DescuentoStrategy{
    @Override
    public double aplicarDescuento(double monto) {
        return monto - 50;
    }
}
