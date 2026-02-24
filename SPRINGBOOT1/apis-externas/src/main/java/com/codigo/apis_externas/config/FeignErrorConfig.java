package com.codigo.apis_externas.config;

import com.codigo.apis_externas.clients.DecoletaErrorDecode;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tools.jackson.databind.ObjectMapper;

@Configuration
public class FeignErrorConfig {
    @Bean
    ErrorDecoder errorDecoder(ObjectMapper objectMapper){
        return new DecoletaErrorDecode(objectMapper);
    }
}
