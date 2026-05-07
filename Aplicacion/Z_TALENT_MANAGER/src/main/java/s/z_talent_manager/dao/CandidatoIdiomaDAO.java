/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package s.z_talent_manager.dao;

import jakarta.persistence.EntityManager;
import java.util.List;
import s.z_talent_manager.modelo.CandidatoIdioma;

/**
 *
 * @author DAW1
 */
public interface CandidatoIdiomaDAO {
 public CandidatoIdioma nuevoCandidatoIdioma (EntityManager em, CandidatoIdioma ci);
    public void modificarCandidatoIdioma (EntityManager em, CandidatoIdioma ci);
    public void eliminarCandidatoIdioma (EntityManager em, Integer id);
    public CandidatoIdioma getCandidatoIdioma (EntityManager em, Integer id); 
    List<CandidatoIdioma> getCandidatoIdiomas (EntityManager em);
}