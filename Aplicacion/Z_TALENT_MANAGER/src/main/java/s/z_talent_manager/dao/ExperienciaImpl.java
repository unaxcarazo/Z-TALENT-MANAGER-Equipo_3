/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s.z_talent_manager.dao;

import jakarta.persistence.EntityManager;
import java.util.List;
import s.z_talent_manager.modelo.Experiencia;

/**
 *
 * @author DAW1
 */
public class ExperienciaImpl implements ExperienciaDAO {

    @Override
    public Experiencia nuevaExperiencia(EntityManager em, Experiencia e) {
        em.persist(e);
        return e;
    }

    @Override
    public void modificarExperiencia(EntityManager em, Experiencia e) {
        em.merge(e);
    }

    @Override
    public void eliminarExperiencia(EntityManager em, Integer id) {
        Experiencia e = getExperiencia(em,id);
        em.remove(e);
    }

    @Override
    public Experiencia getExperiencia(EntityManager em, Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Experiencia> getExperiencias(EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
