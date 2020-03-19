package com.formacion.blockbuster.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.formacion.blockbuster.enums.Enums;

import lombok.Data;

@Data
public class RolDTO {
	
	@NotNull(message = "Se debe asignar un rol")
	private Enums.rolUsuario rolUsuario;
	
	private List<ClienteDTO> clientes = new ArrayList<ClienteDTO>();

}
