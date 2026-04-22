/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s.z_talent_manager.dao;

import jakarta.persistence.EntityManager;
import java.util.List;
import s.z_talent_manager.modelo.CurriculumTitulacion;

/**
 *
 * @author DAW1
 */
public class CurriculumTitulacionImpl implements CurriculumTitulacionDAO {

    @Override
    public CurriculumTitulacion nuevoCurriculumTitulacion(EntityManager em, CurriculumTitulacion cti) {
        em.persist(cti);
        return cti;
    }

    @Override
    public void modificarCurriculumTitulacion(EntityManager em, CurriculumTitulacion cti) {
        em.merge(cti);
    }

    @Override
    public void eliminarCurriculumTitulacion(EntityManager em, Integer id) {
        CurriculumTitulacion cti = getCurriculumTitulacion(em,id);
        em.remove(cti);
    }

    @Override
    public CurriculumTitulacion getCurriculumTitulacion(EntityManager em, Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<CurriculumTitulacion> getCurriculumTitulaciones(EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
