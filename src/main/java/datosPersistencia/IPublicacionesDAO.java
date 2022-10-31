/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosPersistencia;

import dominio.Hashtag;
import dominio.Publicacion;

/**
 *
 * @author Gael
 */
public interface IPublicacionesDAO {
    public void registrar(Publicacion publicacion);
    public Publicacion consultarPorHashtag(Hashtag hashtag);
    public void eliminar(Long idPublicacion);
    
}
