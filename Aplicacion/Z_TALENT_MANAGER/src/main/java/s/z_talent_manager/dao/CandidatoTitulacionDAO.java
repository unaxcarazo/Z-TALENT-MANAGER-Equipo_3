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
public interface CandidatoTitulacionDAO {
  public CandidatoTitulacion nuevoCandidatoTitulacion (EntityManager em, CandidatoTitulacion cti);
    public void modificarCandidatoTitulacion (EntityManager em, CandidatoTitulacion cti);
    public void eliminarCandidatoTitulacion (EntityManager em, Integer id);
    public CandidatoTitulacion getCandidatoTitulacion (EntityManager em, Integer id); 
    List<CandidatoTitulacion> getCandidatoTitulaciones (EntityManager em);
}
