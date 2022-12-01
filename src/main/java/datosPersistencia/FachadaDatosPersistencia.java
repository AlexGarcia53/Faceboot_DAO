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
    public Usuario registrarUsuarioFacebook(Usuario usuario){
       return usuariosDAO.registrarFacebook(usuario);
    }

    @Override
    public Usuario editarPerfilUsuario(Usuario usuario) {
        return usuariosDAO.editar(usuario);
    }

    @Override
    public Usuario consultarUsuario(Usuario usuario) {
        return usuariosDAO.consultarUsuarioRegistrado(usuario.getEmail(), usuario.getContrasenia());
    }
    
    @Override
    public Usuario consultarUsuarioPorAToken(Usuario usuario) {
        return usuariosDAO.consultarUsuarioPorAToken(usuario.getAtoken());
    }

    @Override
    public Publicacion registrarPublicacion(Publicacion publicacion) {
        return publicacionesDAO.registrar(publicacion);
    }

    @Override
    public Publicacion eliminarPublicacion(Publicacion publicacion) {
        return publicacionesDAO.eliminar(publicacion);
    }

    @Override
    public Publicacion editarPublicacion(Publicacion publicacion) {
        return publicacionesDAO.editar(publicacion);
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
    public Hashtag registrarHashtag(Hashtag hashtag) {
        return hashtagsDAO.registrar(hashtag);
    }

    @Override
    public Hashtag consultarHashtag(Long idHashtag) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Comentario registrarComentario(Comentario comentario) {
        return comentariosDAO.registrar(comentario);
    }

    @Override
    public Comentario eliminarComentario(Comentario comentario) {
        return comentariosDAO.eliminar(comentario);
    }
    
    @Override
    public Comentario editarComentario(Comentario comentario) {
        return comentariosDAO.editar(comentario);
    }

    @Override
    public List<Comentario> consultarComentario(Long idPublicacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Mensaje enviarMensaje(Mensaje mensaje) {
        return mensajesDAO.registrar(mensaje);
    }

    @Override
    public Mensaje consultarMensaje(Long idNotificacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Publicacion> consultarPublicaciones() {
        return publicacionesDAO.consultarPublicaciones();
    }

    @Override
    public Usuario consultarUsuarioNombre(Usuario usuario) {
        return usuariosDAO.consultarUsuarioNombre(usuario.getUsuario());
    }
    
}
