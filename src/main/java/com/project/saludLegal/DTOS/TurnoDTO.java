package com.project.saludLegal.DTOS;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**

 * DTO para modelo Turno

 * @author: Manuel Alejandro Verjan Robles

 */
public class TurnoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotNull(message="El id el turno es necesario")
	private Long idTurno; //Id del turno
	
	@NotBlank(message="Se requiere fecha del turno")
	private String fechaTurno;// fecha del turno
    
	@Valid
	private CitaDTO citaDTO;// DTO de la cita asociada al turno

	public Long getIdTurno() {
		return idTurno;
	}

	public void setIdTurno(Long idTurno) {
		this.idTurno = idTurno;
	}

	public String getFechaTurno() {
		return fechaTurno;
	}

	public void setFechaTurno(String fechaTurno) {
		this.fechaTurno = fechaTurno;
	}

	public CitaDTO getCitaDTO() {
		return citaDTO;
	}

	public void setCitaDTO(CitaDTO citaDTO) {
		this.citaDTO = citaDTO;
	}

}
