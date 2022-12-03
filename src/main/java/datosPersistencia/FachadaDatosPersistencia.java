/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosPersistencia;

import interfaces.IComentariosDAO;
import interfaces.IConexionBD;
import interfaces.IDatosPersistencia;
import interfaces.IHashtagsDAO;
import interfaces.IMensajesDAO;
import interfaces.IPublicacionesDAO;
import interfaces.IUsuariosDAO;
import dominio.Comentario;
import dominio.Hashtag;
import dominio.Mensaje;
import dominio.Publicacion;
import dominio.Usuario;
import java.util.List;

/**
 * Clase Fachada que implementa la interfaz de IDatosPersistencia.
 * 
 * @author Equipo Broker.
 */
public class FachadaDatosPersistencia implements IDatosPersistencia {
    /**
     * Atributo de tipo IUsuariosDAO.
     */
    private IUsuariosDAO usuariosDAO;
        /**
     * Atributo de tipo IPublicacionesDAO.
     */
    private IPublicacionesDAO publicacionesDAO;
    /**
     * Atributo de tipo IComentariosDAO.
     */
    private IComentariosDAO comentariosDAO;
    /**
     * Atributo de tipo IMensajesDAO.
     */
    private IMensajesDAO mensajesDAO;
    /**
     * Atributo de tipo IHashtagsDAO.
     */
    private IHashtagsDAO hashtagsDAO;
    
    /**
     * Constructor que inicializa los atributos de la clase.
     */
    public FachadaDatosPersistencia() {
       IConexionBD conexionBD= new ConexionBD();
       this.usuariosDAO= new UsuariosDAO(conexionBD);
       this.publicacionesDAO= new PublicacionesDAO(conexionBD);
       this.comentariosDAO= new ComentariosDAO(conexionBD);
       this.mensajesDAO= new MensajesDAO(conexionBD);
       this.hashtagsDAO= new HashtagsDAO(conexionBD);
    }
    
    /**
     * Método utilizado para registrar a un usuario.
     * @param usuario usuario a registrar.
     * @return usuario registrado.
     */
    @Override
    public Usuario registrarUsuario(Usuario usuario) {
       return usuariosDAO.registrar(usuario);
    }
    /**
     * Método utilizado para registrar a un usuario.
     * @param usuario usuario a registrar a un usuario por facebook.
     * @return usuario registrado.
     */
    @Override
    public Usuario registrarUsuarioFacebook(Usuario usuario){
       return usuariosDAO.registrarFacebook(usuario);
    }
    /**
     * Método utilizado para editar a un usuario.
     * @param usuario usuario a editar.
     * @return usuario editado.
     */
    @Override
    public Usuario editarPerfilUsuario(Usuario usuario) {
        return usuariosDAO.editar(usuario);
    }
    /**
     * Método utilizado consultar a un usuario.
     * @param usuario usuario a consultar.
     * @return usuario consultado.
     */
    @Override
    public Usuario consultarUsuario(Usuario usuario) {
        return usuariosDAO.consultarUsuarioRegistrado(usuario.getEmail(), usuario.getContrasenia());
    }
    /**
     * Método utilizado para consultar por token.
     * @param usuario usuario a consultar.
     * @return usuario consultado.
     */
    @Override
    public Usuario consultarUsuarioPorAToken(Usuario usuario) {
        return usuariosDAO.consultarUsuarioPorAToken(usuario.getAtoken());
    }
    /**
     * Método utilizado para registrar una publicación.
     * @param publicacion publicación a registrar.
     * @return publicación registrada.
     */
    @Override
    public Publicacion registrarPublicacion(Publicacion publicacion) {
        return publicacionesDAO.registrar(publicacion);
    }
    /**
     * Método utilizado para eliminar una publicación.
     * @param publicacion publicación a eliminar.
     * @return publicacion eliminada.
     */
    @Override
    public Publicacion eliminarPublicacion(Publicacion publicacion) {
        return publicacionesDAO.eliminar(publicacion);
    }
    /**
     * Método utilizado para editar una publicación.
     * @param publicacion publicación a editar.
     * @return publicacion editada.
     */
    @Override
    public Publicacion editarPublicacion(Publicacion publicacion) {
        return publicacionesDAO.editar(publicacion);
    }
    /**
     * Método utilizado para consultar una publicación.
     * @param publicacion publicación a consultar.
     * @return publicación consultada.
     */
    @Override
    public Publicacion consultarPublicacion(Publicacion publicacion) {
        return publicacionesDAO.consultarPublicacion(publicacion.getId());
    }

    /**
     * Método utilizado para registrar un hashtag.
     * @param hashtag hashtag a registrar.
     * @return hashtag registrado.
     */
    @Override
    public Hashtag registrarHashtag(Hashtag hashtag) {
        return hashtagsDAO.registrar(hashtag);
    }
    /**
     * Método utilizada para consultar un hashtag.
     * @param idHashtag id del hashtag.
     * @return hashtag consultado.
     */
    @Override
    public Hashtag consultarHashtag(Long idHashtag) {
        return hashtagsDAO.consultarHashtag(idHashtag);
    }
    /**
     * Método utilizado para registrar un comentario.
     * @param comentario comentario a registrar.
     * @return comentario registrado.
     */
    @Override
    public Comentario registrarComentario(Comentario comentario) {
        return comentariosDAO.registrar(comentario);
    }
    /**
     * Método utilizado para eliminar un comentario.
     * @param comentario comentario a eliminar.
     * @return comentario eliminado.
     */
    @Override
    public Comentario eliminarComentario(Comentario comentario) {
        return comentariosDAO.eliminar(comentario);
    }
    /**
     * Método utilizado para editar un comentario.
     * @param comentario comentario a editar.
     * @return comentario editado.
     */
    @Override
    public Comentario editarComentario(Comentario comentario) {
        return comentariosDAO.editar(comentario);
    }
    /**
     * Método para consultar comentario.
     * @param idComentario id del comentario a consultar.
     * @return comentario consultado
     */
    @Override
    public Comentario consultarComentario(Long idComentario) {
        return comentariosDAO.consultarComentario(idComentario);
    }
    /**
     * Método para enviar un mensaje.
     * @param mensaje mensaje a enviar.
     * @return mensaje que fue enviado.
     */
    @Override
    public Mensaje enviarMensaje(Mensaje mensaje) {
        return mensajesDAO.registrar(mensaje);
    }
    /**
     * Método utilizado para consultar un mensaje.
     * @param idNotificacion id del mensaje.
     * @return mensaje consultado.
     */
    @Override
    public Mensaje consultarMensaje(Long idNotificacion) {
        return mensajesDAO.consultar(idNotificacion);
    }
    /**
     * Método utilizado para consultar publicaciones.
     * @return lista de publicaciones.
     */
    @Override
    public List<Publicacion> consultarPublicaciones() {
        return publicacionesDAO.consultarPublicaciones();
    }
    /**
     * Método para consultar a usuario por nombre.
     * @param usuario usuario a consultar.
     * @return usuario consultado.
     */
    @Override
    public Usuario consultarUsuarioNombre(Usuario usuario) {
        return usuariosDAO.consultarUsuarioNombre(usuario.getUsuario());
    }
    /**
     * Método para consultar hashtags por nombre.
     * @param hashtag nombre del hashtag.
     * @return hashtag consultado.
     */
    @Override
    public List<Hashtag> consultarHashtagNombre(String hashtag) {
        return hashtagsDAO.consultarHashtagNombre(hashtag);
    }
    
}
