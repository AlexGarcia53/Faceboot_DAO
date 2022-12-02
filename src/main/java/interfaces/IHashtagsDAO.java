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
    public Hashtag registrar(Hashtag hashtag);
    public Hashtag consultarHashtag(Long idHashtag);
    public List<Hashtag> consultarHashtagNombre(String hashtag);
}
