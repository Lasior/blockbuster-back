package com.formacion.blockbuster.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.formacion.blockbuster.enums.Enums;

public class Juego {
	
	@NotBlank
	private String titulo;
	
	@NotBlank
	@JsonFormat(pattern = "yyyy-MM-dd", locale = "ES")
	private Date fechaLanzamiento;
	
	@NotBlank
	private Integer precio, pegi;

	@NotBlank
	private Enums.categoriaJuego categoria;
	
	private List<Company> companies;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFechaLanzamiento() {
		return fechaLanzamiento;
	}

	public void setFechaLanzamiento(Date fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public Integer getPegi() {
		return pegi;
	}

	public void setPegi(Integer pegi) {
		this.pegi = pegi;
	}

	public Enums.categoriaJuego getCategoria() {
		return categoria;
	}

	public void setCategoria(Enums.categoriaJuego categoria) {
		this.categoria = categoria;
	}

	List<Company> getCompanies() {
		return companies;
	}

	void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	@Override
	public String toString() {
		return "Juego [titulo=" + titulo + ", fechaLanzamiento=" + fechaLanzamiento + ", precio=" + precio + ", pegi="
				+ pegi + ", categoria=" + categoria + ", companies=" + companies.toString() + "]";
	}
	
}
