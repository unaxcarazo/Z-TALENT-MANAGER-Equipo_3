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
@Table(name = "titulacion")
public class Titulacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idTitulacion")
    private Long id;

    @Column(name = "nombreEstudio")
    private String nombreEstudio;

    @Column(name = "tipoEstudio")
    private String tipoEstudio;

    public Titulacion() {
    }

    public Titulacion(String nombreEstudio, String tipoEstudio) {
        this.nombreEstudio = nombreEstudio;
        this.tipoEstudio = tipoEstudio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreEstudio() {
        return nombreEstudio;
    }

    public void setNombreEstudio(String nombreEstudio) {
        this.nombreEstudio = nombreEstudio;
    }

    public String getTipoEstudio() {
        return tipoEstudio;
    }

    public void setTipoEstudio(String tipoEstudio) {
        this.tipoEstudio = tipoEstudio;
    }

    @Override
    public String toString() {
        return "Titulacion{" + "id=" + id + ", nombreEstudio=" + nombreEstudio + ", tipoEstudio=" + tipoEstudio + '}';
    }

}
