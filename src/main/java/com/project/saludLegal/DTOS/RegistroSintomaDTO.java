package com.project.saludLegal.DTOS;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**

 * DTO para registrar sintomas

 * @author: Manuel Alejandro Verjan Robles

 */
public class RegistroSintomaDTO implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	@NotBlank(message="El sintoma debe llevar un nombre")
	private String descSintoma;// nombre del sintoma que se va a agregar
	
	@NotEmpty(message="El sintoma debe llevar especialidades asociadas a el")
	private List<Long> especialidadesAsociadas;// array con ids de la especialidades asociadas
	
	@NotNull(message="Es necesario el id de la prioridad del sintoma")
	private Long idPrioridad;// id de la prioridad asociada a dicho sintoma
	

	public RegistroSintomaDTO(String descSintoma, List<Long> especialidadesAsociadas, Long idPrioridad) {
		super();
		this.descSintoma = descSintoma;
		this.especialidadesAsociadas = especialidadesAsociadas;
		this.idPrioridad = idPrioridad;
	}
	
	public RegistroSintomaDTO() {
		super();
	}


	public Long getIdPrioridad() {
		return idPrioridad;
	}


	public void setIdPrioridad(Long idPrioridad) {
		this.idPrioridad = idPrioridad;
	}


	public String getDescSintoma() {
		return descSintoma;
	}
	public void setDescSintoma(String descSintoma) {
		this.descSintoma = descSintoma;
	}
	public List<Long> getEspecialidadesAsociadas() {
		return especialidadesAsociadas;
	}
	public void setEspecialidadesAsociadas(List<Long> especialidadesAsociadas) {
		this.especialidadesAsociadas = especialidadesAsociadas;
	}
	
	

}
