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
@Table(name = "experiencias")
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idExperiencia")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idCurriculum", nullable = false, unique = true)
    private Curriculum curriculum;

    @Column(name = "compania")
    private String compania;

    @Column(name = "puesto")
    private String puesto;

    @Column(name = "fechaInicio")
    private LocalDate fechaInicio;

    @Column(name = "fechaFin")
    private LocalDate fechaFin;

    @Column(name = "descripcion", columnDefinition = "CLOB")
    private String descripcion;

    public Experiencia() {
    }

    public Experiencia(Curriculum curriculum, String compania, String puesto, LocalDate fechaInicio, LocalDate fechaFin, String descripcion) {
        this.curriculum = curriculum;
        this.compania = compania;
        this.puesto = puesto;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descripcion = descripcion;
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

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Experiencia{" + "id=" + id + ", curriculum=" + curriculum + ", compania=" + compania + ", puesto=" + puesto + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", descripcion=" + descripcion + '}';
    }

}
