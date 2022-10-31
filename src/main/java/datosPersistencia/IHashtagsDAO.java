/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosPersistencia;

import dominio.Hashtag;

/**
 *
 * @author Gael
 */
public interface IHashtagsDAO {
    public void registrar(Hashtag hashtag);
    public Hashtag consultarHashtag(Long idHashtag);
}
