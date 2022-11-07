/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosPersistencia;

import jakarta.persistence.EntityManager;
//import javax.persistence.EntityManager;

/**
 *
 * @author Gael
 */
public interface IConexionBD {

    public EntityManager crearConexion() throws IllegalStateException;

}
