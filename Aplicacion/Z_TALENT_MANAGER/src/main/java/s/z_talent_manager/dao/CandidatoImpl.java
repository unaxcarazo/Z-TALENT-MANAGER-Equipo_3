/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s.z_talent_manager.dao;

import jakarta.persistence.EntityManager;
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Candidato> getCandidatos(EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
