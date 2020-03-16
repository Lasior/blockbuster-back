package com.formacion.blockbuster.exceptions;

public class CustomExceptionHandler extends RuntimeException{

	private static final long serialVersionUID = 4093854531755071342L;
	String message;
	
	public CustomExceptionHandler(){
		super();
	}
	
	public CustomExceptionHandler(String message) {
		super();
		this.message = message;
	}

}
