/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dominio.Comentario;
import java.util.List;

/**
 * Interfaz que implementa la clase ComentariosDAO.
 *
 * @author Equipo Broker.
 */
public interface IComentariosDAO {
    public Comentario registrar(Comentario comentario);
    public Comentario editar(Comentario comentario);
    public List<Comentario> consultarComentarios(Long idPublicacion);
    public Comentario eliminar(Comentario comentario);
}
