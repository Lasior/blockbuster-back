package com.formacion.blockbuster.exceptions.generic;

public class NoContentException extends RuntimeException {

	private static final long serialVersionUID = -1874837296864926029L;
	private static final String DESCRIPTION = "No Content (204)";

	public NoContentException(String details) {
		super(DESCRIPTION + ". " + details);
	}

}
