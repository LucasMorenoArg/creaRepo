package com.example.vates.Tp3.entities;

import jakarta.persistence.*;

@Entity(name="Autores")
public class Autor {

    @Id
    @Column(name = "id")
    int id;
    @Column(name="nombre")
    String nombre;

    public Autor() {
    }

    public Autor(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
