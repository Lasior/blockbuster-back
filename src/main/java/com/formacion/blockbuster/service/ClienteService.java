package com.formacion.blockbuster.service;

import com.formacion.blockbuster.dto.ClienteDTO;
import com.formacion.blockbuster.entity.Cliente;

public interface ClienteService {
	
	public ClienteDTO getCliente(String documentacion);
	
	public void postCliente(ClienteDTO clienteDTO);
	
	public void deleteCliente(String documentacion);
	
	public void putCliente(ClienteDTO clienteDTO, String documentacion);

}
