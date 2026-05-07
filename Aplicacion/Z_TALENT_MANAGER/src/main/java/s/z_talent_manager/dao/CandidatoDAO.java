/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package s.z_talent_manager.dao;

import jakarta.persistence.EntityManager;
import java.util.List;
import s.z_talent_manager.modelo.Candidato;

/**
 *
 * @author DAW1
 */
public interface CandidatoDAO {
    public Candidato nuevoCandidato (EntityManager em, Candidato ca);
    public void modificarCandidato (EntityManager em, Candidato ca);
    public void eliminarCandidato (EntityManager em, Integer id);
    public Candidato getCandidato (EntityManager em, Integer id); 
    public List<Candidato> getCandidatos (EntityManager em);
}
