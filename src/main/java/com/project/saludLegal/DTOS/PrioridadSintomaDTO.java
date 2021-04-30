package com.project.saludLegal.DTOS;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**

 * DTO para prioridades de sintomas

 * @author: Manuel Alejandro Verjan Robles

 */
public class PrioridadSintomaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotNull(message="La prioridad de sintoma debe llevar un id asociado")
	private Long idPrioridadSintoma;// id de prioridad del sintoma
	
	@NotBlank(message="La prioridad debe llevar una descripcion")
	private String descPrioridadSintoma;// descripcion de prioridad del sintoma
	
	public PrioridadSintomaDTO() {
		super();
	}

	public PrioridadSintomaDTO(Long idPrioridadSintoma, String descPrioridadSintoma) {
		super();
		this.idPrioridadSintoma = idPrioridadSintoma;
		this.descPrioridadSintoma = descPrioridadSintoma;
	}

	public Long getIdPrioridadSintoma() {
		return idPrioridadSintoma;
	}

	public void setIdPrioridadSintoma(Long idPrioridadSintoma) {
		this.idPrioridadSintoma = idPrioridadSintoma;
	}

	public String getDescPrioridadSintoma() {
		return descPrioridadSintoma;
	}

	public void setDescPrioridadSintoma(String descPrioridadSintoma) {
		this.descPrioridadSintoma = descPrioridadSintoma;
	}

	
	
	

}
