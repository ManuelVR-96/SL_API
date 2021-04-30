package com.project.saludLegal.DTOS;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**

 * DTO para modelo citas.

 * @author: Manuel Alejandro Verjan Robles

 */
public class CitaDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String fechaCita;// Fecha de la cita
	
	private String nombrePaciente;// Nombre del paciente
	
	@NotNull(message="Falta el id de la cita")
	private Long idCita;// Id de la cita
	
	private String sintomaDesc;//Descripcion del sintoma
	
	private Integer valorCuota;// Valor de la cita
	
	private Integer prioridad;// prioridad de la cita
	
	private String especialidadDesc;// Descripcion de la especialidad
	
	private String centroMedicoNombre;// Nombre del centro medico
	
	private String nombreMedico;// Nombre del medico
	
	private String tipoCita;// Tipo de cita
	
	private String apellidosMedico;// Apellidos del medico
	
	private String nombreCompleto;// Nombre completo del medico
	
	private String apellidosPaciente;// Apellidos del paciente
	
	private Long idTurno;
	

	public CitaDTO(String fechaCita, String nombrePaciente, Long idCita, String sintomaDesc, Integer valorCuota,
			String especialidadDesc, String centroMedicoNombre, String nombreMedico, String tipocita, String apellidosPaciente, Long idTurno, Integer prioridad) {
		super();
		this.fechaCita = fechaCita;
		this.nombrePaciente = nombrePaciente;
		this.idCita = idCita;
		this.idTurno = idTurno;
		this.sintomaDesc = sintomaDesc;
		this.valorCuota = valorCuota;
		this.especialidadDesc = especialidadDesc;
		this.centroMedicoNombre = centroMedicoNombre;
		this.nombreMedico = nombreMedico;
		this.tipoCita = tipocita;
		this.prioridad = prioridad;
		this.nombreCompleto = this.nombreMedico + " " + this.apellidosMedico;
		
	}

	public CitaDTO() {
		super();
	}
	
	
	
	public String getApellidosPaciente() {
		return apellidosPaciente;
	}

	public void setApellidosPaciente(String apellidosPaciente) {
		this.apellidosPaciente = apellidosPaciente;
	}

	public String getNombreMedico() {
		return nombreMedico;
	}

	public void setNombreMedico(String nombreMedico) {
		this.nombreMedico = nombreMedico;
	}

	public String getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(String fechaCita) {
		this.fechaCita = fechaCita;
	}

	public String getNombrePaciente() {
		return nombrePaciente;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}

	public Long getIdCita() {
		return idCita;
	}

	public void setIdCita(Long idCita) {
		this.idCita = idCita;
	}

	public String getSintomaDesc() {
		return sintomaDesc;
	}

	public void setSintomaDesc(String sintomaDesc) {
		this.sintomaDesc = sintomaDesc;
	}

	public Integer getValorCuota() {
		return valorCuota;
	}

	public String getTipoCita() {
		return tipoCita;
	}

	public void setTipoCita(String tipoCita) {
		this.tipoCita = tipoCita;
	}

	public void setValorCuota(Integer valorCuota) {
		this.valorCuota = valorCuota;
	}

	public String getEspecialidadDesc() {
		return especialidadDesc;
	}

	public void setEspecialidadDesc(String especialidadDesc) {
		this.especialidadDesc = especialidadDesc;
	}

	public String getCentroMedicoNombre() {
		return centroMedicoNombre;
	}

	public void setCentroMedicoNombre(String centroMedicoNombre) {
		this.centroMedicoNombre = centroMedicoNombre;
	}

	public String getApellidosMedico() {
		return apellidosMedico;
	}

	public void setApellidosMedico(String apellidosMedico) {
		this.apellidosMedico = apellidosMedico;
	}

	public Long getIdTurno() {
		return idTurno;
	}

	public void setIdTurno(Long idTurno) {
		this.idTurno = idTurno;
	}

	public Integer getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Integer prioridad) {
		this.prioridad = prioridad;
	}
	
}
