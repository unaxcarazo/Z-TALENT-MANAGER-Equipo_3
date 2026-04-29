/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s.z_talent_manager.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import java.util.List;
import s.z_talent_manager.modelo.CandidatoTecnica;

/**
 *
 * @author DAW1
 */
public class CurriculumTecnicaImpl implements CurriculumTecnicaDAO{

    @Override
    public CandidatoTecnica nuevoCurriculumTecnica(EntityManager em, CandidatoTecnica cte) {
        em.persist(cte);
        return cte;
    }

    @Override
    public void modificarCurriculumTecnica(EntityManager em, CandidatoTecnica cte) {
        em.merge(cte);
    }

    @Override
    public void eliminarCurriculumTecnica(EntityManager em, Integer id) {
        CandidatoTecnica cte = getCurriculumTecnica(em,id);
        em.remove(cte);
    }

    @Override
    public CandidatoTecnica getCurriculumTecnica(EntityManager em, Integer id) {
       try {
            return em.createQuery("""
                SELECT cte
                FROM CurriculumTecnica cte
                LEFT JOIN FETCH cte.curriculum cu
                LEFT JOIN FETCH cte.competenciaTecnica ct
                WHERE cte.idCurriculumTecnica = :id
                """, CandidatoTecnica.class)
                .setParameter("id", id)
                .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<CandidatoTecnica> getCurriculumTecnicas(EntityManager em) {
         Query q = em.createQuery(
        """
            SELECT cte
            FROM CurriculumTecnica cte
            LEFT JOIN FETCH cte.curriculum cu
            LEFT JOIN FETCH cte.competenciaTecnica cte
        """);
        return q.getResultList();
    }
}

