package org.geo.dao;

import java.io.File;
import java.io.IOException;

import org.geo.Proerties;
import org.geo.model.continent.Continente;
import org.geo.usuarios.Usuario;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class UsuariosDAO implements IUsuariosDAO {
	
	private ObjectMapper mapper = new ObjectMapper();

	public boolean agregarUsuario(Usuario usuario) throws Exception {
		mapper.writeValue(new File(Proerties.pathFolderUsuarios + "\\" + usuario.getNombre()+ ".json"),
				usuario);
		return false;
	}

	public Usuario buscarUsuario(String nombre) throws Exception {
		File folder = new File(Proerties.pathFolderUsuarios);

		File[] files = folder.listFiles();

		for (File fileJSON : files) {

			if (fileJSON.isDirectory() == false && fileJSON.getName().endsWith(".json")) {

				Usuario usuariosItem = mapper.readValue(fileJSON.getAbsoluteFile(), Usuario.class);

				if (usuariosItem.getNombre().equals(nombre)) {
					return usuariosItem;
				}

			}
		}
		return null;
	}
	
	public Usuario buscarContrasena(String contrasena) throws Exception {
		File folder = new File(Proerties.pathFolderUsuarios);

		File[] files = folder.listFiles();

		for (File fileJSON : files) {

			if (fileJSON.isDirectory() == false && fileJSON.getName().endsWith(".json")) {

				Usuario usuariosItem = mapper.readValue(fileJSON.getAbsoluteFile(), Usuario.class);

				if (usuariosItem.getContrasena().equals(contrasena)) {
					return usuariosItem;
				}

			}
		}
		return null;
	}

	


}
