package com.formacion.blockbuster.exceptions.custom;

import com.formacion.blockbuster.exceptions.generic.BadRequestException;

public class JuegoBadRequestException extends BadRequestException {

	private static final long serialVersionUID = 3782066452317956083L;
	public static final String DESCRIPTION = "Bad Request";

	String mensaje;

	public JuegoBadRequestException(String message) {
		super(DESCRIPTION + ". " + message);
	}

}
