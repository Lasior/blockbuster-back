package com.formacion.blockbuster.exceptions.custom;

import com.formacion.blockbuster.exceptions.generic.NoContentException;

public class RolNoContentException extends NoContentException {

	private static final long serialVersionUID = -5720279857132828545L;
	private static final String DESCRIPTION = "Rol Not Found";

	public RolNoContentException(String details) {
		super(DESCRIPTION + ". " + details);
	}

}
