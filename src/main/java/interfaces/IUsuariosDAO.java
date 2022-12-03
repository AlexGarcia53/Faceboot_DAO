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

    /**
     * Método utilizado para registrar a un usuario.
     *
     * @param usuario usuario a registrar.
     * @return usuario registrado.
     */
    public Usuario registrar(Usuario usuario);

    /**
     * Método utilizado para registrar a un usuario.
     *
     * @param usuario usuario a registrar a un usuario por facebook.
     * @return usuario registrado.
     */
    public Usuario registrarFacebook(Usuario usuario);

    /**
     * Método utilizado consultar a un usuario.
     *
     * @param idUsuario usuario a consultar.
     * @return usuario consultado.
     */
    public Usuario consultarUsuario(Long idUsuario);

    /**
     * Método utilizado consultar a un usuario por nombre.
     *
     * @param nombre usuario a consultar.
     * @return usuario consultado.
     */
    public Usuario consultarUsuarioNombre(String nombre);

    /**
     * Método utilizado consultar a un usuario por token.
     *
     * @param atoken usuario a consultar.
     * @return usuario consultado.
     */
    public Usuario consultarUsuarioPorAToken(String atoken);

    /**
     * Método utilizado para editar a un usuario.
     *
     * @param usuario usuario a editar.
     * @return usuario editado.
     */
    public Usuario editar(Usuario usuario);

    /**
     * Método utilizado consultar a un usuario.
     *
     * @param correo correo del usuario a consultar.
     * @return usuario consultado.
     */
    public Usuario consultarUsuario(String correo);

    /**
     * Método utilizado consultar a un usuario por correo y contraseña.
     *
     * @param correo usuario a consultar.
     * @param contrasenia usuario a consultar.
     * @return usuario consultado.
     */
    public Usuario consultarUsuarioRegistrado(String correo, String contrasenia);
}
