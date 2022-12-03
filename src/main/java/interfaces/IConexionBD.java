/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import jakarta.persistence.EntityManager;
//import javax.persistence.EntityManager;

/**
 * Interfaz que implementa la clase ConexionBD.
 *
 * @author Equipo Broker.
 */
public interface IConexionBD {
    /**
     * Método que crea un objeto EntityManager.
     * @return EntityManager.
     * @throws IllegalStateException Excepción a lanzar.
     */
    public EntityManager crearConexion() throws IllegalStateException;

}
