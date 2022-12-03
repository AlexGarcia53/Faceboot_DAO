/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dominio.Comentario;
import dominio.Hashtag;
import dominio.Mensaje;
import dominio.Publicacion;
import dominio.Usuario;
import java.util.List;

/**
 * Interfaz que contiene todos las operaciones de las distintas entidades.
 *
 * @author Equipo Broker.
 */
public interface IDatosPersistencia {

    /**
     * Método utilizado para registrar a un usuario.
     *
     * @param usuario usuario a registrar.
     * @return usuario registrado.
     */
    public Usuario registrarUsuario(Usuario usuario);

    /**
     * Método utilizado para registrar a un usuario.
     *
     * @param usuario usuario a registrar a un usuario por facebook.
     * @return usuario registrado.
     */
    public Usuario registrarUsuarioFacebook(Usuario usuario);

    /**
     * Método utilizado para editar a un usuario.
     *
     * @param usuario usuario a editar.
     * @return usuario editado.
     */
    public Usuario editarPerfilUsuario(Usuario usuario);

    /**
     * Método utilizado consultar a un usuario.
     *
     * @param usuario usuario a consultar.
     * @return usuario consultado.
     */
    public Usuario consultarUsuario(Usuario usuario);

    /**
     * Método para consultar a usuario por nombre.
     *
     * @param usuario usuario a consultar.
     * @return usuario consultado.
     */
    public Usuario consultarUsuarioNombre(Usuario usuario);

    /**
     * Método utilizado para consultar por token.
     *
     * @param usuario usuario a consultar.
     * @return usuario consultado.
     */
    public Usuario consultarUsuarioPorAToken(Usuario usuario);

    /**
     * Método utilizado para registrar una publicación.
     *
     * @param publicacion publicación a registrar.
     * @return publicación registrada.
     */
    public Publicacion registrarPublicacion(Publicacion publicacion);

    /**
     * Método utilizado para eliminar una publicación.
     *
     * @param publicacion publicación a eliminar.
     * @return publicacion eliminada.
     */
    public Publicacion eliminarPublicacion(Publicacion publicacion);

    /**
     * Método utilizado para editar una publicación.
     *
     * @param publicacion publicación a editar.
     * @return publicacion editada.
     */
    public Publicacion editarPublicacion(Publicacion publicacion);

    /**
     * Método utilizado para consultar una publicación.
     *
     * @param publicacion publicación a consultar.
     * @return publicación consultada.
     */
    public Publicacion consultarPublicacion(Publicacion publicacion);

    /**
     * Método utilizado para registrar un hashtag.
     *
     * @param hashtag hashtag a registrar.
     * @return hashtag registrado.
     */
    public Hashtag registrarHashtag(Hashtag hashtag);

    /**
     * Método utilizada para consultar un hashtag.
     *
     * @param idHashtag id del hashtag.
     * @return hashtag consultado.
     */
    public Hashtag consultarHashtag(Long idHashtag);

    /**
     * Método utilizado para registrar un comentario.
     *
     * @param comentario comentario a registrar.
     * @return comentario registrado.
     */
    public Comentario registrarComentario(Comentario comentario);

    /**
     * Método utilizado para eliminar un comentario.
     *
     * @param comentario comentario a eliminar.
     * @return comentario eliminado.
     */
    public Comentario eliminarComentario(Comentario comentario);

    /**
     * Método utilizado para editar un comentario.
     *
     * @param comentario comentario a editar.
     * @return comentario editado.
     */
    public Comentario editarComentario(Comentario comentario);

    /**
     * Método para consultar comentario.
     *
     * @param idComentario id del comentario a consultar.
     * @return comentario consultado
     */
    public Comentario consultarComentario(Long idComentario);

    /**
     * Método utilizado para consultar publicaciones.
     *
     * @return lista de publicaciones.
     */
    public List<Publicacion> consultarPublicaciones();

    /**
     * Método para consultar a usuario por nombre.
     *
     * @param usuario usuario a consultar.
     * @return usuario consultado.
     */
    public List<Hashtag> consultarHashtagNombre(String hashtag);

    /**
     * Método para enviar un mensaje.
     *
     * @param mensaje mensaje a enviar.
     * @return mensaje que fue enviado.
     */
    public Mensaje enviarMensaje(Mensaje mensaje);

    /**
     * Método utilizado para consultar un mensaje.
     *
     * @param idNotificacion id del mensaje.
     * @return mensaje consultado.
     */
    public Mensaje consultarMensaje(Long idNotificacion);

}
