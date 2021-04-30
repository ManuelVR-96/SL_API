package com.project.saludLegal.DTOS;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**

 * DTO para login del operario

 * @author: Manuel Alejandro Verjan Robles

 */
public class OperarioLoginDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Size (min = 8, max = 20, message = "La constrasenia debe contener entre 8 y 20 caracteres")
	@NotBlank(message="Debe ingresar una contraseña")
	
	private String password;// contrasenia ingresada en el login
	
	@Pattern(regexp = "[0-9]+")
	@Size (min = 8, max = 10, message = "La cedula debe estar entre 6 y 10 caracteres")
	@NotBlank(message="Debe ingresar el numero de su cedula")
	private String cedula;// cedula ingresada en el login
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
}
