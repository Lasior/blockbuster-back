package com.formacion.blockbuster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.formacion.blockbuster.service.JuegoService;

@RestController
public class JuegoController {
	
	@Autowired
	JuegoService juegoService;

	@PostMapping("/juego")
	private void comprarAlquilarDevolverJuego(@RequestHeader String nombreTienda, @RequestHeader String nombreJuego, @RequestHeader String action, @RequestHeader String documentacion) {
		juegoService.comprarAlquilarDevolverJuego(nombreTienda, nombreJuego, action, documentacion);
	}
	
}
