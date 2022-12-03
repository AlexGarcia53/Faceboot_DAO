/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dominio.Hashtag;
import java.util.List;

/**
 * Interfaz que implementa la clase HashtagsDAO.
 *
 * @author Equipo Broker.
 */
public interface IHashtagsDAO {

    /**
     * Método utilizado para registrar un hashtag.
     *
     * @param hashtag hashtag a registrar.
     * @return hashtag registrado.
     */
    public Hashtag registrar(Hashtag hashtag);

    /**
     * Método utilizado para registrar un hashtag.
     *
     * @param idHashtag hashtag a registrar.
     * @return hashtag registrado.
     */
    public Hashtag consultarHashtag(Long idHashtag);

    /**
     * Método utilizado para consultar los hashtags por nombre.
     *
     * @param hashtag hashtag a consultar.
     * @return hashtag consultado.
     */
    public List<Hashtag> consultarHashtagNombre(String hashtag);
}
