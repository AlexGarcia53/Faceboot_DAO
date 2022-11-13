/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosPersistencia;

import dominio.Hashtag;
import dominio.Publicacion;
import excepciones.ErrorGuardarPublicacionException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

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
            EntityManager em = this.conexion.crearConexion();
            String jpqlQuery = "FROM Publicacion WHERE id = '"+id+"'";
            TypedQuery query = em.createQuery(jpqlQuery, Publicacion.class);
            return (Publicacion) query.getSingleResult();
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
    
}
