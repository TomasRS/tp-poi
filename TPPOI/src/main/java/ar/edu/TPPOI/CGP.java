package ar.edu.TPPOI;

import java.util.ArrayList;
import java.util.List;

public class CGP extends POI {
	private List<String> barrios=new ArrayList<String>();
	private List<String> servicios=new ArrayList<String>();
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
	
	public boolean estoyCercaRespectoA (POI poi){
		return this.barrios.contains(poi.getBarrio());
		
	}
	
	
}
