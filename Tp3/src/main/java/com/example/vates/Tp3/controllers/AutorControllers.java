package com.example.vates.Tp3.controllers;

import com.example.vates.Tp3.entities.Autor;
import com.example.vates.Tp3.service.ServicioAutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class AutorControllers {

    @Autowired
    private ServicioAutor servicioAutor;

    @GetMapping("/consultarAutores")
    public Collection<Autor> consultaAutor(){
       return servicioAutor.consultarTodos();
    }
    @GetMapping("/buscarxId/{id}")
    public Autor consultaxId(@PathVariable int id){
        return servicioAutor.buscarxId(id);
    }

}
