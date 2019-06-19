package org.geo.usuarios;


public class Usuario {
	
	private String nombre;
	private String mail;
	private String contrasena;
	private String edad;
	private String sexo;
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		nombre = (nombre != null) ? nombre.trim() : null;
		this.nombre = (nombre != null && nombre.length() == 0) ? null : nombre;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		mail = (mail != null) ? mail.trim() : null;
		this.mail = (mail != null && mail.length() == 0) ? null : mail;
	}
	
	public String getContrasena() {
		return contrasena;
	}
	
	public void setContrasena(String contrasena) {
		contrasena = (contrasena != null) ? contrasena.trim() : null;
		this.contrasena = (contrasena != null && contrasena.length() == 0) ? null : contrasena;
	}
	
	public String getEdad() {
		return edad;
	}
		
	public void setEdad(String edad) {
		edad = (edad != null) ? edad.trim() : null;
		this.edad = (edad != null && edad.length() == 0) ? null : edad;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
		sexo = (sexo != null) ? sexo.trim() : null;
		this.sexo = (sexo != null && sexo.length() == 0) ? null : sexo;
	}

	
	public String toString() {
		
		if(this.getNombre() != null && this.getContrasena() != null) {
			return this.getNombre() + this.getContrasena();
		}
		if(this.getNombre() != null && this.getContrasena() == null) {
			return this.getNombre();
		}
			
		
		return null;
	}
	
	
	
}
