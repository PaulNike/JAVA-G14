package com.codigo.apis_externas.clients;

import com.codigo.apis_externas.dto.ReniecDniResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "decoletaReniecClient", url = "${decoleta.base-url}")
public interface DecoletaReniecFeignClient {

    @GetMapping("/v1/reniec/dni")
    ReniecDniResponse consultarDni(@RequestParam("numero") String numero,
                                   @RequestHeader("Authorization")String authorization);

}
