/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosPersistencia;

import interfaces.IConexionBD;
import interfaces.IUsuariosDAO;
import dominio.Publicacion;
import dominio.Usuario;
import excepciones.ErrorBusquedaUsuarioException;
import excepciones.ErrorEditarUsuarioException;
import excepciones.ErrorGuardarUsuarioException;
import jakarta.persistence.*;

/**
 * Clase que realiza todas las operaciones de base de datos para la entidad de
 * usuarios.
 *
 * @author Equipo Broker.
 */
public class UsuariosDAO implements IUsuariosDAO {

    /**
     * Atributo utilizado para crear una conexión.
     */
    private IConexionBD conexion;

    /**
     * Constructor que inicializa el atributo de la clase.
     *
     * @param conexion conexión a base de datos.
     */
    public UsuariosDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }

    /**
     * Método utilizado para registrar a un usuario.
     *
     * @param usuario usuario a registrar.
     * @return usuario registrado.
     */
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

    /**
     * Método utilizado para registrar a un usuario.
     *
     * @param usuario usuario a registrar a un usuario por facebook.
     * @return usuario registrado.
     */
    @Override
    public Usuario registrarFacebook(Usuario usuario) {
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

    /**
     * Método utilizado consultar a un usuario.
     *
     * @param idUsuario usuario a consultar.
     * @return usuario consultado.
     */
    @Override
    public Usuario consultarUsuario(Long idUsuario) {
        try {
            EntityManager em = this.conexion.crearConexion();
            return em.find(Usuario.class, idUsuario);
        } catch (Exception e) {
            throw new ErrorBusquedaUsuarioException(e.getMessage());
        }
    }

    /**
     * Método utilizado para editar a un usuario.
     *
     * @param usuario usuario a editar.
     * @return usuario editado.
     */
    @Override
    public Usuario editar(Usuario usuario) {
        try {
            EntityManager em = this.conexion.crearConexion();
            em.getTransaction().begin();
            em.merge(usuario);
            em.getTransaction().commit();
            return this.consultarUsuario(usuario.getId());
        } catch (Exception e) {
            throw new ErrorEditarUsuarioException(e.getMessage());
        }
    }

    /**
     * Método utilizado consultar a un usuario por correo.
     *
     * @param correo usuario a consultar.
     * @return usuario consultado.
     */
    @Override
    public Usuario consultarUsuario(String correo) {
        try {
            EntityManager em = this.conexion.crearConexion();
            String jpqlQuery = "FROM Usuario WHERE email = '" + correo + "'";
            TypedQuery query = em.createQuery(jpqlQuery, Usuario.class);
            return (Usuario) query.getSingleResult();
        } catch (Exception ex) {
            throw new ErrorBusquedaUsuarioException("No se pudo encontrar al usuario con email: " + correo);
        }
    }

    /**
     * Método utilizado consultar a un usuario por token.
     *
     * @param token usuario a consultar.
     * @return usuario consultado.
     */
    @Override
    public Usuario consultarUsuarioPorAToken(String token) {
        try {

            EntityManager em = this.conexion.crearConexion();
            String jpqlQuery = "FROM Usuario WHERE token = '" + token + "'";
            TypedQuery query = em.createQuery(jpqlQuery, Usuario.class);
            if (query.getResultList().isEmpty()) {
                return null;
            } else {
                return (Usuario) query.getSingleResult();
            }
        } catch (NoResultException ex) {
            System.out.println(ex.getMessage());
            throw new ErrorBusquedaUsuarioException("No se pudo encontrar al usuario con access token: " + token);
        }
    }

    /**
     * Método utilizado consultar a un usuario por correo y contraseña.
     *
     * @param correo usuario a consultar.
     * @param contrasenia usuario a consultar.
     * @return usuario consultado.
     */
    @Override
    public Usuario consultarUsuarioRegistrado(String correo, String contrasenia) {
        try {
            EntityManager em = this.conexion.crearConexion();
            String jpqlQuery = "FROM Usuario WHERE email = '" + correo + "' AND contrasenia = '" + contrasenia + "'";
            TypedQuery query = em.createQuery(jpqlQuery, Usuario.class);
            return (Usuario) query.getSingleResult();
        } catch (Exception ex) {
            throw new ErrorBusquedaUsuarioException("No se pudo encontrar al usuario");
        }
    }

    /**
     * Método utilizado consultar a un usuario por nombre.
     *
     * @param nombre usuario a consultar.
     * @return usuario consultado.
     */
    @Override
    public Usuario consultarUsuarioNombre(String nombre) {
        try {
            EntityManager em = this.conexion.crearConexion();
            String jpqlQuery = "FROM Usuario WHERE usuario = '" + nombre + "'";
            TypedQuery query = em.createQuery(jpqlQuery, Usuario.class);
            return (Usuario) query.getSingleResult();
        } catch (Exception ex) {
            throw new ErrorBusquedaUsuarioException("No se pudo encontrar al usuario: " + nombre);
        }
    }
}
