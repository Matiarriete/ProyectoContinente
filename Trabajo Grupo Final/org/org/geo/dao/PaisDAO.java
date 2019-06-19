package org.geo.dao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.geo.Proerties;
import org.geo.model.continent.Continente;
import org.geo.model.country.Pais;
import org.geo.model.country.iso3166alpha2state.ISO3166Alpha2State;

public class PaisDAO implements IPaisDAO {

	private ObjectMapper mapper = new ObjectMapper();
	private List<ISO3166Alpha2State> estados = new ArrayList<ISO3166Alpha2State>();
	private List<Pais> countries = new ArrayList<Pais>();

	public List<Pais> find() throws Exception {

		List<Pais> countries = new ArrayList<Pais>();

		File folder = new File(Proerties.pathFolderCountries);

		File[] files = folder.listFiles();

		for (File fileJSON : files) {

			if (fileJSON.isDirectory() == false && fileJSON.getName().endsWith(".json")) {

				Pais country = mapper.readValue(fileJSON.getAbsoluteFile(), Pais.class);
				countries.add(country);

			}
		}

		return countries;
	}

	public boolean update(Pais country) throws Exception {

		File folder = new File(Proerties.pathFolderCountries);

		File[] files = folder.listFiles();

		for (File fileJSON : files) {

			if (fileJSON.isDirectory() == false && fileJSON.getName().endsWith(".json")) {

				Pais countryItem = mapper.readValue(fileJSON.getAbsoluteFile(), Pais.class);

				if (countryItem.getId().equals(country.getId())) {
					mapper.writeValue(fileJSON, country);
					return true;
				}

			}
		}

		return false;
	}

	public int contarFilasPais() throws Exception {

		return find().size();
	}

	public Pais buscarPaisPorId(Long id) throws Exception {
		File folder = new File(Proerties.pathFolderCountries);

		File[] files = folder.listFiles();

		for (File fileJSON : files) {

			if (fileJSON.isDirectory() == false && fileJSON.getName().endsWith(".json")) {

				Pais countryItem = mapper.readValue(fileJSON.getAbsoluteFile(), Pais.class);

				if (countryItem.getId().equals(id)) {
					return countryItem;
				}
			}
		}

		return null;
	}

	public List<Pais> buscarPaisPorNombre(String nombre) throws Exception {

		File folder = new File(Proerties.pathFolderCountries);

		File[] files = folder.listFiles();

		List<Pais> paisesEncontrados = new ArrayList<Pais>();

		for (File fileJSON : files) {

			if (fileJSON.isDirectory() == false && fileJSON.getName().endsWith(".json")) {

				Pais countryItem = mapper.readValue(fileJSON.getAbsoluteFile(), Pais.class);

				if (countryItem.getName().toLowerCase().startsWith(nombre.toLowerCase()))
					paisesEncontrados.add(countryItem);

			}
		}
		if (paisesEncontrados != null)
			return paisesEncontrados;

		return null;
	}

	public Pais buscarPaisPorIso(String codigo) throws Exception {
		File folder = new File(Proerties.pathFolderCountries);

		File[] files = folder.listFiles();

		for (File fileJSON : files) {

			if (fileJSON.isDirectory() == false && fileJSON.getName().endsWith(".json")) {

				Pais countryItem = mapper.readValue(fileJSON.getAbsoluteFile(), Pais.class);

				if (countryItem.getIso31661().getAlpha2().toLowerCase().equals(codigo.toLowerCase())) {
					return countryItem;
				}

			}
		}

		return null;
	}

	public Pais buscarPaisPorIso3(String codigo) throws Exception {
		File folder = new File(Proerties.pathFolderCountries);

		File[] files = folder.listFiles();

		for (File fileJSON : files) {

			if (fileJSON.isDirectory() == false && fileJSON.getName().endsWith(".json")) {

				Pais countryItem = mapper.readValue(fileJSON.getAbsoluteFile(), Pais.class);

				if (countryItem.getIso31661().getAlpha3().toLowerCase().equals(codigo.toLowerCase())) {
					return countryItem;
				}

			}
		}
		return null;
	}

	public Pais buscarPaisPorIsoNum(String codigo) throws Exception {
		File folder = new File(Proerties.pathFolderCountries);

		File[] files = folder.listFiles();

		for (File fileJSON : files) {

			if (fileJSON.isDirectory() == false && fileJSON.getName().endsWith(".json")) {

				Pais countryItem = mapper.readValue(fileJSON.getAbsoluteFile(), Pais.class);

				if (countryItem.getIso31661().getNumeric().equals("0" + codigo)
						|| countryItem.getIso31661().getNumeric().equals("00" + codigo)
						|| countryItem.getIso31661().getNumeric().equals(codigo)) {
					return countryItem;
				}

			}
		}
		return null;
	}

	public List<Pais> buscarPaisPorContinente(Long id) throws Exception {
		List<Pais> countries = new ArrayList<Pais>();

		File folder = new File(Proerties.pathFolderCountries);

		File[] files = folder.listFiles();

		for (File fileJSON : files) {

			if (fileJSON.isDirectory() == false && fileJSON.getName().endsWith(".json")) {

				Pais country = mapper.readValue(fileJSON.getAbsoluteFile(), Pais.class);
				if (country.getContinent().getId().equals(id)) {
					countries.add(country);
				}
			}
		}

		return countries;
	}

	@Override
	public boolean agregarPais(Pais pais) throws Exception {
		mapper.writeValue(new File(Proerties.pathFolderCountries + "\\" + pais.getIso31661().getAlpha2() + ".json"),
				pais);

		return true;
	}

	public List<ISO3166Alpha2State> verEstados() throws Exception {

		List<ISO3166Alpha2State> estadosTemp = new ArrayList<ISO3166Alpha2State>();

		File folder = new File(Proerties.pathFolderState);

		File[] files = folder.listFiles();

		for (File fileJSON : files) {

			if (fileJSON.isDirectory() == false && fileJSON.getName().endsWith(".json")) {

				ISO3166Alpha2State estado = mapper.readValue(fileJSON.getAbsoluteFile(), ISO3166Alpha2State.class);
				if (estado != null)
					estadosTemp.add(estado);

			}
		}

		return estadosTemp;
	}

}
