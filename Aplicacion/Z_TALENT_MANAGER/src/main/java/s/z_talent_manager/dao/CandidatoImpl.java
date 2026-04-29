/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s.z_talent_manager.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import java.util.List;
import s.z_talent_manager.modelo.Candidato;

/**
 *
 * @author DAW1
 */
public class CandidatoImpl implements CandidatoDAO {

    @Override
    public Candidato nuevoCandidato(EntityManager em, Candidato ca) {
         em.persist(ca);
        return ca;
    }

    @Override
    public void modificarCandidato(EntityManager em, Candidato ca) {
         em.merge(ca);
    }

    @Override
    public void eliminarCandidato(EntityManager em, Integer id) {
        Candidato ca = getCandidato(em,id);
        em.remove(ca);
    }

    @Override
    public Candidato getCandidato(EntityManager em, Integer id) {
         try {
            return em.createQuery("""
                SELECT ca
                FROM Candidato ca
                LEFT JOIN FETCH ca.curriculumIdiomas
                LEFT JOIN FETCH ca.curriculumTecnicas
                LEFT JOIN FETCH ca.curriculumTransversales
                LEFT JOIN FETCH ca.curriculumTitulaciones
                LEFT JOIN FETCH ca.experiencias                               
                WHERE ca.idUsuario = :id
                """, Candidato.class)
                .setParameter("id", id)
                .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Candidato> getCandidatos(EntityManager em) {
        return em.createQuery(
                """
                SELECT ca FROM Candidato ca            
                """, Candidato.class)
                .getResultList(); 
    }
}