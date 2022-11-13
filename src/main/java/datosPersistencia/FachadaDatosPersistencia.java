/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosPersistencia;

import dominio.Comentario;
import dominio.Hashtag;
import dominio.Mensaje;
import dominio.Publicacion;
import dominio.Usuario;
import java.util.List;

/**
 *
 * @author Gael
 */
public class FachadaDatosPersistencia implements IDatosPersistencia {
    
    private IUsuariosDAO usuariosDAO;
    private IPublicacionesDAO publicacionesDAO;
    private IComentariosDAO comentariosDAO;
    private IMensajesDAO mensajesDAO;
    private IHashtagsDAO hashtagsDAO;

    public FachadaDatosPersistencia() {
       IConexionBD conexionBD= new ConexionBD();
       this.usuariosDAO= new UsuariosDAO(conexionBD);
       this.publicacionesDAO= new PublicacionesDAO(conexionBD);
       this.comentariosDAO= new ComentariosDAO(conexionBD);
       this.mensajesDAO= new MensajesDAO(conexionBD);
       this.hashtagsDAO= new HashtagsDAO(conexionBD);
    }
    
 
    @Override
    public Usuario registrarUsuario(Usuario usuario) {
       return usuariosDAO.registrar(usuario);
    }

    @Override
    public void editarPerfilUsuario(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario consultarUsuario(Usuario usuario) {
        return usuariosDAO.consultarUsuarioRegistrado(usuario.getEmail(), usuario.getContraseña());
    }

    @Override
    public Publicacion registrarPublicacion(Publicacion publicacion) {
        return publicacionesDAO.registrar(publicacion);
    }

    @Override
    public void eliminarPublicacion(Long idPublicacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editarPublicacion(Publicacion publicacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Publicacion consultarPublicacion(Publicacion publicacion) {
        return publicacionesDAO.consultarPublicacion(publicacion.getId());
    }
    
    @Override
    public Publicacion consultarPublicacionHashtag(Hashtag hashtag) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void registrarHashtag(Hashtag hashtag) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Hashtag consultarHashtag(Long idHashtag) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void registrarComentario(Comentario comentario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarComentario(Long idComentario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Comentario> consultarComentario(Long idPublicacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enviarMensaje(Mensaje mensaje) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Mensaje consultarMensaje(Long idNotificacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
