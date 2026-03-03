package com.codigo.apis_externas.service;

import com.codigo.apis_externas.dto.ReniecDniResponse;
import com.codigo.apis_externas.mapper.ReniecMapper;
import com.codigo.apis_externas.model.ReniecPerson;
import com.codigo.apis_externas.repository.ReniecPersonRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ReniecRestTemplateService {

    private final RestTemplate restTemplate;
    private final ReniecPersonRepository repo;

    @Value("${decoleta.base-url}")
    private String baseUrl;

    @Value("${decoleta.token}")
    private String token;

    public ReniecRestTemplateService(RestTemplate restTemplate, ReniecPersonRepository repo) {
        this.restTemplate = restTemplate;
        this.repo = repo;
    }

    @Transactional
    public ReniecPerson consultaryGuardar(String dni){
        return repo.findByDocumentNumber(dni)
                .orElseGet(() -> {
                    String url = UriComponentsBuilder
                            .fromUriString(baseUrl+"/v1/reniec/dni")
                            .queryParam("numero",dni)
                            .toUriString();

                    HttpHeaders header = new HttpHeaders();
                    header.setBearerAuth(token);

                    ResponseEntity<ReniecDniResponse> response  =
                            restTemplate.exchange(url,HttpMethod.GET,
                                    new HttpEntity<>(header),
                                    ReniecDniResponse.class);

                    ReniecDniResponse dto =  response.getBody();
                    if (dto == null) throw new IllegalStateException("Respuesta vacia del rpoveedor");

                    ReniecPerson person = ReniecMapper.toEntity(dto);
                    return repo.save(person);

                });
    }
}
