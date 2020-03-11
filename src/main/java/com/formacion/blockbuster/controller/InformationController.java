package com.formacion.blockbuster.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formacion.blockbuster.dto.Company;
import com.formacion.blockbuster.dto.Tienda;
import com.formacion.blockbuster.service.InformationService;

@RestController
@Validated
public class InformationController {
	
	@Autowired
	InformationService informationService;
	
	@GetMapping("/tiendas")
	public List<Tienda> getStores() {
		return informationService.getStores();
	}
	
	@PostMapping("/tiendas")
	public void setTiendas(@Validated @RequestBody List<@Valid Tienda> tiendas) {
		informationService.insertStore(tiendas);
	}
	
	@GetMapping("/companies")
	public List<Company> getCompanies() {
		return informationService.getCompanies();
	}
	
	@PostMapping("/companies")
	public void setCompanies(@Validated @RequestBody List<@Valid Company> companies) {
		informationService.insertCompany(companies);
	}
}
