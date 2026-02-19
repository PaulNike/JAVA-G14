package com.codigo.apis_externas.mapper;

import com.codigo.apis_externas.dto.ReniecDniResponse;
import com.codigo.apis_externas.model.ReniecPerson;

public class ReniecMapper {

    public static ReniecPerson toEntity(ReniecDniResponse dto){
        ReniecPerson person = new ReniecPerson();
        person.setDocumentNumber(dto.document_number());
        person.setFullName(dto.full_name());
        person.setFirstName(dto.first_name());
        person.setFirstLastName(dto.first_last_name());
        person.setSecondLastName(dto.second_last_name());
        return person;
    }
}
