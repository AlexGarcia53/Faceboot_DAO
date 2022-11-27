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
            throw new ErrorGuardarPublicacionException("No se pudo registrar la publicación");
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
    public void eliminar(Long idPublicacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Publicacion> consultarPublicaciones() {
        try {
            System.out.println("Entro a consultar publicaciones");
            EntityManager em = this.conexion.crearConexion();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT p FROM Publicacion p");

            List<Publicacion> publicaciones = new ArrayList<>();
            return publicaciones = query.getResultList();

        } catch (Exception ex) {
            throw new ErrorBusquedaPublicacionesException(ex.getClass()+", "+ex.getMessage());
        }
    }
    
}
