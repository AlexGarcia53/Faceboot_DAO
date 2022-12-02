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
     public Mensaje registrar(Mensaje mensaje);
     public Mensaje consultar( Long idMensaje);
}
