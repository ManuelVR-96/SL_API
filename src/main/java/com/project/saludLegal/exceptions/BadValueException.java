package com.project.saludLegal.exceptions;

public class BadValueException extends Exception {
	private static final long serialVersionUID = 1L;
	/**
	 * CONSTRUCTOR DE LA CLASE PADRE
	 * @param errorMessage mensaje de error a devolver
	 */
	public BadValueException(String errorMessage) {
		super(errorMessage);
	}
}

