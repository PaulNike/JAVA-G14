package com.codigo.msregisterhexa.infrastructure.config;

import com.codigo.msregisterhexa.infrastructure.entity.PersonEntity;
import com.codigo.msregisterhexa.infrastructure.response.ResponseReniec;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public ModelMapper defaultMapper(){
        return new ModelMapper();
    }

    @Bean
    public ModelMapper reniecMapper(){
        ModelMapper mapper = new ModelMapper();
        //STRICT Clase origen : firtsName <-> clase destino : firtsName | nombres = firtsName X
        //STANDARD  Clase origen: firtsName <-> clase destino :  firts_Name
        //LOOSE Clase origen: nombreCompleto <-> clase destino :  nombre | nombre = firtsName X
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        mapper.createTypeMap(ResponseReniec.class, PersonEntity.class)
                .addMapping(ResponseReniec::getFirst_name, (dest, v) -> dest.setFirstName((String) v))
                .addMapping(ResponseReniec::getFirst_last_name, (dest, v) -> dest.setLastName((String) v))
                .addMapping(ResponseReniec::getSecond_last_name, (dest, v) -> dest.setMotherLastName((String) v))
                .addMapping(ResponseReniec::getDocument_number, (dest, v) -> dest.setNumDoc((String) v));

        return mapper;

    }
}
