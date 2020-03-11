package com.formacion.blockbuster.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.formacion.blockbuster.dto.Cliente;
import com.formacion.blockbuster.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	List<Cliente> clientes = new ArrayList<Cliente>();

	@Override
	public void addCliente(Cliente client) {
		clientes.add(client);
	}

	@Override
	public void removeCliente(String documentacion) {
		clientes.removeIf(c -> c.getDocumentacion().equals(documentacion));
	}

	@Override
	public Cliente getCliente(String documentacion) {
		return clientes.stream().filter(c -> c.getDocumentacion().equals(documentacion)).findFirst().get();
	}

	@Override
	public List<Cliente> getClientes() {
		return clientes;
	}

}
