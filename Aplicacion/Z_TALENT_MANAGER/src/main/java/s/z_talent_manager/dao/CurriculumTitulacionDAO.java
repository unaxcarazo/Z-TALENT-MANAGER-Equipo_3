/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package s.z_talent_manager.dao;

import jakarta.persistence.EntityManager;
import java.util.List;
import s.z_talent_manager.modelo.CandidatoTitulacion;

/**
 *
 * @author DAW1
 */
public interface CurriculumTitulacionDAO {
  public CandidatoTitulacion nuevoCurriculumTitulacion (EntityManager em, CandidatoTitulacion cti);
    public void modificarCurriculumTitulacion (EntityManager em, CandidatoTitulacion cti);
    public void eliminarCurriculumTitulacion (EntityManager em, Integer id);
    public CandidatoTitulacion getCurriculumTitulacion (EntityManager em, Integer id); 
    List<CandidatoTitulacion> getCurriculumTitulaciones (EntityManager em);
}
