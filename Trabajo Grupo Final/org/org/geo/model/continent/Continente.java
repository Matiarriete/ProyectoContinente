package org.geo.model.continent;

import java.util.ArrayList;
import java.util.List;

import org.geo.model.GeographicalArea;
import org.geo.model.country.Pais;

public class Continente extends GeographicalArea implements Cloneable, Comparable<Continente> {

	private String code;
	private String shortName;
	private String wikipediaURL;
	private String orthographicProjection;
	private String orthographicProjectionURL;
	private List<Pais> countries = new ArrayList<Pais>();

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		code = (code != null) ? code.trim() : null;
		this.code = (code != null && code.length() == 0) ? null : code;
	}

	public String getShortName() {		
		return shortName;
	}

	public void setShortName(String shortName) {
		shortName = (shortName != null) ? shortName.trim() : null;
		this.shortName = (shortName != null && shortName.length() == 0) ? null : shortName;		
	}

	public String getWikipediaURL() {		
		return wikipediaURL;
	}

	public void setWikipediaURL(String wikipediaURL) {
		wikipediaURL = (wikipediaURL != null) ? wikipediaURL.trim() : null;
		this.wikipediaURL = (wikipediaURL != null && wikipediaURL.length() == 0) ? null : wikipediaURL;		
	}

	public String getOrthographicProjection() {
		return orthographicProjection;
	}

	public void setOrthographicProjection(String orthographicProjection) {
		orthographicProjection = (orthographicProjection != null) ? orthographicProjection.trim() : null;
		this.orthographicProjection = (orthographicProjection != null && orthographicProjection.length() == 0) ? null : orthographicProjection;		
	}

	public String getOrthographicProjectionURL() {
		return orthographicProjectionURL;
	}

	public void setOrthographicProjectionURL(String orthographicProjectionURL) {				
		orthographicProjectionURL = (orthographicProjectionURL != null) ? orthographicProjectionURL.trim() : null;
		this.orthographicProjectionURL = (orthographicProjectionURL != null && orthographicProjectionURL.length() == 0) ? null : orthographicProjectionURL;
	}

	public List<Pais> getCountries() {
		return countries;
	}

	public void setCountries(List<Pais> countries) {
		
		List<Integer> listIndex = new ArrayList<Integer>();
		
		for(int i = 0; i < countries.size(); i++){
			
			Pais country = countries.get(i);
			
			if(country == null){
				listIndex.add(i);
			}			
		}
		
		for(int removeIndex : listIndex){
			countries.remove(removeIndex);
		}
		
		this.countries = countries;
	}

	public boolean addCountry(Pais country) {
		
		if(country == null){
			return false;
		}				
		
		if(countries == null){
			countries = new ArrayList<Pais>();
		}
		
		return countries.add(country);
	}

	@Override
	public String toString() {

		if (this.getCode() != null && this.getShortName() != null) {
			return "(" + this.getCode() + ") " + this.getShortName() +" " + this.getId()+ " " +this.getCountries();
		}

		if (this.getCode() != null && this.getShortName() == null) {
			return "(" + this.getCode() + ") ";
		}

		if (this.getCode() == null && this.getShortName() != null) {
			return this.getShortName();
		}

		return null;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		
		Continente other = new Continente();
		
		other.setId(this.getId());
		other.setCode(this.getCode());
		other.setShortName(this.getShortName());
		other.setWikipediaURL(this.getWikipediaURL());
		other.setOrthographicProjection(this.getOrthographicProjection());
		other.setOrthographicProjectionURL(this.getOrthographicProjectionURL());
		if(this.getCountries() != null){
			for(Pais country : this.getCountries()){
				other.addCountry((Pais) country.clone());
			}
		}
		
		return other;
	}
	
	@Override
	public int compareTo(Continente obj) {

		if (obj == null) {
			return -1;
		}

		Continente other = (Continente) obj;

		if (this.getCode() != null && other.getCode() == null) {
			return -1;
		}

		if (this.getCode() == null && other.getCode() != null) {
			return 1;
		}

		return this.getCode().compareTo(other.getCode());
	}

}
