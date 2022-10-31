/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosPersistencia;

import dominio.Mensaje;



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
    public void registrar(Mensaje mensaje) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Mensaje consultar(Long idMensaje) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
