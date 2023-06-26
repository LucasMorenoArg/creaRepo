package com.example.vates.Tp3.service;

import com.example.vates.Tp3.entities.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class ServicioLibro {
    @PersistenceContext
    private EntityManager emLibro;

    @Transactional //listado generales
    public Collection<Libro> consultarTodos(){
        return emLibro.createQuery("select p from Libros p").getResultList();
    }
    public Libro consultaId(int id){
        return emLibro.find(Libro.class, id);
    }
    @Transactional
    public void crearLibro(Libro libro){
        emLibro.persist(libro);
    }

    public double promedioId(){
        return emLibro.createQuery("select p from Libros p",Libro.class)
                .getResultStream()
                .mapToInt(Libro::getId)
                .average().orElse(0);
    }


}
