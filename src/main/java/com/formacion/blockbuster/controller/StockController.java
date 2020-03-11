package com.formacion.blockbuster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.formacion.blockbuster.dto.Stock;
import com.formacion.blockbuster.enums.Enums;
import com.formacion.blockbuster.service.StockService;

@RestController
public class StockController {

	@Autowired
	StockService stockService;
	
	@GetMapping("/stock")
	public Stock getStock(@RequestHeader Integer referencia) {
		return stockService.getStock(referencia);
	}
	
	@PostMapping("/stock")
	public void addStock(@RequestBody Stock stock) {
		stockService.addStock(stock);
	}
	
	@PutMapping("/stock")
	public void modifyStock(@RequestBody Stock stock, @RequestHeader Integer referencia, @RequestHeader Enums.estadoJuego estado) {
		stockService.modifyStock(stock, referencia, estado);
	}
	
	@DeleteMapping("/stock")
	public void removeStock(@RequestHeader Integer referencia) {
		stockService.removeStock(referencia);
	}
	
}
