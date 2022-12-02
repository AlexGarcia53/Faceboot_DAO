/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dominio.Usuario;

/**
 * Interfaz que implementa la clase UsuariosDAO.
 *
 * @author Equipo Broker.
 */
public interface IUsuariosDAO {
    public Usuario registrar(Usuario usuario);
    public Usuario registrarFacebook(Usuario usuario);
    public Usuario consultarUsuario(Long idUsuario);
    public Usuario consultarUsuarioNombre(String nombre);
    public Usuario consultarUsuarioPorAToken(String atoken);
    public Usuario editar(Usuario usuario);
    public Usuario consultarUsuario(String correo);
    public Usuario consultarUsuarioRegistrado(String correo, String contrasenia);
}
