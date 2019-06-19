package org.geo;

import java.util.List;

import org.geo.dao.ContinenteDAO;
import org.geo.dao.PaisDAO;
import org.geo.model.country.Pais;

public class Main {

	public static void main(String[] args) {
		
		PaisDAO dao = new PaisDAO();
		ContinenteDAO daoCon =new ContinenteDAO();
		try {
//		System.out.println(dao.contarFilasPais());
//		System.out.println(dao.buscarPaisPorId(3865483L));
//		System.out.println(dao.buscarPaisPorNombre("S"));
//		System.out.println(dao.buscarPaisPorIso("AR"));
//		System.out.println(dao.buscarPaisPorIso3("BRA"));
//		System.out.println(dao.buscarPaisPorIsoNum("032"));
//		System.out.println(dao.find());
//		
//		System.out.println(daoCon.buscarContinentePorCodigo("EU"));
//		System.out.println(daoCon.buscarContinentePorNombre("A"));
//		System.out.println(daoCon.buscarContinentePorId(6255150L));
//		System.out.println(daoCon.find());
			
		} catch (Exception e) {			
			e.printStackTrace();
		}

	}

}
