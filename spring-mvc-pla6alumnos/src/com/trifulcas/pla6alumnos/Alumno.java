package com.trifulcas.pla6alumnos;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.trifulcas.pla6alumnos.validacion.ValidarDni;

public class Alumno {

	@NotNull
	@Size(min = 3,message = "El nombre debe tener un mínimo de 3 caracteres")
	private String nombre;
//  @Pattern(regexp="\\d{8}[A-Z]",message="Formato de DNI incorrecto")
	@ValidarDni
	private String dni;
	@Pattern(regexp="^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$",message="Formato de email incorrecto")
	private String email;
	@NotNull(message="Debe escojer un valor")
	private String becado;
	@NotEmpty(message="Al menos debe escojer una asignatura")
	private String [] asignaturas;
		
	// getters
	
	public String getNombre() {return nombre;}
	public String getDni() {return dni;}
	public String getEmail() {return email;}
	public String getBecado() {return becado;}
	public String[] getAsignaturas() {return asignaturas;}
	
		// setters
	
	public void setNombre(String nombre) {this.nombre = nombre;}
	public void setDni(String dni) {this.dni = dni;}
	public void setEmail(String email) {this.email = email;}
	public void setBecado(String becado) {this.becado = becado;}
	public void setAsignaturas(String[] asignaturas) {this.asignaturas = asignaturas;}
		
	//constructor
	
	public Alumno() {
		super();
		
	// Afegir Asignaturas	
	
		listaAsignaturas = new LinkedHashMap<String,String>();
		listaAsignaturas.put("PHP","PhP");
		listaAsignaturas.put("JAVA","Java");
		listaAsignaturas.put("JS","JavaScript");
		listaAsignaturas.put("NET","Microsoft .net");
		
	// afegir Becado
			
		listaBecados = new LinkedHashMap<String,String>();
		listaBecados.put("N", "No");
		listaBecados.put("S", "Sí");
			
		}
	
	// ----------------------------------------------------------------------------------------
	
	// 
	
	private Map<String, String> listaAsignaturas;
		
	public Map<String, String> getListaAsignaturas() {return listaAsignaturas;}
		
	private Map<String, String> listaBecados;
	
	public Map<String, String> getListaBecados() {return listaBecados;}
	
}