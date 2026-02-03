package com.codigo.api_rest.repository;

import com.codigo.api_rest.model.Alumno;

import java.util.*;

public class AlumnoInMemoryRepository {

    private final Map<UUID, Alumno> data = new HashMap<>();

    public List<Alumno> findAll(){
        return new ArrayList<>(data.values());
    }

    public Optional<Alumno> findById(UUID id){
        return Optional.ofNullable(data.get(id));
    }

    public Alumno save(Alumno alumno){
        data.put(alumno.getId(), alumno);
        return alumno;
    }

    public void deleteById(UUID id){
        data.remove(id);
    }


}
