package ar.edu.TPPOI;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class CGP extends POI {
	
	private List<String> barrios=new ArrayList<String>();
	private List<Servicio> servicios=new ArrayList<Servicio>();
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
		
	public boolean estoyEn(String textoDondeBuscar){
		return super.estoyEn(textoDondeBuscar)||this.servicios.stream()
		.anyMatch(servicio->textoDondeBuscar.contains(servicio.getNombre()));
	}
	
	public boolean estoyDisponibleEn(LocalDateTime unMomento){
		return this.servicios.stream()
			.anyMatch(servicio->servicio.disponibleEn(unMomento));
	}
}
