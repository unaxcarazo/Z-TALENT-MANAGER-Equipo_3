/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package s.z_talent_manager.dao;

import jakarta.persistence.EntityManager;
import java.util.List;
import s.z_talent_manager.modelo.CurriculumTransversal;

/**
 *
 * @author DAW1
 */
public interface CurriculumTransversalDAO {
 public CurriculumTransversal nuevoCurriculumTransversal (EntityManager em, CurriculumTransversal ctr);
    public void modificarCurriculumTransversal (EntityManager em, CurriculumTransversal ctr);
    public void eliminarCurriculumTransversal (EntityManager em, Integer id);
    public CurriculumTransversal getCurriculumTransversal (EntityManager em, Integer id); 
    List<CurriculumTransversal> getCurriculumTransversals (EntityManager em);
}

