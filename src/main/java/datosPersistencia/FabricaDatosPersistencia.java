/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosPersistencia;

import interfaces.IDatosPersistencia;

/**
 * Clase que crea una instancia de FachadaDatosPersistencia.
 * 
 * @author Equipo Broker.
 */
public class FabricaDatosPersistencia {
    /**
     * Instancia de IDatosPersistencia.
     */
    private static IDatosPersistencia datosPersistencia;
    /**
     * Método que devuelve una FachadaDatosPersistencia.
     * @return FachadaDatosPersistencia.
     */
    public static IDatosPersistencia crearFachadaDatos(){
        return new FachadaDatosPersistencia();
    }
}
