/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosPersistencia;

import dominio.Hashtag;
import dominio.Publicacion;
import java.util.List;

/**
 *
 * @author Gael
 */
public interface IPublicacionesDAO {
    public Publicacion registrar(Publicacion publicacion);
    public Publicacion editar(Publicacion publicacion);
    public Publicacion consultarPublicacion(Long id);
    public Publicacion consultarPorHashtag(Hashtag hashtag);
    public List<Publicacion> consultarPublicaciones();
    public Publicacion eliminar(Publicacion publicacion);
    
}
