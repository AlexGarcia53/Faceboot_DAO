/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosPersistencia;

import interfaces.IConexionBD;
import interfaces.IHashtagsDAO;
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
 * Clase que realiza todas las operaciones de base de datos para la entidad 
 * de hashtag.
 * 
 * @author Equipo Broker.
 */
public class HashtagsDAO implements IHashtagsDAO {
    /**
     * Atributo utilizado para crear una conexión.
     */
    private IConexionBD conexion;
    /**
     * Constructor que inicializa el atributo de la clase.
     * @param conexion conexión a base de datos.
     */
    public HashtagsDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }
    /**
     * Método utilizado para registrar un hashtag.
     * @param hashtag hashtag a registrar.
     * @return hashtag registrado.
     */
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
    /**
     * Método utilizado para registrar un hashtag.
     * @param idHashtag hashtag a registrar.
     * @return hashtag registrado.
     */
    @Override
    public Hashtag consultarHashtag(Long idHashtag) {
        try {
            EntityManager em = this.conexion.crearConexion();
            
            return em.find(Hashtag.class, idHashtag);
            
        } catch (Exception ex) {
            throw new ErrorConsultarHashtagException("No se pudo encontar el hashtag: " + idHashtag);
        }
    }
    /**
     * Método utilizado para consultar los hashtags por nombre.
     * @param hashtag hashtag a consultar.
     * @return hashtag consultado.
     */
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
