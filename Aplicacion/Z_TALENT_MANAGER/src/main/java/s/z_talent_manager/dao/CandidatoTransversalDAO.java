/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package s.z_talent_manager.dao;

import jakarta.persistence.EntityManager;
import java.util.List;
import s.z_talent_manager.modelo.CandidatoTransversal;

/**
 *
 * @author DAW1
 */
public interface CandidatoTransversalDAO {
 public CandidatoTransversal nuevoCandidatoTransversal (EntityManager em, CandidatoTransversal ctr);
    public void modificarCandidatoTransversal (EntityManager em, CandidatoTransversal ctr);
    public void eliminarCandidatoTransversal (EntityManager em, Integer id);
    public CandidatoTransversal getCandidatoTransversal (EntityManager em, Integer id); 
    List<CandidatoTransversal> getCandidatoTransversales (EntityManager em);
}

