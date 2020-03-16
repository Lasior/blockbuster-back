package com.formacion.blockbuster.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ClienteConStockAlquiladoException extends RuntimeException{
	
	private static final long serialVersionUID = 2L;

	@ExceptionHandler(value = ClienteConStockAlquiladoException.class)
	public ResponseEntity<Object> exception(ClienteConStockAlquiladoException exception) {
		return new ResponseEntity<>("Este cliente ya tiene un juego alquilado", HttpStatus.NOT_ACCEPTABLE);
	}

}
