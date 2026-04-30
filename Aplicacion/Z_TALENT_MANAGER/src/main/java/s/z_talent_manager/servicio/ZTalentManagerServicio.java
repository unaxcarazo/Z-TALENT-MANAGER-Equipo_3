/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s.z_talent_manager.servicio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;
import s.z_talent_manager.dao.CandidatoDAO;
import s.z_talent_manager.dao.CandidatoImpl;
import s.z_talent_manager.dao.CandidatoIdiomaImpl;
import s.z_talent_manager.dao.CandidatoTecnicaImpl;
import s.z_talent_manager.dao.CandidatoTitulacionImpl;
import s.z_talent_manager.dao.CandidatoTransversalImpl;
import s.z_talent_manager.dao.ExperienciaDAO;
import s.z_talent_manager.dao.ExperienciaImpl;
import s.z_talent_manager.modelo.Candidato;
import s.z_talent_manager.util.JPAUtil;
import s.z_talent_manager.util.PasswordUtils;
import s.z_talent_manager.dao.CandidatoIdiomaDAO;
import s.z_talent_manager.dao.CandidatoTecnicaDAO;
import s.z_talent_manager.dao.CandidatoTitulacionDAO;
import s.z_talent_manager.dao.CandidatoTransversalDAO;

/**
 *
 * @author DAW1
 */
public class ZTalentManagerServicio {
    
    private CandidatoDAO candidatoDAO;
    private CandidatoIdiomaDAO curriculumIdiomaDAO;
    private CandidatoTecnicaDAO curriculumTecnicaDAO;
    private CandidatoTitulacionDAO curriculumTitulacionDAO;
    private CandidatoTransversalDAO curriculumTransversalDAO;
    private ExperienciaDAO experienciaDAO;
    
    private static ZTalentManagerServicio servicio = null;
    
    public static ZTalentManagerServicio getServicio() {
        if (servicio == null) {
            servicio = new ZTalentManagerServicio();
        }
        return servicio;
    }
    
    private ZTalentManagerServicio() {
        candidatoDAO = new CandidatoImpl();
        curriculumIdiomaDAO = new CandidatoIdiomaImpl();
        curriculumTecnicaDAO = new CandidatoTecnicaImpl();
        curriculumTitulacionDAO = new CandidatoTitulacionImpl();
        curriculumTransversalDAO = new CandidatoTransversalImpl();
        experienciaDAO = new ExperienciaImpl();
    }

    /* CANDIDATO --Hiem */
 /* ===== Ver perfil desde candidato. =====
     - Candidato visualiza su perfil y curriculum. */
    public Candidato getCandidato(Integer idCandidato) {
        try (EntityManager em = JPAUtil.getEntityManager()) {
            return candidatoDAO.getCandidato(em, idCandidato);
        }
    }
    
    public List<Candidato> getCandidatos() {
        try (EntityManager em = JPAUtil.getEntityManager()) {
            return candidatoDAO.getCandidatos(em);
        }
    }

 /* ===== Cambio de contraseña desde candidato. =====
     - Lanza excepción si la contraseña actual introducida por el candidato es incorrecta.
     - Lanza excepción si la nueva contraseña es igual a la anterior. */
    public void cambiarContraseña(Integer idCandidato, String contraseñaActual, String contraseñaNueva) {
        try (EntityManager em = JPAUtil.getEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            try {
                Candidato c = candidatoDAO.getCandidato(em, idCandidato);
                
                if (!PasswordUtils.checkPw(contraseñaActual, c.getContraseña())) {
                    throw new RuntimeException(
                            "La contraseña actual no es correcta");
                }
                if (PasswordUtils.checkPw(contraseñaNueva, c.getContraseña())) {
                    throw new RuntimeException(
                            "La nueva contraseña no puede ser igual a la anterior");
                }
                
                c.setContraseña(PasswordUtils.getHash(contraseñaNueva));
                tx.begin();
                candidatoDAO.modificarCandidato(em, c);
                tx.commit();
            } catch (RuntimeException ex) {
                if (tx.isActive()) {
                    tx.rollback();
                }
                throw new RuntimeException(ex.getMessage());
            }
        }
    }

    /* ===== Editar Datos Personales del Candidato =====
     - Candidato modifica los campos de su cv desde su perfil. */
    public void modificarCandidato(EntityManager em, Candidato ca) {
          EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();
                em.merge(ca);
                tx.commit();
            } catch (Exception ex) {
                if (tx.isActive()) {
                    tx.rollback();
                }
                throw new RuntimeException(ex.getMessage());
                
                
            }
        }   
    
           
}
