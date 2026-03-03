package com.codigo.apis_externas.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(
        name = "mockClient",
        url = "${mock.base-url}"
)
public interface MockSlowClient {
    @GetMapping("/api/reniec/mock/slow")
    Map<String, Object>slow(@RequestParam("ms") long ms);
}
