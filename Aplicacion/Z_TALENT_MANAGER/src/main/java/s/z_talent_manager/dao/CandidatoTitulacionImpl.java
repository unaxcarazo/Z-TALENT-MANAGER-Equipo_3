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
public class CandidatoTitulacionImpl implements CandidatoTitulacionDAO {

    @Override
    public CandidatoTitulacion nuevoCandidatoTitulacion(EntityManager em, CandidatoTitulacion cti) {
        em.persist(cti);
        return cti;
    }

    @Override
    public void modificarCandidatoTitulacion(EntityManager em, CandidatoTitulacion cti) {
        em.merge(cti);
    }

    @Override
    public void eliminarCandidatoTitulacion(EntityManager em, Integer id) {
        CandidatoTitulacion cti = getCandidatoTitulacion(em,id);
        em.remove(cti);
    }

    @Override
    public CandidatoTitulacion getCandidatoTitulacion(EntityManager em, Integer id) {
        try {
            return em.createQuery("""
                SSELECT cte
                FROM CandidatoTitulacion cti
                LEFT JOIN FETCH cti.candidato ca
                LEFT JOIN FETCH cti.titulacion t
                WHERE cti.idCandidatoTitulacion = :id
                """, CandidatoTitulacion.class)
                .setParameter("id", id)
                .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    @Override
    public List<CandidatoTitulacion> getCandidatoTitulaciones(EntityManager em) {
        Query q = em.createQuery(
        """
            SELECT cti
            FROM CandidatoTitulacion cti
            LEFT JOIN FETCH cti.candidato ca
            LEFT JOIN FETCH cti.titulacion t
        """);
        return q.getResultList();
    }
}
