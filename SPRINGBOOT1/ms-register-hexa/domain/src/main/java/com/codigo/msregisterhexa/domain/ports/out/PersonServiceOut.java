package com.codigo.msregisterhexa.domain.ports.out;

import com.codigo.msregisterhexa.domain.aggregates.DTO.PersonDTO;

public interface PersonServiceOut {
    PersonDTO createPersonOut(String dni);
}
