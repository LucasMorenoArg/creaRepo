package com.example.vates.Tp3.controllers;

import com.example.vates.Tp3.entities.Autor;
import com.example.vates.Tp3.service.ServicioAutor;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/crearAutor")
    public boolean crearAutor(@RequestBody Autor autor){
        servicioAutor.crearAutor(autor);
        return true;
    }

    @PutMapping("/actualizarAutor")
    public boolean actualizar(@RequestBody Autor autor){
        servicioAutor.actualizarAutor(autor);
        return true;
    }


    @DeleteMapping("/borrarAutor/{id}")
    public boolean borrar(@PathVariable int id){
        servicioAutor. eliminarAutor(id);
        return true;
    }

}
