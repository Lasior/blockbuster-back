package com.formacion.blockbuster.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ClienteDTO {

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
	
	private List<StockDTO> stockDTOs = new ArrayList<StockDTO>();

}
