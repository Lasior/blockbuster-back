package com.formacion.blockbuster.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;

public class Tienda {

	@NotBlank
	private String nombre, direccion;
	
	private List<Stock> stock;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Stock> getStock() {
		return stock;
	}

	public void setStock(List<Stock> stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Tienda [nombre=" + nombre + ", direccion=" + direccion + ", stock=" + stock.toString() + "]";
	}
	
}
