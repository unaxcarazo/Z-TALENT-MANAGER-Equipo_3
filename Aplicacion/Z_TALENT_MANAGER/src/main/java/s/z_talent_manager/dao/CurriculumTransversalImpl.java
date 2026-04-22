/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s.z_talent_manager.dao;

import jakarta.persistence.EntityManager;
import java.util.List;
import s.z_talent_manager.modelo.CurriculumTransversal;

/**
 *
 * @author DAW1
 */
public class CurriculumTransversalImpl implements CurriculumTransversalDAO{

    @Override
    public CurriculumTransversal nuevoCurriculumTransversal(EntityManager em, CurriculumTransversal ctr) {
        em.persist(ctr);
        return ctr;
    }

    @Override
    public void modificarCurriculumTransversal(EntityManager em, CurriculumTransversal ctr) {
        em.merge(ctr);
    }

    @Override
    public void eliminarCurriculumTransversal(EntityManager em, Integer id) {
        CurriculumTransversal ctr = getCurriculumTransversal(em,id);
        em.remove(ctr);
    }

    @Override
    public CurriculumTransversal getCurriculumTransversal(EntityManager em, Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<CurriculumTransversal> getCurriculumTransversals(EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
