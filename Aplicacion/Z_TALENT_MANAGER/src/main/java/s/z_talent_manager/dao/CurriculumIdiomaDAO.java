/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package s.z_talent_manager.dao;

import jakarta.persistence.EntityManager;
import java.util.List;
import s.z_talent_manager.modelo.CurriculumIdioma;

/**
 *
 * @author DAW1
 */
public interface CurriculumIdiomaDAO {
 public CurriculumIdioma nuevoCurriculumIdioma (EntityManager em, CurriculumIdioma ci);
    public void modificarCurriculumIdioma (EntityManager em, CurriculumIdioma ci);
    public void eliminarCurriculumIdioma (EntityManager em, Integer id);
    public CurriculumIdioma getCurriculumIdioma (EntityManager em, Integer id); 
    List<CurriculumIdioma> getCurriculumIdiomas (EntityManager em);
}