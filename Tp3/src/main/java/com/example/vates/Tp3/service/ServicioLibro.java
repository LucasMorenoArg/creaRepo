package com.example.vates.Tp3.service;

import com.example.vates.Tp3.entities.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

@Service
public class ServicioLibro {
    @PersistenceContext
    private EntityManager emLibro;

    //@Transactional //listado generales
    public Collection<Libro> consultarTodos(){
        return emLibro.createQuery("select l from Libros l", Libro.class).getResultList();

    }
    public Collection<Libro> librosxTitulo(){
        return emLibro.createQuery("Select l from Libros l ORDER BY l.titulo ASC").getResultList();

    }
    public Libro consultaId(int id){
        return emLibro.find(Libro.class, id);

    }

    public Collection<Libro> libroxIdAutor(int idAutor){
        return emLibro.createQuery("Select l from Libros l WHERE id_autor=:idAutor", Libro.class).setParameter("idAutor",idAutor).getResultList(); }

    @Transactional
    public void crearLibro(Libro libro){
        emLibro.persist(libro);
    }

    public void actualizarLibro(Libro libro){
        emLibro.merge(libro);
    }

    public void removerLibro(int id){
        Libro aBorrar = consultaId(id);
    }
    public double promedioId(){
        return emLibro.createQuery("select p from Libros p",Libro.class)
                .getResultStream()
                .mapToInt(Libro::getId)
                .average().orElse(0);
    }


}
