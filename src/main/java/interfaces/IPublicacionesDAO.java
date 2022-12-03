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

    /**
     * Método utilizado para registrar una publicación.
     *
     * @param publicacion publicación a registrar.
     * @return publicación registrada.
     */
    public Publicacion registrar(Publicacion publicacion);

    /**
     * Método utilizado para editar una publicación.
     *
     * @param publicacion publicación a editar.
     * @return publicacion editada.
     */
    public Publicacion editar(Publicacion publicacion);

    /**
     * Método utilizado para consultar una publicación.
     *
     * @param publicacion publicación a consultar.
     * @return publicación consultada.
     */
    public Publicacion consultarPublicacion(Long id);

    /**
     * Método utilizado para consultar publicaciones.
     *
     * @return lista de publicaciones.
     */
    public List<Publicacion> consultarPublicaciones();

    /**
     * Método utilizado para eliminar una publicación.
     *
     * @param publicacion publicación a eliminar.
     * @return publicacion eliminada.
     */
    public Publicacion eliminar(Publicacion publicacion);

}
