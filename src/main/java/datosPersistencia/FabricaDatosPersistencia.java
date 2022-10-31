/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosPersistencia;

/**
 *
 * @author Gael
 */
public class FabricaDatosPersistencia {

    private static IDatosPersistencia datosPersistencia;

    public static IDatosPersistencia crearFachadaDatos(){
        return new FachadaDatosPersistencia();
    }
}
