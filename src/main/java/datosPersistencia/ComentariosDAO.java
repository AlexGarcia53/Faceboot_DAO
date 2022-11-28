/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosPersistencia;

import dominio.Comentario;
import excepciones.ErrorEditarComentarioException;
import excepciones.ErrorGuardarComentarioException;
import jakarta.persistence.EntityManager;
import java.util.List;

/**
 *
 * @author Gael
 */
public class ComentariosDAO implements IComentariosDAO {

    private IConexionBD conexion;

    public ComentariosDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }
    
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
    
    public Comentario consultarComentario(Long id){
        try {
            EntityManager em = this.conexion.crearConexion();
            
            return em.find(Comentario.class, id);
            
        } catch (Exception ex) {
            throw new ErrorGuardarComentarioException("No se pudo encontrar el comentario");
        }
    }

    @Override
    public List<Comentario> consultarComentarios(Long idPublicacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Comentario eliminar(Comentario comentario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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
