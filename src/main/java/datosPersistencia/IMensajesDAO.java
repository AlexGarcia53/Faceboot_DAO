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
public interface IMensajesDAO {
     public Mensaje registrar(Mensaje mensaje);
     public Mensaje consultar( Long idMensaje);
}
