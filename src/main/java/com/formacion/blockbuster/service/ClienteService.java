package com.formacion.blockbuster.service;

import com.formacion.blockbuster.dto.ClienteDTO;
import com.formacion.blockbuster.enums.Enums;

public interface ClienteService {
	
	public ClienteDTO getCliente(String documentacion);
	
	public void postCliente(ClienteDTO clienteDTO, Enums.rolUsuario rolUsuario);
	
	public void deleteCliente(String documentacion);
	
	public void putCliente(ClienteDTO clienteDTO, String documentacion);

}
