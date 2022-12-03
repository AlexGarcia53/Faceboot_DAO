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
    /**
     * Método utilizado para registrar un comentario.
     * @param comentario comentario a registrar.
     * @return comentario registrado.
     */
    public Comentario registrar(Comentario comentario);
    /**
     * Método utilizado para editar un comentario.
     * @param comentario comentario a editar.
     * @return comentario editado.
     */
    public Comentario editar(Comentario comentario);
    /**
     * Método utilizado para eliminar un comentario.
     * @param comentario comentario a eliminar.
     * @return comentario eliminado.
     */
    public Comentario eliminar(Comentario comentario);
    /**
     * Método para consultar comentario.
     * @param id ide del comentario.
     * @return comentario consultado.
     */
    public Comentario consultarComentario(Long id);
}
