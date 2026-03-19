package com.codigo.msregisterhexa.infrastructure.rest;

import com.codigo.msregisterhexa.infrastructure.response.ResponseReniec;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "reniecCLient",url = "https://api.decolecta.com/")
public interface ReniecClient {

    @GetMapping("/v1/reniec/dni")
    ResponseReniec consultarDni(@RequestParam("numero") String numero,
                                @RequestHeader("Authorization")String authorization);
}
