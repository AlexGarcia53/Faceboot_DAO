/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosPersistencia;

import dominio.Usuario;

/**
 *
 * @author Gael
 */
public interface IUsuariosDAO {
    public boolean registrar(Usuario usuario);
    public Usuario consultarUsuario(Long idUsuario);
    public void editar(Usuario usuario);
}
