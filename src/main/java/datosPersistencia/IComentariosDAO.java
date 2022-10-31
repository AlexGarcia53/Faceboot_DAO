/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosPersistencia;

import dominio.Comentario;
import java.util.List;

/**
 *
 * @author Gael
 */
public interface IComentariosDAO {
    public void registrar(Comentario comentario);
    public List<Comentario> consultarComentarios(Long idPublicacion);
    public void eliminar(Long idComentario);
}