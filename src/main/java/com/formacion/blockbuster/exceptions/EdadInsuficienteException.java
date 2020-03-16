package com.formacion.blockbuster.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EdadInsuficienteException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	@ExceptionHandler(value = EdadInsuficienteException.class)
	public ResponseEntity<Object> exception(EdadInsuficienteException exception) {
		return new ResponseEntity<>("No tienes edad suficiente para comprar este juego", HttpStatus.NOT_ACCEPTABLE);
	}

}
