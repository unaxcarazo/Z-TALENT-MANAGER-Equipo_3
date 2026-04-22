/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s.z_talent_manager.dao;

import jakarta.persistence.EntityManager;
import java.util.List;

import s.z_talent_manager.modelo.Curriculum;

/**
 *
 * @author DAW1
 */
public class CurriculumImpl implements CurriculumDAO{

    @Override
    public Curriculum nuevoCurriculum(EntityManager em, Curriculum cu) {
        em.persist(cu);
        return cu;
    }

    @Override
    public void modificarCurriculum(EntityManager em, Curriculum cu) {
        em.merge(cu);
                
    }

    @Override
    public void eliminarCurriculum(EntityManager em, Integer id) {
        Curriculum cu = getCurriculum(em,id);
        em.remove(cu);
    }

    @Override
    public Curriculum getCurriculum(EntityManager em, Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Curriculum> getCurriculums(EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
