package com.example.vates.Tp3.service;

import com.example.vates.Tp3.entities.Libro;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class ServicioLibro {
    @PersistenceContext
    private EntityManager em;

    public Collection<Libro> consulta(){
        return em.createQuery("select p from Libros p",Libro.class).getResultList();
    }
    @Transactional
    public boolean crearLibro(Libro libro){
        em.persist(libro);
        return true;
    }
}
