package org.geo.dao;

import java.util.List;
import org.geo.model.country.Pais;
import org.geo.model.country.iso3166alpha2state.ISO3166Alpha2State;

public interface IPaisDAO {

	public int contarFilasPais() throws Exception;
	public Pais buscarPaisPorId(Long id) throws Exception;
	public Pais buscarPaisPorIso(String codigo) throws Exception;
	public Pais buscarPaisPorIso3(String codigo) throws Exception;
	public Pais buscarPaisPorIsoNum(String codigo) throws Exception;
	public List<Pais> buscarPaisPorNombre(String nombre) throws Exception;
	public List<Pais> find() throws Exception;
	public List<Pais> buscarPaisPorContinente(Long id) throws Exception;
	public boolean agregarPais(Pais pais) throws Exception;
	public boolean update(Pais country) throws Exception;
	public List <ISO3166Alpha2State> verEstados () throws Exception;
	
}
