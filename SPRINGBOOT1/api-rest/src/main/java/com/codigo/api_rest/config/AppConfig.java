package com.codigo.api_rest.config;

import com.codigo.api_rest.repository.AlumnoInMemoryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public AlumnoInMemoryRepository alumnoInMemoryRepository(){
        return new AlumnoInMemoryRepository();
    }
}
