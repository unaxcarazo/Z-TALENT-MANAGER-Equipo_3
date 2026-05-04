/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package s.z_talent_manager.dao;

import jakarta.persistence.EntityManager;
import java.util.List;
import s.z_talent_manager.modelo.Experiencia;

/**
 *
 * @author DAW1
 */
public interface ExperienciaDAO {
   public Experiencia nuevaExperiencia (EntityManager em, Experiencia e);
    public void modificarExperiencia (EntityManager em, Experiencia e);
    public void eliminarExperiencia (EntityManager em, Integer id);
    public Experiencia getExperiencia (EntityManager em, Integer id); 
    List<Experiencia> getExperiencias (EntityManager em);
}
