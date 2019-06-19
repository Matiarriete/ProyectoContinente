package org.geo.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.geo.Proerties;
import org.geo.model.continent.Continente;

public class ContinenteDAO implements IContinenteDAO {

	private ObjectMapper mapper = new ObjectMapper();

	public int contarFilas() throws Exception{
		return find().size();
	}
	
	public Continente buscarContinentePorId(Long id) throws Exception {
		File folder = new File(Proerties.pathFolderContinents);

		File[] files = folder.listFiles();

		for (File fileJSON : files) {

			if (fileJSON.isDirectory() == false && fileJSON.getName().endsWith(".json")) {

				Continente continenteItem = mapper.readValue(fileJSON.getAbsoluteFile(), Continente.class);

				if (continenteItem.getId().equals(id)) {
					return continenteItem;
				}

			}
		}
		return null;
	}

	public Continente buscarContinentePorCodigo(String codigo) throws Exception {
		File folder = new File(Proerties.pathFolderContinents);

		File[] files = folder.listFiles();

		for (File fileJSON : files) {

			if (fileJSON.isDirectory() == false && fileJSON.getName().endsWith(".json")) {

				Continente continenteItem = mapper.readValue(fileJSON.getAbsoluteFile(), Continente.class);

				if (continenteItem.getCode().equalsIgnoreCase(codigo)) {
					return continenteItem;
				}

			}
		}
		return null;
	}

	public List<Continente> buscarContinentePorNombre(String nombre) throws Exception {
		File folder = new File(Proerties.pathFolderContinents);

		File[] files = folder.listFiles();

		List<Continente> continentesEncontrados = new ArrayList<Continente>();

		for (File fileJSON : files) {

			if (fileJSON.isDirectory() == false && fileJSON.getName().endsWith(".json")) {

				Continente continenteItem = mapper.readValue(fileJSON.getAbsoluteFile(), Continente.class);

				if (continenteItem.getShortName().toLowerCase().contains(nombre.toLowerCase()))
					continentesEncontrados.add(continenteItem);

			}
		}
		if (continentesEncontrados != null)
			return continentesEncontrados;

		return null;
	}

	public List<Continente> find() throws Exception {

		List<Continente> continentes = new ArrayList<Continente>();

		File folder = new File(Proerties.pathFolderContinents);

		File[] files = folder.listFiles();

		for (File fileJSON : files) {

			if (fileJSON.isDirectory() == false && fileJSON.getName().endsWith(".json")) {

				Continente continent = mapper.readValue(fileJSON.getAbsoluteFile(), Continente.class);
				continentes.add(continent);

			}
		}

		return continentes;
	}

	public boolean update(Continente continente) throws Exception {

		File folder = new File(Proerties.pathFolderContinents);

		File[] files = folder.listFiles();

		for (File fileJSON : files) {

			if (fileJSON.isDirectory() == false && fileJSON.getName().endsWith(".json")) {

				Continente continenteItem = mapper.readValue(fileJSON.getAbsoluteFile(), Continente.class);

				if (continenteItem.getId().equals(continente.getId())) {
					mapper.writeValue(fileJSON, continente);
					return true;
				}

			}
		}

		return false;
	}

	public boolean agregarContinente(Continente continente) throws Exception {

		mapper.writeValue(new File(Proerties.pathFolderContinents + "\\" + continente.getCode()+ ".json"),
				continente);

		return true;
	}

	@Override
	public boolean borrarContinente(Continente continente) throws Exception{
		
		File folder = new File(Proerties.pathFolderContinents);

		File[] files = folder.listFiles();

		for (File fileJSON : files) {

			if (fileJSON.isDirectory() == false && fileJSON.getName().endsWith(".json")) {

				Continente continenteItem = mapper.readValue(fileJSON.getAbsoluteFile(), Continente.class);

				if (continenteItem.getId().equals(continente.getId())) {
					mapper.writeValue(fileJSON, continente);
					return true;
				}

			}
		}

		return false;	
		
	}
}
