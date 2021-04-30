/**
 * 
 */
package com.project.saludLegal.exceptions;

/**
 * @author Manuel Alejandro Verjan
 * Custom Excepcion para controlar el caso de que se busque agendar en una fecha que ya existe
 */
public class AppointmentAlreadyExistsException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * CONSTRUCTOR DE LA CLASE PADRE
	 * @param errorMessage mensaje de error a devolver
	 */
	public AppointmentAlreadyExistsException(String errorMessage) {
		super(errorMessage);
	}

}
