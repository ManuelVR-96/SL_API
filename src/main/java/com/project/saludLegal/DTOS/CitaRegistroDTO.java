package com.project.saludLegal.DTOS;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**

 * DTO para transportar informacion de una cita que se va a agendar

 * @author: Manuel Alejandro Verjan Robles

 */
public class CitaRegistroDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotBlank(message="La cedula del paciente es obligatoria")
	@Pattern(regexp = "[0-9]+", message="La cedula debe contener solo digitos")
	private String cedulaPaciente;// Cedula del paciente al cual se le va a generar una cita
	
	@NotNull(message="El id del sintoma es obligatorio")
	private Long sintoma;// Id del sintoma relacionado en la cita
	
	@NotNull(message="El id de la especialidad es obligatorio")
	private Long especialidad;// Id de la especialidad solicitada para la cita
	
	@NotNull(message="El id del tipo de cita es obligatorio")
	private Long tipoCita;// Id del tipo de cita solicitado
	
	public CitaRegistroDTO() {
		super();
	}

	public CitaRegistroDTO(String cedulaPaciente, Long sintoma, Long especialidad, Long tipoCita) {
		super();
		this.cedulaPaciente = cedulaPaciente;
		this.sintoma = sintoma;
		this.especialidad = especialidad;
		this.tipoCita = tipoCita;
	}

	public String getCedulaPaciente() {
		return cedulaPaciente;
	}

	public void setCedulaPaciente(String cedulaPaciente) {
		this.cedulaPaciente = cedulaPaciente;
	}

	public Long getSintoma() {
		return sintoma;
	}

	public void setSintoma(Long sintoma) {
		this.sintoma = sintoma;
	}

	public Long getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Long especialidad) {
		this.especialidad = especialidad;
	}

	public Long getTipoCita() {
		return tipoCita;
	}

	public void setTipoCita(Long tipoCita) {
		this.tipoCita = tipoCita;
	}
	
	
	
	
}
