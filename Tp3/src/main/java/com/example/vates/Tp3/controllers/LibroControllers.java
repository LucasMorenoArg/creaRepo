package com.example.vates.Tp3.controllers;

import com.example.vates.Tp3.entities.Libro;
import com.example.vates.Tp3.service.ServicioLibro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
public class LibroControllers {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    private ServicioLibro servicio;
   @GetMapping("/consultaLibros")
    public Collection<Libro> consultaLibros(){
    //return em.createQuery("select p from Libros p",Libro.class).getResultList();

    return servicio.consulta();
   }

   @PutMapping("/crearLibro")
    public void creaLibro(@RequestBody Libro libro){
    servicio.crearLibro(libro);
   }

}