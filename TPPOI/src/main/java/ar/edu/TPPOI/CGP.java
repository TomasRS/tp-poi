package ar.edu.TPPOI;

import java.util.ArrayList;
import java.util.List;

public class CGP extends POI {
	private List<String> barrios=new ArrayList<String>();
	private List<String> servicios=new ArrayList<String>();
	private Integer radioDeZona; //es el RADIO de cobertura del CGP
	
	public List<String> getBarrios() {
		return barrios;
	}
	public void setBarrios(List<String> barrios) {
		this.barrios = barrios;
	}
	public List<String> getServicios() {
		return servicios;
	}
	public void setServicios(List<String> servicios) {
		this.servicios = servicios;
	}
	
	
	//Por ende si la distancia entre el RADIO y YO es menor al RADIO es porque estoy dentro
	//de la circunferencia, caso contrario no pertenezo.
	public boolean estasCercaDeLaCoordenada (Punto unaCoordenada){
		return estasAMenosDeXMetrosDe (radioDeZona,unaCoordenada);
	}
	
	
}
