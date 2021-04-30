package com.project.saludLegal.models;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="SL_pacientes")
public class Paciente {
    
	@Id
    @Column(name="id_paciente",unique = true, nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPaciente;
	
	@Column(name="cedula", unique = true, nullable = false)
	private String cedula;
	
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
	
	@Valid
	@ManyToOne
	@JoinColumn(name="id_tipo_contrato")
	private TipoContrato tipoContrato;
	
	@Valid
	@ManyToOne
	@JoinColumn(name="id_ubicacion")
	private UbicacionGeografica ubicacionGeografica;
	
	public Long getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
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

	public TipoContrato getTipoContrato() {
		return tipoContrato;
	}

	public void setTipoContrato(TipoContrato tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	public UbicacionGeografica getUbicacionGeografica() {
		return ubicacionGeografica;
	}

	public void setUbicacionGeografica(UbicacionGeografica ubicacionGeografica) {
		this.ubicacionGeografica = ubicacionGeografica;
	}

}
