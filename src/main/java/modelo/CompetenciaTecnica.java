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
@Table(name = "competenciatecnica")
public class CompetenciaTecnica {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idCompetenciaTecnica")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    public CompetenciaTecnica() {
    }

    public CompetenciaTecnica(String nombre) {
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

    public void setNombre(String n) {
        this.nombre = n;
    }

    @Override
    public String toString() {
        return nombre != null ? nombre : "";
    }

}
