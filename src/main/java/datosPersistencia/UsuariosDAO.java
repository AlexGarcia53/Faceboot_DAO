/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosPersistencia;

import dominio.Usuario;
import excepciones.ErrorBusquedaUsuarioException;
import excepciones.ErrorGuardarUsuarioException;
import jakarta.persistence.*;


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
            throw new ErrorGuardarUsuarioException("No se pudo agregar al usuario");
        }
    }
    
    @Override
    public Usuario registrarFacebook(Usuario usuario){
        try {
            EntityManager em = this.conexion.crearConexion();
            System.out.println("prueba");
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
            return this.consultarUsuario(usuario.getEmail());
        } catch (Exception ex) {
            throw new ErrorGuardarUsuarioException("No se pudo agregar al usuario");
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
            String jpqlQuery = "FROM Usuario WHERE email = '"+correo+"'";
            TypedQuery query = em.createQuery(jpqlQuery, Usuario.class);
            return (Usuario) query.getSingleResult();
        } catch (Exception ex) {
            throw new ErrorBusquedaUsuarioException("No se pudo buscar al usuario con email: " + correo);
        }
    } 
    
    @Override
    public Usuario consultarUsuarioPorAToken(String atoken) {
        try {
            EntityManager em = this.conexion.crearConexion();
            String jpqlQuery = "FROM Usuario WHERE token = '"+atoken+"'";
            TypedQuery query = em.createQuery(jpqlQuery, Usuario.class);
            try{
                return (Usuario) query.getSingleResult();
            } catch(NoResultException ex) {
                return null;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new ErrorBusquedaUsuarioException("No se pudo buscar al usuario con access token: " + atoken);
        }
    } 
    
    @Override
    public Usuario consultarUsuarioRegistrado(String correo, String contrasenia) {
        try {
            EntityManager em = this.conexion.crearConexion();
            String jpqlQuery = "FROM Usuario WHERE email = '"+correo+"' AND contrasenia = '"+contrasenia+"'";
            TypedQuery query = em.createQuery(jpqlQuery, Usuario.class);
            return (Usuario) query.getSingleResult();
        } catch (Exception ex) {
            throw new ErrorBusquedaUsuarioException("No se pudo encontrar al usuario");
        }
    }
}
