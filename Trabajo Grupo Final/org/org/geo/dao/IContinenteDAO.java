package org.geo.dao;


import java.util.List;

import org.geo.model.continent.Continente;


public interface IContinenteDAO {
	
	public Continente buscarContinentePorId(Long id) throws Exception;
	public Continente buscarContinentePorCodigo(String codigo)throws Exception;
	public List<Continente> buscarContinentePorNombre(String nombre) throws Exception;
	public List<Continente> find() throws Exception;
	public int contarFilas() throws Exception;
	public boolean agregarContinente(Continente continente) throws Exception;
	public boolean borrarContinente(Continente continente) throws Exception;
	public boolean update(Continente continente) throws Exception;
}
