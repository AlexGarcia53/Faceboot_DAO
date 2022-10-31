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
public class HashtagsDAO implements IHashtagsDAO {

    private IConexionBD conexion;

    public HashtagsDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }
    
    @Override
    public void registrar(Hashtag hashtag) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Hashtag consultarHashtag(Long idHashtag) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
