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
public class CandidatoTransversalImpl implements CandidatoTransversalDAO{

    @Override
    public CandidatoTransversal nuevoCandidatoTransversal(EntityManager em, CandidatoTransversal ctr) {
        em.persist(ctr);
        return ctr;
    }

    @Override
    public void modificarCandidatoTransversal(EntityManager em, CandidatoTransversal ctr) {
        em.merge(ctr);
    }

    @Override
    public void eliminarCandidatoTransversal(EntityManager em, Integer id) {
        CandidatoTransversal ctr = getCandidatoTransversal(em,id);
        em.remove(ctr);
    }

    @Override
    public CandidatoTransversal getCandidatoTransversal(EntityManager em, Integer id) {
         try {
            return em.createQuery("""
                SSELECT ctr
                FROM CandidatoTransversal ctr
                LEFT JOIN FETCH ctr.candidato ca
                LEFT JOIN FETCH ctr.titulacion
                WHERE cti.idCandidatoTransversal = :id
                """, CandidatoTransversal.class)
                .setParameter("id", id)
                .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<CandidatoTransversal> getCandidatoTransversales(EntityManager em) {
        Query q = em.createQuery(
        """
            SELECT ctr
            FROM CandidatoTransversal ctr
            LEFT JOIN FETCH ctr.candidato ca
            LEFT JOIN FETCH ctr.transversal tr
        """);
        return q.getResultList();
    }
}
