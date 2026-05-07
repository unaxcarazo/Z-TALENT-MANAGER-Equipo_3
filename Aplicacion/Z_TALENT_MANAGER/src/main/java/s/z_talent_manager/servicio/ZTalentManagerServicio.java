/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s.z_talent_manager.servicio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
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
import s.z_talent_manager.modelo.CandidatoTitulacion;
import s.z_talent_manager.modelo.CompetenciaTecnica;
import s.z_talent_manager.modelo.Idioma;
import s.z_talent_manager.modelo.Titulacion;
import s.z_talent_manager.modelo.Transversal;
import s.z_talent_manager.modelo.Usuario;

/**
 *
 * @author DAW1
 */
public class ZTalentManagerServicio {
    
    private CandidatoDAO candidatoDAO;
    private CandidatoIdiomaDAO candidatoIdiomaDAO;
    private CandidatoTecnicaDAO candidatoTecnicaDAO;
    private CandidatoTitulacionDAO candidatoTitulacionDAO;
    private CandidatoTransversalDAO candidatoTransversalDAO;
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
        candidatoIdiomaDAO = new CandidatoIdiomaImpl();
        candidatoTecnicaDAO = new CandidatoTecnicaImpl();
        candidatoTitulacionDAO = new CandidatoTitulacionImpl();
        candidatoTransversalDAO = new CandidatoTransversalImpl();
        experienciaDAO = new ExperienciaImpl();
        candidatoTitulacionDAO = new CandidatoTitulacionImpl();
    }

 /* ===== CANDIDATO =====
     - Candidato visualiza su perfil y curriculum. */
    public Candidato getCandidato(Integer idCandidato) {
    try (EntityManager em = JPAUtil.getEntityManager()) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin(); 
            
            Candidato c = candidatoDAO.getCandidato(em, idCandidato);
            
            tx.commit(); 
            return c;
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        }
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
    
    /* ---- USUARIO     */
    public Usuario login(String email, String password) {
   try (EntityManager em = JPAUtil.getEntityManager()) {
        Usuario usuario = em.createQuery(
                "SELECT u FROM Usuario u WHERE lower(u.email) = lower(:email)", 
                Usuario.class)
                .setParameter("email", email)
                .getSingleResult();

        if (PasswordUtils.checkPw(password, usuario.getContraseña())) {
            // Si es admin se devuelve el usuario directamente
            if (Boolean.TRUE.equals(usuario.getAdministrador())) {
                return usuario;
            }
            // Si es candidato se carga el candidato completo
            return getCandidato(usuario.getIdUsuario());
        }
        
        return null;
    } catch (NoResultException e) {
        return null;
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}
    
    /* ---- IDIOMA     */    
    public Idioma getIdiomaPorNombre(String nombre) {
    try (EntityManager em = JPAUtil.getEntityManager()) {
        return em.createQuery(
                "SELECT i FROM Idioma i WHERE i.nombre = :nom", 
                Idioma.class)
                 .setParameter("nom", nombre)
                 .getSingleResult();
    } catch (Exception e) {
        return null; // O maneja el error si el idioma no existe
    }
}

    /* ---- TITULACIÓN     */    
    public Titulacion getTitulacionPorNombre(String nombre) {
    try (EntityManager em = JPAUtil.getEntityManager()) {
        return em.createQuery(
            "SELECT t FROM Titulacion t WHERE t.nombreEstudio = :nom",
            Titulacion.class)
            .setParameter("nom", nombre)
            .getSingleResult();
    } catch (Exception e) {
        return null;
    }
}
    
    public List<Titulacion> getTitulaciones() {
    try (EntityManager em = JPAUtil.getEntityManager()) {
        return em.createQuery("SELECT t FROM Titulacion t", Titulacion.class)
                 .getResultList();
    }
}
    
    public void añadirTitulacion(CandidatoTitulacion ct) {
    try (EntityManager em = JPAUtil.getEntityManager()) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(ct);
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) tx.rollback();
            throw new RuntimeException(ex.getMessage());
        }
    }
}
    
    public void eliminarTitulacion(Integer idCandidatoTitulacion) {
    try (EntityManager em = JPAUtil.getEntityManager()) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            CandidatoTitulacion ct = em.find(
                CandidatoTitulacion.class, idCandidatoTitulacion);
            if (ct != null) em.remove(ct);
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) tx.rollback();
            throw new RuntimeException(ex.getMessage());
        }
    }
}
   
    /* ---- TÉCNICAS     */    
    public CompetenciaTecnica getCompetenciaTecnicaPorNombre(String nombre) {
    try (EntityManager em = JPAUtil.getEntityManager()) {
        return em.createQuery(
                "SELECT c FROM CompetenciaTecnica c WHERE c.nombre = :nom",
                CompetenciaTecnica.class)
                .setParameter("nom", nombre)
                .getSingleResult();
    } catch (Exception e) {
        return null;
    }
}

    /* ---- TRANSVERSAL     */    
    public Transversal getTransversalPorNombre(String nombre) {
        try (EntityManager em = JPAUtil.getEntityManager()) {
            return em.createQuery(
                    "SELECT t FROM Transversal t WHERE t.nombre = :nom",
                    Transversal.class)
                    .setParameter("nom", nombre)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
 
    /* ---- CANDIDATO MODIFICAR     */    
    public Candidato modificarCandidato(Candidato ca) { 
    try (EntityManager em = JPAUtil.getEntityManager()) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Candidato actualizado = em.merge(ca); 
            tx.commit();
            em.clear();
            return actualizado; 
        } catch (Exception ex) {
            if (tx.isActive()) tx.rollback();
            throw new RuntimeException(ex.getMessage());
        }
      finally {
            em.close();
    }
    }
    }
}   

