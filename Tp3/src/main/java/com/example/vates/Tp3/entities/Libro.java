package com.example.vates.Tp3.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Entity(name="Libros")
@Table
@Service
public class Libro {



    @Column(name = "id")
    @Id
    int id;
    @Column(name = "titulo")
    String titulo;
    @Column(name = "id_autor")
    int idAutor;

    public Libro() {
    }
    public Libro(int id, String titulo, int idAutor) {
        this.id = id;
        this.titulo = titulo;
        this.idAutor = idAutor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", idAutor=" + idAutor +
                '}';
    }

    public void getResultList() {
   }
}
