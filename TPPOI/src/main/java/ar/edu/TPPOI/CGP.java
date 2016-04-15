package ar.edu.TPPOI;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CGP extends POI {
	
	private List<Servicio> servicios = new ArrayList<>();
	private Integer radioDeZona; //hacerlo con Polygon
	
	public List<Servicio> getServicios() {
		return servicios;
	}
	public void addServicio(Servicio servicio) {
		this.servicios.add(servicio);
	}
	
	
	//Hacerlo con Polygon (nos van a pasar la biblioteca)
	public boolean estasCercaDe (Punto unaCoordenada){
		return this.estasAMenosDeXMetrosDe (radioDeZona,unaCoordenada);
	}
	
	public boolean contiene(String unaPalabraClave) throws NoSoyValidoException{
		return (super.contiene(unaPalabraClave) ||
			   this.getServicios().stream()
			   .anyMatch(unServicio -> this.estanContenidos(unaPalabraClave, unServicio.getNombre()))
			   );
				
	}

	public boolean estoyDisponibleEn(LocalDateTime unMomento){
		return this.servicios.stream()
			.anyMatch(servicio->servicio.disponibleEn(unMomento));
	}
	
}
