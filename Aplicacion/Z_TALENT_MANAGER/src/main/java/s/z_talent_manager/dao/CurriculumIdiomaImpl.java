/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s.z_talent_manager.dao;

import jakarta.persistence.EntityManager;
import java.util.List;
import s.z_talent_manager.modelo.CurriculumIdioma;

/**
 *
 * @author DAW1
 */
public class CurriculumIdiomaImpl implements CurriculumIdiomaDAO{

    @Override
    public CurriculumIdioma nuevoCurriculumIdioma(EntityManager em, CurriculumIdioma ci) {
        em.persist(ci);
        return ci;
    }

    @Override
    public void modificarCurriculumIdioma(EntityManager em, CurriculumIdioma ci) {
        em.merge(ci);
    }

    @Override
    public void eliminarCurriculumIdioma(EntityManager em, Integer id) {
        CurriculumIdioma ci = getCurriculumIdioma(em,id);
        em.remove(ci);
    }

    @Override
    public CurriculumIdioma getCurriculumIdioma(EntityManager em, Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<CurriculumIdioma> getCurriculumIdiomas(EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
