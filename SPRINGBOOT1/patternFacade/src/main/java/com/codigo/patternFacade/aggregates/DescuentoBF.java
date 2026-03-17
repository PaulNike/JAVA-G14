package com.codigo.patternFacade.aggregates;


public class DescuentoBF implements DescuentoStrategy{
    @Override
    public double aplicarDescuento(double monto) {
        return monto * 0.70;
    }
}
