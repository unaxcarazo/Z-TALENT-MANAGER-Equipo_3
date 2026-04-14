/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "curriculum")
public class Curriculum {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idCurriculum")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false, unique = true)
    private Candidato candidato;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "fechaCreacion")
    private LocalDate fechaCreacion;

    //Character Large Object
    @Column(name = "sobreMi", columnDefinition = "CLOB")
    private String sobreMi;

    public Curriculum() {
    }

    public Curriculum(Long id, Candidato candidato, String nombre, LocalDate fechaCreacion, String sobreMi) {
        this.id = id;
        this.candidato = candidato;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.sobreMi = sobreMi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getSobreMi() {
        return sobreMi;
    }

    public void setSobreMi(String sobreMi) {
        this.sobreMi = sobreMi;
    }

    @Override
    public String toString() {
        return "Curriculum{" + "id=" + id + ", candidato=" + candidato + ", nombre=" + nombre + ", fechaCreacion=" + fechaCreacion + ", sobreMi=" + sobreMi + '}';
    }

}
