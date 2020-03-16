package com.formacion.blockbuster.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class TiendaDTO {

	@NotBlank
	private String nombre, direccion;
	
	private List<StockDTO> stockDTO = new ArrayList<StockDTO>();

}
