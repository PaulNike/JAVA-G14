package com.codigo.holamundo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HolaController {

    @GetMapping("/hola")
    public String hola(){
        return "Hola mundo desde mi proyecto en spring";
    }
}
