package com.project.saludLegal.exceptions;

/**
 * @author Manuel Alejandro Verjan
 * Custom Excepcion para controlar el caso de que se busque agregar un sintoma que ya existe
 */
public class SintomaAlreadyExistsException extends Exception{

	private static final long serialVersionUID = 1L;

	/**
	 * CONSTRUCTOR DE LA CLASE PADRE
	 * @param errorMessage mensaje de error a devolver
	 */
	public SintomaAlreadyExistsException(String errorMessage) {
		super(errorMessage);
	}

}
