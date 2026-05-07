/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s.z_talent_manager.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import java.util.List;
import s.z_talent_manager.modelo.Candidato;
import s.z_talent_manager.util.JPAUtil;

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
        Candidato ca = getCandidato(em, id);
        em.remove(ca);
    }

    @Override
    public Candidato getCandidato(EntityManager em, Integer id) {
        try {

            Candidato ca = em.createQuery("""
            SELECT DISTINCT ca
            FROM Candidato ca
            LEFT JOIN FETCH ca.candidatoIdiomas ci
            LEFT JOIN FETCH ci.idioma
            WHERE ca.idUsuario = :id
            """, Candidato.class)
                    .setParameter("id", id)
                    .getSingleResult();

            em.createQuery("""
            SELECT ca FROM Candidato ca 
            LEFT JOIN FETCH ca.candidatoTecnicas ct
            LEFT JOIN FETCH ct.competenciaTecnica
            WHERE ca.idUsuario = :id
            """, Candidato.class)
                    .setParameter("id", id).getSingleResult();

            em.createQuery("""
            SELECT ca FROM Candidato ca 
            LEFT JOIN FETCH ca.candidatoTransversales ctr
            LEFT JOIN FETCH ctr.transversal
            WHERE ca.idUsuario = :id
            """, Candidato.class)
                    .setParameter("id", id).getSingleResult();

            em.createQuery("""
            SELECT ca FROM Candidato ca 
            LEFT JOIN FETCH ca.candidatoTitulaciones cti
            LEFT JOIN FETCH cti.titulacion
            WHERE ca.idUsuario = :id
            """, Candidato.class)
                    .setParameter("id", id).getSingleResult();

            em.createQuery("""
            SELECT ca FROM Candidato ca 
            LEFT JOIN FETCH ca.experiencias 
            WHERE ca.idUsuario = :id
            """, Candidato.class)
                    .setParameter("id", id).getSingleResult();

            return ca;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Candidato> getCandidatos(EntityManager em) {
        return em.createQuery(
                """
                SELECT ca 
                FROM Candidato ca            
                """, Candidato.class)
                .getResultList();
    }
    
    public static void main(String[] args) {
        CandidatoDAO dao = new CandidatoImpl();
        Candidato c = dao.getCandidato(JPAUtil.getEntityManager(), 1);
        System.out.println(c);
    }
}
