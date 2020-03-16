package com.formacion.blockbuster.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.formacion.blockbuster.enums.Enums;

import lombok.Data;

@Data
public class JuegoDTO {
	
	@NotBlank
	private String titulo;
	
	@NotBlank
	@JsonFormat(pattern = "yyyy-MM-dd", locale = "ES")
	private Date fechaLanzamiento;
	
	@NotBlank
	private Integer precio, pegi;

	@NotBlank
	private Enums.categoriaJuego categoria;
	
	private List<CompanyDTO> companyDTOs = new ArrayList<>();
	
}
