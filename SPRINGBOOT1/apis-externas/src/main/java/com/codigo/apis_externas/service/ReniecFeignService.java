package com.codigo.apis_externas.service;

import com.codigo.apis_externas.clients.DecoletaReniecFeignClient;
import com.codigo.apis_externas.dto.ReniecDniResponse;
import com.codigo.apis_externas.mapper.ReniecMapper;
import com.codigo.apis_externas.model.ReniecPerson;
import com.codigo.apis_externas.repository.ReniecPersonRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReniecFeignService {

    private final DecoletaReniecFeignClient feignClient;
    private final ReniecPersonRepository personRepository;

    @Value("${decoleta.token}")
    private String token;

    public ReniecFeignService(DecoletaReniecFeignClient feignClient, ReniecPersonRepository personRepository) {
        this.feignClient = feignClient;
        this.personRepository = personRepository;
    }
    @Transactional
    public ReniecPerson consultarYGuardar(String dni){
        return personRepository.findByDocumentNumber(dni)
                .orElseGet(() -> {
                    String auth = "Bearer "+ token;
                    ReniecDniResponse dto = feignClient.consultarDni(dni,auth);
                    ReniecPerson entity = ReniecMapper.toEntity(dto);
                    return personRepository.save(entity);
                });
    }
}
