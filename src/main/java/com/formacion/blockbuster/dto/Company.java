package com.formacion.blockbuster.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;

public class Company {
	
	@NotBlank
	private String cif, nombre;

	private List<Juego> juegos;

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Juego> getJuegos() {
		return juegos;
	}

	public void setJuegos(List<Juego> juegos) {
		this.juegos = juegos;
	}

	@Override
	public String toString() {
		return "Company [cif=" + cif + ", nombre=" + nombre;
	}
	
	
}
