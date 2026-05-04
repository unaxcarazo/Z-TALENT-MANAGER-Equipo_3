/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s.z_talent_manager.modelo;

/**
 *
 * @author DAW1
 */
public class Sesion {
    private static Usuario usuarioLogueado;

    // Guarda el usuario al hacer login
    public static void setUsuario(Usuario usuario) {
        usuarioLogueado = usuario;
    }

    // Recupera el usuario desde cualquier ventana
    public static Usuario getUsuario() {
        return usuarioLogueado;
    }
    
    // Atajo para obtenerlo directamente como Candidato
    public static Candidato getCandidato() {
        return (usuarioLogueado instanceof Candidato) ? (Candidato) usuarioLogueado : null;
    }

    // Para el botón "Salir"
    public static void cerrarSesion() {
        usuarioLogueado = null;
    }
}
