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
public class CandidatoIdiomaImpl implements CandidatoIdiomaDAO{

    @Override
    public CandidatoIdioma nuevoCandidatoIdioma(EntityManager em, CandidatoIdioma ci) {
        em.persist(ci);
        return ci;
    }

    @Override
    public void modificarCandidatoIdioma(EntityManager em, CandidatoIdioma ci) {
        em.merge(ci);
    }

    @Override
    public void eliminarCandidatoIdioma(EntityManager em, Integer id) {
        CandidatoIdioma ci = getCandidatoIdioma(em,id);
        em.remove(ci);
    }

    @Override
    public CandidatoIdioma getCandidatoIdioma(EntityManager em, Integer id) {
         try {
            return em.createQuery("""
                SSELECT ci
                FROM CandidatoIdioma ci
                LEFT JOIN FETCH ci.candidato ci
                LEFT JOIN FETCH ci.idioma i
                WHERE ci.idCandidatoIdioma = :id
                """, CandidatoIdioma.class)
                .setParameter("id", id)
                .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<CandidatoIdioma> getCandidatoIdiomas(EntityManager em) {
        Query q = em.createQuery(
        """
            SELECT ci
            FROM CandidatoIdioma ci
            LEFT JOIN FETCH ci.candidato ca
            LEFT JOIN FETCH ci.idioma 
        """);
        return q.getResultList();
    }
}