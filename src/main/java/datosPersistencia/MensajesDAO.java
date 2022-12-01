/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosPersistencia;

import dominio.Mensaje;
import excepciones.ErrorBusquedaMensajeException;
import excepciones.ErrorEnviarMensajeException;
import jakarta.persistence.EntityManager;



/**
 *
 * @author Gael
 */
public class MensajesDAO implements IMensajesDAO {

    private IConexionBD conexion;

    public MensajesDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }

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
