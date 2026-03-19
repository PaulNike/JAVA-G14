package com.codigo.msregisterhexa.domain.ports.in;

import com.codigo.msregisterhexa.domain.aggregates.DTO.PersonDTO;

public interface PersonServiceIn {
    PersonDTO createPersonIn(String dni);
}
