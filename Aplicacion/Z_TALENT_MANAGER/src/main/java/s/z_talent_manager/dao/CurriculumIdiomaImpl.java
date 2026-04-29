/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s.z_talent_manager.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import java.util.List;
import s.z_talent_manager.modelo.CandidatoIdioma;

/**
 *
 * @author DAW1
 */
public class CurriculumIdiomaImpl implements CurriculumIdiomaDAO{

    @Override
    public CandidatoIdioma nuevoCurriculumIdioma(EntityManager em, CandidatoIdioma ci) {
        em.persist(ci);
        return ci;
    }

    @Override
    public void modificarCurriculumIdioma(EntityManager em, CandidatoIdioma ci) {
        em.merge(ci);
    }

    @Override
    public void eliminarCurriculumIdioma(EntityManager em, Integer id) {
        CandidatoIdioma ci = getCurriculumIdioma(em,id);
        em.remove(ci);
    }

    @Override
    public CandidatoIdioma getCurriculumIdioma(EntityManager em, Integer id) {
         try {
            return em.createQuery("""
                SSELECT ci
                FROM CurriculumIdioma ci
                LEFT JOIN FETCH ci.curriculum ci
                LEFT JOIN FETCH ci.idioma i
                WHERE ci.idCurriculumIdioma = :id
                """, CandidatoIdioma.class)
                .setParameter("id", id)
                .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<CandidatoIdioma> getCurriculumIdiomas(EntityManager em) {
        Query q = em.createQuery(
        """
            SELECT ci
            FROM CurriculumIdioma ci
            LEFT JOIN FETCH ci.curriculum cu
            LEFT JOIN FETCH ci.idioma 
        """);
        return q.getResultList();
    }
}