package com.formacion.blockbuster.exceptions.custom;

import com.formacion.blockbuster.exceptions.generic.NoContentException;

public class StockNoContentException extends NoContentException {

	private static final long serialVersionUID = 5996579581912624944L;
	private static final String DESCRIPTION = "Stock Not Found";

	public StockNoContentException(String details) {
		super(DESCRIPTION + ". " + details);
		// TODO Auto-generated constructor stub
	}

}
