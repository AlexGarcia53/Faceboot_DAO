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
public interface IDatosPersistencia {
    public Usuario registrarUsuario(Usuario usuario);
    public void editarPerfilUsuario(Usuario usuario);
    public Usuario consultarUsuario(Usuario usuario);
    public Publicacion registrarPublicacion(Publicacion publicacion);
    public void eliminarPublicacion(Long idPublicacion);
    public void editarPublicacion(Publicacion publicacion);
    public Publicacion consultarPublicacion(Publicacion publicacion);
    public Publicacion consultarPublicacionHashtag(Hashtag hashtag);
    public void registrarHashtag(Hashtag hashtag);
    public Hashtag consultarHashtag(Long idHashtag);
    public void registrarComentario(Comentario comentario);
    public void eliminarComentario(Long idComentario);
    public List<Comentario> consultarComentario(Long idPublicacion);
    public void enviarMensaje(Mensaje mensaje);
    public Mensaje consultarMensaje(Long idNotificacion);
     
}
