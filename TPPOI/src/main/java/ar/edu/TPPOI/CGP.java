package ar.edu.TPPOI;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class CGP extends POI {
	
	private List<String> barrios=new ArrayList<String>();
	List<Servicio> servicios = new ArrayList<Servicio>();
	private Integer radioDeZona; //hacerlo con Polygon

	public  void addServicio(Servicio servicio){
		this.servicios.add(servicio);
	}
	
	public List<String> getBarrios() {
		return barrios;
	}
	public void setBarrios(List<String> barrios) {
		this.barrios = barrios;
	}
	
	//Hacerlo con Polygon (nos van a pasar la biblioteca)
		public boolean estasCercaDe (Punto unaCoordenada){
			return this.estasAMenosDeXMetrosDe (radioDeZona,unaCoordenada);
		}
		
		

/*	public List<Servicio> serviciosCumplenCondicion(Date fechaHorarioDado){
		return  (this.servicios
				.stream()
				.filter(servicio -> servicio.estaAtendiendo(fechaHorarioDado))
				.collect(Collectors.toList()));
		
	}
	
		public Boolean estaDisponible(Date fechaHorario, Servicio unServicio) {

		if (unServicio != null ){
			
			return unServicio.estaAtendiendo(fechaHorario);
		
		}else{
			
			return (this.serviciosCumplenCondicion(fechaHorario).size()) >= 1;
			
		}
		
		
	}*/


}
