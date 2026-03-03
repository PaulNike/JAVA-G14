package com.codigo.apis_externas.service;

import com.codigo.apis_externas.dto.ReniecDniResponse;
import com.codigo.apis_externas.mapper.ReniecMapper;
import com.codigo.apis_externas.model.ReniecPerson;
import com.codigo.apis_externas.repository.ReniecPersonRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClient;

@Service
public class ReniecRestClientService {

    private final RestClient restClient;
    private final ReniecPersonRepository repo;

    @Value("${decoleta.base-url}")
    private String baseUrl;

    @Value("${decoleta.token}")
    private String token;

    public ReniecRestClientService(RestClient restClient, ReniecPersonRepository repo) {
        this.restClient = restClient;
        this.repo = repo;
    }

    @Transactional
    public ReniecPerson consultaryGuardar(String dni){
        return repo.findByDocumentNumber(dni)
                .orElseGet(() -> {
                    ReniecDniResponse dto = restClient.get()
                            .uri(baseUrl+"/v1/reniec/dni?numero={dni}",dni)
                            .accept(MediaType.APPLICATION_JSON)
                            .header("Authorization", "Bearer " + token)
                            .retrieve()
                            .body(ReniecDniResponse.class);

                    if(dto == null) throw new IllegalStateException("Respues vacia de Rneic");

                    ReniecPerson person = ReniecMapper.toEntity(dto);
                    return repo.save(person);
                });
    }
}
