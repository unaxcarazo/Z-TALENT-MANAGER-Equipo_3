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
@Table(name = "candidatos")
public class Candidato {

    @Id
    @Column(name = "idUsuario")
    private Long idUsuario;

    @OneToOne
    @MapsId
    @JoinColumn(name = "idUsuario", nullable = false, unique = true)
    private Usuario usuario;

    @Column(name = "municipio")
    private String municipio;

    @Column(name = "provincia")
    private String provincia;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "fechaNacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "genero")
    private String genero;

    public Candidato() {
    }

    public Candidato(Usuario usuario, String municipio, String provincia, String telefono, LocalDate fechaNacimiento, String genero) {
        this.usuario = usuario;
        this.municipio = municipio;
        this.provincia = provincia;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Candidato{" + "usuario=" + usuario + ", municipio=" + municipio + ", provincia=" + provincia + ", telefono=" + telefono + ", fechaNacimiento=" + fechaNacimiento + ", genero=" + genero + '}';
    }

}
