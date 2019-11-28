package com.trifulcas.springformularis;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.trifulcas.springformularis.validation.ValidarDni;


public class Cliente {

	@NotNull
	@Size(min = 2,message = "Debe introducir el nombre del cliente")
	private String nombre;
	@Pattern(regexp="[A-Z]\\d{8}",message="NIF incorrecto")
	private String nif;
	private String provincia;
	private String sector;
	private String [] pagos;
	@Min(value=100,message="Mínimo 100")
	@Max(value=1000,message="Máximo 1000")
	private int credito;
	@NotNull
	@ValidarDni
	private String dni_admin;
	
	// getters
	public String getNombre() {return nombre;}
	public String getNif() {return nif;}
	public String getProvincia() {return provincia;}
	public String getSector() {return sector;}
	public String[] getPagos() {return pagos;}
	public int getCredito() {return credito;}
	public String getDni_admin() {return dni_admin;}
	
	// setters
	
	public void setNombre(String nombre) {this.nombre = nombre;}
	public void setNif(String nif) {this.nif = nif;}
	public void setProvincia(String provincia) {this.provincia = provincia;}
	public void setSector(String sector) {this.sector = sector;}
	public void setPagos(String[] pagos) {this.pagos = pagos;}
	public void setCredito(int credito) {this.credito = credito;}
	public void setDni_admin(String dni_admin) {this.dni_admin = dni_admin;}
	
	//constructor
	
	public Cliente() {
		super();
		
	// Afegir provincies	
	
		listaProvincias=new LinkedHashMap<String,String>();
		listaProvincias.put("BCN","Barcelona");
		listaProvincias.put("LLE","Lleida");
		listaProvincias.put("GIR","Girona");
		listaProvincias.put("TAR","Tarragona");
		
	// afegir sectors
		
		listaSectores=new LinkedHashMap<String,String>();
		listaSectores.put("Ganadería", "Ganadería");
		listaSectores.put("Agricultura", "Agricultura");
		listaSectores.put("Pesca", "Pesca");
		
	// afegir pagaments
		
		listaPagos=new LinkedHashMap<String,String>();
		listaPagos.put("Contado", "Contado");
		listaPagos.put("Tarjeta", "Tarjeta");
		listaPagos.put("Paypal", "Paypal");

		}
	
	// ----------------------------------------------------------------------------------------
	
	// Provincias
	
	private Map<String, String> listaProvincias;
		
	public Map<String, String> getListaProvincias() {return listaProvincias;}
		
	// Sectores
	
	private Map<String, String> listaSectores;
	
	public Map<String, String> getListaSectores() {return listaSectores;}
	
	// Pagos
	
	private Map<String, String> listaPagos;
		
	public Map<String, String> getListaPagos() {return listaPagos;}
		
	
	
}
