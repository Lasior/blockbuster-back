package com.formacion.blockbuster.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.formacion.blockbuster.dto.Cliente;
import com.formacion.blockbuster.service.ClienteService;

@RestController
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@GetMapping("/cliente")
	public Cliente getCliente(@Valid @RequestHeader String documentacion) {
		return clienteService.getCliente(documentacion);
	}
	
	@PostMapping("/cliente")
	public void addCliente(@Valid @RequestBody Cliente client) {
		clienteService.addCliente(client);
	}
	
	@DeleteMapping("/cliente")
	public void removeCliente(@Valid @RequestHeader String documentacion) {
		clienteService.removeCliente(documentacion);
	}
	
	@GetMapping("/clientes")
	public List<Cliente> getClientes(){
		return clienteService.getClientes();
	}

}
