package com.example.vates.Tp3.service;

import com.example.vates.Tp3.entities.Autor;
import com.example.vates.Tp3.entities.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ServicioAutor {
    @PersistenceContext
    private EntityManager emAutor;

    public Collection<Autor> consultarTodos(){
        return emAutor.createQuery("select p from Autores p").getResultList();
    }

    public Autor buscarxId(int id){
        return emAutor.find(Autor.class, id);
    }



}
