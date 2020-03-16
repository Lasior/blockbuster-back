package com.formacion.blockbuster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formacion.blockbuster.dto.CompanyDTO;
import com.formacion.blockbuster.dto.JuegoDTO;
import com.formacion.blockbuster.dto.TiendaDTO;
import com.formacion.blockbuster.service.GenerateDataService;

@RestController
public class GenerateDataController {
	
	@Autowired
	GenerateDataService gDS;

	@PostMapping("/company")
	private void addCompany(@RequestBody CompanyDTO companyDTO) {
		gDS.addCompany(companyDTO);
	}
	
	@PostMapping("/juego")
	private void addJuego(@RequestBody JuegoDTO juegoDTO) {
		gDS.addJuego(juegoDTO);
	}
	
	@PostMapping("/tienda")
	private void addTienda(@RequestBody TiendaDTO tiendaDTO) {
		gDS.addTienda(tiendaDTO);
	}
	
}
