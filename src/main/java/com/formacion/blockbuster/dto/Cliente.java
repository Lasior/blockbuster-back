package com.formacion.blockbuster.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Cliente {

	@NotBlank
	private String nombre;

	@NotBlank
	@Pattern(regexp = "^[0-9]{8}[A-Z]{1}$")
	private String documentacion;

	@NotBlank
	@Email
	private String correo;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	
	private List<Juego> juegos;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDocumentacion() {
		return documentacion;
	}

	public void setDocumentacion(String documentacion) {
		this.documentacion = documentacion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public List<Juego> getJuegos() {
		return juegos;
	}

	public void setJuegos(List<Juego> juegos) {
		this.juegos = juegos;
	}

}
