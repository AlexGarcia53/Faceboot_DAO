/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosPersistencia;

import dominio.Usuario;
import jakarta.persistence.EntityManager;

/**
 *
 * @author Gael
 */
public class UsuariosDAO implements IUsuariosDAO {
    
    private IConexionBD conexion;

    public UsuariosDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }

    @Override
    public Usuario registrar(Usuario usuario) {
        try {
            System.out.println("Método registrar usuario");
            System.out.println(usuario.toString());
            EntityManager em = this.conexion.crearConexion();
            System.out.println("prueba");
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
            return this.consultarUsuario(usuario.getEmail());
        } catch (Exception ex) {
            System.out.println("No se pudo agregar al usuario");
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Usuario consultarUsuario(Long idUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario consultarUsuario(String correo) {
        try {
            EntityManager em = this.conexion.crearConexion();
            return em.find(Usuario.class, correo);
        } catch (Exception ex) {
            System.err.println("No se pudo buscar al usuario con email: " + correo);
            ex.printStackTrace();
            return null;
        }
    }
    
}
