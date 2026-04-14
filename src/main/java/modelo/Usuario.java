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
@Table(name = "usuarios")
public class Usuario {

    public static final String ROL_CANDIDATO = "CANDIDATO";
    public static final String ROL_ADMINISTRADOR = "ADMINISTRADOR";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "email", unique = true, nullable = false, length = 255)
    private String email;

    @Column(name = "contrasena", nullable = false, length = 255)
    private String contrasena;

    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;

    @Column(name = "apellidos", nullable = false, length = 255)
    private String apellidos;

    @Transient
    private String rol;

    public Usuario() {
    }

    public Usuario(String email, String contrasena, String nombre, String apellidos) {
        this.email = email;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public boolean esCandidato() {
        return ROL_CANDIDATO.equals(rol);
    }

    public boolean esAdministrador() {
        return ROL_ADMINISTRADOR.equals(rol);
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", email=" + email + ", nombre=" + nombre + ", apellidos=" + apellidos + '}';
    }

}
