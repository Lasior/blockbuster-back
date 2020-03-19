package com.formacion.blockbuster.exceptions.generic;

public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = 5208345419671262252L;
	public static final String DESCRIPTION = "Bad Request (400)";
	
	public BadRequestException(String details) {
		super(DESCRIPTION + ". " + details);
	}
	
}
