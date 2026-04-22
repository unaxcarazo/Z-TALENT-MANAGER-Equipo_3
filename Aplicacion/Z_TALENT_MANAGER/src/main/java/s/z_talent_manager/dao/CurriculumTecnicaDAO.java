/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package s.z_talent_manager.dao;

import jakarta.persistence.EntityManager;
import java.util.List;
import s.z_talent_manager.modelo.CurriculumTecnica;

/**
 *
 * @author DAW1
 */
public interface CurriculumTecnicaDAO {
 public CurriculumTecnica nuevoCurriculumTecnica (EntityManager em, CurriculumTecnica cte);
    public void modificarCurriculumTecnica (EntityManager em, CurriculumTecnica cte);
    public void eliminarCurriculumTecnica (EntityManager em, Integer id);
    public CurriculumTecnica getCurriculumTecnica (EntityManager em, Integer id); 
    List<CurriculumTecnica> getCurriculumTecnicas (EntityManager em);
}