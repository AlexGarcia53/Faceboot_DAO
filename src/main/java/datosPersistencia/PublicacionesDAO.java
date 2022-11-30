/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosPersistencia;

import dominio.Hashtag;
import dominio.Publicacion;
import excepciones.ErrorBusquedaPublicacionesException;
import excepciones.ErrorBusquedaUsuarioException;
import excepciones.ErrorEliminarPublicacionException;
import excepciones.ErrorGuardarPublicacionException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gael
 */
public class PublicacionesDAO implements IPublicacionesDAO {

    private IConexionBD conexion;

    public PublicacionesDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }

    @Override
    public Publicacion registrar(Publicacion publicacion) {
        try {
            System.out.println(publicacion.toString());
            EntityManager em = this.conexion.crearConexion();
            System.out.println("prueba");
            em.getTransaction().begin();
            em.persist(publicacion);
            em.getTransaction().commit();
            return this.consultarPublicacion(publicacion.getId());
        } catch (Exception ex) {
            throw new ErrorGuardarPublicacionException("No se pudo registrar la publicación"+ ex.getClass()+", "+ex.getMessage());
        }
    }
    
    @Override
    public Publicacion consultarPublicacion(Long id) {
        try {
            System.out.println("Entro a consultar, id:"+id);
            EntityManager em = this.conexion.crearConexion();
            
            return em.find(Publicacion.class, id);
            
        } catch (Exception ex) {
            throw new ErrorGuardarPublicacionException("No se pudo buscar la publicación: " + id);
        }
    }

    @Override
    public Publicacion consultarPorHashtag(Hashtag hashtag) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Publicacion eliminar(Publicacion publicacion) {
        try {
            System.out.println("Llegó a eliminar publicación");
            EntityManager em = this.conexion.crearConexion();
            em.getTransaction().begin();
            Publicacion instancia= em.merge(publicacion);
            em.remove(instancia);
            em.getTransaction().commit();
            return instancia;
        } catch (Exception ex) {
            throw new ErrorEliminarPublicacionException("No se pudo eliminar la publicación,"+ex.getClass()+", "+ex.getMessage());
        }
    }

    @Override
    public List<Publicacion> consultarPublicaciones() {
        try {
            System.out.println("Entro a consultar publicaciones");
            EntityManager em = this.conexion.crearConexion();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT p FROM Publicacion p"); //ORDER BY p.id DESC

            List<Publicacion> publicaciones = new ArrayList<>();
            return publicaciones = query.getResultList();

        } catch (Exception ex) {
            throw new ErrorBusquedaPublicacionesException(ex.getClass()+", "+ex.getMessage());
        }
    }

    @Override
    public Publicacion editar(Publicacion publicacion) {
        try {
            EntityManager em = this.conexion.crearConexion();
            em.getTransaction().begin();
            em.merge(publicacion);
            em.getTransaction().commit();
            return this.consultarPublicacion(publicacion.getId());
        } catch (Exception ex) {
            throw new ErrorGuardarPublicacionException("No se pudo editar la publicación,"+ex.getClass()+", "+ex.getMessage());
        }
    }
    
}
