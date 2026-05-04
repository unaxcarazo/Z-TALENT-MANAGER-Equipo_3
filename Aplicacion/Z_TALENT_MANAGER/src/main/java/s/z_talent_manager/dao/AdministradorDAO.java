/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package s.z_talent_manager.dao;

import jakarta.persistence.EntityManager;
import java.util.List;
import s.z_talent_manager.modelo.Administrador;

/**
 *
 * @author DAW1
 */
public interface AdministradorDAO {
    
    public Administrador nuevoAdministrador (EntityManager em, Administrador a);
    public void modificarAdministrador (EntityManager em, Administrador a);
    public void eliminarAdministrador (EntityManager em, Integer id);
    public Administrador getAdministrador (EntityManager em, Integer id); 
   

}