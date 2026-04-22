/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package s.z_talent_manager.dao;

import jakarta.persistence.EntityManager;
import java.util.List;
import s.z_talent_manager.modelo.Curriculum;

/**
 *
 * @author DAW1
 */
public interface CurriculumDAO {
    public Curriculum nuevoCurriculum(EntityManager em, Curriculum cu);
    public void modificarCurriculum(EntityManager em, Curriculum cu);
    public void eliminarCurriculum(EntityManager em, Integer id);
    public Curriculum getCurriculum(EntityManager em, Integer id);
    List<Curriculum> getCurriculums(EntityManager em);
}
