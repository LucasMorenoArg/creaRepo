package com.example.vates.Tp3.controllers;

import com.example.vates.Tp3.entities.Libro;
import com.example.vates.Tp3.service.ServicioLibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class LibroControllers {
    @Autowired
    private ServicioLibro servicioLibro;

    @GetMapping("/consultarLibros")
    public Collection<Libro> consultaLibros(){
        return servicioLibro.consultarTodos();
    }

    @GetMapping("/libroxTitulo")
    public Collection<Libro> libroxTitulo(){
        return servicioLibro.librosxTitulo();
    }
    @GetMapping("/librosxAutor/{idAutor}")
    public Collection<Libro> librosxAutor(@PathVariable int idAutor){
        return servicioLibro.libroxIdAutor(idAutor);
    }

    @GetMapping("/consultaId/{id}")
    public Libro consulta(@PathVariable int id){
       return servicioLibro.consultaId(id);
    }
    @GetMapping("/promedioId")
    public double promedios(){
       return servicioLibro.promedioId();
   }

    @PutMapping("/crearLibro")
    public void creaLibro(@RequestBody Libro libro){
        servicioLibro.crearLibro(libro);
    }

    @PutMapping("/actualizarLibro")
    public void actualizarLibro(@RequestBody Libro libro){
        servicioLibro.actualizarLibro(libro);
    }

    @DeleteMapping("/removerLibro/{id}")
    public void removerLibro(@PathVariable int id){
        servicioLibro.removerLibro(id);
    }



}
