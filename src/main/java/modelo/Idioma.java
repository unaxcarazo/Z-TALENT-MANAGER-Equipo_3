/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import jakarta.persistence.*;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "idiomas")
public class Idioma {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idIdioma")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    public Idioma() {
    }

    public Idioma(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return "Idioma{" + "id=" + id + ", nombre=" + nombre + '}';
    }

}
