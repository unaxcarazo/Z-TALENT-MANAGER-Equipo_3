/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s.z_talent_manager.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import s.z_talent_manager.modelo.Usuario;

/**
 *
 * @author DAW1
 */
public class Usuarioimpl implements UsuarioDAO {

    @Override
    public Usuario getUsuarioPorEmail(EntityManager em, String email) {

    Query q = em.createQuery("""

                             SELECT u FROM Usuario u
                             WHERE u.email = :email
                             """);

    q.setParameter("email", email);
    return (Usuario) q.getSingleResultOrNull();

        }

    }
