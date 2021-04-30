package com.project.saludLegal.exceptions;

/**
 * @author Manuel Alejandro Verjan
 * Custom exception para controlar el caso de que se busque generar agenda en un dia que ya hay agenda
 */

public class DiaryAlreadyExistsException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * CONSTRUCTOR DE LA CLASE PADRE
	 * @param errorMessage mensaje de error a devolver
	 */
	public DiaryAlreadyExistsException(String errorMessage) {
		super(errorMessage);
	}

}
