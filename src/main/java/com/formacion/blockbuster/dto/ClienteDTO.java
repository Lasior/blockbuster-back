package com.formacion.blockbuster.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;

@Data
public class ClienteDTO {

	@NotBlank(message = "El nombre no puede estar vacío")
	private String nombre;
	
	@NotBlank(message = "El usuario del cliente no puede estar vacío")
	private String username;
	
	@NotBlank(message = "Debes introducir una contraseña")
	@Size(min = 8, message = "La contraseña debe tener más de 8 caracteres")
	private String password;

	@NotBlank(message = "Debe introducir una documentación")
	@Pattern(regexp = "^[0-9]{8}[A-Z]{1}$", message = "Documentación no válida")
	private String documentacion;

	@NotBlank(message = "Debe introducir un correo")
	@Email(message = "Correo introducido no válido")
	private String correo;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	
	private List<StockDTO> stockDTOs = new ArrayList<StockDTO>();
	
	private List<RolDTO> roles = new ArrayList<RolDTO>();

}
