package com.codigo.api_bd.service;

import com.codigo.api_bd.dto.AlumnoCreateRequest;
import com.codigo.api_bd.dto.AlumnoResponse;
import com.codigo.api_bd.dto.AlumnoUpdateRequest;
import com.codigo.api_bd.model.Alumno;
import com.codigo.api_bd.repository.AlumnoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class AlumnoService {
    private final AlumnoRepository repository;

    public AlumnoService(AlumnoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public AlumnoResponse crear(AlumnoCreateRequest request){
        Alumno a = new Alumno(request.nombre(),request.edad());
        Alumno saved = repository.save(a);

        return toResponse(saved);
    }

    public List<AlumnoResponse> listar(){
        return repository.findAll().stream()
                .map(this::toResponse)
                //.map(alumno -> new AlumnoResponse(alumno.getId(), alumno.getNombre(), alumno.getEdad()))
                //.map(a -> toResponse(a))
                .toList();
    }

    public AlumnoResponse obtener(UUID id){
        Alumno a = repository.findById(id).orElseThrow(
                () -> new RuntimeException("ALUMNO NO EXISTE!!!"));
        return toResponse(a);
    }

    public void eliminar(UUID id){
        if (repository.existsById(id)){ //TRUE O FALSE
            //repository.findById(id).get(); //OPTIONAL<ALUMNO>
            repository.deleteById(id);
        }
    }

    @Transactional
    public AlumnoResponse actualizar(UUID id,
                                     AlumnoUpdateRequest request){
        Alumno alumno = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ALUMNO NO EXISTE!!"));

        alumno.setNombre(request.nombre());
        alumno.setEdad(request.edad());
        //Alumno savede = repository.save(alumno);
        return toResponse(alumno);

        //DIRTY CHECKING -> COMPARA EL ESTADO ORIGINAL VS EL ESTADO ACTUAL DE UNA ENTIDAD
        //Y DECIDE SI DEBE EJECUTAR UN UPDATE
    }

    private AlumnoResponse toResponse(Alumno a){
        return new AlumnoResponse(a.getId(),
                a.getNombre(),
                a.getEdad());
    }

    List<String> nombres = List.of("Ana", "Luis", "Pedro");
    Stream<String> stream = nombres.stream();

    Fuente -> Operaciones intermedias -> operaciones terminal
    nombres.stream()  -> (map(), filter(), sorted(), distinct()) -> toList(), forEach(), findFirts(), count()

    Collecion -> caja con datos
    Stream -> cinta transportadora
    map/filter -> maquinas
    toList() -> caja final lista para enviarse}


}
