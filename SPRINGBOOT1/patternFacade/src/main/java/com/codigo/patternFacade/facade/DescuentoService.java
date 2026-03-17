package com.codigo.patternFacade.facade;

import org.springframework.stereotype.Service;

@Service
public class DescuentoService {

    public double aplicar(double monto){
        return monto * 0.10;
        //1000 10% = 100
    }
}
