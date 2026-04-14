/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "curriculumTitulacion")
public class CurriculumTitulacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idCurriculumTitulacion")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idCurriculum", nullable = false)
    private Curriculum curriculum;

    @ManyToOne
    @JoinColumn(name = "idTitulacion", nullable = false)
    private Titulacion titulacion;

    @Column(name = "fechaInicio")
    private LocalDate fechaInicio;

    @Column(name = "fechaFin")
    private LocalDate fechaFin;

    @Column(name = "nombre")
    private String nombre;

    public CurriculumTitulacion() {
    }

    public CurriculumTitulacion(Curriculum curriculum, Titulacion titulacion, LocalDate fechaInicio, LocalDate fechaFin, String nombre) {
        this.curriculum = curriculum;
        this.titulacion = titulacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Curriculum getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }

    public Titulacion getTitulacion() {
        return titulacion;
    }

    public void setTitulacion(Titulacion titulacion) {
        this.titulacion = titulacion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
