/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosPersistencia;

import interfaces.IComentariosDAO;
import interfaces.IConexionBD;
import dominio.Comentario;
import excepciones.ErrorEditarComentarioException;
import excepciones.ErrorEliminarComentarioException;
import excepciones.ErrorGuardarComentarioException;
import jakarta.persistence.EntityManager;

/**
 * Clase que realiza todas las operaciones de base de datos para la entidad 
 * de comentario.
 * 
 * @author Equipo Broker.
 */
public class ComentariosDAO implements IComentariosDAO {
    /**
     * Atributo utilizado para crear una conexión.
     */
    private IConexionBD conexion;
    /**
     * Constructor que inicializa el atributo de la clase.
     * @param conexion conexión a base de datos.
     */
    public ComentariosDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }
    /**
     * Método utilizado para registrar un comentario.
     * @param comentario comentario a registrar.
     * @return comentario registrado.
     */
    @Override
    public Comentario registrar(Comentario comentario) {
        try {
            System.out.println("Llegó a registar comentario");
            EntityManager em = this.conexion.crearConexion();
            em.getTransaction().begin();
            em.persist(comentario);
            em.getTransaction().commit();
            return this.consultarComentario(comentario.getId());
        } catch (Exception ex) {
            throw new ErrorGuardarComentarioException("No se pudo registrar el comentario: "+ex.getClass()+", "+ex.getMessage());
        }
    }
    /**
     * Método para consultar comentario.
     * @param id ide del comentario.
     * @return comentario consultado.
     */
    @Override
    public Comentario consultarComentario(Long id){
        try {
            EntityManager em = this.conexion.crearConexion();
            
            return em.find(Comentario.class, id);
            
        } catch (Exception ex) {
            throw new ErrorGuardarComentarioException("No se pudo encontrar el comentario");
        }
    }

    /**
     * Método utilizado para eliminar un comentario.
     * @param comentario comentario a eliminar.
     * @return comentario eliminado.
     */
    @Override
    public Comentario eliminar(Comentario comentario) {
        try {
            System.out.println("Llegó a eliminar comentario");
            EntityManager em = this.conexion.crearConexion();
            em.getTransaction().begin();
            Comentario instancia= em.find(Comentario.class, comentario.getId());
            em.createQuery("DELETE FROM Comentario WHERE id= :id").setParameter("id", instancia.getId()).executeUpdate();
            em.getTransaction().commit();
            return instancia;
        } catch (Exception ex) {
            throw new ErrorEliminarComentarioException("No se pudo eliminar el comentario,"+ex.getClass()+", "+ex.getMessage());
        }
    }
    /**
     * Método utilizado para editar un comentario.
     * @param comentario comentario a editar.
     * @return comentario editado.
     */
    @Override
    public Comentario editar(Comentario comentario) {
        try {
            EntityManager em = this.conexion.crearConexion();
            em.getTransaction().begin();
            em.merge(comentario);
            em.getTransaction().commit();
            return this.consultarComentario(comentario.getId());
        } catch (Exception ex) {
            throw new ErrorEditarComentarioException("No se pudo editar el comentario,"+ex.getClass()+", "+ex.getMessage());
        }
    }
    
}
