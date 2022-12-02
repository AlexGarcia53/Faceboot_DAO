/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dominio.Hashtag;
import dominio.Publicacion;
import java.util.List;

/**
 * Interfaz que implementa la clase PublicacionesDAO.
 *
 * @author Equipo Broker.
 */
public interface IPublicacionesDAO {
    public Publicacion registrar(Publicacion publicacion);
    public Publicacion editar(Publicacion publicacion);
    public Publicacion consultarPublicacion(Long id);
    public Publicacion consultarPorHashtag(Hashtag hashtag);
    public List<Publicacion> consultarPublicaciones();
    public Publicacion eliminar(Publicacion publicacion);
    
}
