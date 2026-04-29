/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s.z_talent_manager.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import java.util.List;
import s.z_talent_manager.modelo.CandidatoTransversal;

/**
 *
 * @author DAW1
 */
public class CurriculumTransversalImpl implements CurriculumTransversalDAO{

    @Override
    public CandidatoTransversal nuevoCurriculumTransversal(EntityManager em, CandidatoTransversal ctr) {
        em.persist(ctr);
        return ctr;
    }

    @Override
    public void modificarCurriculumTransversal(EntityManager em, CandidatoTransversal ctr) {
        em.merge(ctr);
    }

    @Override
    public void eliminarCurriculumTransversal(EntityManager em, Integer id) {
        CandidatoTransversal ctr = getCurriculumTransversal(em,id);
        em.remove(ctr);
    }

    @Override
    public CandidatoTransversal getCurriculumTransversal(EntityManager em, Integer id) {
         try {
            return em.createQuery("""
                SSELECT ctr
                FROM CurriculumTransversal ctr
                LEFT JOIN FETCH ctr.curriculum cu
                LEFT JOIN FETCH ctr.titulacion
                WHERE cti.idCurriculumTransversal = :id
                """, CandidatoTransversal.class)
                .setParameter("id", id)
                .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<CandidatoTransversal> getCurriculumTransversales(EntityManager em) {
        Query q = em.createQuery(
        """
            SELECT ctr
            FROM CurriculumTransversal ctr
            LEFT JOIN FETCH ctr.curriculum cu
            LEFT JOIN FETCH ctr.transversal tr
        """);
        return q.getResultList();
    }
}
