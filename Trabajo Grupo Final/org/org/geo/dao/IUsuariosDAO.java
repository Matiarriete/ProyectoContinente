package org.geo.dao;

import org.geo.usuarios.Usuario;

public interface IUsuariosDAO {
	public boolean agregarUsuario(Usuario usuario) throws Exception;
	public Usuario buscarUsuario(String nombre) throws Exception;
	public Usuario buscarContrasena(String contrasena) throws Exception;
}
