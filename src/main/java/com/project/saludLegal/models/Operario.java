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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="SL_operarios") 
public class Operario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_operario")
	private Long idOperario;
	
	@NotBlank(message="Se requiere cedula del operario")
	@Pattern(regexp = "[0-9]+", message="La cedula debe contener solo digitos")
	private String cedula;
	
	@NotBlank(message="Se requiere nombre del Operario")
	@Size(min=2)
	@Pattern(regexp="^[A-Za-z]*$",message = "El nombre no puede tener caracteres numericos")
	private String nombre;
	
	@NotBlank(message="Se requieren apellidos del operario")
	@Size(min=2)
	@Pattern(regexp="^[A-Za-z]*$",message = "Los apellidos no pueden tener caracteres numericos")
	private String apellidos;
	
	@NotBlank(message="Se requiere el email del operario")
	@Email()
	private String email;
	
	@Size (min = 8, max = 20, message = "La constrasenia debe contener entre 8 y 20 caracteres")
	@NotBlank(message="El operario debe tener una conatrasenia")
	private String Password;
	
	public Long getIdOperario() {
		return idOperario;
	}

	public void setIdOperario(Long idOperario) {
		this.idOperario = idOperario;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
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

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_rol")
	private Rol rol;

}
