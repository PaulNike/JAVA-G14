package com.codigo.api_rest.service;

import com.codigo.api_rest.dto.AlumnoCreateRequest;
import com.codigo.api_rest.dto.AlumnoResponse;
import com.codigo.api_rest.model.Alumno;
import com.codigo.api_rest.repository.AlumnoInMemoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AlumnoService {
    private final AlumnoInMemoryRepository alumnoInMemoryRepository;

    public AlumnoService(AlumnoInMemoryRepository alumnoInMemoryRepository) {
        this.alumnoInMemoryRepository = alumnoInMemoryRepository;
    }

    public List<AlumnoResponse> listar(){

        return alumnoInMemoryRepository.findAll()
                .stream()
                .map(a -> new AlumnoResponse(a.getId(), a.getNombre(), a.getEdad()))
                .toList();
    }

    public AlumnoResponse obtener(UUID id){
        Alumno alumno = alumnoInMemoryRepository.findById(id).orElseThrow();
        return new AlumnoResponse(
                alumno.getId(),
                alumno.getNombre(),
                alumno.getEdad()
        );
    }

    public AlumnoResponse crear(AlumnoCreateRequest alumnoCreateRequest){
        Alumno alumno  = new Alumno(
                UUID.randomUUID(),
                alumnoCreateRequest.nombre(),
                alumnoCreateRequest.edad()
        );

        alumnoInMemoryRepository.save(alumno); //aqui se ejecuta el guardado

        return new AlumnoResponse(alumno.getId(),alumno.getNombre(),alumno.getEdad());

    }


}
