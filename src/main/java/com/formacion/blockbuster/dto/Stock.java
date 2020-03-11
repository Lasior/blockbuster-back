package com.formacion.blockbuster.dto;

import javax.validation.constraints.NotBlank;

import com.formacion.blockbuster.enums.Enums;

public class Stock {
	
	@NotBlank
	private Integer referencia;
	
	@NotBlank
	private Enums.estadoJuego estado;
	
	@NotBlank
	private Juego juego;
	
	public Integer getReferencia() {
		return referencia;
	}
	public void setReferencia(Integer referencia) {
		this.referencia = referencia;
	}
	public Enums.estadoJuego getEstado() {
		return estado;
	}
	public void setEstado(Enums.estadoJuego estado) {
		this.estado = estado;
	}
	public Juego getJuego() {
		return juego;
	}
	public void setJuego(Juego juego) {
		this.juego = juego;
	}
	@Override
	public String toString() {
		return "Stock [referencia=" + referencia + ", estado=" + estado + ", juego=" + juego.toString() + "]";
	}
		
}
