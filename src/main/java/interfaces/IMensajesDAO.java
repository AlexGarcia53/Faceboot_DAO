/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dominio.Mensaje;

/**
 * Interfaz que implementa la clase MensajesDAO.
 *
 * @author Equipo Broker.
 */
public interface IMensajesDAO {

    /**
     * Método para enviar un mensaje.
     *
     * @param mensaje mensaje a enviar.
     * @return mensaje que fue enviado.
     */
    public Mensaje registrar(Mensaje mensaje);

    /**
     * Método utilizado para consultar un mensaje.
     *
     * @param idNotificacion id del mensaje.
     * @return mensaje consultado.
     */
    public Mensaje consultar(Long idMensaje);
}
