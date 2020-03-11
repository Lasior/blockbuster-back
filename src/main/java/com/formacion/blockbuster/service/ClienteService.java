package com.formacion.blockbuster.service;

import java.util.List;

import com.formacion.blockbuster.dto.Cliente;

public interface ClienteService {
	
	public void addCliente(Cliente client);
	
	public void removeCliente(String documentacion);
	
	public Cliente getCliente(String documentacion);
	
	public List<Cliente> getClientes();

}
