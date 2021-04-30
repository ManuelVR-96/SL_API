package com.project.saludLegal.DTOS;

import javax.validation.constraints.NotBlank;

/**

 * DTO informacion de sesion del usuario

 * @author: Manuel Alejandro Verjan Robles

 */
public class OperarioSessionDTO {
	
	@NotBlank(message="El id del operario no puede ser null")
	private Long idOperario;// id del operario
	
	@NotBlank(message="El nombre del operario no puede ser vacio")
	private String nombreOperario;// nombre del operario
	
	@NotBlank(message="Los apellidos del operario no pueden ser vacios")
	private String apellidosOperario;//apellidos del operario
	
	@NotBlank(message="El operario debe tener un rol asignado")
	private Long idRol;// rol del operario
	
	public Long getIdOperario() {
		return idOperario;
	}
	public void setIdOperario(Long idOperario) {
		this.idOperario = idOperario;
	}
	public String getNombreOperario() {
		return nombreOperario;
	}
	public void setNombreOperario(String nombreOperario) {
		this.nombreOperario = nombreOperario;
	}
	public String getApellidosOperario() {
		return apellidosOperario;
	}
	public void setApellidosOperario(String apellidosOperario) {
		this.apellidosOperario = apellidosOperario;
	}
	public Long getIdRol() {
		return idRol;
	}
	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}
	

}
