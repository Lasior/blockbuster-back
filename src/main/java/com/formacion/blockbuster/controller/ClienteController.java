package com.formacion.blockbuster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.formacion.blockbuster.dto.ClienteDTO;
import com.formacion.blockbuster.service.ClienteService;

@RestController
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@GetMapping("/cliente")
	public ClienteDTO getCliente(@RequestHeader String documentacion) {
		return clienteService.getCliente(documentacion);
	}
	
	@PostMapping("/cliente")
	public void postCliente(@RequestBody ClienteDTO clienteDTO) {
		clienteService.postCliente(clienteDTO);
	}
	
	@PutMapping("/cliente")
	public void putCliente(@RequestBody ClienteDTO clienteDTO, @RequestHeader String documentacion) {
		clienteService.putCliente(clienteDTO, documentacion);
	}
	
	@DeleteMapping("/cliente")
	public void deteleCliente(@RequestHeader String documentacion){
		clienteService.deleteCliente(documentacion);
	}

}
