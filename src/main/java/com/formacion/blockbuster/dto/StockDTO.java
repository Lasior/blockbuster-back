package com.formacion.blockbuster.dto;

import javax.validation.constraints.NotBlank;

import com.formacion.blockbuster.enums.Enums;

import lombok.Data;

@Data
public class StockDTO {
	
	@NotBlank
	private String referencia;
	
	@NotBlank
	private Enums.estadoJuego estado;
	
	private JuegoDTO juegoDTO;
	
	private TiendaDTO tiendaDTO;
	
	private ClienteDTO clienteDTO;
	
}
