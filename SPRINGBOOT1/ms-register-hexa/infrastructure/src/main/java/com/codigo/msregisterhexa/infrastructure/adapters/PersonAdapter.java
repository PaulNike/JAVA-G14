package com.codigo.msregisterhexa.infrastructure.adapters;

import com.codigo.msregisterhexa.domain.aggregates.DTO.PersonDTO;
import com.codigo.msregisterhexa.domain.ports.out.PersonServiceOut;
import com.codigo.msregisterhexa.infrastructure.entity.PersonEntity;
import com.codigo.msregisterhexa.infrastructure.repository.PersonRepository;
import com.codigo.msregisterhexa.infrastructure.response.ResponseReniec;
import com.codigo.msregisterhexa.infrastructure.rest.ReniecClient;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

@Service
@Log4j2
public class PersonAdapter implements PersonServiceOut {

    private final ReniecClient reniecClient;
    private final ModelMapper personMapper;
    private final ModelMapper reniecMapper;
    private final PersonRepository personRepository;

    @Value("${token.api}")
    private String token;
    public PersonAdapter(ReniecClient reniecClient,
                         @Qualifier("defaultMapper") ModelMapper personMapper,
                         @Qualifier("reniecMapper") ModelMapper reniecMapper,
                         PersonRepository personRepository) {
        this.reniecClient = reniecClient;
        this.personMapper = personMapper;
        this.reniecMapper = reniecMapper;
        this.personRepository = personRepository;
    }


    @Override
    public PersonDTO createPersonOut(String dni) {
        return mapToPersonDTO(personRepository.save(getEntityForSave(dni)));
    }

    private ResponseReniec executeReniec(String dni){
        log.info("Consultando los datos a RENIEC para el DNI: {}", dni);
        String header = "Bearer "+token;
        return Optional.ofNullable(reniecClient.consultarDni(dni,header))
                .orElseThrow(() -> new RuntimeException("Error al consutla con Reniec"));
    }

    private PersonEntity getEntityForSave(String dni) {
        log.info("{} - {} INICIO, getEntityForSave to: ", dni);
        ResponseReniec responseReniec = executeReniec(dni);

        if (responseReniec == null ||
                responseReniec.getDocument_number() == null) {
            throw new RuntimeException("Respuesta invalida de RENIEC: " + dni);
        }
        PersonEntity person = mapReniecToPersonEntity(responseReniec);
        person.setDateCreate(new Timestamp(System.currentTimeMillis()));
        person.setStatus(1);
        person.setUserCreate("PRODRIGUEZ");
        person.setTypeDoc("DNI");
        log.info("{} - {} FIN, getEntityForSave to: ", dni);
        return person;
    }

    private PersonEntity mapReniecToPersonEntity(ResponseReniec responseReniec) {
        return reniecMapper.map(responseReniec, PersonEntity.class);
    }

    private PersonDTO mapToPersonDTO(PersonEntity person){
        return personMapper.map(person, PersonDTO.class);
    }

}
