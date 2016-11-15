package web;

import deApoyo.Punto;
import pois.Direccion;

public class POIShowStruct {
	private String nombre;
	private String tipo;
	private String callePrincipal;
	private Direccion direccion;
	private Punto coordenada;
	private long id;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Punto getCoordenada() {
		return coordenada;
	}
	public void setCoordenada(Punto coordenada) {
		this.coordenada = coordenada;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public String getCallePrincipal() {
		return callePrincipal;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setCallePrincipal(String callePrincipal) {
		this.callePrincipal = callePrincipal;
	}
	public String getNombre() {
		return nombre;
	}
	public String getTipo() {
		return tipo;
	}
	
	public String toString(){
		return String.format("Nombre:%s\nTipo:%s\nCalle:%s", nombre, tipo, callePrincipal);
	}
}
