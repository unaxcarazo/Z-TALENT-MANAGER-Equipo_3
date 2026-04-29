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
public interface CurriculumIdiomaDAO {
 public CandidatoIdioma nuevoCurriculumIdioma (EntityManager em, CandidatoIdioma ci);
    public void modificarCurriculumIdioma (EntityManager em, CandidatoIdioma ci);
    public void eliminarCurriculumIdioma (EntityManager em, Integer id);
    public CandidatoIdioma getCurriculumIdioma (EntityManager em, Integer id); 
    List<CandidatoIdioma> getCurriculumIdiomas (EntityManager em);
}