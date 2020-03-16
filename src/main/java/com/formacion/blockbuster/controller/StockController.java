package com.formacion.blockbuster.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.formacion.blockbuster.dto.StockDTO;
import com.formacion.blockbuster.exceptions.CustomExceptionHandler;
import com.formacion.blockbuster.exceptions.ResponseError;
import com.formacion.blockbuster.service.StockService;

@RestController
public class StockController {
	
	@Autowired
	StockService stockService;
	
	@GetMapping("/stock")
	private StockDTO getStock(@Valid @RequestHeader String reference) {
		return stockService.getStock(reference);
	}
	
	@PostMapping("/stock")
	private void postStock(@Valid @RequestBody StockDTO stockDTO, @Valid @RequestHeader String cliente, @Valid @RequestHeader String tienda,
			@Valid @RequestHeader String juego) {
		stockService.postStock(stockDTO, cliente, tienda, juego);
	}
	
	@DeleteMapping("/stock")
	private void deleteStock(@Valid @RequestHeader String reference) {
		stockService.deleteStock(reference);
	}
	
	@PutMapping("/stock")
	private void putStock(@Valid @RequestBody StockDTO stockDTO, @Valid @RequestHeader String reference) {
		stockService.putStock(stockDTO, reference);
	}
	
	@ExceptionHandler(CustomExceptionHandler.class)
	@ResponseBody
	public ResponseError handleCustomException(CustomExceptionHandler ex) {
		ResponseError err = new ResponseError();
		err.setErrorMessage(ex.getMessage());
		err.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
		
		return err;		
	}

}
