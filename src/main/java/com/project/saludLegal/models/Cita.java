package com.project.saludLegal.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="SL_citas") 
public class Cita {
	
	@Id
	@Column(name="id_cita",unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCita;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_cita")
	private TipoCita tipoCita;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_sintomatologia")
	private Sintomatologia sintomatologia;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cuota_moderadora")
	private CuotaModeradora cuotaModeradora;
	
	@OneToOne()
	@JoinColumn(name = "id_turno")
	private  Turno turno;

	@Column(name="fecha_cita",unique=true, nullable=true)
	private Date fechaCita;
	
	@Column(name="fecha_solicitud",unique=true, nullable=true)
	private Date fechaSolicitud;
	
	@Column(name="prioridad",unique=true, nullable=false)
	private Long prioridad;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_paciente", nullable=false)
	private Paciente paciente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_especialidad", nullable=false)
	private Especialidad especialidad;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_centro_medico", nullable=false)
	private CentroMedico centroMedico;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_estado_cita", nullable=false)
	private EstadoCita estadoCita;
	
	
	
	public Cita(Long idCita, Date fechaCita, Date fechaSolicitud, Long prioridad, Paciente paciente,
			Especialidad especialidad, CentroMedico centroMedico, EstadoCita estadoCita, TipoCita tipoCita,
			Sintomatologia sintomatologia, CuotaModeradora cuotaModeradora, Turno turno) {
		this.idCita = idCita;
		this.fechaCita = fechaCita;
		this.fechaSolicitud = fechaSolicitud;
		this.prioridad = prioridad;
		this.paciente = paciente;
		this.especialidad = especialidad;
		this.centroMedico = centroMedico;
		this.estadoCita = estadoCita;
		this.tipoCita = tipoCita;
		this.sintomatologia = sintomatologia;
		this.cuotaModeradora = cuotaModeradora;
		this.turno = turno;
	}

	public Cita() {
		super();
	}
	
	
	
	@Override
	public String toString() {
		return "Cita [idCita=" + idCita + ", tipoCita=" + tipoCita + ", sintomatologia=" + sintomatologia
				+ ", cuotaModeradora=" + cuotaModeradora + ", turno=" + turno + ", fechaCita=" + fechaCita
				+ ", fechaSolicitud=" + fechaSolicitud + ", prioridad=" + prioridad + ", paciente=" + paciente
				+ ", especialidad=" + especialidad + ", centroMedico=" + centroMedico + ", estadoCita=" + estadoCita
				+ "]";
	}



	
	
	public Long getIdCita() {
		return idCita;
	}

	public void setIdCita(Long idCita) {
		this.idCita = idCita;
	}

	public Date getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(Date fechaCita) {
		this.fechaCita = fechaCita;
	}

	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public Long getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Long prioridad) {
		this.prioridad = prioridad;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public CentroMedico getCentroMedico() {
		return centroMedico;
	}

	public void setCentroMedico(CentroMedico centroMedico) {
		this.centroMedico = centroMedico;
	}

	public EstadoCita getEstadoCita() {
		return estadoCita;
	}

	public void setEstadoCita(EstadoCita estadoCita) {
		this.estadoCita = estadoCita;
	}

	public TipoCita getTipoCita() {
		return tipoCita;
	}

	public void setTipoCita(TipoCita tipoCita) {
		this.tipoCita = tipoCita;
	}

	public Sintomatologia getSintomatologia() {
		return sintomatologia;
	}

	public void setSintomatologia(Sintomatologia sintomatologia) {
		this.sintomatologia = sintomatologia;
	}

	public CuotaModeradora getCuotaModeradora() {
		return cuotaModeradora;
	}

	public void setCuotaModeradora(CuotaModeradora cuotaModeradora) {
		this.cuotaModeradora = cuotaModeradora;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

}
