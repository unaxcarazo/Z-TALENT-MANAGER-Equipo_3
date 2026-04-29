/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package s.z_talent_manager.dao;

import jakarta.persistence.EntityManager;
import java.util.List;
import s.z_talent_manager.modelo.CandidatoTecnica;

/**
 *
 * @author DAW1
 */
public interface CurriculumTecnicaDAO {
 public CandidatoTecnica nuevoCurriculumTecnica (EntityManager em, CandidatoTecnica cte);
    public void modificarCurriculumTecnica (EntityManager em, CandidatoTecnica cte);
    public void eliminarCurriculumTecnica (EntityManager em, Integer id);
    public CandidatoTecnica getCurriculumTecnica (EntityManager em, Integer id); 
    List<CandidatoTecnica> getCurriculumTecnicas (EntityManager em);
}