package com.formacion.blockbuster.exceptions.generic;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private static final String DESCRIPTION = "Not Found (404)";

	public NotFoundException(String details) {
		super(DESCRIPTION + ". " + details);
	}

}
