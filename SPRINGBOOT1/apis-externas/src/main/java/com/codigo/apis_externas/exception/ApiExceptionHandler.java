package com.codigo.apis_externas.exception;



import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DniInvalidoException.class)
    public Map<String,String> dniInvalido(DniInvalidoException exception){
        return Map.of("Message", exception.getMessage());
    }
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    @ExceptionHandler(ReniecProviderException.class)
    public Map<String,String> proveedorFallo(ReniecProviderException exception){
        return Map.of("Message", exception.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    @ExceptionHandler(HandlerMethodValidationException.class)
    public Map<String,String> proveedorFallo2(HandlerMethodValidationException exception){
        return Map.of("Message", exception.getMessage());
    }

}
