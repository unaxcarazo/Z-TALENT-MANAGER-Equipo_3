/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s.z_talent_manager.dao;

import jakarta.persistence.EntityManager;
import java.util.List;
import s.z_talent_manager.modelo.CurriculumTecnica;

/**
 *
 * @author DAW1
 */
public class CurriculumTecnicaImpl implements CurriculumTecnicaDAO{

    @Override
    public CurriculumTecnica nuevoCurriculumTecnica(EntityManager em, CurriculumTecnica cte) {
        em.persist(cte);
        return cte;
    }

    @Override
    public void modificarCurriculumTecnica(EntityManager em, CurriculumTecnica cte) {
        em.merge(cte);
    }

    @Override
    public void eliminarCurriculumTecnica(EntityManager em, Integer id) {
        CurriculumTecnica cte = getCurriculumTecnica(em,id);
        em.remove(cte);
    }

    @Override
    public CurriculumTecnica getCurriculumTecnica(EntityManager em, Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<CurriculumTecnica> getCurriculumTecnicas(EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
