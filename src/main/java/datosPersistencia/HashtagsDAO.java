/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosPersistencia;

import dominio.Hashtag;
import dominio.Publicacion;
import excepciones.ErrorConsultarHashtagException;
import excepciones.ErrorGuardarHashtagException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gael
 */
public class HashtagsDAO implements IHashtagsDAO {

    private IConexionBD conexion;

    public HashtagsDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }
    
    @Override
    public Hashtag registrar(Hashtag hashtag) {
        try {
            System.out.println(hashtag.toString());
            EntityManager em = this.conexion.crearConexion();
            em.getTransaction().begin();
            em.persist(hashtag);
            em.getTransaction().commit();
            return this.consultarHashtag(hashtag.getId());
        } catch (Exception ex) {
            throw new ErrorGuardarHashtagException("No se pudo registrar el hashtag"+ ex.getClass()+", "+ex.getMessage());
        }
    }

    @Override
    public Hashtag consultarHashtag(Long idHashtag) {
        try {
            EntityManager em = this.conexion.crearConexion();
            
            return em.find(Hashtag.class, idHashtag);
            
        } catch (Exception ex) {
            throw new ErrorConsultarHashtagException("No se pudo encontar el hashtag: " + idHashtag);
        }
    }

    @Override
    public List<Hashtag> consultarHashtagNombre(String hashtag) {
        try {
            EntityManager em = this.conexion.crearConexion();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT h FROM Hashtag h WHERE h.nombre= :nombre").setParameter("nombre", hashtag); //ORDER BY p.id DESC

            List<Hashtag> hashtags = new ArrayList<>();
            return hashtags = query.getResultList();
        } catch (Exception ex) {
            throw new ErrorConsultarHashtagException("No se pudo encontar el hashtag: " + hashtag);
        }
    } 
}
