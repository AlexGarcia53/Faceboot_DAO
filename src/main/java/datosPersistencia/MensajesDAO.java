/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosPersistencia;

import interfaces.IConexionBD;
import interfaces.IMensajesDAO;
import dominio.Mensaje;
import excepciones.ErrorBusquedaMensajeException;
import excepciones.ErrorEnviarMensajeException;
import jakarta.persistence.EntityManager;



/**
 * Clase que realiza todas las operaciones de base de datos para la entidad 
 * de mensaje.
 * 
 * @author Equipo Broker.
 */
public class MensajesDAO implements IMensajesDAO {
        /**
     * Atributo utilizado para crear una conexión.
     */
    private IConexionBD conexion;
    /**
     * Constructor que inicializa el atributo de la clase.
     * @param conexion conexión a base de datos.
     */
    public MensajesDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }
    /**
     * Método para enviar un mensaje.
     * @param mensaje mensaje a enviar.
     * @return mensaje que fue enviado.
     */
    @Override
    public Mensaje registrar(Mensaje mensaje) {
        try{
            EntityManager em = this.conexion.crearConexion();
            em.getTransaction().begin();
            em.persist(mensaje);
            em.getTransaction().commit();
            return this.consultar(mensaje.getId());
        } catch (Exception ex) {
            throw new ErrorEnviarMensajeException("No se pudo registrar el envío del mensaje");
        }
    }
    /**
     * Método utilizado para consultar un mensaje.
     * @param idNotificacion id del mensaje.
     * @return mensaje consultado.
     */
    @Override
    public Mensaje consultar(Long idMensaje) {
        try{
            EntityManager em = this.conexion.crearConexion();
            return em.find(Mensaje.class, idMensaje);
        } catch(Exception e){
            throw new ErrorBusquedaMensajeException(e.getMessage());
        }
    }
   
}
