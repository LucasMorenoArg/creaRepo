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

    public Libro consultaind(int id){
        return em.find(Libro.class, id);
    }
    @Transactional
    public boolean crearLibro(Libro libro){
        em.persist(libro);
        return true;
    }
    @Transactional
    public Collection<Libro> consultarTodos(){

        return em.createQuery("select p from Libros p").getResultList();
    }

    public double promedioId(){
        return em.createQuery("select p from libro p",Libro.class)
                .getResultStream()
                .mapToInt(Libro::getId)
                .average().orElse(0);
    }


}
