/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package s.z_talent_manager.dao;

import jakarta.persistence.EntityManager;
import s.z_talent_manager.modelo.Usuario;

/**
 *
 * @author DAW1
 */
public interface UsuarioDAO {
    public Usuario getUsuarioPorEmail (EntityManager em, String email); 
}
