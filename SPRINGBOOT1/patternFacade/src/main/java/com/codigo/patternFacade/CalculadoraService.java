package com.codigo.patternFacade;

import com.codigo.patternFacade.aggregates.*;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {


    public double calcular(String tipo, double monto){
        DescuentoStrategy strategy;
        if(tipo.equalsIgnoreCase("normal")){
            strategy = new DescuentoNormal();
        }else if (tipo.equalsIgnoreCase("VIP")){
            strategy = new DescuentoClienteVip();
        } else if (tipo.equalsIgnoreCase("promo")) {
            strategy = new DescuentoPromocion();
        }else {
            strategy = new DescuentoBF();
        }

        CalculadoraPrecio calculadoraPrecio = new CalculadoraPrecio(strategy);
        return calculadoraPrecio.calcular(monto);
    }

}
