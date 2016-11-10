package web;

public class POIShowStruct {
	private String nombre;
	private String tipo;
	private String callePrincipal;
	private String calle1;
	private String calle2;
	private String barrio;
	
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
	
	
	public void setCalle1(String calle1) {
		this.calle1 = calle1;
	}
	public void setCalle2(String calle2) {
		this.calle2 = calle2;
	}
	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}
	public String toString(){
		return String.format("Nombre:%s\nTipo:%s\nCalle:%s", nombre, tipo, callePrincipal);
	}
}
