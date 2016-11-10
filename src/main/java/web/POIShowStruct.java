package web;

public class POIShowStruct {
	private String nombre;
	private String tipo;
	private String callePrincipal;
	
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
	public String getCallePrincipal() {
		return callePrincipal;
	}
	
	
	public String toString(){
		return String.format("Nombre:%s\nTipo:%s\nCalle:%s", nombre, tipo, callePrincipal);
	}
}
