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
@Table(name = "administracion")
public class Administracion {

    @Id
    @Column(name = "idUsuario")
    private Long idUsuario;

    @OneToOne
    @MapsId
    @JoinColumn(name = "idUsuario", nullable = false, unique = true)
    private Usuario usuario;

    @Column(name = "cargo", length = 100)
    private String cargo;

    public Administracion() {
    }

    public Administracion(Usuario usuario, String cargo) {
        this.usuario = usuario;
        this.cargo = cargo;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Administracion{" + "idUsuario=" + idUsuario + ", usuario=" + usuario + ", cargo=" + cargo + '}';
    }

}
