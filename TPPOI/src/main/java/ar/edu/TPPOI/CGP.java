package ar.edu.TPPOI;

import java.util.ArrayList;
import java.util.List;

public class CGP extends POI {
	private List<String> barrios=new ArrayList<String>();
	private List<Servicio> servicios=new ArrayList<Servicio>();
	private Integer radioDeZona; //hacerlo con Polygon
	
	public List<String> getBarrios() {
		return barrios;
	}
	public void setBarrios(List<String> barrios) {
		this.barrios = barrios;
	}
	public List<Servicio> getServicios() {
		return servicios;
	}
	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}
	
	
	//Hacerlo con Polygon (nos van a pasar la biblioteca)
	public boolean estasCercaDe (Punto unaCoordenada){
		return this.estasAMenosDeXMetrosDe (radioDeZona,unaCoordenada);
	}
	
	public boolean estoyEn(String textoDondeBuscar){
		return super.estoyEn(textoDondeBuscar)||this.servicios.stream()
			.anyMatch(servicio->textoDondeBuscar.contains(servicio.getNombre()));
	}
	
}
