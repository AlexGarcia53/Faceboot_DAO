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
    public Usuario registrarUsuario(Usuario usuario);
    public Usuario registrarUsuarioFacebook(Usuario usuario);
    public Usuario editarPerfilUsuario(Usuario usuario);
    public Usuario consultarUsuario(Usuario usuario);
    public Usuario consultarUsuarioNombre(Usuario usuario);
    public Usuario consultarUsuarioPorAToken(Usuario usuario);
    public Publicacion registrarPublicacion(Publicacion publicacion);
    public Publicacion eliminarPublicacion(Publicacion publicacion);
    public Publicacion editarPublicacion(Publicacion publicacion);
    public Publicacion consultarPublicacion(Publicacion publicacion);
    public Publicacion consultarPublicacionHashtag(Hashtag hashtag);
    public Hashtag registrarHashtag(Hashtag hashtag);
    public Hashtag consultarHashtag(Long idHashtag);
    public Comentario registrarComentario(Comentario comentario);
    public Comentario eliminarComentario(Comentario comentario);
    public Comentario editarComentario(Comentario comentario);
    public List<Comentario> consultarComentario(Long idPublicacion);
    public List<Publicacion> consultarPublicaciones();
    public List<Hashtag> consultarHashtagNombre(String hashtag);
    public Mensaje enviarMensaje(Mensaje mensaje);
    public Mensaje consultarMensaje(Long idNotificacion);
     
}
