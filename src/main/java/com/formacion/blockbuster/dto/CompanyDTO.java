package com.formacion.blockbuster.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class CompanyDTO {
	
	@NotBlank
	private String cif, nombre;

	private List<JuegoDTO> juegoDTOs = new ArrayList<JuegoDTO>();

}
