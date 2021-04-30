package com.project.saludLegal.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="SL_medicos")
public class Medico {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_medico")
	private Long idMedico;
	
	@NotBlank(message="Se requiere direccion del medico")
	private String direccion;
	
	@NotBlank(message="Se requiere nombre del medico")
	@Size(min=2)
	@Pattern(regexp="^[A-Za-z]*$",message = "El nombre no puede tener caracteres numericos")
	private String nombre;
	
	@NotBlank(message="Se requieren los apellidos del medico")
	@Size(min=3)
	@Pattern(regexp="^[A-Za-z]*$",message = "Los apellidos no puede tener caracteres numericos")
	private String apellidos;
	
	@NotBlank(message="Se requiere el email del medico")
	@Email()
	private String email;
	
	@NotBlank(message="Se requiere el telefono del medico")
	@Pattern(regexp = "[0-9]+", message="El telefono debe contener solo digitos")
	private String telefono;
	
	@NotBlank(message="Se requiere el cedula del medico")
	@Pattern(regexp = "[0-9]+", message="La cedula debe contener solo digitos")
	private String cedula;
	
	@Valid
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_centro_medico")
	private CentroMedico centroMedico;
	
	@Valid
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_jornada")
	private Jornada jornada;
	
	@Valid
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_especialidad")
	private Especialidad especialdad;
	
	public Medico(String direccion, String nombre, String apellidos, String email, String telefono, String cedula,
			CentroMedico centroMedico, Jornada jornada, Especialidad especialdad) {
		super();
		this.direccion = direccion;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.telefono = telefono;
		this.cedula = cedula;
		this.centroMedico = centroMedico;
		this.jornada = jornada;
		this.especialdad = especialdad;
	}
	
	public Medico(Long idMedico) {
		super();
		this.idMedico = idMedico;
	}
	
	public Medico() {
	}
	
	public Long getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(Long idMedico) {
		this.idMedico = idMedico;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public CentroMedico getCentroMedico() {
		return centroMedico;
	}

	public void setCentroMedico(CentroMedico centroMedico) {
		this.centroMedico = centroMedico;
	}

	public Jornada getJornada() {
		return jornada;
	}

	public void setJornada(Jornada jornada) {
		this.jornada = jornada;
	}

	public Especialidad getEspecialdad() {
		return especialdad;
	}

	public void setEspecialdad(Especialidad especialdad) {
		this.especialdad = especialdad;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	
}
