/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s.z_talent_manager.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import java.util.List;
import s.z_talent_manager.modelo.CandidatoTitulacion;

/**
 *
 * @author DAW1
 */
public class CurriculumTitulacionImpl implements CurriculumTitulacionDAO {

    @Override
    public CandidatoTitulacion nuevoCurriculumTitulacion(EntityManager em, CandidatoTitulacion cti) {
        em.persist(cti);
        return cti;
    }

    @Override
    public void modificarCurriculumTitulacion(EntityManager em, CandidatoTitulacion cti) {
        em.merge(cti);
    }

    @Override
    public void eliminarCurriculumTitulacion(EntityManager em, Integer id) {
        CandidatoTitulacion cti = getCurriculumTitulacion(em,id);
        em.remove(cti);
    }

    @Override
    public CandidatoTitulacion getCurriculumTitulacion(EntityManager em, Integer id) {
        try {
            return em.createQuery("""
                SSELECT cte
                FROM CurriculumTitulacion cti
                LEFT JOIN FETCH cti.curriculum cu
                LEFT JOIN FETCH cti.titulacion t
                WHERE cti.idCurriculumTitulacion = :id
                """, CandidatoTitulacion.class)
                .setParameter("id", id)
                .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    @Override
    public List<CandidatoTitulacion> getCurriculumTitulaciones(EntityManager em) {
        Query q = em.createQuery(
        """
            SELECT cti
            FROM CurriculumTitulacion cti
            LEFT JOIN FETCH cti.curriculum cu
            LEFT JOIN FETCH cti.titulacion t
        """);
        return q.getResultList();
    }
}
