/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosPersistencia;

import interfaces.IConexionBD;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Clase que utilizada para realizar una conexión a base de datos.
 * 
 * @author Equipo Broker.
 */
public class ConexionBD implements IConexionBD {

    /**
     * Método que crea un objeto EntityManager.
     * @return EntityManager.
     * @throws IllegalStateException Excepción a lanzar.
     */
    @Override
    public EntityManager crearConexion() throws IllegalStateException {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("FaceBoot_DominioPU");
        EntityManager em = emFactory.createEntityManager();
        return em;
    }

}
