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
public interface CandidatoTecnicaDAO {
 public CandidatoTecnica nuevoCandidatoTecnica (EntityManager em, CandidatoTecnica cte);
    public void modificarCandidatoTecnica (EntityManager em, CandidatoTecnica cte);
    public void eliminarCandidatoTecnica (EntityManager em, Integer id);
    public CandidatoTecnica getCandidatoTecnica (EntityManager em, Integer id); 
    List<CandidatoTecnica> getCandidatoTecnicas (EntityManager em);
}