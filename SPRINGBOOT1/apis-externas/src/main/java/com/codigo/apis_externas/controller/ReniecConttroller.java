package com.codigo.apis_externas.controller;

import com.codigo.apis_externas.clients.MockSlowClient;
import com.codigo.apis_externas.model.ReniecPerson;
import com.codigo.apis_externas.service.ReniecFeignService;
import com.codigo.apis_externas.service.ReniecRestClientService;
import com.codigo.apis_externas.service.ReniecRestTemplateService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Valid
@RestController
@RequestMapping("/api/reniec")
public class ReniecConttroller {

    private final ReniecFeignService reniecFeignService;
    private final MockSlowClient mockSlowClient;
    private final ReniecRestClientService restClientservice;
    private final ReniecRestTemplateService templateService;

    public ReniecConttroller(ReniecFeignService reniecFeignService, MockSlowClient mockSlowClient, ReniecRestClientService restClientservice, ReniecRestTemplateService templateService) {
        this.reniecFeignService = reniecFeignService;
        this.mockSlowClient = mockSlowClient;
        this.restClientservice = restClientservice;
        this.templateService = templateService;
    }

    @GetMapping("/feign/{dni}")
    public ReniecPerson feign(@PathVariable @Pattern(regexp = "\\d{8}") String dni){
        return reniecFeignService.consultarYGuardar(dni);
    }
    @GetMapping("/restClient/{dni}")
    public ReniecPerson restClient(@PathVariable @Pattern(regexp = "\\d{8}") String dni){
        return restClientservice.consultaryGuardar(dni);
    }
    @GetMapping("/restTemplate/{dni}")
    public ReniecPerson restTemplate(@PathVariable @Pattern(regexp = "\\d{8}") String dni){
        return templateService.consultaryGuardar(dni);
    }

    @GetMapping("/mock/slow")
    public Map<String,Object> slow(@RequestParam(defaultValue = "8000")
                                   long ms) throws InterruptedException{
        if(ms < 0 || ms > 20000){
            ms = 8000;
        }
        Thread.sleep(ms);
        return Map.of("Message:", "Mock ok",
                "Tiempo: ", ms);
    }

    @GetMapping("/feign/slow")
    public Map<String,Object> feignTimeOut(@RequestParam(defaultValue = "8000")
                                   long ms){
            return mockSlowClient.slow(ms);
    }

    //@Pattern(regexp = "\\d{8}")
}
