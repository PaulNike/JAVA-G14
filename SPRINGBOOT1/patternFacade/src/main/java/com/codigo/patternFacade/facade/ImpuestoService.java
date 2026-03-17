package com.codigo.patternFacade.facade;

import org.springframework.stereotype.Service;

@Service
public class ImpuestoService {

    public double calcular(double monto){
        return monto * 0.18;
        //1000 18% = 180
    }
}
