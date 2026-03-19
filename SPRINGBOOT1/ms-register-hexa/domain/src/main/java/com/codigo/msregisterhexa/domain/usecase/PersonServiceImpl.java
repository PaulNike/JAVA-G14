package com.codigo.msregisterhexa.domain.usecase;

import com.codigo.msregisterhexa.domain.aggregates.DTO.PersonDTO;
import com.codigo.msregisterhexa.domain.ports.in.PersonServiceIn;
import com.codigo.msregisterhexa.domain.ports.out.PersonServiceOut;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
//@Log4j2
public class PersonServiceImpl implements PersonServiceIn {

    private final PersonServiceOut serviceOut;

    private String SERVICE_NAME = "PersonServiceImpl";
    @Override
    public PersonDTO createPersonIn(String dni) {
        String nameMethod ="createPersonIn";
        //log.info("{} - {} - INICIO", SERVICE_NAME, nameMethod);
        PersonDTO personDTO = serviceOut.createPersonOut(dni);
        //log.info("{} - {} - FIN", SERVICE_NAME, nameMethod);
        return personDTO;
    }
}
